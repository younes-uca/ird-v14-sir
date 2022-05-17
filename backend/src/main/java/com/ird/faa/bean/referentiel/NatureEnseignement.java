package com.ird.faa.bean.referentiel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.Archivable;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "nature_enseignement")
public class NatureEnseignement implements Archivable   implements Archivable  {

    @Id
    @SequenceGenerator(name = "nature_enseignement_seq", sequenceName = "nature_enseignement_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nature_enseignement_seq")
    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "boolean default false")
    private Boolean archive = false;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateArchivage;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;


    public NatureEnseignement()  {
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

    public Date getDateCreation()  {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation)  {
        this.dateCreation = dateCreation;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NatureEnseignement natureEnseignement = (NatureEnseignement) o;
        return id != null && id.equals(natureEnseignement.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}
