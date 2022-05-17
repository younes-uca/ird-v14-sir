package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etablissement_encadrement_doctorant")
public class EtablissementEncadrementDoctorant {

    @Id
    @SequenceGenerator(name = "etablissement_encadrement_doctorant_seq", sequenceName = "etablissement_encadrement_doctorant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etablissement_encadrement_doctorant_seq")
    private Long id;


    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private EncadrementDoctorant encadrementDoctorant;


    public EtablissementEncadrementDoctorant() {
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
        EtablissementEncadrementDoctorant etablissementEncadrementDoctorant = (EtablissementEncadrementDoctorant) o;
        return id != null && id.equals(etablissementEncadrementDoctorant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

