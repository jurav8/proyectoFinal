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
import org.proyectofinal.gestorpacientes.modelo.ModeloEstadistica;
import org.proyectofinal.gestorpacientes.modelo.ModeloPadecimiento;
import org.proyectofinal.gestorpacientes.modelo.entidades.Estadistica;
import org.proyectofinal.gestorpacientes.modelo.entidades.Padecimientos;

import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class PanelTopPadecimientos extends Panel{
	

	private ModeloEstadistica estadisticaModelo;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4807470566872635396L;
	
	public PanelTopPadecimientos (){
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		estadisticaModelo = ModeloEstadistica.getInstancia((Manejador.getInstancia(false, false)));
						
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
			DefaultCategoryDataset datasetPadecimiento = new DefaultCategoryDataset();
			ArrayList<Estadistica> estadisticaPadecimiento = (ArrayList<Estadistica>) estadisticaModelo.getEstadisticaPadecimiento();
			
				for(Estadistica estadist : estadisticaPadecimiento){
					System.out.println(estadist.getTotal()+"\t"+ estadist.getMedicoId());
					
					long val;
					val = (long) estadist.getTotal();
					String val2 = "";
					val2 += estadist.getMedicoId();
					
					dataset.setValue(val, "Padecimiento", ((Padecimientos)ModeloPadecimiento.getInstancia(false, false).consultar(Integer.parseInt(val2))).getNombre() );
					
				}
				
			  JFreeChart chartPadecimiento = ChartFactory.createBarChart
			  ("Top 10 padecimientos más frecuentados","", "Padecimientos", dataset, 
			   PlotOrientation.VERTICAL, false,true, false);
			  chartPadecimiento.setBackgroundPaint(Color.white);
			  chartPadecimiento.getTitle().setPaint(Color.blue); 
			  CategoryPlot pa = chartPadecimiento.getCategoryPlot(); 
			  pa.setRangeGridlinePaint(Color.red); 
			  setLayout(null);
			  ChartPanel panelPadecimiento = new ChartPanel(chartPadecimiento);
			  panelPadecimiento.setBounds(47, 41, 837, 551);
			  panelPadecimiento.setBackground(SystemColor.control);
			  add(panelPadecimiento);
	}

}
