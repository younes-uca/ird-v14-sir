package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.config.EtatEtapeCampagne;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "culture_scientifique_outil_pedagogique")
public class CultureScientifiqueOutilPedagogique {

    @Id
    @SequenceGenerator(name = "culture_scientifique_outil_pedagogique_seq", sequenceName = "culture_scientifique_outil_pedagogique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "culture_scientifique_outil_pedagogique_seq")
    private Long id;

    private String role;
    private String nomOutil;
    private Integer sortieAnnee;
    private Integer sortieMois;
    private String lienWeb;

    @ManyToOne
    private Campagne campagne;
    @ManyToOne
    private Chercheur chercheur;
    @ManyToOne
    private EtatEtapeCampagne etatEtapeCampagne;

    @OneToMany(mappedBy = "cultureScientifiqueOutilPedagogique")
    private List<PublicCibleCultureScientifiqueOutilPedagogique> publicCibleCultureScientifiqueOutilPedagogiques;
    @OneToMany(mappedBy = "cultureScientifiqueOutilPedagogique")
    private List<TypeOutilCultureScientifiqueOutilPedagogique> typeOutilCultureScientifiqueOutilPedagogiques;
    @OneToMany(mappedBy = "cultureScientifiqueOutilPedagogique")
    private List<PaysTypeOutilCultureScientifiqueOutilPedagogique> paysTypeOutilCultureScientifiqueOutilPedagogiques;
    @OneToMany(mappedBy = "cultureScientifiqueOutilPedagogique")
    private List<EtablissementCultureScientifiqueOutilPedagogique> etablissementCultureScientifiqueOutilPedagogiques;

    public CultureScientifiqueOutilPedagogique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PublicCibleCultureScientifiqueOutilPedagogique> getPublicCibleCultureScientifiqueOutilPedagogiques() {
        return this.publicCibleCultureScientifiqueOutilPedagogiques;
    }

    public void setPublicCibleCultureScientifiqueOutilPedagogiques(List<PublicCibleCultureScientifiqueOutilPedagogique> publicCibleCultureScientifiqueOutilPedagogiques) {
        this.publicCibleCultureScientifiqueOutilPedagogiques = publicCibleCultureScientifiqueOutilPedagogiques;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<TypeOutilCultureScientifiqueOutilPedagogique> getTypeOutilCultureScientifiqueOutilPedagogiques() {
        return this.typeOutilCultureScientifiqueOutilPedagogiques;
    }

    public void setTypeOutilCultureScientifiqueOutilPedagogiques(List<TypeOutilCultureScientifiqueOutilPedagogique> typeOutilCultureScientifiqueOutilPedagogiques) {
        this.typeOutilCultureScientifiqueOutilPedagogiques = typeOutilCultureScientifiqueOutilPedagogiques;
    }

    public String getNomOutil() {
        return this.nomOutil;
    }

    public void setNomOutil(String nomOutil) {
        this.nomOutil = nomOutil;
    }

    public Integer getSortieAnnee() {
        return this.sortieAnnee;
    }

    public void setSortieAnnee(Integer sortieAnnee) {
        this.sortieAnnee = sortieAnnee;
    }

    public Integer getSortieMois() {
        return this.sortieMois;
    }

    public void setSortieMois(Integer sortieMois) {
        this.sortieMois = sortieMois;
    }

    public List<PaysTypeOutilCultureScientifiqueOutilPedagogique> getPaysTypeOutilCultureScientifiqueOutilPedagogiques() {
        return this.paysTypeOutilCultureScientifiqueOutilPedagogiques;
    }

    public void setPaysTypeOutilCultureScientifiqueOutilPedagogiques(List<PaysTypeOutilCultureScientifiqueOutilPedagogique> paysTypeOutilCultureScientifiqueOutilPedagogiques) {
        this.paysTypeOutilCultureScientifiqueOutilPedagogiques = paysTypeOutilCultureScientifiqueOutilPedagogiques;
    }

    public List<EtablissementCultureScientifiqueOutilPedagogique> getEtablissementCultureScientifiqueOutilPedagogiques() {
        return this.etablissementCultureScientifiqueOutilPedagogiques;
    }

    public void setEtablissementCultureScientifiqueOutilPedagogiques(List<EtablissementCultureScientifiqueOutilPedagogique> etablissementCultureScientifiqueOutilPedagogiques) {
        this.etablissementCultureScientifiqueOutilPedagogiques = etablissementCultureScientifiqueOutilPedagogiques;
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

    public EtatEtapeCampagne getEtatEtapeCampagne() {
        return this.etatEtapeCampagne;
    }

    public void setEtatEtapeCampagne(EtatEtapeCampagne etatEtapeCampagne) {
        this.etatEtapeCampagne = etatEtapeCampagne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique = (CultureScientifiqueOutilPedagogique) o;
        return id != null && id.equals(cultureScientifiqueOutilPedagogique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

