package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.TypeOutil;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_outil_culture_scientifique_outil_pedagogique")
public class TypeOutilCultureScientifiqueOutilPedagogique {

    @Id
    @SequenceGenerator(name = "type_outil_culture_scientifique_outil_pedagogique_seq", sequenceName = "type_outil_culture_scientifique_outil_pedagogique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_outil_culture_scientifique_outil_pedagogique_seq")
    private Long id;


    @ManyToOne
    private CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique;
    @ManyToOne
    private TypeOutil typeOutil;


    public TypeOutilCultureScientifiqueOutilPedagogique() {
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

    public TypeOutil getTypeOutil() {
        return this.typeOutil;
    }

    public void setTypeOutil(TypeOutil typeOutil) {
        this.typeOutil = typeOutil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOutilCultureScientifiqueOutilPedagogique typeOutilCultureScientifiqueOutilPedagogique = (TypeOutilCultureScientifiqueOutilPedagogique) o;
        return id != null && id.equals(typeOutilCultureScientifiqueOutilPedagogique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

