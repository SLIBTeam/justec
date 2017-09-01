package com.ec.justec.controlador;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PruebaControlador implements Serializable{

	
	private static final long serialVersionUID = 2847406720012462886L;
	
//	@EJB
//	private SeccionService seccionService;
	
	public void obtenerSecciones()
	{
//		List<Seccion> secciones = seccionService.obtenerSecciones();
//		for(Seccion s : secciones)
//		{
//			System.out.println("s: "+s.getNombreSec());
//		}
	}
}
