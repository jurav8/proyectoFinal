package org.proyectofinal.gestorpacientes.vista.dialogos;


import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class IDialog extends JDialog{
	
	protected JButton nuevo;
	protected JButton eliminar;
	protected JButton editar;
	protected JButton guardar;
	protected JScrollPane panelTabla;
	protected JTable tabla;
	protected DefaultTableModel tablaPorDefecto;
	protected TableRowSorter<TableModel> order;
	protected  String [] titulo;
	protected Frame padre;
	
	public Frame getPadre() {
		return padre;
	}
	public void setPadre(Frame padre) {
		this.padre = padre;
	}
	protected IDialog(Frame padre, boolean modal) {
		super(padre,modal);
		this.setPadre(padre);
		
		setSize(630, 450);
		
	}
	/***********************************************************************
	 * Construccion de botones Nuevo
	***********************************************************************/
	public JButton getNuevo(){
		if(nuevo == null){
			nuevo = new JButton("Nuevo");
			nuevo.setIcon(new ImageIcon(IDialog.class.getResource("/Imagenes/icons/Action-edit-add-icon.png")));
		}
		return nuevo;
	}
	/***********************************************************************
 	* 		 botones Eliminar
 	***********************************************************************/
	public JButton getEliminar(){
		if(eliminar == null){
			eliminar = new JButton("Eliminar");
			eliminar.setIcon(new ImageIcon(IDialog.class.getResource("/Imagenes/icons/Actions-edit-delete-icon.png")));
		}
		return eliminar;
	}
	/***********************************************************************
 	* 		 Boton Editar
 	***********************************************************************/
	public JButton getEditar(){
		if(editar == null){
			editar = new JButton("Editar");
			editar.setName("editar");
			editar.setSize(60, 13);
			editar.setIcon(new ImageIcon(IDialog.class.getResource("/Imagenes/icons/Edit-icon.png")));
		}
		return editar;
	}
	/***********************************************************************
 	* 		 botones Guardar
 	***********************************************************************/
	public JButton getGuardar(){
		if(guardar == null){
			guardar = new JButton("Guardar");
			guardar.setName("guardar");
			guardar.setIcon(new ImageIcon(IDialog
					.class.getResource("/Imagenes/icons/Actions-dialog-ok-apply-icon.png")));
		}
		return guardar;
	}
	/**********************************************************************
	 *		JScrollPane para la tabla
	 **********************************************************************/
	public JScrollPane getPanelTabla(){
		if(panelTabla == null){
			panelTabla = new JScrollPane(getTabla());
		}
		return panelTabla;
	}
	/***********************************************************************
 	* 		 Tabla por defecto
 	***********************************************************************/
	public JTable getTabla(){
		if(tabla == null){
			tabla = new JTable(getTablaPorDefecto());
			tabla.setSize(180, 40);
			tabla.setCellSelectionEnabled(false);
		}
		return tabla;
	}
	/***********************************************************************
 	* 		Default Table Model Para la tabla
 	***********************************************************************/
	public DefaultTableModel getTablaPorDefecto(){
		if(tablaPorDefecto == null){
			tablaPorDefecto = new DefaultTableModel(null, titulo);
		}
		return tablaPorDefecto;
	}
	@SuppressWarnings("unused")
	protected void ocultaColumnas(JTable tabla, int columna[])
	{
	  for(int i=0;i<columna.length;i++)
	  {
	       tabla.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
	       tabla.getColumnModel().getColumn(columna[i]).setMinWidth(0);
	       tabla.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
	       tabla.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);
	  }
	}
	
}