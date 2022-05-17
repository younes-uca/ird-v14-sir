package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_expert")
public class TypeExpert   implements Archivable  {

    @Id
    @SequenceGenerator(name = "type_expert_seq", sequenceName = "type_expert_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_expert_seq")
    private Long id;

    private String libelle;
    private String code;


    public TypeExpert()  {
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
        TypeExpert typeExpert = (TypeExpert) o;
        return id != null && id.equals(typeExpert.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

