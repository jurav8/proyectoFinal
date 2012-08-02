package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;

public class ModeloPaciente extends Modelo {
	private static ModeloPaciente instancia;

	private ModeloPaciente(Boolean script, Boolean export) {
		super(script, export);
	}

	public static ModeloPaciente getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloPaciente(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		session.beginTransaction().begin();
		Object paciente = session.get(Paciente.class, id);
		session.delete(paciente);
		session.getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Paciente> desplegar() {
		session.beginTransaction().begin();
		Query q = session.getNamedQuery("Paciente.getAll");
		@SuppressWarnings("rawtypes")
		List pacientes = q.list();
		session.getTransaction().commit();
		return pacientes;
	}

	@Override
	public Object consultar(int id) {
		session.beginTransaction().begin();
		return (Paciente) session.get(Paciente.class, id);
	}

	@Override
	public void modificar(Object obj) {
	
		session.beginTransaction().begin();

		Paciente pacienteOld = (Paciente) session.get(Paciente.class,((Paciente) obj).getId());
		pacienteOld.setNombre(((Paciente) obj).getNombre());
		pacienteOld.setApellido(((Paciente) obj).getApellido());
		pacienteOld.setCedula(((Paciente) obj).getCedula());
		pacienteOld.setFumador(((Paciente) obj).getFumador());	
		pacienteOld.setTelefonoCasa(((Paciente) obj).getTelefonoCasa());
		pacienteOld.setTelefonoCelular(((Paciente) obj).getTelefonoCelular());
		pacienteOld.setAlergias(((Paciente)obj).getAlergias());
		pacienteOld.setNombreFoto(((Paciente)obj).getNombreFoto());

		session.update(pacienteOld);
		session.getTransaction().commit();	
		
	}

}
