package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pays_encadrement_etudiant")
public class PaysEncadrementEtudiant {

    @Id
    @SequenceGenerator(name = "pays_encadrement_etudiant_seq", sequenceName = "pays_encadrement_etudiant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pays_encadrement_etudiant_seq")
    private Long id;


    @ManyToOne
    private Pays pays;
    @ManyToOne
    private EncadrementEtudiant encadrementEtudiant;


    public PaysEncadrementEtudiant() {
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
        PaysEncadrementEtudiant paysEncadrementEtudiant = (PaysEncadrementEtudiant) o;
        return id != null && id.equals(paysEncadrementEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

