package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pays_encadrement_doctorant")
public class PaysEncadrementDoctorant {

    @Id
    @SequenceGenerator(name = "pays_encadrement_doctorant_seq", sequenceName = "pays_encadrement_doctorant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pays_encadrement_doctorant_seq")
    private Long id;


    @ManyToOne
    private Pays pays;
    @ManyToOne
    private EncadrementDoctorant encadrementDoctorant;


    public PaysEncadrementDoctorant() {
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

    public EncadrementDoctorant getEncadrementDoctorant() {
        return this.encadrementDoctorant;
    }

    public void setEncadrementDoctorant(EncadrementDoctorant encadrementDoctorant) {
        this.encadrementDoctorant = encadrementDoctorant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaysEncadrementDoctorant paysEncadrementDoctorant = (PaysEncadrementDoctorant) o;
        return id != null && id.equals(paysEncadrementDoctorant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

