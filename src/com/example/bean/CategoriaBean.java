package com.example.bean;

public class CategoriaBean {

	private String cat_id, plat_id, cat_descripcion, cat_estado, cat_diahora;

	public CategoriaBean() {
	}

	public CategoriaBean(String cat_id, String plat_id, String cat_descripcion,
			String cat_estado, String cat_diahora) {
		super();
		this.cat_id = cat_id;
		this.plat_id = plat_id;
		this.cat_descripcion = cat_descripcion;
		this.cat_estado = cat_estado;
		this.cat_diahora = cat_diahora;
	}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public String getPlat_id() {
		return plat_id;
	}

	public void setPlat_id(String plat_id) {
		this.plat_id = plat_id;
	}

	public String getCat_descripcion() {
		return cat_descripcion;
	}

	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}

	public String getCat_estado() {
		return cat_estado;
	}

	public void setCat_estado(String cat_estado) {
		this.cat_estado = cat_estado;
	}

	public String getCat_diahora() {
		return cat_diahora;
	}

	public void setCat_diahora(String cat_diahora) {
		this.cat_diahora = cat_diahora;
	}

}
