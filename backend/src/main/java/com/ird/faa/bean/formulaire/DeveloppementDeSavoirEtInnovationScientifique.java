package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.bean.config.RoleDeveloppementDeSavoir;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dev_savoir_innov_scientifique")
public class DeveloppementDeSavoirEtInnovationScientifique {

    @Id
    @SequenceGenerator(name = "dev_savoir_innov_scientifique_seq", sequenceName = "dev_savoir_innov_scientifique_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_savoir_innov_scientifique_seq")
    private Long id;

    @Column(length = 500)
    private String titreInstrument;
    private Integer anneeMiseEnOeuvre;
    @Column(length = 500)
    private String lienWeb;

    @ManyToOne
    private RoleDeveloppementDeSavoir roleDeveloppementDeSavoir;
    @ManyToOne
    private SavoirEtInnovation savoirEtInnovation;
    @ManyToOne
    private EtatEtapeCampagne etatEtapeCampagne;

    @OneToMany(mappedBy = "developpementDeSavoirEtInnovationScientifique")
    private List<TypeSavoirDeveloppementDeSavoirEtInnovationScientifique> typeSavoirDeveloppementDeSavoirEtInnovationScientifiques;
    @OneToMany(mappedBy = "developpementDeSavoirEtInnovationScientifique")
    private List<TypeUtilisateurSavoirConcu> typeUtilisateurSavoirConcus;
    @OneToMany(mappedBy = "developpementDeSavoirEtInnovationScientifique")
    private List<DeveloppementDeSavoirEtInnovationScientifiqueModeDiffusion> developpementDeSavoirEtInnovationScientifiqueModeDiffusions;
    @OneToMany(mappedBy = "developpementDeSavoirEtInnovationScientifique")
    private List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd> developpementDeSavoirEtInnovationScientifiqueEnjeuxIrds;
    @OneToMany(mappedBy = "developpementDeSavoirEtInnovationScientifique")
    private List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiques;
    @OneToMany(mappedBy = "developpementDeSavoirEtInnovationScientifique")
    private List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> developpementDeSavoirEtInnovationScientifiqueInstrumentIrds;
    @OneToMany(mappedBy = "developpementDeSavoirEtInnovationScientifique")
    private List<DeveloppementDeSavoirEtInnovationScientifiquePays> developpementDeSavoirEtInnovationScientifiquePayss;
    @OneToMany(mappedBy = "developpementDeSavoirEtInnovationScientifique")
    private List<DeveloppementDeSavoirEtInnovationScientifiqueRole> developpementDeSavoirEtInnovationScientifiqueRoles;

    public DeveloppementDeSavoirEtInnovationScientifique() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TypeSavoirDeveloppementDeSavoirEtInnovationScientifique> getTypeSavoirDeveloppementDeSavoirEtInnovationScientifiques() {
        return this.typeSavoirDeveloppementDeSavoirEtInnovationScientifiques;
    }

    public void setTypeSavoirDeveloppementDeSavoirEtInnovationScientifiques(
            List<TypeSavoirDeveloppementDeSavoirEtInnovationScientifique> typeSavoirDeveloppementDeSavoirEtInnovationScientifiques) {
        this.typeSavoirDeveloppementDeSavoirEtInnovationScientifiques = typeSavoirDeveloppementDeSavoirEtInnovationScientifiques;
    }

    public String getTitreInstrument() {
        return this.titreInstrument;
    }

    public void setTitreInstrument(String titreInstrument) {
        this.titreInstrument = titreInstrument;
    }

    public RoleDeveloppementDeSavoir getRoleDeveloppementDeSavoir() {
        return this.roleDeveloppementDeSavoir;
    }

    public void setRoleDeveloppementDeSavoir(RoleDeveloppementDeSavoir roleDeveloppementDeSavoir) {
        this.roleDeveloppementDeSavoir = roleDeveloppementDeSavoir;
    }

    public List<TypeUtilisateurSavoirConcu> getTypeUtilisateurSavoirConcus() {
        return this.typeUtilisateurSavoirConcus;
    }

