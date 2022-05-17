package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "corps")
public class Corps {

    @Id
    @SequenceGenerator(name = "corps_seq", sequenceName = "corps_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corps_seq")
    private Long id;

    private String libelle;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;
    /* TODO: add fields*/
    private String idGraph;
    /* TODO: fin  add fields*/


    public Corps() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corps corps = (Corps) o;
        return id != null && id.equals(corps.id);
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

