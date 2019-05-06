package control;

import java.util.ArrayList;

import modelo.CapitalEstado;
import modelo.DatosVista;
import modelo.TipoSeres;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;

public class Estado {

	private Poblacion poblacion;
	private Industria industria;
	private DatosVista datosVista;
	private CapitalEstado capitalEstado;

	private double demanda = 100000;

	public Estado() {
		super();
		this.industria = new Industria();
		this.poblacion = new Poblacion(50, 100, 30);
		this.capitalEstado = new CapitalEstado(100000);
	}

	public void pasarAño() {
		this.poblacion.setResetDatos();
		double cuenta = this.demanda
				- (this.industria.getProduccionTotal() + (this.poblacion.getNumTipoSer(TipoSeres.menor) * 1000));
		if (cuenta > 0) {
			int nacimientos = (int) cuenta / 1000;
			this.poblacion.setNacimientos(nacimientos);
			this.industria.setContratarDesempleados(this.poblacion.getDesempleados());
		} else {
			cuenta-=((this.poblacion.getNumTipoSer(TipoSeres.menor))*1000);
			int despidos = Math.abs((int) cuenta / 1000);
			ArrayList<Integer> listaDespidos = this.industria.setDespedirEmpleados((int) despidos);
			this.poblacion.setDespedir(listaDespidos);

		}
		this.capitalEstado.setDineroEstado(capitalEstado.getDineroEstado() + industria.getProduccionTotal());
		this.poblacion.setPagarTrabajadores(capitalEstado);
		this.poblacion.setPagarMenores(capitalEstado);
		this.poblacion.setPagarDesempleados(capitalEstado);
		this.poblacion.setPagarJubilados(capitalEstado);
		this.poblacion.setEnvejecerPoblacion();
		this.industria.setEliminarTrabajadores(this.poblacion.setEliminarMuertos(capitalEstado));
		this.industria.setEliminarTrabajadores(this.poblacion.setActualizarSer());
		this.industria.setEliminarFactoriasVacias();
		this.poblacion.setActualizarSer();
	}

	public DatosPoblacion getDatosPoblacion() {
		return new DatosPoblacion(this.poblacion.getSeres().size(), this.poblacion.getNumTipoSer(TipoSeres.menor),
				this.poblacion.getNumTipoSer(TipoSeres.desempleado), this.poblacion.getNumTipoSer(TipoSeres.trabajador),
				this.poblacion.getNumTipoSer(TipoSeres.jubilado), this.poblacion.getNewMenores(),
				this.poblacion.getFallecidos(), this.poblacion.getNewJubilados(), this.poblacion.getNewTrabajadores());
	}

	public DatosEstadoGlobal getDatosEstadoGlobales() {
		return new DatosEstadoGlobal(this.demanda, this.industria.getProduccionTotal(),
				(int) this.capitalEstado.getDineroEstado(), 0);
	}

	public DatosEstadoLocal getDatosEstadoLocal() {
		return new DatosEstadoLocal(0, 0, 0, 0, this.industria.getFactorias().size(), 0);
	}

	public ArrayList<String> getDatosVista() {
		return datosVista.getDatos();
	}

	public void setAumentarDemanda(double demanda) {
		this.demanda += demanda;
	}

	public void setDisminuirDemanda(double demanda) {
		this.demanda -= demanda;
	}

}
