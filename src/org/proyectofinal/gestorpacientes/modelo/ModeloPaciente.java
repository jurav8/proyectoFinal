package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;

public class ModeloPaciente implements Modelo {
	private static ModeloPaciente instancia;
	private Manejador manejador;

	private ModeloPaciente(Boolean script, Boolean export) {
		manejador = Manejador.getInstancia(script, export);
	}

	public static ModeloPaciente getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloPaciente(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		manejador.getSession().beginTransaction().begin();
		Object paciente = manejador.getSession().get(Paciente.class, id);
		manejador.getSession().delete(paciente);
		manejador.getSession().getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Paciente> getListado() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador.getSession().getNamedQuery("Paciente.getAll");
		@SuppressWarnings("rawtypes")
		List pacientes = q.list();
		manejador.getSession().getTransaction().commit();
		return pacientes;
	}

	@Override
	public Object consultar(int id) {
		manejador.getSession().beginTransaction().begin();
		return (Paciente) manejador.getSession().get(Paciente.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		manejador.getSession().beginTransaction().begin();

		Paciente pacienteOld = (Paciente) manejador.getSession().get(Paciente.class,((Paciente) obj).getId());
		pacienteOld.setNombre(((Paciente) obj).getNombre());
		pacienteOld.setApellido(((Paciente) obj).getApellido());
		pacienteOld.setCedula(((Paciente) obj).getCedula());
		pacienteOld.setFumador(((Paciente) obj).getFumador());	
		pacienteOld.setTelefonoCasa(((Paciente) obj).getTelefonoCasa());
		pacienteOld.setTelefonoCelular(((Paciente) obj).getTelefonoCelular());
		pacienteOld.setAlergias(((Paciente)obj).getAlergias());
		pacienteOld.setNombreFoto(((Paciente)obj).getNombreFoto());

		manejador.getSession().update(pacienteOld);
		manejador.getSession().getTransaction().commit();	
		
	}

	@Override
	public void crear(Object obj) {
		manejador.getSession().beginTransaction().begin();
		manejador.getSession().save(obj);
		manejador.getSession().getTransaction().commit();
	}


}
