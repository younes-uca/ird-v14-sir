package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publique_cible_rencontre_grand_publique_jeune_publique")
public class PubliqueCibleRencontreGrandPubliqueJeunePublique {

    @Id
    @SequenceGenerator(name = "publique_cible_rencontre_grand_publique_jeune_publique_seq", sequenceName = "publique_cible_rencontre_grand_publique_jeune_publique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publique_cible_rencontre_grand_publique_jeune_publique_seq")
    private Long id;


    @ManyToOne
    private PubliqueCibleRencontre publiqueCibleRencontre;
    @ManyToOne
    private RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique;


    public PubliqueCibleRencontreGrandPubliqueJeunePublique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PubliqueCibleRencontre getPubliqueCibleRencontre() {
        return this.publiqueCibleRencontre;
    }

    public void setPubliqueCibleRencontre(PubliqueCibleRencontre publiqueCibleRencontre) {
        this.publiqueCibleRencontre = publiqueCibleRencontre;
    }

    public RencontreGrandPubliqueJeunePublique getRencontreGrandPubliqueJeunePublique() {
        return this.rencontreGrandPubliqueJeunePublique;
    }

    public void setRencontreGrandPubliqueJeunePublique(RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique) {
        this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PubliqueCibleRencontreGrandPubliqueJeunePublique publiqueCibleRencontreGrandPubliqueJeunePublique = (PubliqueCibleRencontreGrandPubliqueJeunePublique) o;
        return id != null && id.equals(publiqueCibleRencontreGrandPubliqueJeunePublique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

