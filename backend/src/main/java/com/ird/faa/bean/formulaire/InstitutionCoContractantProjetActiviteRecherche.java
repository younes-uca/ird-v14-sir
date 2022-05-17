package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "institution_co_contractant_projet_activite_recherche")
public class InstitutionCoContractantProjetActiviteRecherche {

    @Id
    @SequenceGenerator(name = "institution_co_contractant_projet_activite_recherche_seq", sequenceName = "institution_co_contractant_projet_activite_recherche_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institution_co_contractant_projet_activite_recherche_seq")
    private Long id;


    @ManyToOne
    private InstitutionCoContractant institutionCoContractant;
    @ManyToOne
    private ProjetActiviteRecherche projetActiviteRecherche;


    public InstitutionCoContractantProjetActiviteRecherche() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstitutionCoContractant getInstitutionCoContractant() {
        return this.institutionCoContractant;
    }

    public void setInstitutionCoContractant(InstitutionCoContractant institutionCoContractant) {
        this.institutionCoContractant = institutionCoContractant;
    }

    public ProjetActiviteRecherche getProjetActiviteRecherche() {
        return this.projetActiviteRecherche;
    }

    public void setProjetActiviteRecherche(ProjetActiviteRecherche projetActiviteRecherche) {
        this.projetActiviteRecherche = projetActiviteRecherche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutionCoContractantProjetActiviteRecherche institutionCoContractantProjetActiviteRecherche = (InstitutionCoContractantProjetActiviteRecherche) o;
        return id != null && id.equals(institutionCoContractantProjetActiviteRecherche.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

