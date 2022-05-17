package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "statut_master")
public class StatutMaster   implements Archivable  {

    @Id
    @SequenceGenerator(name = "statut_master_seq", sequenceName = "statut_master_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statut_master_seq")
    private Long id;

    private String libelle;
    private String code;


    public StatutMaster()  {
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
        StatutMaster statutMaster = (StatutMaster) o;
        return id != null && id.equals(statutMaster.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

