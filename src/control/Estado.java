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

	public Estado() {
		super();
		this.poblacion = new Poblacion(50, 100, 30);
		this.industria = new Industria();
		this.capitalEstado = new CapitalEstado(100000);
		this.datosVista = new DatosVista(poblacion.getSeres().size(), poblacion.getListSer(TipoSeres.menor).size(),
				poblacion.getListSer(TipoSeres.trabajador).size(), poblacion.getListSer(TipoSeres.jubilado).size(),
				poblacion.getNewMenores(), poblacion.getFallecidos(), poblacion.getNewJubilados(),
				poblacion.getNewTrabajadores(), industria.getFactorias().size(), capitalEstado.getDineroEstado(),
				poblacion.getListSer(TipoSeres.desempleado).size());
	}

	public void actualizarListas() {
		this.capitalEstado.sumarDineroEstado(industria.getProduccionTotal());
		this.poblacion.pagarTrabajadores(capitalEstado);
		this.poblacion.pagarMenores(capitalEstado);
		this.poblacion.pagarDesempleados(capitalEstado);
		this.poblacion.pagarJubilados(capitalEstado);
		this.poblacion.envejecerPoblacion();
		ArrayList<Integer> listaIdMuertos = this.poblacion.eliminarMuertos(capitalEstado);
		industria.eliminarTrabajadores(listaIdMuertos);
		ArrayList<Integer> listaIdJubilados = this.poblacion.actualizarSer();
		industria.eliminarTrabajadores(listaIdJubilados);

		this.datosVista = new DatosVista(poblacion.getSeres().size(), poblacion.getListSer(TipoSeres.menor).size(),
				poblacion.getListSer(TipoSeres.trabajador).size(), poblacion.getListSer(TipoSeres.jubilado).size(),
				poblacion.getNewMenores(), poblacion.getFallecidos(), poblacion.getNewJubilados(),
				poblacion.getNewTrabajadores(), industria.getFactorias().size(), capitalEstado.getDineroEstado(),
				poblacion.getListSer(TipoSeres.desempleado).size());
	}

	public ArrayList<String> getDatosVista() {
		return datosVista.getDatos();
	}

}
