package com.nff.insideWorks.insideworksexercise4.entity.enuns;

public enum Categoria {
	
	OFFROAD(1),
	PASSEIO(2),
	PICAPE(3),
	SPORT(4);
	
	private Categoria(Integer cod) {
		this.cod = cod;
	}
	
	private Integer cod;

	public Integer getCod() {
		return cod;
	}

	
	

}
