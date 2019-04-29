package control;

import java.util.ArrayList;

import modelo.CapitalEstado;
import modelo.DatosVista;
import modelo.Ser;
import modelo.TipoSeres;

public class Estado {

	private Poblacion poblacion;
	private Industria industria;
	private DatosVista datosVista;
	private CapitalEstado capitalEstado;

	public Estado() {
		super();
		this.industria = new Industria();
		this.poblacion = new Poblacion(50, 100, 30);
		this.capitalEstado = new CapitalEstado(100000);
		actualizarDatosVista();
	}

	public void pasarAño() {
		actualizarDatosVista();
		this.poblacion.resetDatos();
		this.industria.setContratarDesempleados(this.poblacion.getDesempleados());
		this.capitalEstado.setDineroEstado(capitalEstado.getDineroEstado() + industria.getProduccionTotal());
		this.poblacion.setPagarTrabajadores(capitalEstado);
		this.poblacion.sePagarMenores(capitalEstado);
		this.poblacion.setPagarDesempleados(capitalEstado);
		this.poblacion.setPagarJubilados(capitalEstado);
		this.poblacion.setEnvejecerPoblacion();
		ArrayList<Integer> listaIdMuertos = this.poblacion.setEliminarMuertos(capitalEstado);
		industria.setEliminarTrabajadores(listaIdMuertos);
		ArrayList<Integer> listaIdJubilados = this.poblacion.setActualizarSer();
		industria.setEliminarTrabajadores(listaIdJubilados);
		this.poblacion.setActualizarSer();
		this.industria.setEliminarFactoriasVacias();
	}

	private void actualizarDatosVista() {
		this.datosVista = new DatosVista(poblacion.getSeres().size(), poblacion.getNumTipoSer(TipoSeres.menor),
				poblacion.getNumTipoSer(TipoSeres.trabajador), poblacion.getNumTipoSer(TipoSeres.jubilado),
				poblacion.getNewMenores(), poblacion.getFallecidos(), poblacion.getNewJubilados(),
				poblacion.getNewTrabajadores(), industria.getFactorias().size(), capitalEstado.getDineroEstado(),
				poblacion.getNumTipoSer(TipoSeres.desempleado), industria.getProduccionTotal());
	}

	public ArrayList<String> getDatosVista() {
		return datosVista.getDatos();
	}

}
