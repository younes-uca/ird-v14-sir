package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pays")
public class Pays   implements Archivable  {

    @Id
    @SequenceGenerator(name = "pays_seq", sequenceName = "pays_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pays_seq")
    private Long id;

    private String libelle;
    private String code;

    @ManyToOne
    private Continent continent;
    /*TODO:add fields*/
    private String idGraph;
    /*TODO: fin add fields*/


    public Pays()  {
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

    public Continent getContinent()  {
        return this.continent;
    }

    public void setContinent(Continent continent)  {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pays pays = (Pays) o;
        return id != null && id.equals(pays.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }


    public String getIdGraph()  {
        return idGraph;
    }


    public void setIdGraph(String idGraph)  {
        this.idGraph = idGraph;
    }

}

