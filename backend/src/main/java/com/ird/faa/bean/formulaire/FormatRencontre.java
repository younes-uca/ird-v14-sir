package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "format_rencontre")
public class FormatRencontre {

    @Id
    @SequenceGenerator(name = "format_rencontre_seq", sequenceName = "format_rencontre_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "format_rencontre_seq")
    private Long id;

    private String libelle;
    private String code;


    public FormatRencontre() {
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
        FormatRencontre formatRencontre = (FormatRencontre) o;
        return id != null && id.equals(formatRencontre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

