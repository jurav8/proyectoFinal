package org.proyectofinal.gestorpacientes.modelo.entidades;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Impresora  implements Printable{

	private Recetas receta;

	public Impresora(Object receta){
		this.receta = (Recetas) receta;
	}

	@Override
	public int print(Graphics g, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		try{
			g.drawRect(150, 150, 350, 340);
			g.drawString("Rep Dom.", 275, 135);
			g.drawString(receta.getMedicamentos(), 150, 210);
			g.drawString("Firma: __________________________________________", 150, 550);

			} catch (Exception ex){
				ex.printStackTrace();
			}

		return PAGE_EXISTS;
	}



}