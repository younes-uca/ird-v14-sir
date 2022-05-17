package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ecole_doctorale")
public class EcoleDoctorale {

    @Id
    @SequenceGenerator(name = "ecole_doctorale_seq", sequenceName = "ecole_doctorale_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecole_doctorale_seq")
    private Long id;

    private String intitule;
    private Boolean international;

    @ManyToOne
    private Pays pays;


    public EcoleDoctorale() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Boolean getInternational() {
        return this.international;
    }

    public void setInternational(Boolean international) {
        this.international = international;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EcoleDoctorale ecoleDoctorale = (EcoleDoctorale) o;
        return id != null && id.equals(ecoleDoctorale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

