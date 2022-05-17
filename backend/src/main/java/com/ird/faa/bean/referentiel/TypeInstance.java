package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_instance")
public class TypeInstance   implements Archivable  {

    @Id
    @SequenceGenerator(name = "type_instance_seq", sequenceName = "type_instance_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_instance_seq")
    private Long id;

    private String code;
    private String libelle;


    public TypeInstance()  {
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
        TypeInstance typeInstance = (TypeInstance) o;
        return id != null && id.equals(typeInstance.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

