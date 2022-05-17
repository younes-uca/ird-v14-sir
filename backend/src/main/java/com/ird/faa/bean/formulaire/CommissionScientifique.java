package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "commission_scientifique")
public class CommissionScientifique {


    @Id
    @SequenceGenerator(name = "commission_scientifique_seq", sequenceName = "commission_scientifique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commission_scientifique_seq")
    private Long id;
    private String libelle;
    private String code;


    public CommissionScientifique() {
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
        CommissionScientifique commissionScientifique = (CommissionScientifique) o;
        return id != null && id.equals(commissionScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

