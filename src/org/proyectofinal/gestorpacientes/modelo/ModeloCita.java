package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;

public class ModeloCita extends Modelo{

	private static ModeloCita instancia;

	private ModeloCita(Boolean script, Boolean export) {
		super(script, export);
	}

	public static ModeloCita getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloCita(script, export);

		return instancia;
	}

	public void eliminar(int id) {
		session.beginTransaction().begin();
		Object cita = session.get(Citas.class, id);
		session.delete(cita);
		session.getTransaction().commit();
	}

	@Override
	public List<Citas> desplegar() {
		session.beginTransaction().begin();
		Query q = session.getNamedQuery("Citas.getAll");
		List citas = q.list();
		session.getTransaction().commit();
		return citas;
	}

	@Override
	public Object consultar(int id) {
		session.beginTransaction().begin();
		return (Citas) session.get(Citas.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		session.beginTransaction().begin();

		Citas citaOld = (Citas) session.get(Citas.class,((Citas) obj).getIdCitas());
		citaOld.setCausa(((Citas) obj).getCausa());
		citaOld.setFecha(((Citas) obj).getFecha());
		citaOld.setHora(((Citas) obj).getHora());
		citaOld.setIdPaciente(((Citas) obj).getIdPaciente());	
		citaOld.setIdMedico(((Citas) obj).getIdMedico());
		session.update(citaOld);
		session.getTransaction().commit();	
		
	}

}
