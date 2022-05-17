package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.referentiel.OutilPedagogique;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "outil_pedagogique_periode")
public class OutilPedagogiquePeriode {

    @Id
    @SequenceGenerator(name = "outil_pedagogique_periode_seq", sequenceName = "outil_pedagogique_periode_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outil_pedagogique_periode_seq")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateDiffusion;

    @ManyToOne
    private OutilPedagogique outilPedagogique;


    public OutilPedagogiquePeriode() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDiffusion() {
        return dateDiffusion;
    }

    public void setDateDiffusion(Date dateDiffusion) {
        this.dateDiffusion = dateDiffusion;
    }


    public OutilPedagogique getOutilPedagogique() {
        return outilPedagogique;
    }

    public void setOutilPedagogique(OutilPedagogique outilPedagogique) {
        this.outilPedagogique = outilPedagogique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutilPedagogiquePeriode outilPedagogiquePeriode = (OutilPedagogiquePeriode) o;
        return id != null && id.equals(outilPedagogiquePeriode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

