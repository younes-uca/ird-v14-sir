package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_outil")
public class TypeOutil   implements Archivable  {

    @Id
    @SequenceGenerator(name = "type_outil_seq", sequenceName = "type_outil_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_outil_seq")
    private Long id;

    private String libelle;
    private String code;
    @Column(columnDefinition = "boolean default false")
    private Boolean numerique;


    public TypeOutil()  {
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

    public Boolean getNumerique()  {
        return numerique;
    }


    public void setNumerique(Boolean numerique)  {
        this.numerique = numerique;
    }


    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOutil typeOutil = (TypeOutil) o;
        return id != null && id.equals(typeOutil.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

