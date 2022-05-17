package com.ird.faa.bean.config;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "etat_etape_campagne")
public class EtatEtapeCampagne {

    @Id
    @SequenceGenerator(name = "etat_etape_campagne_seq", sequenceName = "etat_etape_campagne_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etat_etape_campagne_seq")
    private Long id;

    private String libelle;
    private String code;


    public EtatEtapeCampagne() {
        super();
    }

    public EtatEtapeCampagne(String libelle, String code) {
        this.libelle = libelle;
        this.code = code;
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
        EtatEtapeCampagne etatEtapeCampagne = (EtatEtapeCampagne) o;
        return id != null && id.equals(etatEtapeCampagne.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

