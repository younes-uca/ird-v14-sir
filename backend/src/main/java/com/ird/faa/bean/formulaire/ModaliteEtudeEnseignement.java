package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.ModaliteEtude;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "modalite_etude_enseignement")
public class ModaliteEtudeEnseignement {

    @Id
    @SequenceGenerator(name = "modalite_etude_enseignement_seq", sequenceName = "modalite_etude_enseignement_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modalite_etude_enseignement_seq")
    private Long id;


    @ManyToOne
    private ModaliteEtude modaliteEtude;
    @ManyToOne
    private Enseignement enseignement;


    public ModaliteEtudeEnseignement() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModaliteEtude getModaliteEtude() {
        return this.modaliteEtude;
    }

    public void setModaliteEtude(ModaliteEtude modaliteEtude) {
        this.modaliteEtude = modaliteEtude;
    }

    public Enseignement getEnseignement() {
        return this.enseignement;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModaliteEtudeEnseignement modaliteEtudeEnseignement = (ModaliteEtudeEnseignement) o;
        return id != null && id.equals(modaliteEtudeEnseignement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

