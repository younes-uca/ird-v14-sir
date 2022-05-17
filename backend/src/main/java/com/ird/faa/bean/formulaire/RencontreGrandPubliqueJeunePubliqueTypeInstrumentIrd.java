package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.TypeInstrumentIrd;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rencontre_grand_publique_jeune_publique_type_instrument_ird")
public class RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd {

    @Id
    @SequenceGenerator(name = "rencontre_grand_publique_jeune_publique_type_instrument_ird_seq", sequenceName = "rencontre_grand_publique_jeune_publique_type_instrument_ird_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rencontre_grand_publique_jeune_publique_type_instrument_ird_seq")
    private Long id;


    @ManyToOne
    private TypeInstrumentIrd typeInstrumentIrd;
    @ManyToOne
    private RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique;


    public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RencontreGrandPubliqueJeunePublique getRencontreGrandPubliqueJeunePublique() {
        return this.rencontreGrandPubliqueJeunePublique;
    }

    public void setRencontreGrandPubliqueJeunePublique(RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique) {
        this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = (RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd) o;
        return id != null && id.equals(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public TypeInstrumentIrd getTypeInstrumentIrd() {
        return typeInstrumentIrd;
    }

    public void setTypeInstrumentIrd(TypeInstrumentIrd typeInstrumentIrd) {
        this.typeInstrumentIrd = typeInstrumentIrd;
    }

}

