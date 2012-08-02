package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;

public class ModeloUsuario implements Modelo {
	private static ModeloUsuario instancia;
	private Manejador manejador;

	private ModeloUsuario(Boolean script, Boolean export) {
		manejador = Manejador.getInstancia(script, export);
	}

	public static ModeloUsuario getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new ModeloUsuario(script, export);

		return instancia;
	}

	@Override
	public void eliminar(int id) {
		manejador.getSession().beginTransaction().begin();
		Object usuario = manejador.getSession().get(Usuario.class, id);
		manejador.getSession().delete(usuario);
		manejador.getSession().getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Usuario> getListado() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador.getSession().getNamedQuery("Usuario.getAll");
		@SuppressWarnings("rawtypes")
		List usuarios = q.list();
		manejador.getSession().getTransaction().commit();
		return usuarios;
	}

	@Override
	public Object consultar(int id) {
		manejador.getSession().beginTransaction().begin();
		return (Usuario) manejador.getSession().get(Usuario.class, id);
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
