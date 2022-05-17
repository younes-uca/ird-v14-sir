package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instruments_et_dispositifs_ird")
public class InstrumentsEtDispositifsIrd {

    @Id
    @SequenceGenerator(name = "instruments_et_dispositifs_ird_seq", sequenceName = "instruments_et_dispositifs_ird_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instruments_et_dispositifs_ird_seq")
    private Long id;

    private String libelle;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Campagne campagne;
    @ManyToOne
    private Chercheur chercheur;


    public InstrumentsEtDispositifsIrd() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Campagne getCampagne() {
        return this.campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    public Chercheur getChercheur() {
        return this.chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd = (InstrumentsEtDispositifsIrd) o;
        return id != null && id.equals(instrumentsEtDispositifsIrd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

