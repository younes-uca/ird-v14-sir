package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "organisme")
public class Organisme   implements Archivable  {

    @Id
    @SequenceGenerator(name = "organisme_seq", sequenceName = "organisme_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organisme_seq")
    private Long id;

    private String intitule;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private Pays pays;


    public Organisme()  {
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

    public String getDescription()  {
        return this.description;
    }

    public void setDescription(String description)  {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organisme organisme = (Organisme) o;
        return id != null && id.equals(organisme.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }


    public Pays getPays()  {
        return pays;
    }


    public void setPays(Pays pays)  {
        this.pays = pays;
    }

}

