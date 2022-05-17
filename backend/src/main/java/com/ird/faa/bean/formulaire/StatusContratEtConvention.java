package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "status_contrat_et_convention")
public class StatusContratEtConvention   implements Archivable  {

    @Id
    @SequenceGenerator(name = "status_contrat_et_convention_seq", sequenceName = "status_contrat_et_convention_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_contrat_et_convention_seq")
    private Long id;

    private String libelle;
    private String code;


    public StatusContratEtConvention()  {
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
        StatusContratEtConvention statusContratEtConvention = (StatusContratEtConvention) o;
        return id != null && id.equals(statusContratEtConvention.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

