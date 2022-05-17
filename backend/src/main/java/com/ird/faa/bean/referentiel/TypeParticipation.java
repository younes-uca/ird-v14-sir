package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_participation")
public class TypeParticipation   implements Archivable  {

    @Id
    @SequenceGenerator(name = "type_participation_seq", sequenceName = "type_participation_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_participation_seq")
    private Long id;

    private String code;
    private String libelle;


    public TypeParticipation()  {
        super();
    }


    public Long getId()  {
        return this.id;
    }

    public void setId(Long id)  {
        this.id = id;
    }

    public String getCode()  {
        return this.code;
    }

    public void setCode(String code)  {
        this.code = code;
    }

    public String getLibelle()  {
        return this.libelle;
    }

    public void setLibelle(String libelle)  {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeParticipation typeParticipation = (TypeParticipation) o;
        return id != null && id.equals(typeParticipation.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

