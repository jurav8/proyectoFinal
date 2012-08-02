package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;

public class ModeloMedico extends Modelo {
	private static ModeloMedico instancia;

	private ModeloMedico(Boolean script, Boolean export) {
		super(script, export);
	}

	public static ModeloMedico getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloMedico(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		session.beginTransaction().begin();
		Object medico = session.get(Medico.class, id);
		session.delete(medico);
		session.getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Medico> desplegar() {
		session.beginTransaction().begin();
		Query q = session.getNamedQuery("Medico.getAll");
		@SuppressWarnings("rawtypes")
		List medicos = q.list();
		session.getTransaction().commit();
		return medicos;
	}

	@Override
	public Object consultar(int id) {
		session.beginTransaction().begin();
		return (Medico) session.get(Medico.class, id);
	}

	@Override
	public void modificar(Object obj) {

		session.beginTransaction().begin();

		Medico medicoOld = (Medico) session.get(Medico.class,
				((Paciente) obj).getId());
		medicoOld.setNombre(((Medico) obj).getNombre());
		medicoOld.setApellido(((Medico) obj).getApellido());
		medicoOld.setCedula(((Medico) obj).getCedula());
		medicoOld.setTelefonoCasa(((Medico) obj).getTelefonoCasa());
		medicoOld.setTelefonoCelular(((Medico) obj).getTelefonoCelular());
		medicoOld.setUsuario(((Medico) obj).getUsuario());

		session.update(medicoOld);
		session.getTransaction().commit();

	}

}
