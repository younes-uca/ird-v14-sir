package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @SequenceGenerator(name = "continent_seq", sequenceName = "continent_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "continent_seq")
    private Long id;

    private String libelle;
    private String code;
    /*TODO: fields to add*/
    private String idGraph;
    /*TODO: fin fields to add*/

    public Continent() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return id != null && id.equals(continent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public String getIdGraph() {
        return idGraph;
    }


    public void setIdGraph(String idGraph) {
        this.idGraph = idGraph;
    }

}

