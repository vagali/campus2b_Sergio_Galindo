package com.cursos.domain;

public class Refresco {
	private String marca;
	private float precio;
	private boolean estadoDisponible;
	private int numVendidos;
	private int numProductosDispos;
	private boolean reponer;
	
	public Refresco() {
		super();
		marca = "";
		precio = 0;
		estadoDisponible = false;
		numVendidos = 0;
		numProductosDispos = 0;
		reponer = false;
	}
	
	public Refresco(String marca, float precio, boolean estadoDisponible, int numVendidos, int numProductosDispos, boolean reponer) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.estadoDisponible = estadoDisponible;
		this.numVendidos = numVendidos;
		this.numProductosDispos = numProductosDispos;
		this.reponer = reponer;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isEstadoDisponible() {
		return estadoDisponible;
	}

	public void setEstadoDisponible(boolean estadoDisponible) {
		this.estadoDisponible = estadoDisponible;
	}

	public int getNumVendidos() {
		return numVendidos;
	}

	public void setNumVendidos(int numVendidos) {
		this.numVendidos = numVendidos;
	}

	public int getNumProductosDispos() {
		return numProductosDispos;
	}

	public void setNumProductosDispos(int numProductosDispos) {
		this.numProductosDispos = numProductosDispos;
	}
	
	public boolean isReponer() {
		return reponer;
	}

	public void setReponer(boolean reponer) {
		this.reponer = reponer;
	}

	public boolean getEstadoDispo() {
		if(numProductosDispos > 0) {
			return true;
		}
		return false;
	}
	public String getEstadoActual() {
		return "Nombre del producto: "+marca+", Numero del producto disponibles :"+numProductosDispos;
	}
	public boolean reponer(int numRefresco) {
		if(numRefresco <= 0) {
			System.out.println("Numero de productos a introducir no valido");
			return false;
		}else {
			this.numProductosDispos +=numRefresco;
			System.out.println("Producto repuesto satisfacotriamente.\n"
					+ "La cantidad del producto es de: "+this.numProductosDispos);
			return true;
		}
	}
	@Override
	public String toString() {
		return "Refresco [marca=" + marca + ", precio=" + precio + ", estadoDisponible=" + estadoDisponible
				+ ", numVendidos=" + numVendidos + ", numProductosDispos=" + numProductosDispos + ", reponer=" + reponer
				+ "]";
	}
	
	
	
}
