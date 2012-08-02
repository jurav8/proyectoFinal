package org.proyectofinal.gestorpacientes.vista;

import java.awt.Color;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.proyectofinal.gestorpacientes.modelo.Estadistica;
import org.proyectofinal.gestorpacientes.modelo.Manejador;
import org.proyectofinal.gestorpacientes.modelo.Modelo;
import org.proyectofinal.gestorpacientes.modelo.ModeloCita;
import org.proyectofinal.gestorpacientes.modelo.ModeloEstadistica;
import org.proyectofinal.gestorpacientes.modelo.ModeloPaciente;

public class PanelEstadisticas extends Panel{

	private ModeloEstadistica estadisticaModelo;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4807470566872635396L;
	
	public PanelEstadisticas(){
		estadisticaModelo = ModeloEstadistica.getInstancia(Manejador.getInstancia(false, false));
				
		/*****************************************************
		 * Panel de Medico
		 * ***************************************************/
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Estadistica> estadisticaMedica = (ArrayList<Estadistica>) estadisticaModelo.getEstadisticaMedico();
		
			for(Estadistica estadist : estadisticaMedica){
				System.out.println(estadist.getTotal()+"\t"+ estadist.getMedicoId());
				
				long val;
				val = (long) estadist.getTotal();
				String val2 = "";
				val2 += estadist.getMedicoId();
				
				dataset.setValue(val, "Medico", val2 );
				
			}
		  JFreeChart chartMedico = ChartFactory.createBarChart
		  ("","", "Medico", dataset, 
		   PlotOrientation.VERTICAL, false,true, false);
		  chartMedico.setBackgroundPaint(Color.yellow);
		  chartMedico.getTitle().setPaint(Color.blue); 
		  CategoryPlot p = chartMedico.getCategoryPlot(); 
		  p.setRangeGridlinePaint(Color.red);
		  ChartPanel panel = new ChartPanel(chartMedico);
		  add(panel);
		
		  
		  
		  /*****************************************************
		   * Panel de Padecimiento
		   * 
		   * ***************************************************/
		  
		  

			DefaultCategoryDataset datasetPadecimiento = new DefaultCategoryDataset();
			ArrayList<Estadistica> estadisticaPadecimiento = (ArrayList<Estadistica>) estadisticaModelo.getEstadisticaPadecimiento();
			
				for(Estadistica estadist : estadisticaPadecimiento){
					System.out.println(estadist.getTotal()+"\t"+ estadist.getMedicoId());
					
					long val;
					val = (long) estadist.getTotal();
					String val2 = "";
					val2 += estadist.getMedicoId();
					
					dataset.setValue(val, "Padecimiento", val2 );
					
				}
			  JFreeChart chartPadecimiento = ChartFactory.createBarChart
			  ("BarChart using JFreeChart","", "Padecimientos", dataset, 
			   PlotOrientation.VERTICAL, false,true, false);
			  chartPadecimiento.setBackgroundPaint(Color.yellow);
			  chartPadecimiento.getTitle().setPaint(Color.blue); 
			  CategoryPlot pa = chartPadecimiento.getCategoryPlot(); 
			  pa.setRangeGridlinePaint(Color.red); 
			  ChartPanel panelPadecimiento = new ChartPanel(chartPadecimiento);
			  add(panelPadecimiento);
	}

}
