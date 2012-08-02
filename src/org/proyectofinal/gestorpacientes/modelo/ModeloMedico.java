package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;

public class ModeloMedico implements Modelo {
	private static ModeloMedico instancia;
	private Manejador manejador;

	
	private ModeloMedico(Boolean script, Boolean export) {
		manejador = Manejador.getInstancia(script, export);
	}

	public static ModeloMedico getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloMedico(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		manejador.getSession().beginTransaction().begin();
		Object medico = manejador.getSession().get(Medico.class, id);
		manejador.getSession().delete(medico);
		manejador.getSession().getTransaction().commit();
	}

	@Override
	public List<Medico> getListado() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador.getSession().getNamedQuery("Medico.getAll");
		@SuppressWarnings("rawtypes")
		List medicos = q.list();
		manejador.getSession().getTransaction().commit();
		return medicos;
	}

	@Override
	public Object consultar(int id) {
		manejador.getSession().beginTransaction().begin();
		return (Medico) manejador.getSession().get(Medico.class, id);
	}

	@Override
	public void modificar(Object obj) {

		manejador.getSession().beginTransaction().begin();

		Medico medicoOld = (Medico) manejador.getSession().get(Medico.class,
				((Paciente) obj).getId());
		medicoOld.setNombre(((Medico) obj).getNombre());
		medicoOld.setApellido(((Medico) obj).getApellido());
		medicoOld.setCedula(((Medico) obj).getCedula());
		medicoOld.setTelefonoCasa(((Medico) obj).getTelefonoCasa());
		medicoOld.setTelefonoCelular(((Medico) obj).getTelefonoCelular());
		medicoOld.setUsuario(((Medico) obj).getUsuario());

		manejador.getSession().update(medicoOld);
		manejador.getSession().getTransaction().commit();

	}

	@Override
	public void crear(Object obj) {
		manejador.getSession().beginTransaction().begin();
		manejador.getSession().save(obj);
		manejador.getSession().getTransaction().commit();
	}


}
