package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projet_activite_recherche_detail_etablissement_financeur")
public class ProjetActiviteRechercheDetailEtablissementFinanceur {
    @Id
    @SequenceGenerator(name = "projet_activite_recherche_detail_etablissement_financeur_seq", sequenceName = "projet_activite_recherche_detail_etablissement_financeur_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projet_activite_recherche_detail_etablissement_financeur_seq")
    private Long id;

    @ManyToOne
    private Etablissement etablissement;

    @ManyToOne
    private ProjetActiviteRechercheDetail projetActiviteRechercheDetail;

    public ProjetActiviteRechercheDetailEtablissementFinanceur() {
        super();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public ProjetActiviteRechercheDetail getProjetActiviteRechercheDetail() {
        return projetActiviteRechercheDetail;
    }

    public void setProjetActiviteRechercheDetail(ProjetActiviteRechercheDetail projetActiviteRechercheDetail) {
        this.projetActiviteRechercheDetail = projetActiviteRechercheDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjetActiviteRechercheDetailEtablissementFinanceur projetActiviteRechercheDetailEtablissementFinanceur = (ProjetActiviteRechercheDetailEtablissementFinanceur) o;
        return id != null && id.equals(projetActiviteRechercheDetailEtablissementFinanceur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
