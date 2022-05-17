package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "master")
public class Master   implements Archivable  {

    @Id
    @SequenceGenerator(name = "master_seq", sequenceName = "master_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "master_seq")
    private Long id;

    private String intitule;
    private String code;
    private Boolean international;

    @ManyToOne
    private Pays pays;


    public Master()  {
        super();
    }


    public Long getId()  {
        return this.id;
    }

    public void setId(Long id)  {
        this.id = id;
    }

    public String getIntitule()  {
        return this.intitule;
    }

    public void setIntitule(String intitule)  {
        this.intitule = intitule;
    }

    public String getCode()  {
        return this.code;
    }

    public void setCode(String code)  {
        this.code = code;
    }

    public Boolean getInternational()  {
        return this.international;
    }

    public void setInternational(Boolean international)  {
        this.international = international;
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
        Master master = (Master) o;
        return id != null && id.equals(master.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

