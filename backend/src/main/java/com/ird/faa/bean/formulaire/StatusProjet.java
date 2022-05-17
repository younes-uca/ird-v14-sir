package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "status_projet")
public class StatusProjet   implements Archivable  {

    @Id
    @SequenceGenerator(name = "status_projet_seq", sequenceName = "status_projet_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_projet_seq")
    private Long id;

    private String libelle;
    private String code;


    public StatusProjet()  {
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
        StatusProjet statusProjet = (StatusProjet) o;
        return id != null && id.equals(statusProjet.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

