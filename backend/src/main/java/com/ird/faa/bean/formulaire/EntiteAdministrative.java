package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.TypeEntiteAdministrative;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "entite_administrative")
public class EntiteAdministrative implements Archivable  {

    @Id
    @SequenceGenerator(name = "entite_administrative_seq", sequenceName = "entite_administrative_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entite_administrative_seq")
    private Long id;

    private String libelle;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private TypeEntiteAdministrative typeEntiteAdministrative;


    public EntiteAdministrative()  {
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

    public String getDescription()  {
        return this.description;
    }

    public void setDescription(String description)  {
        this.description = description;
    }

    public TypeEntiteAdministrative getTypeEntiteAdministrative()  {
        return this.typeEntiteAdministrative;
    }

    public void setTypeEntiteAdministrative(TypeEntiteAdministrative typeEntiteAdministrative)  {
        this.typeEntiteAdministrative = typeEntiteAdministrative;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntiteAdministrative entiteAdministrative = (EntiteAdministrative) o;
        return id != null && id.equals(entiteAdministrative.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

