package org.proyectofinal.gestorpacientes.controler;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.proyectofinal.gestorpacientes.modelo.Alergia;
import org.proyectofinal.gestorpacientes.modelo.Asistentes;
import org.proyectofinal.gestorpacientes.modelo.Citas;
import org.proyectofinal.gestorpacientes.modelo.Especialidad;
import org.proyectofinal.gestorpacientes.modelo.Medico;
import org.proyectofinal.gestorpacientes.modelo.Paciente;
import org.proyectofinal.gestorpacientes.modelo.Padecimientos;
import org.proyectofinal.gestorpacientes.modelo.Persona;
import org.proyectofinal.gestorpacientes.modelo.PruebaDeLaboratorio;
import org.proyectofinal.gestorpacientes.modelo.Recetas;
import org.proyectofinal.gestorpacientes.modelo.RelacionAlergiaPaciente;
import org.proyectofinal.gestorpacientes.modelo.RelacionEspecialidadMedico;
import org.proyectofinal.gestorpacientes.modelo.RelacionPadecimientoPaciente;
import org.proyectofinal.gestorpacientes.modelo.ResultadoDeLaboratorio;
import org.proyectofinal.gestorpacientes.modelo.Usuario;

public class Controller {

	private static Controller instancia;
	private AnnotationConfiguration config;
	private SessionFactory factory;
	private Session session;

