package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "discipline_scientifique")
public class DisciplineScientifique {

    @Id
    @SequenceGenerator(name = "discipline_scientifique_seq", sequenceName = "discipline_scientifique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline_scientifique_seq")
    private Long id;

    private String libelle;
    private String code;


    public DisciplineScientifique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineScientifique disciplineScientifique = (DisciplineScientifique) o;
        return id != null && id.equals(disciplineScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

