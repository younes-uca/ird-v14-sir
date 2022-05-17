package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.ChercheurVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChercheurConverter extends AbstractConverter<Chercheur, ChercheurVo> {

    @Autowired
    private CommunauteSavoirChercheurConverter communauteSavoirChercheurConverter;
    @Autowired
    private TypeEntiteAdministrativeConverter typeEntiteAdministrativeConverter;
    @Autowired
    private DepartementScientifiqueConverter departementScientifiqueConverter;
    @Autowired
    private ZoneActiviteInteractionRechercheConverter zoneActiviteInteractionRechercheConverter;
    @Autowired
    private GradeConverter gradeConverter;
    @Autowired
    private CorpsConverter corpsConverter;
    @Autowired
    private CommissionScientifiqueConverter commissionScientifiqueConverter;
    @Autowired
    private PaysConverter paysConverter;
    @Autowired
    private IdentifiantAuteurExpertConverter identifiantAuteurExpertConverter;
    @Autowired
    private DomaineScientifiqueChercheurConverter domaineScientifiqueChercheurConverter;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter;
    @Autowired
    private SexeConverter sexeConverter;
    @Autowired
    private VilleConverter villeConverter;
    @Autowired
    private InstrumentsEtDispositifsIrdChercheurConverter instrumentsEtDispositifsIrdChercheurConverter;
    private Boolean typeEntiteAdministrative;
    private Boolean entiteAdministrative;
    private Boolean pays;
    private Boolean ville;
    private Boolean departementScientifique;
    private Boolean commissionScientifique;
    private Boolean grade;
    private Boolean corps;
    private Boolean sexe;
    private Boolean domaineScientifiqueChercheurs;
    private Boolean zoneActiviteInteractionRecherches;
    private Boolean communauteSavoirChercheurs;
    private Boolean instrumentsEtDispositifsIrdChercheurs;
    private Boolean identifiantAuteurExperts;

    public ChercheurConverter() {
        init(true);
    }

    @Override
    public Chercheur toItem(ChercheurVo vo) {
        if (vo == null) {
            return null;
        } else {
            Chercheur item = new Chercheur();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getNumeroMatricule()))
                item.setNumeroMatricule(vo.getNumeroMatricule());
            if (StringUtil.isNotEmpty(vo.getEmail()))
                item.setEmail(vo.getEmail());
            if (StringUtil.isNotEmpty(vo.getNatureImplication()))
                item.setNatureImplication(vo.getNatureImplication());
            if (StringUtil.isNotEmpty(vo.getResume()))
                item.setResume(vo.getResume());
            if (StringUtil.isNotEmpty(vo.getFormationEnManagement()))
                item.setFormationEnManagement(NumberUtil.toBoolean(vo.getFormationEnManagement()));
            if (StringUtil.isNotEmpty(vo.getCredentialsNonExpired()))
                item.setCredentialsNonExpired(NumberUtil.toBoolean(vo.getCredentialsNonExpired()));
            if (StringUtil.isNotEmpty(vo.getEnabled()))
                item.setEnabled(NumberUtil.toBoolean(vo.getEnabled()));
            if (StringUtil.isNotEmpty(vo.getCreatedAt()))
                item.setCreatedAt(DateUtil.parse(vo.getCreatedAt()));
            if (StringUtil.isNotEmpty(vo.getUpdatedAt()))
                item.setUpdatedAt(DateUtil.parse(vo.getUpdatedAt()));
            if (StringUtil.isNotEmpty(vo.getAccountNonExpired()))
                item.setAccountNonExpired(NumberUtil.toBoolean(vo.getAccountNonExpired()));
            if (StringUtil.isNotEmpty(vo.getAccountNonLocked()))
                item.setAccountNonLocked(NumberUtil.toBoolean(vo.getAccountNonLocked()));
            if (StringUtil.isNotEmpty(vo.getUsername()))
                item.setUsername(vo.getUsername());
            if (StringUtil.isNotEmpty(vo.getPassword()))
                item.setPassword(vo.getPassword());
            if (StringUtil.isNotEmpty(vo.getPrenom()))
                item.setPrenom(vo.getPrenom());
            if (StringUtil.isNotEmpty(vo.getNom()))
                item.setNom(vo.getNom());
            if (StringUtil.isNotEmpty(vo.getRole()))
                item.setRole(vo.getRole());
            if (StringUtil.isNotEmpty(vo.getPasswordChanged()))
                item.setPasswordChanged(NumberUtil.toBoolean(vo.getPasswordChanged()));
            if (vo.getTypeEntiteAdministrativeVo() != null && this.typeEntiteAdministrative)
                item.setTypeEntiteAdministrative(typeEntiteAdministrativeConverter.toItem(vo.getTypeEntiteAdministrativeVo()));
            if (vo.getEntiteAdministrativeVo() != null && this.entiteAdministrative)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(vo.getEntiteAdministrativeVo()));
            if (vo.getPaysVo() != null && this.pays)
                item.setPays(paysConverter.toItem(vo.getPaysVo()));
            if (vo.getVilleVo() != null && this.ville)
                item.setVille(villeConverter.toItem(vo.getVilleVo()));
            if (vo.getDepartementScientifiqueVo() != null && this.departementScientifique)
                item.setDepartementScientifique(departementScientifiqueConverter.toItem(vo.getDepartementScientifiqueVo()));
            if (vo.getCommissionScientifiqueVo() != null && this.commissionScientifique)
                item.setCommissionScientifique(commissionScientifiqueConverter.toItem(vo.getCommissionScientifiqueVo()));
            if (vo.getGradeVo() != null && this.grade)
                item.setGrade(gradeConverter.toItem(vo.getGradeVo()));
            if (vo.getCorpsVo() != null && this.corps)
                item.setCorps(corpsConverter.toItem(vo.getCorpsVo()));
            if (vo.getSexeVo() != null && this.sexe)
                item.setSexe(sexeConverter.toItem(vo.getSexeVo()));

            if (ListUtil.isNotEmpty(vo.getDomaineScientifiqueChercheursVo()) && this.domaineScientifiqueChercheurs)
                item.setDomaineScientifiqueChercheurs(domaineScientifiqueChercheurConverter.toItem(vo.getDomaineScientifiqueChercheursVo()));
            if (ListUtil.isNotEmpty(vo.getZoneActiviteInteractionRecherchesVo()) && this.zoneActiviteInteractionRecherches)
                item.setZoneActiviteInteractionRecherches(zoneActiviteInteractionRechercheConverter.toItem(vo.getZoneActiviteInteractionRecherchesVo()));
            if (ListUtil.isNotEmpty(vo.getCommunauteSavoirChercheursVo()) && this.communauteSavoirChercheurs)
                item.setCommunauteSavoirChercheurs(communauteSavoirChercheurConverter.toItem(vo.getCommunauteSavoirChercheursVo()));
            if (ListUtil.isNotEmpty(vo.getInstrumentsEtDispositifsIrdChercheursVo()) && this.instrumentsEtDispositifsIrdChercheurs)
                item.setInstrumentsEtDispositifsIrdChercheurs(instrumentsEtDispositifsIrdChercheurConverter.toItem(vo.getInstrumentsEtDispositifsIrdChercheursVo()));
            if (ListUtil.isNotEmpty(vo.getIdentifiantAuteurExpertsVo()) && this.identifiantAuteurExperts)
                item.setIdentifiantAuteurExperts(identifiantAuteurExpertConverter.toItem(vo.getIdentifiantAuteurExpertsVo()));
            /*
             * TODO:added fields
             */
            if(StringUtil.isNotEmpty(vo.getIdGraph()))
                item.setIdGraph(vo.getIdGraph());
            if(StringUtil.isNotEmpty(vo.getCivilite()))
                item.setCivilite(vo.getCivilite());
            if(StringUtil.isNotEmpty(vo.getIntitulePoste()))
                item.setIntitulePoste(vo.getIntitulePoste());
            if(vo.getSorgho()!=null)
                item.setSorgho(vo.getSorgho());
            if(vo.getValide()!=null)
                item.setValide(vo.getValide());
            if(StringUtil.isNotEmpty(vo.getTypeEffectif()))
                item.setTypeEffectif(vo.getTypeEffectif());
            if(StringUtil.isNotEmpty(vo.getDomaineActivite()))
                item.setDomaineActivite(vo.getDomaineActivite());
            if(StringUtil.isNotEmpty(vo.getNomNaissance()))
                item.setNomNaissance(vo.getNomNaissance());
            if(vo.getDateDeNaissance()!=null)
                item.setDateDeNaissance(vo.getDateDeNaissance());
            if(StringUtil.isNotEmpty(vo.getLieuDeNaissance()))
                item.setLieuDeNaissance(vo.getLieuDeNaissance());
            if(StringUtil.isNotEmpty(vo.getTelephone()))
                item.setTelephone(vo.getTelephone());
            if(StringUtil.isNotEmpty(vo.getIdentifiantCas()))
                item.setIdentifiantCas(vo.getIdentifiantCas());
            if(StringUtil.isNotEmpty(vo.getCommentaireDesactivation()))
                item.setCommentaireDesactivation(vo.getCommentaireDesactivation());
            if(vo.getDateCreation()!=null)
                item.setDateCreation(vo.getDateCreation());
            if(vo.getDateModification()!=null)
                item.setDateModification(vo.getDateModification());
            /*fin added fields*/

            return item;
        }
    }

    @Override
    public ChercheurVo toVo(Chercheur item) {
        if (item == null) {
            return null;
        } else {
            ChercheurVo vo = new ChercheurVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (StringUtil.isNotEmpty(item.getNumeroMatricule()))
                vo.setNumeroMatricule(item.getNumeroMatricule());

            if (StringUtil.isNotEmpty(item.getEmail()))
                vo.setEmail(item.getEmail());

            if (StringUtil.isNotEmpty(item.getNatureImplication()))
                vo.setNatureImplication(item.getNatureImplication());

            if (StringUtil.isNotEmpty(item.getResume()))
                vo.setResume(item.getResume());

            if (item.getFormationEnManagement() != null)
                vo.setFormationEnManagement(NumberUtil.toString(item.getFormationEnManagement()));
            vo.setCredentialsNonExpired(NumberUtil.toString(item.getCredentialsNonExpired()));
            vo.setEnabled(NumberUtil.toString(item.getEnabled()));
            if (item.getCreatedAt() != null)
                vo.setCreatedAt(DateUtil.formateDate(item.getCreatedAt()));
            if (item.getUpdatedAt() != null)
                vo.setUpdatedAt(DateUtil.formateDate(item.getUpdatedAt()));
            vo.setAccountNonExpired(NumberUtil.toString(item.getAccountNonExpired()));
            vo.setAccountNonLocked(NumberUtil.toString(item.getAccountNonLocked()));
            if (StringUtil.isNotEmpty(item.getUsername()))
                vo.setUsername(item.getUsername());

            if (StringUtil.isNotEmpty(item.getPassword()))
                vo.setPassword(item.getPassword());

            if (StringUtil.isNotEmpty(item.getPrenom()))
                vo.setPrenom(item.getPrenom());

            if (StringUtil.isNotEmpty(item.getNom()))
                vo.setNom(item.getNom());

            if (StringUtil.isNotEmpty(item.getRole()))
                vo.setRole(item.getRole());

            vo.setPasswordChanged(NumberUtil.toString(item.getPasswordChanged()));
            if (item.getTypeEntiteAdministrative() != null && this.typeEntiteAdministrative) {
                vo.setTypeEntiteAdministrativeVo(typeEntiteAdministrativeConverter.toVo(item.getTypeEntiteAdministrative()));
            }
            if (item.getEntiteAdministrative() != null && this.entiteAdministrative) {
                vo.setEntiteAdministrativeVo(entiteAdministrativeConverter.toVo(item.getEntiteAdministrative()));
            }
            if (item.getPays() != null && this.pays) {
                vo.setPaysVo(paysConverter.toVo(item.getPays()));
            }
            if (item.getVille() != null && this.ville) {
                vo.setVilleVo(villeConverter.toVo(item.getVille()));
            }
            if (item.getDepartementScientifique() != null && this.departementScientifique) {
                vo.setDepartementScientifiqueVo(departementScientifiqueConverter.toVo(item.getDepartementScientifique()));
            }
            if (item.getCommissionScientifique() != null && this.commissionScientifique) {
                vo.setCommissionScientifiqueVo(commissionScientifiqueConverter.toVo(item.getCommissionScientifique()));
            }
            if (item.getGrade() != null && this.grade) {
                vo.setGradeVo(gradeConverter.toVo(item.getGrade()));
            }
            if (item.getCorps() != null && this.corps) {
                vo.setCorpsVo(corpsConverter.toVo(item.getCorps()));
            }
            if (item.getSexe() != null && this.sexe) {
                vo.setSexeVo(sexeConverter.toVo(item.getSexe()));
            }
            if (ListUtil.isNotEmpty(item.getDomaineScientifiqueChercheurs()) && this.domaineScientifiqueChercheurs) {
                domaineScientifiqueChercheurConverter.init(true);
                domaineScientifiqueChercheurConverter.setChercheur(false);
                vo.setDomaineScientifiqueChercheursVo(domaineScientifiqueChercheurConverter.toVo(item.getDomaineScientifiqueChercheurs()));
            }
            if (ListUtil.isNotEmpty(item.getZoneActiviteInteractionRecherches()) && this.zoneActiviteInteractionRecherches) {
                zoneActiviteInteractionRechercheConverter.init(true);
                zoneActiviteInteractionRechercheConverter.setChercheur(false);
                vo.setZoneActiviteInteractionRecherchesVo(zoneActiviteInteractionRechercheConverter.toVo(item.getZoneActiviteInteractionRecherches()));
            }
            if (ListUtil.isNotEmpty(item.getCommunauteSavoirChercheurs()) && this.communauteSavoirChercheurs) {
                communauteSavoirChercheurConverter.init(true);
                communauteSavoirChercheurConverter.setChercheur(false);
                vo.setCommunauteSavoirChercheursVo(communauteSavoirChercheurConverter.toVo(item.getCommunauteSavoirChercheurs()));
            }
            if (ListUtil.isNotEmpty(item.getInstrumentsEtDispositifsIrdChercheurs()) && this.instrumentsEtDispositifsIrdChercheurs) {
                instrumentsEtDispositifsIrdChercheurConverter.init(true);
                instrumentsEtDispositifsIrdChercheurConverter.setChercheur(false);
                vo.setInstrumentsEtDispositifsIrdChercheursVo(instrumentsEtDispositifsIrdChercheurConverter.toVo(item.getInstrumentsEtDispositifsIrdChercheurs()));
            }
            if (ListUtil.isNotEmpty(item.getIdentifiantAuteurExperts()) && this.identifiantAuteurExperts) {
                identifiantAuteurExpertConverter.init(true);
                identifiantAuteurExpertConverter.setChercheur(false);
                vo.setIdentifiantAuteurExpertsVo(identifiantAuteurExpertConverter.toVo(item.getIdentifiantAuteurExperts()));
            }
            /*
             * TODO:added fields
             */
            if(StringUtil.isNotEmpty(item.getIdGraph()))
                vo.setIdGraph(item.getIdGraph());
            if(StringUtil.isNotEmpty(item.getCivilite()))
            	vo.setCivilite(item.getCivilite());
            if(StringUtil.isNotEmpty(item.getIntitulePoste()))
            	vo.setIntitulePoste(item.getIntitulePoste());
            if(item.getSorgho()!=null)
            	vo.setSorgho(item.getSorgho());
            if(item.getValide()!=null)
            	vo.setValide(item.getValide());
            if(StringUtil.isNotEmpty(item.getTypeEffectif()))
            	vo.setTypeEffectif(item.getTypeEffectif());
            if(StringUtil.isNotEmpty(item.getDomaineActivite()))
            	vo.setDomaineActivite(item.getDomaineActivite());
            if(StringUtil.isNotEmpty(item.getNomNaissance()))
            	vo.setNomNaissance(item.getNomNaissance());
            if(item.getDateDeNaissance()!=null)
            	vo.setDateDeNaissance(item.getDateDeNaissance());
            if(StringUtil.isNotEmpty(item.getLieuDeNaissance()))
            	vo.setLieuDeNaissance(item.getLieuDeNaissance());
            if(StringUtil.isNotEmpty(item.getTelephone()))
            	vo.setTelephone(item.getTelephone());
            if(StringUtil.isNotEmpty(item.getIdentifiantCas()))
            	vo.setIdentifiantCas(item.getIdentifiantCas());
            if(StringUtil.isNotEmpty(item.getCommentaireDesactivation()))
            	vo.setCommentaireDesactivation(item.getCommentaireDesactivation());
            if(item.getDateCreation()!=null)
            	vo.setDateCreation(item.getDateCreation());
            if(item.getDateModification()!=null)
            	vo.setDateModification(item.getDateModification());
            /*fin added fields*/

            return vo;
        }
    }

    public void init(Boolean value) {
        typeEntiteAdministrative = value;
        entiteAdministrative = value;
        pays = value;
        ville = value;
        departementScientifique = value;
        commissionScientifique = value;
        grade = value;
        corps = value;
        sexe = value;
        domaineScientifiqueChercheurs = value;
        zoneActiviteInteractionRecherches = value;
        communauteSavoirChercheurs = value;
        instrumentsEtDispositifsIrdChercheurs = value;
        identifiantAuteurExperts = value;
    }


    public CommunauteSavoirChercheurConverter getCommunauteSavoirChercheurConverter() {
        return this.communauteSavoirChercheurConverter;
    }

    public void setCommunauteSavoirChercheurConverter(CommunauteSavoirChercheurConverter communauteSavoirChercheurConverter) {
        this.communauteSavoirChercheurConverter = communauteSavoirChercheurConverter;
    }

    public TypeEntiteAdministrativeConverter getTypeEntiteAdministrativeConverter() {
        return this.typeEntiteAdministrativeConverter;
    }

    public void setTypeEntiteAdministrativeConverter(TypeEntiteAdministrativeConverter typeEntiteAdministrativeConverter) {
        this.typeEntiteAdministrativeConverter = typeEntiteAdministrativeConverter;
    }

    public DepartementScientifiqueConverter getDepartementScientifiqueConverter() {
        return this.departementScientifiqueConverter;
    }

    public void setDepartementScientifiqueConverter(DepartementScientifiqueConverter departementScientifiqueConverter) {
        this.departementScientifiqueConverter = departementScientifiqueConverter;
    }

    public ZoneActiviteInteractionRechercheConverter getZoneActiviteInteractionRechercheConverter() {
        return this.zoneActiviteInteractionRechercheConverter;
    }

    public void setZoneActiviteInteractionRechercheConverter(ZoneActiviteInteractionRechercheConverter zoneActiviteInteractionRechercheConverter) {
        this.zoneActiviteInteractionRechercheConverter = zoneActiviteInteractionRechercheConverter;
    }

    public GradeConverter getGradeConverter() {
        return this.gradeConverter;
    }

    public void setGradeConverter(GradeConverter gradeConverter) {
        this.gradeConverter = gradeConverter;
    }

    public CorpsConverter getCorpsConverter() {
        return this.corpsConverter;
    }

    public void setCorpsConverter(CorpsConverter corpsConverter) {
        this.corpsConverter = corpsConverter;
    }

    public CommissionScientifiqueConverter getCommissionScientifiqueConverter() {
        return this.commissionScientifiqueConverter;
    }

    public void setCommissionScientifiqueConverter(CommissionScientifiqueConverter commissionScientifiqueConverter) {
        this.commissionScientifiqueConverter = commissionScientifiqueConverter;
    }

    public PaysConverter getPaysConverter() {
        return this.paysConverter;
    }

    public void setPaysConverter(PaysConverter paysConverter) {
        this.paysConverter = paysConverter;
    }

    public IdentifiantAuteurExpertConverter getIdentifiantAuteurExpertConverter() {
        return this.identifiantAuteurExpertConverter;
    }

    public void setIdentifiantAuteurExpertConverter(IdentifiantAuteurExpertConverter identifiantAuteurExpertConverter) {
        this.identifiantAuteurExpertConverter = identifiantAuteurExpertConverter;
    }

    public DomaineScientifiqueChercheurConverter getDomaineScientifiqueChercheurConverter() {
        return this.domaineScientifiqueChercheurConverter;
    }

    public void setDomaineScientifiqueChercheurConverter(DomaineScientifiqueChercheurConverter domaineScientifiqueChercheurConverter) {
        this.domaineScientifiqueChercheurConverter = domaineScientifiqueChercheurConverter;
    }

    public EntiteAdministrativeConverter getEntiteAdministrativeConverter() {
        return this.entiteAdministrativeConverter;
    }

    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter) {
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }

    public SexeConverter getSexeConverter() {
        return this.sexeConverter;
    }

    public void setSexeConverter(SexeConverter sexeConverter) {
        this.sexeConverter = sexeConverter;
    }

    public VilleConverter getVilleConverter() {
        return this.villeConverter;
    }

    public void setVilleConverter(VilleConverter villeConverter) {
        this.villeConverter = villeConverter;
    }

    public InstrumentsEtDispositifsIrdChercheurConverter getInstrumentsEtDispositifsIrdChercheurConverter() {
        return this.instrumentsEtDispositifsIrdChercheurConverter;
    }

    public void setInstrumentsEtDispositifsIrdChercheurConverter(InstrumentsEtDispositifsIrdChercheurConverter instrumentsEtDispositifsIrdChercheurConverter) {
        this.instrumentsEtDispositifsIrdChercheurConverter = instrumentsEtDispositifsIrdChercheurConverter;
    }

    public boolean isTypeEntiteAdministrative() {
        return this.typeEntiteAdministrative;
    }

    public void setTypeEntiteAdministrative(boolean typeEntiteAdministrative) {
        this.typeEntiteAdministrative = typeEntiteAdministrative;
    }

    public boolean isEntiteAdministrative() {
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(boolean entiteAdministrative) {
        this.entiteAdministrative = entiteAdministrative;
    }

    public boolean isPays() {
        return this.pays;
    }

    public void setPays(boolean pays) {
        this.pays = pays;
    }

    public boolean isVille() {
        return this.ville;
    }

    public void setVille(boolean ville) {
        this.ville = ville;
    }

    public boolean isDepartementScientifique() {
        return this.departementScientifique;
    }

    public void setDepartementScientifique(boolean departementScientifique) {
        this.departementScientifique = departementScientifique;
    }

    public boolean isCommissionScientifique() {
        return this.commissionScientifique;
    }

    public void setCommissionScientifique(boolean commissionScientifique) {
        this.commissionScientifique = commissionScientifique;
    }

    public boolean isGrade() {
        return this.grade;
    }

    public void setGrade(boolean grade) {
        this.grade = grade;
    }

    public boolean isCorps() {
        return this.corps;
    }

    public void setCorps(boolean corps) {
        this.corps = corps;
    }

    public boolean isSexe() {
        return this.sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }


    public Boolean isDomaineScientifiqueChercheurs() {
        return this.domaineScientifiqueChercheurs;
    }

    public void setDomaineScientifiqueChercheurs(Boolean domaineScientifiqueChercheurs) {
        this.domaineScientifiqueChercheurs = domaineScientifiqueChercheurs;
    }


    public Boolean isZoneActiviteInteractionRecherches() {
        return this.zoneActiviteInteractionRecherches;
    }

    public void setZoneActiviteInteractionRecherches(Boolean zoneActiviteInteractionRecherches) {
        this.zoneActiviteInteractionRecherches = zoneActiviteInteractionRecherches;
    }


    public Boolean isCommunauteSavoirChercheurs() {
        return this.communauteSavoirChercheurs;
    }

    public void setCommunauteSavoirChercheurs(Boolean communauteSavoirChercheurs) {
        this.communauteSavoirChercheurs = communauteSavoirChercheurs;
    }


    public Boolean isInstrumentsEtDispositifsIrdChercheurs() {
        return this.instrumentsEtDispositifsIrdChercheurs;
    }

    public void setInstrumentsEtDispositifsIrdChercheurs(Boolean instrumentsEtDispositifsIrdChercheurs) {
        this.instrumentsEtDispositifsIrdChercheurs = instrumentsEtDispositifsIrdChercheurs;
    }


    public Boolean isIdentifiantAuteurExperts() {
        return this.identifiantAuteurExperts;
    }

    public void setIdentifiantAuteurExperts(Boolean identifiantAuteurExperts) {
        this.identifiantAuteurExperts = identifiantAuteurExperts;
    }


}
