package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Recetas;

public class ModeloReceta extends Modelo{

	private static ModeloReceta instancia;

	private ModeloReceta(Boolean script, Boolean export) {
		super(script, export);
	}

	public static ModeloReceta getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloReceta(script, export);

		return instancia;
	}

	public void eliminar(int id) {
		session.beginTransaction().begin();
		Object cita = session.get(Recetas.class, id);
		session.delete(cita);
		session.getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Recetas> desplegar() {
		session.beginTransaction().begin();
		Query q = session.getNamedQuery("Recetas.getAll");
		@SuppressWarnings("rawtypes")
		List recetas = q.list();
		session.getTransaction().commit();
		return recetas;
	}

	@Override
	public Object consultar(int id) {
		session.beginTransaction().begin();
		return (Recetas) session.get(Recetas.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		session.beginTransaction().begin();

		Recetas recetaOld = (Recetas) session.get(Recetas.class,((Recetas) obj).getIdReceta());
		recetaOld.setIdPadecimientos(((Recetas) obj).getIdPadecimientos());
		recetaOld.setMedicamentos(((Recetas) obj).getMedicamentos());
		recetaOld.setIdPaciente(((Recetas) obj).getIdPaciente());
		session.update(recetaOld);
		session.getTransaction().commit();	
		
	}
}
