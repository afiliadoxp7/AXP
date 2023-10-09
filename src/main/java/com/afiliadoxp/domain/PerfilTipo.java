package com.afiliadoxp.domain;

public enum PerfilTipo {
	ADMIN(1, "ADMIN"), AFILIADO(2, "AFILIADO"), START(3, "START");
	
	private long cod;
	private String desc;

	private PerfilTipo(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
