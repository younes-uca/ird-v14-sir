package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.EnjeuxIrd;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rencontre_media_enjeux_ird")
public class RencontreMediaEnjeuxIrd {

    @Id
    @SequenceGenerator(name = "rencontre_media_enjeux_ird_seq", sequenceName = "rencontre_media_enjeux_ird_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rencontre_media_enjeux_ird_seq")
    private Long id;


    @ManyToOne
    private RencontreMedia rencontreMedia;
    @ManyToOne
    private EnjeuxIrd enjeuxIrd;


    public RencontreMediaEnjeuxIrd() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RencontreMedia getRencontreMedia() {
        return this.rencontreMedia;
    }

    public void setRencontreMedia(RencontreMedia rencontreMedia) {
        this.rencontreMedia = rencontreMedia;
    }

    public EnjeuxIrd getEnjeuxIrd() {
        return this.enjeuxIrd;
    }

    public void setEnjeuxIrd(EnjeuxIrd enjeuxIrd) {
        this.enjeuxIrd = enjeuxIrd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RencontreMediaEnjeuxIrd rencontreMediaEnjeuxIrd = (RencontreMediaEnjeuxIrd) o;
        return id != null && id.equals(rencontreMediaEnjeuxIrd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

