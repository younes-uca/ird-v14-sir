package com.ird.faa.bean.config;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_publique")
public class TypePublique {

    @Id
    @SequenceGenerator(name = "type_publique_seq", sequenceName = "type_publique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_publique_seq")
    private Long id;

    private String libelle;
    private String code;


    public TypePublique() {
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
        TypePublique typePublique = (TypePublique) o;
        return id != null && id.equals(typePublique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

