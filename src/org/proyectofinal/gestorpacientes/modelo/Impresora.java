package org.proyectofinal.gestorpacientes.modelo;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.AttributedCharacterIterator;

import org.proyectofinal.gestorpacientes.modelo.entidades.Medico;
import org.proyectofinal.gestorpacientes.modelo.entidades.Recetas;

public class Impresora  implements Printable{

//	private Medico medico;
	private Recetas receta;
	
	public Impresora(Object receta){
//		this.medico = medico;
		this.receta = (Recetas) receta;
	}
	
	@Override
	public int print(Graphics g, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		try{
			g.drawRect(150, 150, 350, 340);
//			g.drawString(medico.getNombre()+" "+medico.getApellido(), 250, 90);
//			g.drawString(medico.getEspecialidades().get(0).getIdEspecialidad().getNombreEspecialidad(), 265, 120);
			g.drawString("Rep Dom.", 275, 135);
			g.drawString(receta.getMedicamentos(), 150, 210);
			g.drawString("Firma: __________________________________________", 150, 550);
		
			} catch (Exception ex){
				ex.printStackTrace();
			}
		
		return PAGE_EXISTS;
	}
	
	

}
