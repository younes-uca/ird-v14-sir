package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.TypeInstrumentsEtDispositifsIrd;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instruments_et_dispositifs_ird_chercheur")
public class InstrumentsEtDispositifsIrdChercheur {

    @Id
    @SequenceGenerator(name = "instruments_et_dispositifs_ird_chercheur_seq", sequenceName = "instruments_et_dispositifs_ird_chercheur_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instruments_et_dispositifs_ird_chercheur_seq")
    private Long id;


    @ManyToOne
    private TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd;
    @ManyToOne
    private Chercheur chercheur;


    public InstrumentsEtDispositifsIrdChercheur() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeInstrumentsEtDispositifsIrd getTypeInstrumentsEtDispositifsIrd() {
        return this.typeInstrumentsEtDispositifsIrd;
    }

    public void setTypeInstrumentsEtDispositifsIrd(TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd) {
        this.typeInstrumentsEtDispositifsIrd = typeInstrumentsEtDispositifsIrd;
    }

    public Chercheur getChercheur() {
        return this.chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur = (InstrumentsEtDispositifsIrdChercheur) o;
        return id != null && id.equals(instrumentsEtDispositifsIrdChercheur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

