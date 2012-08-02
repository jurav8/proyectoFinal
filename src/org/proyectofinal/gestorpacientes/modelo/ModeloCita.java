package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;

public class ModeloCita implements Modelo{

	private static ModeloCita instancia;
	private Manejador manejador;

	private ModeloCita(Boolean script, Boolean export) {
		manejador = Manejador.getInstancia(script, export);
	}

	public static ModeloCita getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloCita(script, export);

		return instancia;
	}

	public void eliminar(int id) {
		manejador.getSession().beginTransaction().begin();
		Object cita = manejador.getSession().get(Citas.class, id);
		manejador.getSession().delete(cita);
		manejador.getSession().getTransaction().commit();
	}

	@Override
	public List<Citas> getListado() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador.getSession().getNamedQuery("Citas.getAll");
		List citas = q.list();
		manejador.getSession().getTransaction().commit();
		return citas;
	}

	@Override
	public Object consultar(int id) {
		manejador.getSession().beginTransaction().begin();
		return (Citas) manejador.getSession().get(Citas.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		manejador.getSession().beginTransaction().begin();

		Citas citaOld = (Citas) manejador.getSession().get(Citas.class,((Citas) obj).getIdCitas());
		citaOld.setCausa(((Citas) obj).getCausa());
		citaOld.setFecha(((Citas) obj).getFecha());
		citaOld.setHora(((Citas) obj).getHora());
		citaOld.setIdPaciente(((Citas) obj).getIdPaciente());	
		citaOld.setIdMedico(((Citas) obj).getIdMedico());
		manejador.getSession().update(citaOld);
		manejador.getSession().getTransaction().commit();	
		
	}

	@Override
	public void crear(Object obj) {
		manejador.getSession().beginTransaction().begin();
		manejador.getSession().save(obj);
		manejador.getSession().getTransaction().commit();
	}

}
