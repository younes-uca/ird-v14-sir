package com.ird.faa.mail.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.ird.faa.bean.formulaire.Campagne;
import com.ird.faa.bean.formulaire.CampagneChercheurFermeture;
import com.ird.faa.bean.formulaire.CampagneRelance;
import com.ird.faa.bean.formulaire.CampagneRelanceChercheur;
import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.mail.common.EmailParams;
import com.ird.faa.mail.service.facade.EmailService;
import com.ird.faa.mail.util.FormatUtils;
import com.ird.faa.mail.util.Request;
import com.ird.faa.mail.util.Response;
import com.ird.faa.service.admin.facade.formulaire.CampagneChercheurFermetureAdminService;
import com.ird.faa.service.admin.facade.formulaire.CampagneChercheurOuvertureAdminService;
import com.ird.faa.service.admin.facade.formulaire.CampagneRappelAdminService;
import com.ird.faa.service.admin.facade.formulaire.CampagneRappelChercheurAdminService;
import com.ird.faa.service.admin.facade.formulaire.CampagneRelanceAdminService;
import com.ird.faa.service.admin.facade.formulaire.CampagneRelanceChercheurAdminService;
import com.ird.faa.bean.formulaire.CampagneChercheurOuverture;
import com.ird.faa.bean.formulaire.CampagneRappel;
import com.ird.faa.bean.formulaire.CampagneRappelChercheur;

@Service
public class EmailServiceImpl implements EmailService {


	@Autowired
	private CampagneRelanceChercheurAdminService campagneRelanceChercheurAdminService;

	@Autowired
	private CampagneChercheurOuvertureAdminService campagneChercheurOuvertureAdminService;

	@Autowired
	private CampagneChercheurFermetureAdminService campagneChercheurFermetureAdminService;

	@Autowired
	private CampagneRappelChercheurAdminService campagneRappelChercheurAdminService;
	
	@Autowired
	private CampagneRelanceAdminService campagneRelanceAdminService;
	
	@Autowired
	private CampagneRappelAdminService campagneRappelAdminService;

	@Autowired
	private  JavaMailSender mailSender;

	public void sendEmailOuverture(Campagne campagne, List<CampagneChercheurOuverture> campagneChercheurOuvertures) {
		campagneChercheurOuvertures.forEach(campagneChercheurOuverture -> {
			Request request = new Request();
			preparedRequest(request, campagneChercheurOuverture.getChercheur(), campagne);
			request.setObjet(FormatUtils.formatObject(campagne, campagneChercheurOuverture.getChercheur(),
					campagne.getObjetOuverture()));
			request.setMessage(FormatUtils.formatMessage(campagne, campagneChercheurOuverture.getChercheur(),
					campagne.getMessageOuverture()));
			Response response = sendEmail(request);
			preparedCampagneChercheurOuverture(campagneChercheurOuverture, request, campagne,
					campagneChercheurOuverture.getChercheur(), response.isStatus());

			List<CampagneChercheurOuverture> foundedCampagneChercheurOuvertures = this.campagneChercheurOuvertureAdminService
					.findByCampagneId(campagne.getId());

			if (foundedCampagneChercheurOuvertures != null && !foundedCampagneChercheurOuvertures.isEmpty()) {
				saveFoundedCampagneChercheurOuvertures(foundedCampagneChercheurOuvertures, campagneChercheurOuverture);

			} else {
				this.campagneChercheurOuvertureAdminService.save(campagneChercheurOuvertures);
			}

		});

	}
	
	private void saveFoundedCampagneChercheurOuvertures(List<CampagneChercheurOuverture> foundedCampagneChercheurOuvertures,
			CampagneChercheurOuverture campagneChercheurOuverture
			) {
		List<CampagneChercheurOuverture> filterFoundedCampagneChercheurOuvertures = foundedCampagneChercheurOuvertures
				  .stream()
				  .filter(foundedCampagneChercheurOuverture -> foundedCampagneChercheurOuverture.getChercheur()
							.getId().equals(campagneChercheurOuverture.getChercheur().getId()))
				  .collect(Collectors.toList());			

		if (!filterFoundedCampagneChercheurOuvertures.isEmpty()) {
			filterFoundedCampagneChercheurOuvertures.forEach(foundedCampagneChercheurOuverture -> {
				this.campagneChercheurOuvertureAdminService.delete(foundedCampagneChercheurOuverture);
				this.campagneChercheurOuvertureAdminService.save(campagneChercheurOuverture);

			});
		} else {
			this.campagneChercheurOuvertureAdminService.save(campagneChercheurOuverture);

		}
		
	}
	
