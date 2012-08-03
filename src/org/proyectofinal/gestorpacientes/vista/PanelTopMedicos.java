package org.proyectofinal.gestorpacientes.vista;

import java.awt.Color;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.proyectofinal.gestorpacientes.modelo.Manejador;
import org.proyectofinal.gestorpacientes.modelo.ModeloCita;
import org.proyectofinal.gestorpacientes.modelo.ModeloEstadistica;
import org.proyectofinal.gestorpacientes.modelo.entidades.Estadistica;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class PanelTopMedicos extends Panel {

	private ModeloEstadistica estadisticaModelo;
	private static PanelTopMedicos instancia;

	public static PanelTopMedicos getInstancia() {
		if (instancia == null) {
			instancia = new PanelTopMedicos();
		}
		return instancia;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4807470566872635396L;

	private PanelTopMedicos() {
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		estadisticaModelo = ModeloEstadistica.getInstancia((Manejador.getInstancia(false, false)));

		/*****************************************************
		 * Panel de Medico
		 * ***************************************************/

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Estadistica> estadisticaMedica = (ArrayList<Estadistica>) estadisticaModelo
				.getEstadisticaMedico();

		for (Estadistica estadist : estadisticaMedica) {
			System.out.println(estadist.getTotal() + "\t"
					+ estadist.getMedicoId());

			long val;
			val = (long) estadist.getTotal();
			String val2 = "";
			val2 += estadist.getMedicoId();

			dataset.setValue(val, "Medico", val2);

		}
		JFreeChart chartMedico = ChartFactory.createBarChart(
				"Top 10 médicos más visitados", "", "Médicos",
				dataset, PlotOrientation.VERTICAL, false, true, false);
		chartMedico.setBackgroundPaint(Color.white);
		chartMedico.getTitle().setPaint(Color.blue);
		CategoryPlot p = chartMedico.getCategoryPlot();
		p.setRangeGridlinePaint(Color.red);
		setLayout(null);
		ChartPanel panel = new ChartPanel(chartMedico);
		panel.setBounds(39, 47, 855, 541);
		add(panel);

	}
}
