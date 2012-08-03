package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.ResultadoDeLaboratorio;

public class ModeloResultadoLaboratorio implements Modelo {
	private static ModeloResultadoLaboratorio instancia;
	private Manejador manejador;
	
	private ModeloResultadoLaboratorio(Boolean script, Boolean export) {
		manejador = Manejador.getInstancia(script, export);
	}

	public static ModeloResultadoLaboratorio getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloResultadoLaboratorio(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		manejador.getSession().beginTransaction().begin();
		Object resultado = manejador.getSession().get(ResultadoDeLaboratorio.class, id);
		manejador.getSession().delete(resultado);
		manejador.getSession().getTransaction().commit();
	}

	@Override
	public Object consultar(int id) {
		manejador.getSession().beginTransaction().begin();
		return (ResultadoDeLaboratorio) manejador.getSession().get(ResultadoDeLaboratorio.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		manejador.getSession().beginTransaction().begin();

		ResultadoDeLaboratorio resultadoOld = (ResultadoDeLaboratorio) manejador.getSession().get(ResultadoDeLaboratorio.class,((Paciente) obj).getId());
		resultadoOld.setIdPaciente(((ResultadoDeLaboratorio)obj).getIdPaciente());
		resultadoOld.setIdPruebaLaboratorio((((ResultadoDeLaboratorio)obj).getIdPruebaLaboratorio()));
		resultadoOld.setResultado((((ResultadoDeLaboratorio)obj).getResultado()));
		manejador.getSession().update(resultadoOld);
		manejador.getSession().getTransaction().commit();	
		
	}


	@Override
	public List<ResultadoDeLaboratorio> getListado() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador.getSession().getNamedQuery("ResultadoDeLaboratorio.getAll");
		@SuppressWarnings("rawtypes")
		List resultados = q.list();
		manejador.getSession().getTransaction().commit();
		return resultados;
	}
	@Override
	public void crear(Object obj) {
		manejador.getSession().beginTransaction().begin();
		manejador.getSession().save(obj);
		manejador.getSession().getTransaction().commit();
	}

}