    public void setTypeUtilisateurSavoirConcus(List<TypeUtilisateurSavoirConcu> typeUtilisateurSavoirConcus) {
        this.typeUtilisateurSavoirConcus = typeUtilisateurSavoirConcus;
    }

    public Integer getAnneeMiseEnOeuvre() {
        return this.anneeMiseEnOeuvre;
    }

    public void setAnneeMiseEnOeuvre(Integer anneeMiseEnOeuvre) {
        this.anneeMiseEnOeuvre = anneeMiseEnOeuvre;
    }

    public List<DeveloppementDeSavoirEtInnovationScientifiqueModeDiffusion> getDeveloppementDeSavoirEtInnovationScientifiqueModeDiffusions() {
        return this.developpementDeSavoirEtInnovationScientifiqueModeDiffusions;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifiqueModeDiffusions(
            List<DeveloppementDeSavoirEtInnovationScientifiqueModeDiffusion> developpementDeSavoirEtInnovationScientifiqueModeDiffusions) {
        this.developpementDeSavoirEtInnovationScientifiqueModeDiffusions = developpementDeSavoirEtInnovationScientifiqueModeDiffusions;
    }

    public List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd> getDeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrds() {
        return this.developpementDeSavoirEtInnovationScientifiqueEnjeuxIrds;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrds(
            List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd> developpementDeSavoirEtInnovationScientifiqueEnjeuxIrds) {
        this.developpementDeSavoirEtInnovationScientifiqueEnjeuxIrds = developpementDeSavoirEtInnovationScientifiqueEnjeuxIrds;
    }

    public List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> getDeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiques() {
        return this.developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiques;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiques(
            List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiques) {
        this.developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiques = developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiques;
    }

    public List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> getDeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrds() {
        return this.developpementDeSavoirEtInnovationScientifiqueInstrumentIrds;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrds(
            List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> developpementDeSavoirEtInnovationScientifiqueInstrumentIrds) {
        this.developpementDeSavoirEtInnovationScientifiqueInstrumentIrds = developpementDeSavoirEtInnovationScientifiqueInstrumentIrds;
    }

    public List<DeveloppementDeSavoirEtInnovationScientifiquePays> getDeveloppementDeSavoirEtInnovationScientifiquePayss() {
        return this.developpementDeSavoirEtInnovationScientifiquePayss;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifiquePayss(
            List<DeveloppementDeSavoirEtInnovationScientifiquePays> developpementDeSavoirEtInnovationScientifiquePayss) {
        this.developpementDeSavoirEtInnovationScientifiquePayss = developpementDeSavoirEtInnovationScientifiquePayss;
    }

    public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> getDeveloppementDeSavoirEtInnovationScientifiqueRoles() {
        return this.developpementDeSavoirEtInnovationScientifiqueRoles;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifiqueRoles(
            List<DeveloppementDeSavoirEtInnovationScientifiqueRole> developpementDeSavoirEtInnovationScientifiqueRoles) {
        this.developpementDeSavoirEtInnovationScientifiqueRoles = developpementDeSavoirEtInnovationScientifiqueRoles;
    }

    public String getLienWeb() {
        return this.lienWeb;
    }

    public void setLienWeb(String lienWeb) {
        this.lienWeb = lienWeb;
    }

    public SavoirEtInnovation getSavoirEtInnovation() {
        return this.savoirEtInnovation;
    }

    public void setSavoirEtInnovation(SavoirEtInnovation savoirEtInnovation) {
        this.savoirEtInnovation = savoirEtInnovation;
    }

    public EtatEtapeCampagne getEtatEtapeCampagne() {
        return this.etatEtapeCampagne;
    }

    public void setEtatEtapeCampagne(EtatEtapeCampagne etatEtapeCampagne) {
        this.etatEtapeCampagne = etatEtapeCampagne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique = (DeveloppementDeSavoirEtInnovationScientifique) o;
        return id != null && id.equals(developpementDeSavoirEtInnovationScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
