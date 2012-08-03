package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;

public class ModeloEspecialidad implements Modelo{

	private static ModeloEspecialidad instancia;
	private Manejador manejador;

	
	private ModeloEspecialidad(Boolean script, Boolean export) {
		manejador = Manejador.getInstancia(script, export);
	}

	public static ModeloEspecialidad getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloEspecialidad(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		manejador.getSession().beginTransaction().begin();
		Especialidad especialidad = (Especialidad) manejador.getSession().get(Especialidad.class, id);
		manejador.getSession().delete(especialidad);
		manejador.getSession().getTransaction().commit();
	}

	@Override
	public List<Especialidad> getListado() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador.getSession().getNamedQuery("Especialidad.getAll");
		@SuppressWarnings("rawtypes")
		List especialidad = q.list();
		manejador.getSession().getTransaction().commit();
		return especialidad;
	}

	@Override
	public Object consultar(int id) {
		manejador.getSession().beginTransaction().begin();
		return (Especialidad) manejador.getSession().get(Especialidad.class, id);
	}

	@Override
	public void modificar(Object obj) {

		manejador.getSession().beginTransaction().begin();

		Especialidad especilidadOld = (Especialidad) manejador.getSession().get(Especialidad.class,((Especialidad)obj).getCodigoEspecialidad() );
		especilidadOld.setNombreEspecialidad(((Especialidad)obj).getNombreEspecialidad());
		
		manejador.getSession().update(especilidadOld);
		manejador.getSession().getTransaction().commit();

	}

	@Override
	public void crear(Object obj) {
		manejador.getSession().beginTransaction().begin();
		manejador.getSession().save(obj);
		manejador.getSession().getTransaction().commit();
	}
}
