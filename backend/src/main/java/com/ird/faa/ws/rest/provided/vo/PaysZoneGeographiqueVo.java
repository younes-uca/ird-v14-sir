package com.ird.faa.ws.rest.provided.vo;

import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.ZoneGeographique;

public class PaysZoneGeographiqueVo {
	private String dataKey;
	private String libelle;
	private Pays pays;
	private ZoneGeographique zoneGeographique;

	public PaysZoneGeographiqueVo() {
		super();
	}

	public PaysZoneGeographiqueVo(Pays pays, ZoneGeographique zoneGeographique) {
		super();
		this.pays = pays;
		this.zoneGeographique = zoneGeographique;
		if(pays!=null) {
			this.libelle=pays.getLibelle();
			this.dataKey="p"+pays.getId();
		}else if(zoneGeographique!=null){
			this.libelle=zoneGeographique.getLibelle();
			this.dataKey="z"+zoneGeographique.getId();
		}
	}

	public Pays getPays() {
		return this.pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public ZoneGeographique getZoneGeographique() {
		return this.zoneGeographique;
	}

	public void setZoneGeographique(ZoneGeographique zoneGeographique) {
		this.zoneGeographique = zoneGeographique;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDataKey() {
		return dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

}
