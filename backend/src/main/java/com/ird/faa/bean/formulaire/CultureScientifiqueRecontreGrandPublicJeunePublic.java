package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "culture_scientifique_recontre_grand_public_jeune_public")
public class CultureScientifiqueRecontreGrandPublicJeunePublic {

    @Id
    @SequenceGenerator(name = "culture_scientifique_recontre_grand_public_jeune_public_seq", sequenceName = "culture_scientifique_recontre_grand_public_jeune_public_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "culture_scientifique_recontre_grand_public_jeune_public_seq")
    private Long id;

    private BigDecimal tempsEstimePourCetteAnnne;
    private String intituleSujet;
    private Integer periodeAnnee;
    private Integer periodeMois;
    private Boolean evenementGrandPublic;
    private BigDecimal volumePublic;
    private String lienWeb;

    @ManyToOne
    private FormatRencontre formatRencontre;
    @ManyToOne
    private Campagne campagne;
    @ManyToOne
    private Chercheur chercheur;

    @OneToMany(mappedBy = "cultureScientifiqueRecontreGrandPublicJeunePublic")
    private List<PublicCibleCultureScientifiqueRecontreGrandPublic> publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics;
    @OneToMany(mappedBy = "cultureScientifiqueRecontreGrandPublicJeunePublic")
    private List<ContexteCultureScientifiqueRecontreGrandPublicJeunePublic> contexteCultureScientifiqueRecontreGrandPublicJeunePublics;
    @OneToMany(mappedBy = "cultureScientifiqueRecontreGrandPublicJeunePublic")
    private List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> etablissementCultureScientifiqueRecontreGrandPublicJeunePublics;
    @OneToMany(mappedBy = "cultureScientifiqueRecontreGrandPublicJeunePublic")
    private List<PaysCultureScientifiqueRecontreGrandPublicJeunePublic> paysCultureScientifiqueRecontreGrandPublicJeunePublics;

    public CultureScientifiqueRecontreGrandPublicJeunePublic() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTempsEstimePourCetteAnnne() {
        return this.tempsEstimePourCetteAnnne;
    }

    public void setTempsEstimePourCetteAnnne(BigDecimal tempsEstimePourCetteAnnne) {
        this.tempsEstimePourCetteAnnne = tempsEstimePourCetteAnnne;
    }

    public List<PublicCibleCultureScientifiqueRecontreGrandPublic> getPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublics() {
        return this.publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics;
    }

    public void setPublicCibleCultureScientifiqueRecontresGrandPublicJeunePublics(List<PublicCibleCultureScientifiqueRecontreGrandPublic> publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics) {
        this.publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics = publicCibleCultureScientifiqueRecontresGrandPublicJeunePublics;
    }

    public FormatRencontre getFormatRencontre() {
        return this.formatRencontre;
    }

    public void setFormatRencontre(FormatRencontre formatRencontre) {
        this.formatRencontre = formatRencontre;
    }

    public List<ContexteCultureScientifiqueRecontreGrandPublicJeunePublic> getContexteCultureScientifiqueRecontreGrandPublicJeunePublics() {
        return this.contexteCultureScientifiqueRecontreGrandPublicJeunePublics;
    }

    public void setContexteCultureScientifiqueRecontreGrandPublicJeunePublics(List<ContexteCultureScientifiqueRecontreGrandPublicJeunePublic> contexteCultureScientifiqueRecontreGrandPublicJeunePublics) {
        this.contexteCultureScientifiqueRecontreGrandPublicJeunePublics = contexteCultureScientifiqueRecontreGrandPublicJeunePublics;
    }

    public String getIntituleSujet() {
        return this.intituleSujet;
    }

    public void setIntituleSujet(String intituleSujet) {
        this.intituleSujet = intituleSujet;
    }

    public Integer getPeriodeAnnee() {
        return this.periodeAnnee;
    }

    public void setPeriodeAnnee(Integer periodeAnnee) {
        this.periodeAnnee = periodeAnnee;
    }

    public Integer getPeriodeMois() {
        return this.periodeMois;
    }

    public void setPeriodeMois(Integer periodeMois) {
        this.periodeMois = periodeMois;
    }

    public List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> getEtablissementCultureScientifiqueRecontreGrandPublicJeunePublics() {
        return this.etablissementCultureScientifiqueRecontreGrandPublicJeunePublics;
    }

    public void setEtablissementCultureScientifiqueRecontreGrandPublicJeunePublics(List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> etablissementCultureScientifiqueRecontreGrandPublicJeunePublics) {
        this.etablissementCultureScientifiqueRecontreGrandPublicJeunePublics = etablissementCultureScientifiqueRecontreGrandPublicJeunePublics;
    }

    public Boolean getEvenementGrandPublic() {
        return this.evenementGrandPublic;
    }

    public void setEvenementGrandPublic(Boolean evenementGrandPublic) {
        this.evenementGrandPublic = evenementGrandPublic;
    }

    public BigDecimal getVolumePublic() {
        return this.volumePublic;
    }

    public void setVolumePublic(BigDecimal volumePublic) {
        this.volumePublic = volumePublic;
    }

    public List<PaysCultureScientifiqueRecontreGrandPublicJeunePublic> getPaysCultureScientifiqueRecontreGrandPublicJeunePublics() {
        return this.paysCultureScientifiqueRecontreGrandPublicJeunePublics;
    }

    public void setPaysCultureScientifiqueRecontreGrandPublicJeunePublics(List<PaysCultureScientifiqueRecontreGrandPublicJeunePublic> paysCultureScientifiqueRecontreGrandPublicJeunePublics) {
        this.paysCultureScientifiqueRecontreGrandPublicJeunePublics = paysCultureScientifiqueRecontreGrandPublicJeunePublics;
    }

    public String getLienWeb() {
        return this.lienWeb;
    }

    public void setLienWeb(String lienWeb) {
        this.lienWeb = lienWeb;
    }

    public Campagne getCampagne() {
        return this.campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    public Chercheur getChercheur() {
        return this.chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic = (CultureScientifiqueRecontreGrandPublicJeunePublic) o;
        return id != null && id.equals(cultureScientifiqueRecontreGrandPublicJeunePublic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

