package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projet_activite_recherche_detail_institution_co_contractant")
public class ProjetActiviteRechercheDetailInstitutionCoContractant {

    @Id
    @SequenceGenerator(name = "projet_activite_recherche_detail_institution_co_contractant_seq", sequenceName = "projet_activite_recherche_detail_institution_co_contractant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projet_activite_recherche_detail_institution_co_contractant_seq")
    private Long id;


    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private ProjetActiviteRechercheDetail projetActiviteRechercheDetail;


    public ProjetActiviteRechercheDetailInstitutionCoContractant() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public ProjetActiviteRechercheDetail getProjetActiviteRechercheDetail() {
        return this.projetActiviteRechercheDetail;
    }

    public void setProjetActiviteRechercheDetail(ProjetActiviteRechercheDetail projetActiviteRechercheDetail) {
        this.projetActiviteRechercheDetail = projetActiviteRechercheDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjetActiviteRechercheDetailInstitutionCoContractant projetActiviteRechercheDetailInstitutionCoContractant = (ProjetActiviteRechercheDetailInstitutionCoContractant) o;
        return id != null && id.equals(projetActiviteRechercheDetailInstitutionCoContractant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

