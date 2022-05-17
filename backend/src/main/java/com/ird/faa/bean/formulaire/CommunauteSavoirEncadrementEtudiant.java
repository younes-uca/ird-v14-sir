package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "communaute_savoir_encadrement_etudiant")
public class CommunauteSavoirEncadrementEtudiant {
    @Id
    @SequenceGenerator(name = "communaute_savoir_encadrement_etudiant_seq", sequenceName = "communaute_savoir_encadrement_etudiant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "communaute_savoir_encadrement_etudiant_seq")
    private Long id;

    @ManyToOne
    private CommunauteSavoir communauteSavoir;
    @ManyToOne
    private EncadrementEtudiant encadrementEtudiant;


    public CommunauteSavoirEncadrementEtudiant() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommunauteSavoir getCommunauteSavoir() {
        return this.communauteSavoir;
    }

    public void setCommunauteSavoir(CommunauteSavoir communauteSavoir) {
        this.communauteSavoir = communauteSavoir;
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
        CommunauteSavoirEncadrementEtudiant communauteSavoirEncadrementEtudiant = (CommunauteSavoirEncadrementEtudiant) o;
        return id != null && id.equals(communauteSavoirEncadrementEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

