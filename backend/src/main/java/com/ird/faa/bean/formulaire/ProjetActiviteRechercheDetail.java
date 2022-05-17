package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "projet_activite_recherche_detail")
public class ProjetActiviteRechercheDetail {

    @Id
    @SequenceGenerator(name = "projet_activite_recherche_detail_seq", sequenceName = "projet_activite_recherche_detail_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projet_activite_recherche_detail_seq")
    private Long id;

    @Column(length = 500)
    private String sujetIntituleReponse;
    private Integer dureePrevuEnMois;
    @Column(columnDefinition = "boolean default false")
    private Boolean financementSpecifique;
    private BigDecimal montantFinancementPrevu;

    @ManyToOne
    private StatusProjet statusProjet;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private Pays pays;
    @ManyToOne
    private ProjetActiviteRecherche projetActiviteRecherche;

    @OneToMany(mappedBy = "projetActiviteRechercheDetail")
    private List<ProjetActiviteRechercheDetailEnjeuxIrd> projetActiviteRechercheDetailEnjeuxIrds;
    @OneToMany(mappedBy = "projetActiviteRechercheDetail")
    private List<ProjetActiviteRechercheDetailInstrumentIrd> projetActiviteRechercheDetailInstrumentIrds;
    @OneToMany(mappedBy = "projetActiviteRechercheDetail")
    private List<ProjetActiviteRechercheDetailPays> projetActiviteRechercheDetailPayss;
    @OneToMany(mappedBy = "projetActiviteRechercheDetail")
    private List<ProjetActiviteRechercheDetailInstitutionCoContractant> projetActiviteRechercheDetailInstitutionCoContractants;
    @OneToMany(mappedBy = "projetActiviteRechercheDetail")
    private List<ProjetActiviteRechercheDetailEtablissementLanceur> projetActiviteRechercheDetailEtablissementLanceurs;
    @OneToMany(mappedBy = "projetActiviteRechercheDetail")
    private List<ProjetActiviteRechercheDetailEtablissementFinanceur> projetActiviteRechercheDetailEtablissementFinanceurs;

    public ProjetActiviteRechercheDetail() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusProjet getStatusProjet() {
        return this.statusProjet;
    }

    public void setStatusProjet(StatusProjet statusProjet) {
        this.statusProjet = statusProjet;
    }

    public String getSujetIntituleReponse() {
        return this.sujetIntituleReponse;
    }

    public void setSujetIntituleReponse(String sujetIntituleReponse) {
        this.sujetIntituleReponse = sujetIntituleReponse;
    }

    public Integer getDureePrevuEnMois() {
        return this.dureePrevuEnMois;
    }

    public void setDureePrevuEnMois(Integer dureePrevuEnMois) {
        this.dureePrevuEnMois = dureePrevuEnMois;
    }

    public List<ProjetActiviteRechercheDetailEnjeuxIrd> getProjetActiviteRechercheDetailEnjeuxIrds() {
        return this.projetActiviteRechercheDetailEnjeuxIrds;
    }

    public void setProjetActiviteRechercheDetailEnjeuxIrds(List<ProjetActiviteRechercheDetailEnjeuxIrd> projetActiviteRechercheDetailEnjeuxIrds) {
        this.projetActiviteRechercheDetailEnjeuxIrds = projetActiviteRechercheDetailEnjeuxIrds;
    }

    public List<ProjetActiviteRechercheDetailInstrumentIrd> getProjetActiviteRechercheDetailInstrumentIrds() {
        return this.projetActiviteRechercheDetailInstrumentIrds;
    }

    public void setProjetActiviteRechercheDetailInstrumentIrds(List<ProjetActiviteRechercheDetailInstrumentIrd> projetActiviteRechercheDetailInstrumentIrds) {
        this.projetActiviteRechercheDetailInstrumentIrds = projetActiviteRechercheDetailInstrumentIrds;
    }

    public List<ProjetActiviteRechercheDetailPays> getProjetActiviteRechercheDetailPayss() {
        return this.projetActiviteRechercheDetailPayss;
    }

    public void setProjetActiviteRechercheDetailPayss(List<ProjetActiviteRechercheDetailPays> projetActiviteRechercheDetailPayss) {
        this.projetActiviteRechercheDetailPayss = projetActiviteRechercheDetailPayss;
    }

    public Boolean getFinancementSpecifique() {
        return this.financementSpecifique;
    }

    public void setFinancementSpecifique(Boolean financementSpecifique) {
        this.financementSpecifique = financementSpecifique;
    }

    public BigDecimal getMontantFinancementPrevu() {
        return this.montantFinancementPrevu;
    }

    public void setMontantFinancementPrevu(BigDecimal montantFinancementPrevu) {
        this.montantFinancementPrevu = montantFinancementPrevu;
    }

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<ProjetActiviteRechercheDetailInstitutionCoContractant> getProjetActiviteRechercheDetailInstitutionCoContractants() {
        return this.projetActiviteRechercheDetailInstitutionCoContractants;
    }

    public void setProjetActiviteRechercheDetailInstitutionCoContractants(List<ProjetActiviteRechercheDetailInstitutionCoContractant> projetActiviteRechercheDetailInstitutionCoContractants) {
        this.projetActiviteRechercheDetailInstitutionCoContractants = projetActiviteRechercheDetailInstitutionCoContractants;
    }

    public List<ProjetActiviteRechercheDetailEtablissementLanceur> getProjetActiviteRechercheDetailEtablissementLanceurs() {
        return this.projetActiviteRechercheDetailEtablissementLanceurs;
    }

    public void setProjetActiviteRechercheDetailEtablissementLanceurs(List<ProjetActiviteRechercheDetailEtablissementLanceur> projetActiviteRechercheDetailEtablissementLanceurs) {
        this.projetActiviteRechercheDetailEtablissementLanceurs = projetActiviteRechercheDetailEtablissementLanceurs;
    }

    public List<ProjetActiviteRechercheDetailEtablissementFinanceur> getProjetActiviteRechercheDetailEtablissementFinanceurs() {
        return projetActiviteRechercheDetailEtablissementFinanceurs;
    }

    public void setProjetActiviteRechercheDetailEtablissementFinanceurs(
            List<ProjetActiviteRechercheDetailEtablissementFinanceur> projetActiviteRechercheDetailEtablissementFinanceurs) {
        this.projetActiviteRechercheDetailEtablissementFinanceurs = projetActiviteRechercheDetailEtablissementFinanceurs;
    }

    public ProjetActiviteRecherche getProjetActiviteRecherche() {
        return this.projetActiviteRecherche;
    }

    public void setProjetActiviteRecherche(ProjetActiviteRecherche projetActiviteRecherche) {
        this.projetActiviteRecherche = projetActiviteRecherche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjetActiviteRechercheDetail projetActiviteRechercheDetail = (ProjetActiviteRechercheDetail) o;
        return id != null && id.equals(projetActiviteRechercheDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

