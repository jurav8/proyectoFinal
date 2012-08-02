package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Citas;
import org.proyectofinal.gestorpacientes.modelo.entidades.Paciente;
import org.proyectofinal.gestorpacientes.modelo.entidades.Recetas;
import org.proyectofinal.gestorpacientes.modelo.entidades.ResultadoDeLaboratorio;

public class ModeloHistorial {
	private static ModeloHistorial instancia;
	private ModeloPaciente modelo = ModeloPaciente.getInstancia(false, false);

	private ModeloHistorial(){
	}
	
	public static ModeloHistorial getInstancia(){
		if(instancia==null)
			instancia= new ModeloHistorial();
		return instancia;
	}
	
	public Paciente getPaciente(int id){
		return (Paciente) this.modelo.consultar(id);
	}
	
	public List<Citas> getFechaPaciente(int id){
		modelo.getSession().beginTransaction().begin();
		String query = "from Citas where idPaciente ="+ id;
		Query q = modelo.getSession().createQuery(query);
		List<Citas> citas = q.list();
		modelo.getSession().getTransaction().commit();
		return citas;
	}
	
	public List<Recetas> getRecetaPaciente(int id){
		modelo.getSession().beginTransaction().begin();
		String query = "from Recetas where idPaciente ="+ id;
		Query q = modelo.getSession().createQuery(query);
		List<Recetas> recetas = q.list();
		modelo.getSession().getTransaction().commit();
		return recetas;
	}
	
	public List<ResultadoDeLaboratorio> getResultadoDeLaboratorio(int id){
		modelo.getSession().beginTransaction().begin();
		String query = "from ResultadoDeLaboratorio where idPaciente ="+ id;
		Query q = modelo.getSession().createQuery(query);
		List<ResultadoDeLaboratorio> resultadoLaboratorio = q.list();
		modelo.getSession().getTransaction().commit();
		return resultadoLaboratorio;
	}
}
