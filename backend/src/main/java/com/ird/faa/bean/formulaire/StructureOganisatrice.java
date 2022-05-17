package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "structure_oganisatrice")
public class StructureOganisatrice   implements Archivable  {

    @Id
    @SequenceGenerator(name = "structure_oganisatrice_seq", sequenceName = "structure_oganisatrice_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "structure_oganisatrice_seq")
    private Long id;


    @ManyToOne
    private RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique;
    @ManyToOne
    private com.ird.faa.bean.referentiel.Etablissement etablissement;


    public StructureOganisatrice()  {
        super();
    }


    public Long getId()  {
        return this.id;
    }

    public void setId(Long id)  {
        this.id = id;
    }

    public RencontreGrandPubliqueJeunePublique getRencontreGrandPubliqueJeunePublique()  {
        return this.rencontreGrandPubliqueJeunePublique;
    }

    public void setRencontreGrandPubliqueJeunePublique(RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique)  {
        this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
    }

    public com.ird.faa.bean.referentiel.Etablissement getEtablissement()  {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement)  {
        this.etablissement = etablissement;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructureOganisatrice structureOganisatrice = (StructureOganisatrice) o;
        return id != null && id.equals(structureOganisatrice.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

