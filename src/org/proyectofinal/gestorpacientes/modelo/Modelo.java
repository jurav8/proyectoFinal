package org.proyectofinal.gestorpacientes.modelo;

import java.util.List;

public interface Modelo {
	public void crear(Object obj);
	public  void eliminar(int id);
	public  void modificar(Object obj);
	public  List getListado();
	public  Object consultar(int id);
}
