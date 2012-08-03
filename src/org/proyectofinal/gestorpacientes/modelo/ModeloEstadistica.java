package org.proyectofinal.gestorpacientes.modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.proyectofinal.gestorpacientes.modelo.entidades.Estadistica;

public class ModeloEstadistica {
	
	private static ModeloEstadistica instancia;
	private Manejador manejador;

	private ModeloEstadistica(Manejador manejador) {
		this.manejador = manejador;
	}

	public static ModeloEstadistica getInstancia(Manejador manejador) {
		if (instancia == null)
			instancia = new ModeloEstadistica(manejador);
		return instancia;
	}

	public List getEstadisticaMedico() {

		manejador.getSession().beginTransaction().begin();
		Query q = manejador
				.getSession()
				.createQuery(
						"select count(medico_id) from Citas group by medico_id order by medico_id");
		Query qu = manejador
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

		manejador.getSession().getTransaction().commit();
		return estadistica;
	}

	public Object getEstadisticaPadecimiento() {
		manejador.getSession().beginTransaction().begin();
		Query q = manejador
				.getSession()
				.createQuery(
						"select count(nombre) as total from Padecimientos group by nombre order by nombre");
		Query qu = manejador
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

		manejador.getSession().getTransaction().commit();
		return estadistica;
	}

}
