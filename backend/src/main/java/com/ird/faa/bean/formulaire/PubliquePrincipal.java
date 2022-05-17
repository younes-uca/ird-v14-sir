package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "publique_principal")
public class PubliquePrincipal {

    @Id
    @SequenceGenerator(name = "publique_principal_seq", sequenceName = "publique_principal_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publique_principal_seq")
    private Long id;

    private String libelle;
    private String code;


    public PubliquePrincipal() {
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
        PubliquePrincipal publiquePrincipal = (PubliquePrincipal) o;
        return id != null && id.equals(publiquePrincipal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

