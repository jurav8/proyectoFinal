package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;

public class ModeloUsuario extends Modelo {
	private static ModeloUsuario instancia;

	private ModeloUsuario(Boolean script, Boolean export) {
		super(script, export);
	}

	public static ModeloUsuario getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloUsuario(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		session.beginTransaction().begin();
		Object usuario = session.get(Usuario.class, id);
		session.delete(usuario);
		session.getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Usuario> desplegar() {
		session.beginTransaction().begin();
		Query q = session.getNamedQuery("Usuario.getAll");
		@SuppressWarnings("rawtypes")
		List usuarios = q.list();
		session.getTransaction().commit();
		return usuarios;
	}

	@Override
	public Object consultar(int id) {
		session.beginTransaction().begin();
		return (Usuario) session.get(Usuario.class, id);
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
