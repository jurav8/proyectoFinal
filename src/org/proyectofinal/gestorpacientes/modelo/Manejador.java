package org.proyectofinal.gestorpacientes.modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import org.proyectofinal.gestorpacientes.modelo.entidades.Administrador;
import org.proyectofinal.gestorpacientes.modelo.entidades.Asistentes;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Especialidad;
import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Padecimientos;
import org.proyectofinal.gestorpacientes.modelo.entidades.Persona;
import org.proyectofinal.gestorpacientes.modelo.entidades.PruebaDeLaboratorio;
import org.proyectofinal.gestorpacientes.modelo.entidades.Recetas;
import org.proyectofinal.gestorpacientes.modelo.entidades.RelacionEspecialidadMedico;
import org.proyectofinal.gestorpacientes.modelo.entidades.ResultadoDeLaboratorio;
import org.proyectofinal.gestorpacientes.modelo.entidades.Usuario;

public class Manejador {
	private static Manejador instancia;
	private AnnotationConfiguration config;
	private SessionFactory factory;
	private Session session;

	private Manejador(Boolean script, Boolean export) {

		config = new AnnotationConfiguration();
		config.addAnnotatedClass(Asistentes.class);
		config.addAnnotatedClass(Administrador.class);
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
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(script, export);

		factory = config.buildSessionFactory();
		session = factory.openSession();
	}

	public static Manejador getInstancia(Boolean script, Boolean export) {
		if (instancia == null)
			instancia = new Manejador(script, export);
		return instancia;
	}

	public Session getSession() {
		return this.session;
	}

}
