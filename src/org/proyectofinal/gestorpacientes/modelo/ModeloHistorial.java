package org.proyectofinal.gestorpacientes.modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Administrador;
import org.proyectofinal.gestorpacientes.modelo.entidades.Asistentes;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Recetas;
import org.proyectofinal.gestorpacientes.modelo.entidades.RelacionEspecialidadMedico;
import org.proyectofinal.gestorpacientes.modelo.entidades.ResultadoDeLaboratorio;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;


public class ModeloHistorial {
	private static ModeloHistorial instancia;
	private Manejador manejador;

	private ModeloHistorial(Manejador manejador) {
		this.manejador = manejador;
	}

	public static ModeloHistorial getInstancia(Manejador manejador) {
		if (instancia == null)
			instancia = new ModeloHistorial(manejador);
		return instancia;
	}
	
	public Paciente getPaciente(int id){
		return (Paciente) this.manejador.getSession().get(Paciente.class, id);
	}
	
	public List<Citas> getFechaPaciente(int id){
		manejador.getSession().beginTransaction().begin();
		String query = "from Citas where idPaciente ="+ id;
		Query q = manejador.getSession().createQuery(query);
		List<Citas> citas = q.list();
		manejador.getSession().getTransaction().commit();
		return citas;
	}
	
	public List<Recetas> getRecetaPaciente(int id){
		manejador.getSession().beginTransaction().begin();
		String query = "from Recetas where idPaciente ="+ id;
		Query q = manejador.getSession().createQuery(query);
		List<Recetas> recetas = q.list();
		manejador.getSession().getTransaction().commit();
		return recetas;
	}
	
	public List<ResultadoDeLaboratorio> getResultadoDeLaboratorio(int id){
		manejador.getSession().beginTransaction().begin();
		String query = "from ResultadoDeLaboratorio where idPaciente ="+ id;
		Query q = manejador.getSession().createQuery(query);
		List<ResultadoDeLaboratorio> resultadoLaboratorio = q.list();
		manejador.getSession().getTransaction().commit();
		return resultadoLaboratorio;
	}
	
	public Usuario getUsuario(String usuario, String clave){
		manejador.getSession().beginTransaction().begin();
		
		String query = "from Usuario where usuario ='"+usuario +"'"+" and clave='"+clave+"'" ;
		Query q = manejador.getSession().createQuery(query);
		List<Usuario> usuarios = q.list();
		
		manejador.getSession().getTransaction().commit();
		return usuarios.get(0);
	}
	
	public Medico getMedico(int id){
		manejador.getSession().beginTransaction().begin();
		
		String query = "from Medico where usuario_id ='"+id+"'";
		Query q = manejador.getSession().createQuery(query);
		List<Medico> medico = q.list();
		
		manejador.getSession().getTransaction().commit();
		return medico.get(0);
	}
	
	public Administrador getAdministrador(int id){
		manejador.getSession().beginTransaction().begin();
		
		String query = "from Administrador where usuario_id ="+id;
		Query q = manejador.getSession().createQuery(query);
		List<Administrador> admin = q.list();
		
		manejador.getSession().getTransaction().commit();
		return admin.get(0);
	}
	
	public Asistentes getAsistente(int id){
		manejador.getSession().beginTransaction().begin();
		
		String query = "from Asistentes where usuario_id ='"+id+"'";
		Query q = manejador.getSession().createQuery(query);
		List<Asistentes> asistente = q.list();
		manejador.getSession().getTransaction().commit();
		return asistente.get(0);
	}
	
	public void crearMedico(String nombre, String apellido,
			String telefonoCasa, String telefonoCelular, String direccion,
			String cedula, Usuario usuario,
			List<Especialidad> especialidades) {

		manejador.getSession().beginTransaction().begin();

		Medico medico = new Medico();
		medico.setApellido(apellido);
		medico.setCedula(cedula);
		medico.setDireccion(direccion);
		medico.setNombre(nombre);
		medico.setTelefonoCasa(telefonoCasa);
		medico.setTelefonoCelular(telefonoCelular);
		medico.setUsuario(usuario);

		List<RelacionEspecialidadMedico> relacion = new ArrayList<>();

		for (Especialidad especialidad : especialidades) {

			RelacionEspecialidadMedico relacionMedico = new RelacionEspecialidadMedico();

			relacionMedico.setIdEspecialidad(especialidad);
			relacionMedico.setIdMedico(medico);
			relacion.add(relacionMedico);

			manejador.getSession().save(relacionMedico);
		}

		manejador.getSession().save(medico);
		manejador.getSession().save(usuario);

		manejador.getSession().getTransaction().commit();
	}
	
	public void crearAsistente(String nombre, String apellido,
			String telefonoCasa, String telefonoCelular, String direccion,
			String cedula, Usuario usuario) {

		manejador.getSession().beginTransaction().begin();

		Asistentes asistente = new Asistentes();
		asistente.setApellido(apellido);
		asistente.setCedula(cedula);
		asistente.setDireccion(direccion);
		asistente.setNombre(nombre);
		asistente.setTelefonoCasa(telefonoCasa);
		asistente.setTelefonoCelular(telefonoCelular);
		asistente.setUsuario(usuario);

		manejador.getSession().save(usuario);
		manejador.getSession().save(asistente);
		manejador.getSession().getTransaction().commit();
	}
	
	public void crearAdministrador(String nombre, String apellido,
			String telefonoCasa, String telefonoCelular, String direccion,
			String cedula, Usuario usuario) {

		manejador.getSession().beginTransaction().begin();

		Administrador administrador = new Administrador();
		administrador.setApellido(apellido);
		administrador.setCedula(cedula);
		administrador.setDireccion(direccion);
		administrador.setNombre(nombre);
		administrador.setTelefonoCasa(telefonoCasa);
		administrador.setTelefonoCelular(telefonoCelular);
		administrador.setUsuario(usuario);

		manejador.getSession().save(usuario);
		manejador.getSession().save(administrador);
		manejador.getSession().getTransaction().commit();
	}
	public void updateAdmin(String nombre, String apellido,
			String telefonoCasa, String telefonoCelular, String direccion,
			String cedula, Usuario usuario,int id) {

		manejador.getSession().beginTransaction().begin();

		Administrador admin = (Administrador) manejador.getSession().get(Administrador.class, id);
		admin.setApellido(apellido);
		admin.setCedula(cedula);
		admin.setDireccion(direccion);
		admin.setNombre(nombre);
		admin.setTelefonoCasa(telefonoCasa);
		admin.setTelefonoCelular(telefonoCelular);
		admin.setUsuario(usuario);

		manejador.getSession().update(usuario);
		manejador.getSession().update(admin);
		manejador.getSession().getTransaction().commit();
	}
	
	public void updateAsistente(String nombre, String apellido,
			String telefonoCasa, String telefonoCelular, String direccion,
			String cedula, Usuario usuario,int id) {

		manejador.getSession().beginTransaction().begin();

		Asistentes asistente = (Asistentes) manejador.getSession().get(Asistentes.class, id);
		asistente.setApellido(apellido);
		asistente.setCedula(cedula);
		asistente.setDireccion(direccion);
		asistente.setNombre(nombre);
		asistente.setTelefonoCasa(telefonoCasa);
		asistente.setTelefonoCelular(telefonoCelular);
		asistente.setUsuario(usuario);

		manejador.getSession().merge(usuario);
		manejador.getSession().update(asistente);
		manejador.getSession().getTransaction().commit();
	}
}