	private Controller(Boolean script, Boolean export) {

		config = new AnnotationConfiguration();
		config.addAnnotatedClass(Alergia.class);
		config.addAnnotatedClass(Asistentes.class);
		config.addAnnotatedClass(Citas.class);
		config.addAnnotatedClass(Especialidad.class);
		config.addAnnotatedClass(Medico.class);
		config.addAnnotatedClass(Paciente.class);
		config.addAnnotatedClass(Padecimientos.class);
		config.addAnnotatedClass(Persona.class);
		config.addAnnotatedClass(PruebaDeLaboratorio.class);
		config.addAnnotatedClass(Recetas.class);
		config.addAnnotatedClass(ResultadoDeLaboratorio.class);
		config.addAnnotatedClass(Usuario.class);
		config.addAnnotatedClass(RelacionEspecialidadMedico.class);
		config.addAnnotatedClass(RelacionPadecimientoPaciente.class);
		config.addAnnotatedClass(RelacionAlergiaPaciente.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(script, export);

		factory = config.buildSessionFactory();
		session = factory.getCurrentSession();
	}

	public static Controller getEnlace(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new Controller(script, export);

		return instancia;
	}

	public void crearMedico(String nombre, String apellido,
			String telefonoCasa, String telefonoCelular, String direccion,
			String cedula, Usuario usuario,
			ArrayList<Especialidad> especialidades) {

		session.beginTransaction().begin();

		Medico medico = new Medico();
		medico.setApellido(apellido);
		medico.setCedula(cedula);
		medico.setDireccion(direccion);
		medico.setNombre(nombre);
		medico.setTelefonoCasa(telefonoCasa);
		medico.setTelefonoCelular(telefonoCelular);
		medico.setUsuario(usuario);

		ArrayList<RelacionEspecialidadMedico> relacion = new ArrayList<>();

		for (Especialidad especialidad : especialidades) {

			RelacionEspecialidadMedico relacionMedico = new RelacionEspecialidadMedico();

			relacionMedico.setIdEspecialidad(especialidad);
			relacionMedico.setIdMedico(medico);
			relacion.add(relacionMedico);

			session.save(relacionMedico);
		}

		session.save(medico);
		session.save(usuario);

		session.getTransaction().commit();
	}

	public void crearEspecialidad(String nombreEspecialidad) {

		session.beginTransaction().begin();

		Especialidad especialidad = new Especialidad();
		especialidad.setNombreEspecialidad(nombreEspecialidad);

		session.save(especialidad);
		session.getTransaction().commit();
	}

	public void crearPaciente(String nombre, String apellido,
			String telefonoCasa, String telefonoCelular, String direccion,
			String cedula, GregorianCalendar fechaNacimiento, int fumador,
			String nombreFoto, ArrayList<Alergia> alergias,
			ArrayList<Padecimientos> padecimientos) {

		session.beginTransaction().begin();
		ArrayList<RelacionAlergiaPaciente> alergia = new ArrayList<>();
		ArrayList<RelacionPadecimientoPaciente> pacientePadecimientos = new ArrayList<>();
		
		Paciente paciente = new Paciente();
		paciente.setApellido(apellido);
		paciente.setCedula(cedula);
		paciente.setDireccion(direccion);
		paciente.setNombre(nombre);
		paciente.setTelefonoCasa(telefonoCasa);
		paciente.setTelefonoCelular(telefonoCelular);
		paciente.setFechaNacimiento(fechaNacimiento);
		paciente.setFumador(fumador);
		paciente.setNombreFoto(nombreFoto);

		for (Alergia aler : alergias) {
			RelacionAlergiaPaciente pacienAler = new RelacionAlergiaPaciente();
			pacienAler.setAlergiaPaciente(paciente);
			pacienAler.setIdAlergia(aler);
			alergia.add(pacienAler);
			session.save(pacienAler);
		}
		paciente.setAlergia(alergia);
		
		
		for(Padecimientos padecimiento: padecimientos){
			RelacionPadecimientoPaciente pacientePadeciemient = new RelacionPadecimientoPaciente();
			pacientePadeciemient.setIdPaciente(paciente);
			pacientePadeciemient.setIdPadeciemiento(padecimiento);
			pacientePadecimientos.add(pacientePadeciemient);
			session.save(padecimiento);
		}
		paciente.setPadecimientos(pacientePadecimientos);

		session.save(paciente);
		session.getTransaction().commit();
	}

	public void crearAlergia(String nombreAlergia) {

		session.beginTransaction().begin();
		Alergia alergia = new Alergia();
		alergia.setNombreAlergia(nombreAlergia);

		session.save(alergia);
		session.getTransaction().commit();
	}
	
	public void crearPadecimiento(String nombre){
		
		session.beginTransaction().begin();
		
		Padecimientos padecieminto = new Padecimientos();
		padecieminto.setNombre(nombre);
		
		session.save(padecieminto);
		session.getTransaction().commit();
	}

	public void crearAsistente(String nombre, String apellido,
			String telefonoCasa, String telefonoCelular, String direccion,
			String cedula, Usuario usuario) {

		session.beginTransaction().begin();

		Asistentes asistente = new Asistentes();
		asistente.setApellido(apellido);
		asistente.setCedula(cedula);
		asistente.setDireccion(direccion);
		asistente.setNombre(nombre);
		asistente.setTelefonoCasa(telefonoCasa);
		asistente.setTelefonoCelular(telefonoCelular);
		asistente.setUsuario(usuario);

		session.save(usuario);
		session.save(asistente);
		session.getTransaction().commit();
	}

	public void crearCitas(GregorianCalendar fecha, String hora, String causa,
			Medico medico, Paciente paciente) {

		session.beginTransaction().begin();

		Citas cita = new Citas();
		cita.setCausa(causa);
		cita.setFecha(fecha);
		cita.setHora(hora);
		cita.setIdMedico(medico);
		cita.setIdPaciente(paciente);

		session.save(cita);
		session.getTransaction().commit();
	}

	public void crearPruebaLaboratorio(String nombreDeLaPrueba, Paciente idPaciente) {

		session.beginTransaction().begin();

		PruebaDeLaboratorio prueba = new PruebaDeLaboratorio();
		prueba.setNombreDeLaPrueba(nombreDeLaPrueba);
		prueba.setIdPaciente(idPaciente);

		session.save(prueba);
		session.getTransaction().commit();
	}

	public void crearRecetas(String medicamentos, Paciente idPaciente,
			Padecimientos idPadecimientos) {

		session.beginTransaction().begin();

		Recetas receta = new Recetas(medicamentos);
		receta.setIdPadecimientos(idPadecimientos);
		receta.setIdPaciente(idPaciente);

		session.save(receta);
		session.getTransaction().commit();
	}

	public void crearResultadoDeLaboratorio(String resultado,
			Paciente idPaciente, PruebaDeLaboratorio idPruebaLaboratorio) {

		session.beginTransaction().begin();

		ResultadoDeLaboratorio resultadoLab = new ResultadoDeLaboratorio(
				resultado);
		resultadoLab.setIdPaciente(idPaciente);
		resultadoLab.setIdPruebaLaboratorio(idPruebaLaboratorio);

		session.save(resultadoLab);
		session.getTransaction().commit();
	}

	public Medico consultarMedico(int id) {
		session.beginTransaction().begin();
		return (Medico) session.get(Medico.class, id);
	}

	public Alergia consultarAlergia(int id) {
		session.beginTransaction().begin();
		return (Alergia) session.get(Alergia.class, id);
	}

	public Paciente consultarPaciente(int id) {
		session.beginTransaction().begin();
		return (Paciente) session.get(Paciente.class, id);
	}

	public Padecimientos consultarPadecimiento(int id) {
		session.beginTransaction().begin();
		return (Padecimientos) session.get(Padecimientos.class, id);
	}

	public PruebaDeLaboratorio consultarPruebaDeLaboratorio(int id) {
		session.beginTransaction().begin();
		return (PruebaDeLaboratorio) session.get(PruebaDeLaboratorio.class, id);
	}

	public Citas consultarCitas(int id) {
		session.beginTransaction().begin();
		return (Citas) session.get(Citas.class, id);
	}

	public Especialidad consultarEspecialidad(int id) {
		session.beginTransaction().begin();
		return (Especialidad) session.get(Especialidad.class, id);
	}

	public void modificar(Object objeto) {
		session.beginTransaction().begin();
		session.update(objeto);
		session.getTransaction().commit();
	}

	public void eliminar(Object objeto) {
		session.beginTransaction().begin();
		session.delete(objeto);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Medico> getMedico() {
		session.beginTransaction().begin();
		Query q = session.getNamedQuery("Medico.buscarMedicos");
		List medicos = q.list();
		session.getTransaction().commit();
		return medicos;
	}

}
