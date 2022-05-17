package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etablissement_encadrement_etudiant")
public class EtablissementEncadrementEtudiant {

    @Id
    @SequenceGenerator(name = "etablissement_encadrement_etudiant_seq", sequenceName = "etablissement_encadrement_etudiant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etablissement_encadrement_etudiant_seq")
    private Long id;


    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private EncadrementEtudiant encadrementEtudiant;


    public EtablissementEncadrementEtudiant() {
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

    public EncadrementEtudiant getEncadrementEtudiant() {
        return this.encadrementEtudiant;
    }

    public void setEncadrementEtudiant(EncadrementEtudiant encadrementEtudiant) {
        this.encadrementEtudiant = encadrementEtudiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtablissementEncadrementEtudiant etablissementEncadrementEtudiant = (EtablissementEncadrementEtudiant) o;
        return id != null && id.equals(etablissementEncadrementEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

