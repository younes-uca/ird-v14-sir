package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ville")
public class Ville   implements Archivable  {

    @Id
    @SequenceGenerator(name = "ville_seq", sequenceName = "ville_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ville_seq")
    private Long id;

    private String libelle;
    private String code;

    @ManyToOne
    private Pays pays;


    public Ville()  {
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

    public Pays getPays()  {
        return this.pays;
    }

    public void setPays(Pays pays)  {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return id != null && id.equals(ville.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

