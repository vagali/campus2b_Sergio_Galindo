package com.cursos.domain;

public class MaquinaRefrescos {
	private Refresco[] refrescos;
	private float cambio;
	private boolean estadoCambioDisponible;

	public MaquinaRefrescos() {
		super();
		refrescos = new Refresco[3];
		cambio = 100;
		estadoCambioDisponible = false;
	}

	public MaquinaRefrescos(Refresco refresco[], float cambio, boolean estadoCambioDisponible) {
		super();
		this.refrescos = refresco;
		this.cambio = cambio;
		this.estadoCambioDisponible = estadoCambioDisponible;
	}

	public Refresco[] getRefresco() {
		return refrescos;
	}

	public void setRefresco(Refresco[] refresco) {
		this.refrescos = refresco;
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

	public float getCambioDevuelto(float efectivo, Refresco refresco) {
		float dinero = 0;
		if (estadoCambioDisponible) {
			dinero = efectivo - refresco.getPrecio();
		}
		return dinero;
	}

	public boolean comprar(float efectivo, Refresco refresco) {
		boolean correcto = false;
		;
		if (!refresco.getEstadoDispo()) {
			System.out.println("no hay producto disponible");
			correcto = false;
		} else {
			if (estadoCambioDisponible) {
				if (efectivo > refresco.getPrecio()) {
					refresco.setNumVendidos(refresco.getNumVendidos() + 1);
					cambio -= refresco.getPrecio();
					refresco.setNumProductosDispos(refresco.getNumProductosDispos() - 1);
					if (refresco.getNumProductosDispos() == 0) {
						refresco.setEstadoDisponible(false);
					}
					System.out.println(this.getCambioDevuelto(efectivo, refresco));
					System.out.println(refresco);
					correcto = true;
				} else {
					System.out.println("Efectivo no suficiente");
					correcto = false;
				}
			} else {
				System.out.println("Cambio insuficiente");
				correcto = false;
			}
		}
		return correcto;
	}

	public boolean retirarCambio(float cambio) {
		if (cambio > this.cambio) {
			return false;
		} else {
			if (this.cambio - cambio >= 100) {
				this.cambio -= cambio;
				return true;
			} else
				return false;
		}
	}

	public String[] getEstadoActual() {
		String estado = "------------------------------\n"
				+ "Cambio disponible: " + cambio;
		String[] refrescosEstado = new String[refrescos.length + 1];
		
		for (int i = 0; i < refrescos.length; i++) {
			refrescosEstado[i] = refrescos[i].getEstadoActual();
		}
		refrescosEstado[3] = estado;
		
		return refrescosEstado;
	}

	@Override
	public String toString() {
		return "Maquina [refresco=" + refrescos + ", cambio=" + cambio + ", estadoCambioDisponible="
				+ estadoCambioDisponible + "]";
	}

}
