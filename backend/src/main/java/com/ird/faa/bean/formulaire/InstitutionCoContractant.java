package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Institution;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "institution_co_contractant")
public class InstitutionCoContractant {

    @Id
    @SequenceGenerator(name = "institution_co_contractant_seq", sequenceName = "institution_co_contractant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institution_co_contractant_seq")
    private Long id;


    @ManyToOne
    private Chercheur chercheur;
    @ManyToOne
    private Institution institution;


    public InstitutionCoContractant() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chercheur getChercheur() {
        return this.chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutionCoContractant institutionCoContractant = (InstitutionCoContractant) o;
        return id != null && id.equals(institutionCoContractant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

