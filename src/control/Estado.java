package control;

import java.util.ArrayList;
import java.util.Stack;

import modelo.CapitalEstado;
import modelo.DatosVista;
import modelo.Factoria;
import modelo.Ser;
import modelo.seres.Jubilado;
import modelo.seres.Menor;
import modelo.seres.Trabajador;
import utilesglobal.Utilies;

public class Estado {

	private ArrayList<Ser> seres;
	private ArrayList<Menor> menores;
	private Stack<Trabajador> desempleados;
	private ArrayList<Jubilado> jubilados;

	private LogicaPoblacion logicaPoblacion;
	private Industria industria;
	private DatosVista datosVista;
	private CapitalEstado capitalEstado;

	public Estado() {
		super();
		this.seres = new ArrayList<Ser>();
		this.logicaPoblacion = new LogicaPoblacion();
		this.menores = new ArrayList<Menor>();
		this.desempleados = new Stack<Trabajador>();
		this.jubilados = new ArrayList<Jubilado>();
		this.industria = new Industria();
		this.capitalEstado = new CapitalEstado(100000);

		for (int i = 0; i < 50; i++) {
			seres.add(new Menor(logicaPoblacion.getId()));
			logicaPoblacion.setId(logicaPoblacion.getId() + 1);
		}
		for (int i = 0; i < 100; i++) {
			seres.add(new Trabajador(Utilies.getNombreAleatorio(), logicaPoblacion.getId()));
			logicaPoblacion.setId(logicaPoblacion.getId() + 1);
		}
		for (int i = 0; i < 30; i++) {
			seres.add(new Jubilado(Utilies.getNombreAleatorio(), logicaPoblacion.getId(), 500));
			logicaPoblacion.setId(logicaPoblacion.getId() + 1);
		}
	}

	public void actualizarListas() {
		int[] numSeres = { menores.size(), desempleados.size(), industria.getNumTrabajdores(), jubilados.size() };

		this.capitalEstado.sumarDineroEstado(industria.getProduccionTotal());
		this.logicaPoblacion.pagarMenores(capitalEstado.obtenerSueldo(numSeres[0], 365), seres, capitalEstado);
		this.logicaPoblacion.pagarDesempleados(capitalEstado.obtenerSueldo(numSeres[1], 182.5), seres, capitalEstado);
		this.logicaPoblacion.pagarTrabajadores(capitalEstado.obtenerSueldo(numSeres[2], 730), seres, capitalEstado);
		this.logicaPoblacion.pagarJubilados(capitalEstado.obtenerSueldo(numSeres[3], 182.5), seres, capitalEstado);
		this.logicaPoblacion.envejecerPoblacion(seres);
//		this.logicaPoblacion.eliminarMuertos(this.capitalEstado, this.industria, this.seres);
//		this.logicaPoblacion.actualizarSer(industria, seres);

		this.desempleados = logicaPoblacion.getTrabajadoresDesempleados(seres);
		this.menores = logicaPoblacion.getMenor(seres);
		this.jubilados = logicaPoblacion.getJubilado(seres);

		this.datosVista = new DatosVista(this.seres.size(), this.menores.size(), this.industria.getNumTrabajdores(),
				this.jubilados.size(), this.logicaPoblacion.getNewMenores(), this.logicaPoblacion.getFallecidos(),
				this.logicaPoblacion.getNewJubilados(), this.logicaPoblacion.getNewTrabajadores(),
				industria.getFactorias().size(), capitalEstado.getDineroEstado(), this.desempleados.size());
	}

	public DatosVista getDatosVista() {
		return datosVista;
	}

}
