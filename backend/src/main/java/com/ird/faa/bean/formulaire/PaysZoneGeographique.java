package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.ZoneGeographique;

public class PaysZoneGeographique {

    private String libelle;

    private ZoneGeographique zoneGeographique;

    private Pays pays;

    public String getLibelle() {
        return libelle;
    }

    public ZoneGeographique getZoneGeographique() {
        return zoneGeographique;
    }

    public Pays getPays() {
        return pays;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setZoneGeographique(ZoneGeographique zoneGeographique) {
        this.zoneGeographique = zoneGeographique;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public PaysZoneGeographique() {
        super();
    }


}
