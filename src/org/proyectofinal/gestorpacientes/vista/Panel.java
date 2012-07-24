package org.proyectofinal.gestorpacientes.vista;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Panel extends JPanel{

	protected JButton nuevo;
	protected JButton eliminar;
	protected JButton editar;
	protected JButton guardar;
	protected JScrollPane panelTabla;
	protected JTable tabla;
	protected DefaultTableModel tablaPorDefecto;
	protected TableRowSorter<TableModel> order;
	protected  String [] titulo;
	
	protected Panel(){
		
		setSize(935,620);
		
	}
	/**********************************************************************
 	* 		Boton Nuevo
 	***********************************************************************/
	public JButton getNuevo(){
		if(nuevo == null){
			nuevo = new JButton("Nuevo");
			nuevo.setIcon(new ImageIcon(Panel.class.getResource("/Imagenes/icons/Action-edit-add-icon.png")));
		}
		return nuevo;
	}
	/**********************************************************************
 	* 		Boton Eliminar
 	**********************************************************************/
	public JButton getEliminar(){
		if(eliminar == null){
			eliminar = new JButton("Eliminar");
			eliminar.setIcon(new ImageIcon(Panel.class.getResource("/Imagenes/icons/Actions-edit-delete-icon.png")));
		}
		return eliminar;
	}
	/*********************************************************************
 	* 		Boton Editar
 	*********************************************************************/
	public JButton getEditar(){
		if(editar == null){
			editar = new JButton("Editar");
			editar.setName("editar");
			editar.setSize(60, 13);
			editar.setIcon(new ImageIcon(Panel.class.getResource("/Imagenes/icons/Edit-icon.png")));
		}
		return editar;
	}
	/*******************************************************************
 	* 		Boton Guardar
 	*******************************************************************/
	public JButton getGuardar(){
		if(guardar == null){
			guardar = new JButton("Guardar");
			guardar.setName("guardar");
			guardar.setIcon(new ImageIcon(Panel
					.class.getResource("/Imagenes/icons/Actions-dialog-ok-apply-icon.png")));
		}
		return guardar;
	}
	/******************************************************************
	*		JScrollPane de la tabla
	******************************************************************/
	
	public JScrollPane getPanelTabla(String [] titulo){
		if(panelTabla == null){
			panelTabla = new JScrollPane(getTabla(titulo));
		}
		return panelTabla;
	}
	/****************************************************************
 	* 		JTable Tabla
 	*****************************************************************/
	public JTable getTabla(String [] titulo){
		if(tabla == null){
			tabla = new JTable(getTablaPorDefecto(titulo));
			tabla.setSize(180, 40);
		}
		return tabla;
	}
	/****************************************************************
 	* 		Default Model de la tabla
 	*****************************************************************/
	public DefaultTableModel getTablaPorDefecto(String [] titulo){
		if(tablaPorDefecto == null){
			tablaPorDefecto = new DefaultTableModel(null, titulo);
		}
		return tablaPorDefecto;
	}
	/***************************************************************
	 * Metodos utilitarios
	 * *************************************************************/
	protected JButton cambarImangen(JButton boton, String url){
		boton.setIcon(new ImageIcon(Panel.class.getResource(url)));
		boton.setMargin(insets());
		boton.setBorderPainted(false);
		return boton;
	}
}
