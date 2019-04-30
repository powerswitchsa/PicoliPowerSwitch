package control;

import java.util.ArrayList;

import modelo.CapitalEstado;
import modelo.DatosVista;
import modelo.TipoSeres;

public class Estado {

	private Poblacion poblacion;
	private Industria industria;
	private DatosVista datosVista;
	private CapitalEstado capitalEstado;

	private double demanda = 100000;

	private int años = 0;

	public Estado() {
		super();
		this.industria = new Industria();
		this.poblacion = new Poblacion(50, 100, 30);
		this.capitalEstado = new CapitalEstado(100000);
		actualizarDatosVista();
	}

	public void pasarAño() {
		actualizarDatosVista();
		this.poblacion.setResetDatos();
		if (this.demanda > this.industria.getProduccionTotal()) {
			double cuenta = this.demanda - (this.industria.getProduccionTotal()
					+ (poblacion.getNumTipoSer(TipoSeres.menor) * 1000));
			System.out.println(cuenta);
			if (cuenta > 0) {
				int nacimientos = (int) cuenta / 1000;
				this.poblacion.setNacimientos(nacimientos);
			}
		} else {
//			double cuenta = this.demanda - this.industria.getProduccionTotal();
//			int despidos = (int) cuenta / 1000;
//			ArrayList<Integer> listaDespidos = this.industria.setDespedirEmpleados((int) despidos);
//			this.poblacion.setDespedir(listaDespidos);
		}
		this.industria.setEliminarFactoriasVacias();
		this.industria.setContratarDesempleados(this.poblacion.getDesempleados());
		this.capitalEstado.setDineroEstado(capitalEstado.getDineroEstado() + industria.getProduccionTotal());
		this.poblacion.setPagarTrabajadores(capitalEstado);
		this.poblacion.setPagarMenores(capitalEstado);
		this.poblacion.setPagarDesempleados(capitalEstado);
		this.poblacion.setPagarJubilados(capitalEstado);
		this.poblacion.setEnvejecerPoblacion();
		ArrayList<Integer> listaIdMuertos = this.poblacion.setEliminarMuertos(capitalEstado);
		this.industria.setEliminarTrabajadores(listaIdMuertos);
		ArrayList<Integer> listaIdJubilados = this.poblacion.setActualizarSer();
		industria.setEliminarTrabajadores(listaIdJubilados);
		this.poblacion.setActualizarSer();
		this.años++;
	}

	private void actualizarDatosVista() {
		this.datosVista = new DatosVista(poblacion.getSeres().size(), poblacion.getNumTipoSer(TipoSeres.menor),
				poblacion.getNumTipoSer(TipoSeres.trabajador), poblacion.getNumTipoSer(TipoSeres.jubilado),
				poblacion.getNewMenores(), poblacion.getFallecidos(), poblacion.getNewJubilados(),
				poblacion.getNewTrabajadores(), industria.getFactorias().size(), capitalEstado.getDineroEstado(),
				poblacion.getNumTipoSer(TipoSeres.desempleado), industria.getProduccionTotal(), this.años,
				this.demanda);
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
