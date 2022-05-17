package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "communaute_savoir")
public class CommunauteSavoir {

    @Id
    @SequenceGenerator(name = "communaute_savoir_seq", sequenceName = "communaute_savoir_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "communaute_savoir_seq")
    private Long id;

    private String libelle;
    private String code;


    public CommunauteSavoir() {
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
        CommunauteSavoir communauteSavoir = (CommunauteSavoir) o;
        return id != null && id.equals(communauteSavoir.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

