package com.ird.faa.ws.rest.provided.vo;

public class OutilPedagogiquePeriodeVo {

	private String id;
	private String dateDiffusion;
	private OutilPedagogiqueVo outilPedagogiqueVo;


	public OutilPedagogiquePeriodeVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateDiffusion() {
		return dateDiffusion;
	}

	public void setDateDiffusion(String dateDiffusion) {
		this.dateDiffusion = dateDiffusion;
	}

	public OutilPedagogiqueVo getOutilPedagogiqueVo() {
		return outilPedagogiqueVo;
	}

	public void setOutilPedagogiqueVo(OutilPedagogiqueVo outilPedagogiqueVo) {
		this.outilPedagogiqueVo = outilPedagogiqueVo;
	}
}
