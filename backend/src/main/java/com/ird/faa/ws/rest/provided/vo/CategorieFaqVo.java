package com.ird.faa.ws.rest.provided.vo;


import com.ird.faa.bean.formulaire.Faq;

import java.util.List;

public class CategorieFaqVo {

    private String id;
    private String libelle;
    private String ordre;
    private Boolean archive;
    private List<Faq> faqs;

    public List<Faq> getFaqs() {
        return faqs;
    }

    public void setFaqs(List<Faq> faqs) {
        this.faqs = faqs;
    }

    private String ordreMax;
    private String ordreMin;


    public CategorieFaqVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getOrdre() {
        return this.ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public Boolean getArchive() {
        return this.archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }


    public String getOrdreMax() {
        return this.ordreMax;
    }

    public String getOrdreMin() {
        return this.ordreMin;
    }

    public void setOrdreMax(String ordreMax) {
        this.ordreMax = ordreMax;
    }

    public void setOrdreMin(String ordreMin) {
        this.ordreMin = ordreMin;
    }


}
