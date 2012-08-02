package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Recetas;
import org.proyectofinal.gestorpacientes.modelo.entidades.ResultadoDeLaboratorio;


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
}
