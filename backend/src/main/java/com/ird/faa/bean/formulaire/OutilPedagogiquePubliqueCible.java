package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.OutilPedagogique;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "outil_pedagogique_public_cible")
public class OutilPedagogiquePubliqueCible {

    @Id
    @SequenceGenerator(name = "outil_pedagogique_public_cible_seq", sequenceName = "outil_pedagogique_public_cible_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outil_pedagogique_public_cible_seq")
    private Long id;


    @ManyToOne
    private PublicCible publicCible;
    @ManyToOne
    private OutilPedagogique outilPedagogique;


    public OutilPedagogiquePubliqueCible() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PublicCible getPubliqueCible() {
        return this.publicCible;
    }

    public void setPublicCible(PublicCible publicCible) {
        this.publicCible = publicCible;
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
        OutilPedagogiquePubliqueCible outilPedagogiquePubliqueCible = (OutilPedagogiquePubliqueCible) o;
        return id != null && id.equals(outilPedagogiquePubliqueCible.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

