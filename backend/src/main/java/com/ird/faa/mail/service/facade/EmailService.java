package com.ird.faa.mail.service.facade;

import java.util.List;

import com.ird.faa.bean.formulaire.Campagne;
import com.ird.faa.bean.formulaire.CampagneChercheurFermeture;
import com.ird.faa.bean.formulaire.CampagneChercheurOuverture;
import com.ird.faa.bean.formulaire.CampagneRappel;
import com.ird.faa.bean.formulaire.CampagneRappelChercheur;
import com.ird.faa.bean.formulaire.CampagneRelance;
import com.ird.faa.bean.formulaire.CampagneRelanceChercheur;

public interface EmailService { 
	 void sendEmailOuverture(Campagne campagne, List<CampagneChercheurOuverture> campagneChercheurOuvertures);
	 void sendEmailRelance(CampagneRelance campagneRelance, List<CampagneRelanceChercheur> campagneRelanceChercheurs);
	 void sendEmailRappel(CampagneRappel campagneRappel, List<CampagneRappelChercheur> campagneRappelChercheurs); 
	 void sendEmailFermeture(Campagne campagne, List<CampagneChercheurFermeture> campagneChercheurFermetures); 
	 void sendAutoEmailRelance(CampagneRelance campagneRelance,
				List<CampagneChercheurOuverture> campagneChercheurOuvertures); 
	 public void sendAutoEmailRappel(CampagneRappel campagneRappel,
			 List<CampagneChercheurOuverture> campagneChercheurOuvertures);
	 
	 
	

}
