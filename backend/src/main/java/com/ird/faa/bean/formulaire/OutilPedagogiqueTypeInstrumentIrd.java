package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.referentiel.TypeInstrumentIrd;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "outil_pedagogique_type_instrument_ird")
public class OutilPedagogiqueTypeInstrumentIrd {

    @Id
    @SequenceGenerator(name = "outil_pedagogique_type_instrument_ird_seq", sequenceName = "outil_pedagogique_type_instrument_ird_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outil_pedagogique_type_instrument_ird_seq")
    private Long id;


    @ManyToOne
    private TypeInstrumentIrd typeInstrumentIrd;
    @ManyToOne
    private OutilPedagogique outilPedagogique;


    public OutilPedagogiqueTypeInstrumentIrd() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeInstrumentIrd getTypeInstrumentIrd() {
        return typeInstrumentIrd;
    }

    public void setTypeInstrumentIrd(TypeInstrumentIrd typeInstrumentIrd) {
        this.typeInstrumentIrd = typeInstrumentIrd;
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
        OutilPedagogiqueTypeInstrumentIrd outilPedagogiqueTypeInstrumentIrd = (OutilPedagogiqueTypeInstrumentIrd) o;
        return id != null && id.equals(outilPedagogiqueTypeInstrumentIrd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

