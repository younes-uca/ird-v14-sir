package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "responsabilite_encadrement_etudiant")
public class ResponsabiliteEncadrementEtudiant {

    @Id
    @SequenceGenerator(name = "responsabilite_encadrement_etudiant_seq", sequenceName = "responsabilite_encadrement_etudiant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responsabilite_encadrement_etudiant_seq")
    private Long id;

    private String libelle;
    private String code;


    public ResponsabiliteEncadrementEtudiant() {
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
        ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant = (ResponsabiliteEncadrementEtudiant) o;
        return id != null && id.equals(responsabiliteEncadrementEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

