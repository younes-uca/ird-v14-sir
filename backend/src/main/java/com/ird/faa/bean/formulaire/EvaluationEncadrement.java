package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "evaluation_encadrement")
public class EvaluationEncadrement {

    @Id
    @SequenceGenerator(name = "evaluation_encadrement_seq", sequenceName = "evaluation_encadrement_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_encadrement_seq")
    private Long id;

    private String libelle;
    private String code;


    public EvaluationEncadrement() {
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
        EvaluationEncadrement evaluationEncadrement = (EvaluationEncadrement) o;
        return id != null && id.equals(evaluationEncadrement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

