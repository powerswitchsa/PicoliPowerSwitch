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
		this.datosVista = new DatosVista(poblacion.getSeres().size(), poblacion.getNumTipoSer(TipoSeres.menor),
				poblacion.getNumTipoSer(TipoSeres.trabajador), poblacion.getNumTipoSer(TipoSeres.jubilado),
				poblacion.getNewMenores(), poblacion.getFallecidos(), poblacion.getNewJubilados(),
				industria.getNumTrabajadores(), industria.getFactorias().size(), capitalEstado.getDineroEstado(),
				poblacion.getNumTipoSer(TipoSeres.desempleado));
	}

	public void actualizarListas() {
		this.industria.contratar(this.poblacion.getDesempleados());
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
		this.poblacion.actualizarSer();

		this.datosVista = new DatosVista(poblacion.getSeres().size(), poblacion.getNumTipoSer(TipoSeres.menor),
				poblacion.getNumTipoSer(TipoSeres.trabajador), poblacion.getNumTipoSer(TipoSeres.jubilado),
				poblacion.getNewMenores(), poblacion.getFallecidos(), poblacion.getNewJubilados(),
				industria.getNumTrabajadores(), industria.getFactorias().size(), capitalEstado.getDineroEstado(),
				poblacion.getNumTipoSer(TipoSeres.desempleado));
	}

	public ArrayList<String> getDatosVista() {
		return datosVista.getDatos();
	}

}