	private  Response sendEmail(Request request) {
		Response response = new Response();

		try {
			SimpleMailMessage message = new SimpleMailMessage();
			preparedMessage(message, request);
			mailSender.send(message);
			System.out.println("Mail Send...");
			response.setMessage("mail send to: " + request.getToEmail());
			response.setStatus(Boolean.TRUE);
		} catch (Exception e) {
			response.setMessage("Mail Sending failure: " + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;

	}
	
	private  SimpleMailMessage preparedMessage(SimpleMailMessage message, Request request) {
		message.setFrom(EmailParams.EMAIL_FROM);
		message.setTo(request.getToEmail());
		message.setText(request.getMessage());
		message.setSubject(request.getObjet());
		return message;

	}
	
	
	public  Request preparedRequest(Request request, Chercheur chercheur, Campagne campagne) {
		request.setToEmail(chercheur.getEmail());
		request.setFromEmail(EmailParams.EMAIL_FROM);
		return request;
	}

	private CampagneChercheurOuverture preparedCampagneChercheurOuverture(
			CampagneChercheurOuverture campagneChercheurOuverture, Request request, Campagne campagne,
			Chercheur chercheur, Boolean status) {
		campagneChercheurOuverture.setDateEnvoi(new Date());
		campagneChercheurOuverture.setEnvoye(status);
		campagneChercheurOuverture.setObjet(request.getObjet());
		campagneChercheurOuverture.setMessage(request.getMessage());
		campagneChercheurOuverture.setCampagne(campagne);
		return campagneChercheurOuverture;

	}

	public void sendEmailFermeture(Campagne campagne, List<CampagneChercheurFermeture> campagneChercheurFermetures) {
		campagneChercheurFermetures.forEach(campagneChercheurFermeture -> {
			Request request = new Request();
			preparedRequest(request, campagneChercheurFermeture.getChercheur(), campagne);
			request.setObjet(FormatUtils.formatObject(campagne, campagneChercheurFermeture.getChercheur(),
					campagne.getObjetCloture()));
			request.setMessage(FormatUtils.formatMessage(campagne, campagneChercheurFermeture.getChercheur(),
					campagne.getMessageCloture()));
			Response response = sendEmail(request);
			preparedCampagneChercheurFermeture(campagneChercheurFermeture, request, campagne,
					campagneChercheurFermeture.getChercheur(), response.isStatus());
			
			List<CampagneChercheurFermeture> foundedCampagneChercheurFermetures = this.campagneChercheurFermetureAdminService
					.findByCampagneId(campagne.getId());

					if (foundedCampagneChercheurFermetures != null && !foundedCampagneChercheurFermetures.isEmpty()) {
					saveFoundedCampagneChercheurFermetures(foundedCampagneChercheurFermetures, campagneChercheurFermeture);

					} else {
					this.campagneChercheurFermetureAdminService.save(campagneChercheurFermetures);
					}
		});

	}

	
	
	private CampagneChercheurFermeture preparedCampagneChercheurFermeture(
			CampagneChercheurFermeture campagneChercheurFermeture, Request request, Campagne campagne,
			Chercheur chercheur, Boolean status) {
		campagneChercheurFermeture.setDateEnvoi(new Date());
		campagneChercheurFermeture.setEnvoye(status);
		campagneChercheurFermeture.setObjet(request.getObjet());
		campagneChercheurFermeture.setMessage(request.getMessage());
		campagneChercheurFermeture.setCampagne(campagne);
		return campagneChercheurFermeture;

	}

	
	private void saveFoundedCampagneChercheurFermetures(
			List<CampagneChercheurFermeture> foundedCampagneChercheurFermetures,
			CampagneChercheurFermeture campagneChercheurFermeture) {
		List<CampagneChercheurFermeture> filterFoundedCampagneChercheurFermetures = foundedCampagneChercheurFermetures
				.stream().filter(foundedCampagneChercheurFermeture -> foundedCampagneChercheurFermeture.getChercheur()
						.getId().equals(campagneChercheurFermeture.getChercheur().getId()))
				.collect(Collectors.toList());

		if (!filterFoundedCampagneChercheurFermetures.isEmpty()) {
			filterFoundedCampagneChercheurFermetures.forEach(foundedCampagneChercheurFermeture -> {
				this.campagneChercheurFermetureAdminService.delete(foundedCampagneChercheurFermeture);
				this.campagneChercheurFermetureAdminService.save(campagneChercheurFermeture);

			});
		} else {
			this.campagneChercheurFermetureAdminService.save(campagneChercheurFermeture);

		}

	}
	
	
	public void sendEmailRelance(CampagneRelance campagneRelance,
		List<CampagneRelanceChercheur> campagneRelanceChercheurs) {
		
		if (campagneRelanceChercheurs != null) {
			campagneRelanceChercheurs.forEach(campagneRelanceChercheur -> {
				Request request = new Request();
				preparedRequest(request, campagneRelanceChercheur.getChercheur(),
						campagneRelance.getCampagne());
				request.setObjet(FormatUtils.formatObject(campagneRelance.getCampagne(),
						campagneRelanceChercheur.getChercheur(), campagneRelance.getObjetRelance()));
				request.setMessage(FormatUtils.formatMessage(campagneRelance.getCampagne(),
						campagneRelanceChercheur.getChercheur(), campagneRelance.getMessageRelance()));
				Response response = sendEmail(request);
				campagneRelance.setId(null);
				campagneRelance.setDateRelance(new Date());
				CampagneRelance campagneRelanceFound= this.campagneRelanceAdminService.save(campagneRelance);
				campagneRelanceChercheur.setCampagneRelance(campagneRelanceFound);
				preparedCampagneRelanceChercheur(campagneRelanceChercheur, campagneRelance, response.isStatus());
				this.campagneRelanceChercheurAdminService.save(campagneRelanceChercheur);
			});
		}
	}
	
	
	
	public void sendAutoEmailRelance(CampagneRelance campagneRelance,
			List<CampagneChercheurOuverture> campagneChercheurOuvertures) {
			if (campagneChercheurOuvertures != null) {
				campagneChercheurOuvertures.forEach(campagneChercheurOuverture -> {
					Request request = new Request();
					preparedRequest(request, campagneChercheurOuverture.getChercheur(),
							campagneRelance.getCampagne());
					request.setObjet(FormatUtils.formatObject(campagneRelance.getCampagne(),
							campagneChercheurOuverture.getChercheur(), campagneRelance.getObjetRelance()));
					request.setMessage(FormatUtils.formatMessage(campagneRelance.getCampagne(),
							campagneChercheurOuverture.getChercheur(), campagneRelance.getMessageRelance()));
					Response response = sendEmail(request);
					campagneRelance.setDateRelance(new Date());
					CampagneRelanceChercheur campagneRelanceChercheur= new CampagneRelanceChercheur();
					campagneRelanceChercheur.setCampagneRelance(campagneRelance);
					preparedCampagneRelanceChercheur(campagneRelanceChercheur, campagneRelance, response.isStatus());
					this.campagneRelanceChercheurAdminService.save(campagneRelanceChercheur);
				});
			}
		}
	
	
	
	
	
	

	private CampagneRelanceChercheur preparedCampagneRelanceChercheur(CampagneRelanceChercheur campagneRelanceChercheur,
			CampagneRelance campagneRelance, boolean status) {
		campagneRelanceChercheur.setDateEnvoi(new Date());
		campagneRelanceChercheur.setEnvoye(status);
		campagneRelanceChercheur.setObjet(campagneRelance.getObjetRelance());
		campagneRelanceChercheur.setMessage(campagneRelance.getMessageRelance());
		return campagneRelanceChercheur;
	}
	
	public void sendEmailRappel(CampagneRappel campagneRappel, List<CampagneRappelChercheur> campagneRappelChercheurs) {
		if (campagneRappelChercheurs != null) {
			campagneRappelChercheurs.forEach(campagneRappelChercheur -> {
				Request request = new Request();
				preparedRequest(request, campagneRappelChercheur.getChercheur(), campagneRappel.getCampagne());
				request.setObjet(FormatUtils.formatObject(campagneRappel.getCampagne(),
						campagneRappelChercheur.getChercheur(), campagneRappel.getObjetRappel()));
				request.setMessage(FormatUtils.formatMessage(campagneRappel.getCampagne(),
						campagneRappelChercheur.getChercheur(), campagneRappel.getMessageRappel()));
				Response response = sendEmail(request);
				campagneRappel.setDateRappel(new Date());
				campagneRappel.setId(null);
				campagneRappelChercheur.setCampagneRappel(this.campagneRappelAdminService.save(campagneRappel));

				campagneRappelChercheur.setCampagneRappel(campagneRappel);
				preparedCampagneRappelChercheur(campagneRappelChercheur, campagneRappel, response.isStatus());
				this.campagneRappelChercheurAdminService.save(campagneRappelChercheur);
			});
		}
	}

			private CampagneRappelChercheur preparedCampagneRappelChercheur(CampagneRappelChercheur campagneRappelChercheur,
			    CampagneRappel campagneRappel, boolean status) {
			campagneRappelChercheur.setDateEnvoi(new Date());
			campagneRappelChercheur.setEnvoye(status);
			campagneRappelChercheur.setObjet(campagneRappel.getObjetRappel());
			campagneRappelChercheur.setMessage(campagneRappel.getMessageRappel());
			return campagneRappelChercheur;
			}
	
			
	public void sendAutoEmailRappel(CampagneRappel campagneRappel,
			List<CampagneChercheurOuverture> campagneChercheurOuvertures) {
		if (campagneChercheurOuvertures != null) {
			campagneChercheurOuvertures.forEach(campagneChercheurOuverture -> {
				Request request = new Request();
				preparedRequest(request, campagneChercheurOuverture.getChercheur(), campagneRappel.getCampagne());
				request.setObjet(FormatUtils.formatObject(campagneRappel.getCampagne(),
						campagneChercheurOuverture.getChercheur(), campagneRappel.getObjetRappel()));
				request.setMessage(FormatUtils.formatMessage(campagneRappel.getCampagne(),
						campagneChercheurOuverture.getChercheur(), campagneRappel.getMessageRappel()));
				Response response = sendEmail(request);
				campagneRappel.setDateRappel(new Date());
				CampagneRappelChercheur campagneRappelChercheur = new CampagneRappelChercheur();
				campagneRappelChercheur.setCampagneRappel(campagneRappel);
				preparedCampagneRappelChercheur(campagneRappelChercheur, campagneRappel, response.isStatus());
				this.campagneRappelChercheurAdminService.save(campagneRappelChercheur);
			});
		}
	}



}
