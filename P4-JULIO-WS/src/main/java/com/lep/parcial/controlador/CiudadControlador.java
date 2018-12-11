package com.lep.parcial.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lep.parcial.entidades.Ciudad;
import com.lep.parcial.modelo.CiudadRepository;

@RestController
@RequestMapping(path="/ciudad")
public class CiudadControlador {

	
	@Autowired
    private CiudadRepository ciudadModel;
	
	
	@GetMapping(path="/agregar")
	public String agregar(
			@RequestParam (value="nombre", defaultValue="") String nombre,
			@RequestParam (value="pais", defaultValue="") String pais,
			@RequestParam (value="habitantes", defaultValue="0") float num_habitantes) {
		
		String resultado = "";
		try {
			
			Ciudad ciudad = new Ciudad(0,nombre,pais,num_habitantes);
			ciudadModel.save(ciudad);
			
			
			String habitantes = Float.toString(num_habitantes);
			System.out.println("Ciudad Agregada-->\n nombre:"+nombre+
					"\n pais: "+pais+ "\n habitantes: "+habitantes);
			resultado = "La Ciudad " +nombre+ ", Ingresada correctamente"; 
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error al tratar de ingresar la ciudad: " +nombre;
		}
		
		
		return resultado;
	}
	
	
	@GetMapping (path="/get")
	public List<Ciudad> getAll(){
		
		List<Ciudad> allciudades = new ArrayList<Ciudad>();

		try {
			
			Iterator<Ciudad> iciudad = ciudadModel.findAll().iterator();
			Ciudad ciudad = null;
			while(iciudad.hasNext()) {
				ciudad = iciudad.next();
				allciudades.add(ciudad);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allciudades;
	}
	
	@GetMapping(path="/actualizar")
	public String actualizar(
			@RequestParam (value="id", defaultValue="0") int id,
			@RequestParam (value="nombre", defaultValue="") String nombre,
			@RequestParam (value="pais", defaultValue="") String pais,
			@RequestParam (value="habitantes", defaultValue="0") float num_habitantes) {
		
		String resultado = "";
		try {
			
			Optional<Ciudad> optCiudad = ciudadModel.findById(id);
			if(optCiudad.isPresent()) {
				
				Ciudad ciudad = new Ciudad(id,nombre,pais,num_habitantes);
				ciudadModel.save(ciudad);
				
				String habitantes = Float.toString(num_habitantes);
				System.out.println("Ciudad Actualizada-->\n nombre:"+nombre+
						"\n pais: "+pais+ "\n habitantes: "+habitantes);
				resultado = "La ciudad: " +nombre+ ", ha sido actualizada correctamente.";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "La ciudad: " +nombre+ ", No se pudo actualizar.";
		}
		
		return resultado;
	}
	
	
	@GetMapping(path="/eliminar")
	public String eliminar(@RequestParam (value="id") int id) {
		
		
		String resultado = "";
		try {
			
			Optional<Ciudad> optCiudad = ciudadModel.findById(id);
			if(optCiudad.isPresent()) {
				
				Ciudad ciudad = optCiudad.get();
				ciudadModel.delete(ciudad);
				
				System.out.println("Ciudad Eliminada-->\n "+id);
				resultado = "La ciudad ha sido eliminada correctamente.";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Se ha producido un error.";
		}
		
		return resultado;
		
		
	}
	
	
	
}
