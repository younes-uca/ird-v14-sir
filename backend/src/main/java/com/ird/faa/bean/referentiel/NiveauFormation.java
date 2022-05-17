package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "niveau_formation")
public class NiveauFormation   implements Archivable  {

    @Id
    @SequenceGenerator(name = "niveau_formation_seq", sequenceName = "niveau_formation_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "niveau_formation_seq")
    private Long id;

    private String libelle;
    private String code;


    public NiveauFormation()  {
        super();
    }


    public Long getId()  {
        return this.id;
    }

    public void setId(Long id)  {
        this.id = id;
    }

    public String getLibelle()  {
        return this.libelle;
    }

    public void setLibelle(String libelle)  {
        this.libelle = libelle;
    }

    public String getCode()  {
        return this.code;
    }

    public void setCode(String code)  {
        this.code = code;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NiveauFormation niveauFormation = (NiveauFormation) o;
        return id != null && id.equals(niveauFormation.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

