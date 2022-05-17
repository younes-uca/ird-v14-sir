package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.InstrumentIrd;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "evenement_colloque_scientifique_instrument_ird")
public class EvenementColloqueScientifiqueInstrumentIrd {

    @Id
    @SequenceGenerator(name = "evenement_colloque_scientifique_instrument_ird_seq", sequenceName = "evenement_colloque_scientifique_instrument_ird_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evenement_colloque_scientifique_instrument_ird_seq")
    private Long id;

    @ManyToOne
    private EvenementColloqueScienntifique evenementColloqueScienntifique;
    @ManyToOne
    private InstrumentIrd instrumentIrd;

    public EvenementColloqueScientifiqueInstrumentIrd() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EvenementColloqueScienntifique getEvenementColloqueScienntifique() {
        return this.evenementColloqueScienntifique;
    }

    public void setEvenementColloqueScienntifique(EvenementColloqueScienntifique evenementColloqueScienntifique) {
        this.evenementColloqueScienntifique = evenementColloqueScienntifique;
    }

    public InstrumentIrd getInstrumentIrd() {
        return instrumentIrd;
    }

    public void setInstrumentIrd(InstrumentIrd instrumentIrd) {
        this.instrumentIrd = instrumentIrd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EvenementColloqueScientifiqueInstrumentIrd instrumentIrdEvenementColloqueScientifique = (EvenementColloqueScientifiqueInstrumentIrd) o;
        return id != null && id.equals(instrumentIrdEvenementColloqueScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
