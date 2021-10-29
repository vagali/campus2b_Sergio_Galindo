package com.cursos.domain;
/**
 * Maquina con un solo Refresco.
 * @author Sergio Galindo
 *
 */
public class Maquina {
	private Refresco refresco;
	private float cambio;
	private boolean estadoCambioDisponible;
	
	public Maquina() {
		super(); // this(new Refresco(),4,true); ----------------->llamar a otro constructor;
		refresco = new Refresco();
		cambio = 100;
		estadoCambioDisponible = false;
	}
	
	public Maquina(Refresco refresco, float cambio, boolean estadoCambioDisponible) {
		super();
		this.refresco = refresco;
		this.cambio = cambio;
		this.estadoCambioDisponible = estadoCambioDisponible;
	}

	public Refresco getRefresco() {
		return refresco;
	}

	public void setRefresco(Refresco refresco) {
		this.refresco = refresco;
	}

	public float getCambio() {
		return cambio;
	}

	public void setCambio(float cambio) {
		this.cambio = cambio;
	}

	public boolean isEstadoCambioDisponible() {
		return estadoCambioDisponible;
	}

	public void setEstadoCambioDisponible(boolean estadoCambioDisponible) {
		this.estadoCambioDisponible = estadoCambioDisponible;
	}
	
	public float getCambioDevuelto(float efectivo) {
		float dinero = 0;
		if(estadoCambioDisponible) {
			dinero = efectivo - refresco.getPrecio();
		}
		return dinero;
	}
	
	public boolean comprar(float efectivo) {
		boolean correcto = false;;
		if(!refresco.getEstadoDispo()) {
			System.out.println("no hay producto disponible");
			correcto = false;
		}else {
			if(estadoCambioDisponible) {
				if(efectivo > refresco.getPrecio()) {
					refresco.setNumVendidos(refresco.getNumVendidos()+1);
					cambio -= refresco.getPrecio();
					refresco.setNumProductosDispos(refresco.getNumProductosDispos()-1);
					if(refresco.getNumProductosDispos() == 0) {
						refresco.setEstadoDisponible(false);
					}
					System.out.println(this.getCambioDevuelto(efectivo));
					System.out.println(refresco);
					correcto = true;
				}else {
					System.out.println("Efectivo no suficiente");
					correcto = false;
				}
			}else {
				System.out.println("Cambio insuficiente");
				correcto = false;
			}
		}
		return correcto;
	}
	
	public boolean retirarCambio(float cambio) {
		if(cambio > this.cambio) {
			return false;
		}else {
			if(this.cambio - cambio >= 100) {
				this.cambio -= cambio;
				return true;
			}else
				return false;
		}
	}
	
	public String getEstadoActual() {
		return refresco.getEstadoActual()+", Cambio disponible: " + cambio; 
	}
	@Override
	public String toString() {
		return "Maquina [refresco=" + refresco + ", cambio=" + cambio + ", estadoCambioDisponible="
				+ estadoCambioDisponible + "]";
	}
	
	
}
