package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etablissement_culture_scientifique_outil_pedagogique")
public class EtablissementCultureScientifiqueOutilPedagogique {

    @Id
    @SequenceGenerator(name = "etablissement_culture_scientifique_outil_pedagogique_seq", sequenceName = "etablissement_culture_scientifique_outil_pedagogique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etablissement_culture_scientifique_outil_pedagogique_seq")
    private Long id;


    @ManyToOne
    private CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique;
    @ManyToOne
    private Etablissement etablissement;


    public EtablissementCultureScientifiqueOutilPedagogique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CultureScientifiqueOutilPedagogique getCultureScientifiqueOutilPedagogique() {
        return this.cultureScientifiqueOutilPedagogique;
    }

    public void setCultureScientifiqueOutilPedagogique(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique) {
        this.cultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogique;
    }

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtablissementCultureScientifiqueOutilPedagogique etablissementCultureScientifiqueOutilPedagogique = (EtablissementCultureScientifiqueOutilPedagogique) o;
        return id != null && id.equals(etablissementCultureScientifiqueOutilPedagogique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

