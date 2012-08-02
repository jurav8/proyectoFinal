package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Padecimientos;


public class ModeloPadecimiento implements Modelo{

	private static ModeloPadecimiento instancia;
	private Manejador manejador;

	private ModeloPadecimiento(Boolean script, Boolean export) {
		manejador = Manejador.getInstancia(script, export);
	}

	public static ModeloPadecimiento getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloPadecimiento(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		
		manejador.getSession().beginTransaction().begin();
		Object padecimiento = manejador.getSession().get(Padecimientos.class, id);
		manejador.getSession().delete(padecimiento);
		manejador.getSession().getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Padecimientos> getListado() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador.getSession().getNamedQuery("Padecimiento.getAll");
		@SuppressWarnings("rawtypes")
		List padecimientos = q.list();
		manejador.getSession().getTransaction().commit();
		return padecimientos;
	}

	@Override
	public Object consultar(int id) {
		manejador.getSession().beginTransaction().begin();
		return (Padecimientos) manejador.getSession().get(Padecimientos.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		manejador.getSession().beginTransaction().begin();

		Padecimientos padecimientoOld = (Padecimientos) manejador.getSession().get(Padecimientos.class,((Padecimientos) obj).getIdPadecimiento());
		padecimientoOld.setNombre(((Padecimientos) obj).getNombre());
		manejador.getSession().update(padecimientoOld);
		manejador.getSession().getTransaction().commit();	
		
	}

	@Override
	public void crear(Object obj) {
		manejador.getSession().beginTransaction().begin();
		manejador.getSession().save(obj);
		manejador.getSession().getTransaction().commit();
	}

}
