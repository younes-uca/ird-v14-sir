package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rencontre_grand_publique_jeune_publique_periode")
public class RencontreGrandPubliqueJeunePubliquePeriode {

    @Id
    @SequenceGenerator(name = "rencontre_grand_publique_jeune_publique_periode_seq", sequenceName = "rencontre_grand_publique_jeune_publique_periode_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rencontre_grand_publique_jeune_publique_periode_seq")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateRencontre;

    @ManyToOne
    private RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique;


    public RencontreGrandPubliqueJeunePubliquePeriode() {
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

    public Date getDateRencontre() {
        return this.dateRencontre;
    }

    public void setDateRencontre(Date dateRencontre) {
        this.dateRencontre = dateRencontre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RencontreGrandPubliqueJeunePubliquePeriode rencontreGrandPubliqueJeunePubliquePeriode = (RencontreGrandPubliqueJeunePubliquePeriode) o;
        return id != null && id.equals(rencontreGrandPubliqueJeunePubliquePeriode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

