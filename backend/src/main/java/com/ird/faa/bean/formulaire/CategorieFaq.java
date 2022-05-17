package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "categorie_faq")
public class CategorieFaq {

    @Id
    @SequenceGenerator(name = "categorie_faq_seq", sequenceName = "categorie_faq_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorie_faq_seq")
    private Long id;

    private String libelle;
    private Integer ordre;
    private Boolean archive = false;
    @Transient
    @JsonManagedReference
    private List<Faq> faqs;

    public List<Faq> getFaqs() {
        return faqs;
    }

    public void setFaqs(List<Faq> faqs) {
        this.faqs = faqs;
    }

    public CategorieFaq() {
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

    public Integer getOrdre() {
        return this.ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public Boolean getArchive() {
        return this.archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieFaq categorieFaq = (CategorieFaq) o;
        return id != null && id.equals(categorieFaq.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

