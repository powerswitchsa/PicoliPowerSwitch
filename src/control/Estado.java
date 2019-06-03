package control;

import java.util.ArrayList;

import modelo.CapitalEstado;
import modelo.Factoria;
import modelo.TipoSeres;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;

public class Estado {

	private Poblacion poblacion;
	private Industria industria;
	private CapitalEstado capitalEstado;

	private double demanda = 1500000;

	public Estado() {
		super();
		this.industria = new Industria();
		this.poblacion = new Poblacion(800, 2000, 500);
		this.capitalEstado = new CapitalEstado(100000);
	}

	public void pasarAño() {
		this.poblacion.setResetDatos();
		this.industria.setEliminarTrabajadores(this.poblacion.setEliminarMuertos(capitalEstado));
		this.industria.setEliminarTrabajadores(this.poblacion.setActualizarSer());
		double cuenta = this.demanda
				- (this.industria.getProduccionTotal() + (this.poblacion.getNumTipoSer(TipoSeres.menor) * 1000));
		if (cuenta > 0) {
			this.poblacion.setNacimientos((int) cuenta / 1000);
			this.industria.setContratarDesempleados(this.poblacion.getDesempleados());
		} else {
			this.poblacion.setDespedir(
					this.industria.setDespedirEmpleados((int) (this.industria.getProduccionTotal() - demanda) / 1000));
		}
		this.capitalEstado.setDineroEstado(capitalEstado.getDineroEstado() + industria.getProduccionTotal());
		this.poblacion.setPagarTrabajadores(capitalEstado);
		this.poblacion.setPagarMenores(capitalEstado);
		this.poblacion.setPagarDesempleados(capitalEstado);
		this.poblacion.setPagarJubilados(capitalEstado);
		this.poblacion.setEnvejecerPoblacion();
		this.industria.setEliminarFactoriasVacias();
		this.poblacion.setActualizarSer();
	}

	public ArrayList<Factoria> getListaFactorias() {
		ArrayList<Factoria> lista = this.industria.getFactorias();
		return lista;
	}

	public DatosPoblacion getDatosPoblacion() {
		return new DatosPoblacion(this.poblacion.getSeres().size(), this.poblacion.getNumTipoSer(TipoSeres.menor),
				this.industria.getNumTrabajadores(), this.poblacion.getNumTipoSer(TipoSeres.desempleado),
				this.poblacion.getNumTipoSer(TipoSeres.jubilado), this.poblacion.getNewMenores(),
				this.poblacion.getFallecidos(), this.poblacion.getNewJubilados(), this.poblacion.getNewTrabajadores());
	}

	public DatosEstadoGlobal getDatosEstadoGlobales() {
		return new DatosEstadoGlobal(this.demanda, this.industria.getProduccionTotal(),
				(int) this.capitalEstado.getDineroEstado(), this.getCalcularCrecimientoAnual());
	}

	private double getCalcularCrecimientoAnual() {
		double porcentaje;
		porcentaje = ((this.industria.getProduccionTotal() * 100) / this.demanda) - 100;
		return porcentaje;
	}

	public DatosEstadoLocal getDatosEstadoLocal() {
		return new DatosEstadoLocal(this.industria.getFactorias().size());
	}

	public void setAumentarDemanda(double demanda) {
		this.demanda += demanda;
	}

	public void setDisminuirDemanda(double demanda) {
		this.demanda -= demanda;
	}

}
