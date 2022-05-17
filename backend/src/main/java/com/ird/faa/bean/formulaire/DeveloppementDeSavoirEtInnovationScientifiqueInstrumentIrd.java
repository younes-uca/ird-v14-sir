package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.InstrumentIrd;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dev_savoir_innov_scientifique_instrument_ird")
public class DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd {

    @Id
    @SequenceGenerator(name = "dev_savoir_innov_scientifique_instrument_ird_seq", sequenceName = "dev_savoir_innov_scientifique_instrument_ird_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_savoir_innov_scientifique_instrument_ird_seq")
    private Long id;

    @ManyToOne
    private InstrumentIrd instrumentIrd;
    @ManyToOne
    private DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique;

    public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstrumentIrd getInstrumentIrd() {
        return this.instrumentIrd;
    }

    public void setInstrumentIrd(InstrumentIrd instrumentIrd) {
        this.instrumentIrd = instrumentIrd;
    }

    public DeveloppementDeSavoirEtInnovationScientifique getDeveloppementDeSavoirEtInnovationScientifique() {
        return this.developpementDeSavoirEtInnovationScientifique;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifique(
            DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique) {
        this.developpementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd developpementDeSavoirEtInnovationScientifiqueInstrumentIrd = (DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd) o;
        return id != null && id.equals(developpementDeSavoirEtInnovationScientifiqueInstrumentIrd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
