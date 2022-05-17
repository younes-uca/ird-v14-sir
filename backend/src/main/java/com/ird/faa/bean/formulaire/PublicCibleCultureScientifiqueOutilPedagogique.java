package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "public_cible_culture_scientifique_outil_pedagogique")
public class PublicCibleCultureScientifiqueOutilPedagogique {

    @Id
    @SequenceGenerator(name = "public_cible_culture_scientifique_outil_pedagogique_seq", sequenceName = "public_cible_culture_scientifique_outil_pedagogique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public_cible_culture_scientifique_outil_pedagogique_seq")
    private Long id;


    @ManyToOne
    private PublicCible publicCible;
    @ManyToOne
    private CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique;
    @ManyToOne
    private Pays pays;


    public PublicCibleCultureScientifiqueOutilPedagogique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PublicCible getPublicCible() {
        return this.publicCible;
    }

    public void setPublicCible(PublicCible publicCible) {
        this.publicCible = publicCible;
    }

    public CultureScientifiqueOutilPedagogique getCultureScientifiqueOutilPedagogique() {
        return this.cultureScientifiqueOutilPedagogique;
    }

    public void setCultureScientifiqueOutilPedagogique(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique) {
        this.cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogique;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicCibleCultureScientifiqueOutilPedagogique publicCibleCultureScientifiqueOutilPedagogique = (PublicCibleCultureScientifiqueOutilPedagogique) o;
        return id != null && id.equals(publicCibleCultureScientifiqueOutilPedagogique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

