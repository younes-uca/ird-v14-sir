package com.ird.faa.bean.referentiel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.Archivable;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "niveau_formation_post_bac")
public class NiveauFormationPostBac implements Archivable   implements Archivable  {

    @Id
    @SequenceGenerator(name = "niveau_formation_post_bac_seq", sequenceName = "niveau_formation_post_bac_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "niveau_formation_post_bac_seq")
    private Long id;

    private String code;
    private String libelle;
    @Column(columnDefinition = "boolean default false")
    private Boolean archive;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateArchivage;


    public NiveauFormationPostBac()  {
        super();
    }


    public Long getId()  {
        return this.id;
    }

    public void setId(Long id)  {
        this.id = id;
    }

    public String getCode()  {
        return this.code;
    }

    public void setCode(String code)  {
        this.code = code;
    }

    public String getLibelle()  {
        return this.libelle;
    }

    public void setLibelle(String libelle)  {
        this.libelle = libelle;
    }

    public Boolean getArchive()  {
        return this.archive;
    }

    public void setArchive(Boolean archive)  {
        this.archive = archive;
    }

    public Date getDateArchivage()  {
        return this.dateArchivage;
    }

    public void setDateArchivage(Date dateArchivage)  {
        this.dateArchivage = dateArchivage;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NiveauFormationPostBac niveauFormationPostBac = (NiveauFormationPostBac) o;
        return id != null && id.equals(niveauFormationPostBac.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

