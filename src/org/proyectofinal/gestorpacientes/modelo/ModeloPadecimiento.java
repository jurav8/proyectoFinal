package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Padecimientos;


public class ModeloPadecimiento extends Modelo{

	private static ModeloPadecimiento instancia;

	private ModeloPadecimiento(Boolean script, Boolean export) {
		super(script, export);
	}

	public static ModeloPadecimiento getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloPadecimiento(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		session.beginTransaction().begin();
		Object padecimiento = session.get(Padecimientos.class, id);
		session.delete(padecimiento);
		session.getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Padecimientos> desplegar() {
		session.beginTransaction().begin();
		Query q = session.getNamedQuery("Padecimiento.getAll");
		@SuppressWarnings("rawtypes")
		List padecimientos = q.list();
		session.getTransaction().commit();
		return padecimientos;
	}

	@Override
	public Object consultar(int id) {
		session.beginTransaction().begin();
		return (Padecimientos) session.get(Padecimientos.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		session.beginTransaction().begin();

		Padecimientos padecimientoOld = (Padecimientos) session.get(Padecimientos.class,((Padecimientos) obj).getIdPadecimiento());
		padecimientoOld.setNombre(((Padecimientos) obj).getNombre());
		session.update(padecimientoOld);
		session.getTransaction().commit();	
		
	}
}
