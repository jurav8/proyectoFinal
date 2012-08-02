package org.proyectofinal.gestorpacientes.modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

public class ModeloEstadistica {
	private static ModeloEstadistica instancia;
	private ModeloCita modelo = ModeloCita.getInstancia(false, false);

	private ModeloEstadistica() {

	}
	
	public static ModeloEstadistica getInstancia(){
		if(instancia==null)
			instancia = new ModeloEstadistica();
		return instancia;
	}

	public List getEstadisticaMedico() {

		modelo.getSession().beginTransaction().begin();
		Query q = modelo
				.getSession()
				.createQuery(
						"select count(medico_id) from Citas group by medico_id order by medico_id");
		Query qu = modelo
				.getSession()
				.createQuery(
						"select medico from Citas group by medico_id order by medico_id");
		q.setMaxResults(10);
		qu.setMaxResults(10);
		ArrayList<Long> estadisticaCuenta = (ArrayList<Long>) q.list();
		ArrayList<Long> estadisticaId = (ArrayList<Long>) qu.list();
		ArrayList<Estadistica> estadistica = new ArrayList<>();

		for (int i = 0; i < estadisticaId.size(); i++) {
			Estadistica es = new Estadistica(estadisticaId.get(i),
					estadisticaCuenta.get(i));
			estadistica.add(es);
		}

		modelo.getSession().getTransaction().commit();
		return estadistica;
	}

	public Object getEstadisticaPadecimiento() {
		modelo.getSession().beginTransaction().begin();
		Query q = modelo
				.getSession()
				.createQuery(
						"select count(nombre) as total from Padecimientos group by nombre order by nombre");
		Query qu = modelo
				.getSession()
				.createQuery(
						"select nombre  as total from Padecimientos group by nombre order by nombre");
		q.setMaxResults(10);
		qu.setMaxResults(10);
		ArrayList<Long> estadisticaCuenta = (ArrayList<Long>) qu.list();
		ArrayList<Long> estadisticaId = (ArrayList<Long>) q.list();
		ArrayList<Estadistica> estadistica = new ArrayList<>();

		for (int i = 0; i < estadisticaId.size(); i++) {
			Estadistica es = new Estadistica(estadisticaCuenta.get(i),
					estadisticaId.get(i));
			estadistica.add(es);
		}

		modelo.getSession().getTransaction().commit();
		return estadistica;
	}

}
