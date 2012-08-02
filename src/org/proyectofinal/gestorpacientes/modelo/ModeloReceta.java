package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Recetas;

public class ModeloReceta implements Modelo{

	private static ModeloReceta instancia;
	private Manejador manejador;


	private ModeloReceta(Boolean script, Boolean export) {
		manejador = Manejador.getInstancia(script, export);
	}

	public static ModeloReceta getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloReceta(script, export);

		return instancia;
	}

	public void eliminar(int id) {
		manejador.getSession().beginTransaction().begin();
		Object cita = manejador.getSession().get(Recetas.class, id);
		manejador.getSession().delete(cita);
		manejador.getSession().getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Recetas> getListado() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador.getSession().getNamedQuery("Recetas.getAll");
		@SuppressWarnings("rawtypes")
		List recetas = q.list();
		manejador.getSession().getTransaction().commit();
		return recetas;
	}

	@Override
	public Object consultar(int id) {
		manejador.getSession().beginTransaction().begin();
		return (Recetas) manejador.getSession().get(Recetas.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		manejador.getSession().beginTransaction().begin();

		Recetas recetaOld = (Recetas) manejador.getSession().get(Recetas.class,((Recetas) obj).getIdReceta());
		recetaOld.setIdPadecimientos(((Recetas) obj).getIdPadecimientos());
		recetaOld.setMedicamentos(((Recetas) obj).getMedicamentos());
		recetaOld.setIdPaciente(((Recetas) obj).getIdPaciente());
		manejador.getSession().update(recetaOld);
		manejador.getSession().getTransaction().commit();	
		
	}

	@Override
	public void crear(Object obj) {
		manejador.getSession().beginTransaction().begin();
		manejador.getSession().save(obj);
		manejador.getSession().getTransaction().commit();
	}

}
