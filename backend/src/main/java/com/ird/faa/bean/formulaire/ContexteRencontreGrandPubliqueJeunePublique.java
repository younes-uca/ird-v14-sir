package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Contexte;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contexte_rencontre_grand_publique_jeune_publique")
public class ContexteRencontreGrandPubliqueJeunePublique {

    @Id
    @SequenceGenerator(name = "contexte_rencontre_grand_publique_jeune_publique_seq", sequenceName = "contexte_rencontre_grand_publique_jeune_publique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contexte_rencontre_grand_publique_jeune_publique_seq")
    private Long id;


    @ManyToOne
    private RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique;
    @ManyToOne
    private Contexte contexte;


    public ContexteRencontreGrandPubliqueJeunePublique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RencontreGrandPubliqueJeunePublique getRencontreGrandPubliqueJeunePublique() {
        return this.rencontreGrandPubliqueJeunePublique;
    }

    public void setRencontreGrandPubliqueJeunePublique(RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique) {
        this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
    }

    public Contexte getContexte() {
        return this.contexte;
    }

    public void setContexte(Contexte contexte) {
        this.contexte = contexte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContexteRencontreGrandPubliqueJeunePublique contexteRencontreGrandPubliqueJeunePublique = (ContexteRencontreGrandPubliqueJeunePublique) o;
        return id != null && id.equals(contexteRencontreGrandPubliqueJeunePublique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

