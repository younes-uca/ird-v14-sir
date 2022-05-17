package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "outil_pedagogique_pays_conception")
public class OutilPedagogiquePaysConception {

    @Id
    @SequenceGenerator(name = "outil_pedagogique_pays_conception_seq", sequenceName = "outil_pedagogique_pays_conception_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outil_pedagogique_pays_conception_seq")
    private Long id;


    @ManyToOne
    private Pays pays;
    @ManyToOne
    private OutilPedagogique outilPedagogique;


    public OutilPedagogiquePaysConception() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public OutilPedagogique getOutilPedagogique() {
        return this.outilPedagogique;
    }

    public void setOutilPedagogique(OutilPedagogique outilPedagogique) {
        this.outilPedagogique = outilPedagogique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutilPedagogiquePaysConception outilPedagogiquePaysConception = (OutilPedagogiquePaysConception) o;
        return id != null && id.equals(outilPedagogiquePaysConception.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

