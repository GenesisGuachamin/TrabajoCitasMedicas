package Fuente;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * Autor: Alisson Curay, Génesis Guachamín.Paola Lucio
 */
public class AdministradorHistorialClinico {
    
        ArrayList<HistorialClinico> historialclinico;
	Paciente pacientes; 
        
	public AdministradorHistorialClinico() {
		historialclinico = new ArrayList<HistorialClinico>();
	}
	/**
	 * Crea y registra un nuevo historial clínico.
	 * @return True si se pudo registrar con éxito el nuevo historial clínico.
	 * False si no fue posible registrarlo.
	 */
	public boolean nuevoHistorialClinico() {
		String codigo = JOptionPane.showInputDialog(null, "Introduzca el código de historial clínico:", "Nuevo Historial Clínico ", JOptionPane.QUESTION_MESSAGE);
		String fecha = JOptionPane.showInputDialog(null, "Introduzca la fecha:", "Nuevo Historial Clínico", JOptionPane.QUESTION_MESSAGE);
		int idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca id del Paciente:", "Nuevo Historial Clínico", JOptionPane.QUESTION_MESSAGE));
		int idMedico = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca id del Medico:", "Nuevo Historial Clínico", JOptionPane.QUESTION_MESSAGE));
                String observaciones = JOptionPane.showInputDialog(null, "Observaciones:", "Nuevo Historial Clínico", JOptionPane.QUESTION_MESSAGE);
		
		HistorialClinico nuevoHistorial = new HistorialClinico(codigo, fecha, idPaciente, idMedico, observaciones);
		return historialclinico.add(nuevoHistorial);//Devuelve TRUE si se insertó correctamente, FALSE si no se pudo insertar
	}
        //registra un nuevo historial clínico dados los parámetros, el método sirve para agilizar el proceso de ingreso de datos. 
	public boolean nuevoHistorialClinico1(String codigo,String fecha,int idPaciente,int idMedico,String observaciones) {
		
		
		HistorialClinico nuevoHistorial = new HistorialClinico(codigo, fecha, idPaciente, idMedico, observaciones);
                return historialclinico.add(nuevoHistorial);//Devuelve TRUE si se insertó correctamente, FALSE si no se pudo insertar
	}
	/**
	 * Muestra por pantalla el historial clínico del paciente seleccionado.
	 */
        public void mostrarHistorialClinico() {
            
            int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca Identificador del paciente para mostrar historial clínico:",
				"Historial clínico", JOptionPane.QUESTION_MESSAGE));
		for (int i = 0; i < historialclinico.size(); i++){
                    if(historialclinico.get(i).getIdPaciente()==id){
                              historialclinico.get(i).mostrar(); 
                    }	
		}     
	}
	/**
	 * Modifica el historial clínico que el medico solicite mediante el ID de Paciente.
	 * @return True al finalizar la modificacion correctamente.
	 * False si no se encontró ningun historial clinico con el ID indicado.
	 */
	public boolean modificarHistorialClinico() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca Id del paciente para modificar el historial clínico:",
				"Modificar Historial clínico", JOptionPane.QUESTION_MESSAGE));
		/*
		 * Ahora buscaremos el historial clínico en el ArrayList y si lo encontramos lo referenciaremos
		 * a otro objeto de la clase HistorialClinico que incialmente tiene valor null.
		 * Si tras finalizar la búsqueda, este objeto sigue valiendo null significa que no hemos
		 * encontrado el Historial clínico que nos han pedido e informaremos al usuario.
		 */
		HistorialClinico hc=null; 
		for (int i = 0; i < historialclinico.size(); i++){
			if (historialclinico.get(i).getIdPaciente()==id) {
				hc = historialclinico.get(i);//Referenciamos a otro nombre de objeto
				break;//No hace falta seguir buscando, "rompemos" el bucle for
			}
		}
		if (hc == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra historial clínico con el ID:\n" + id,
					"Historial clínico no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			//Comienza el proceso de modificacion de historial clínico, recordando que los campos que se van
                        //a modirficar será la observación, la fecha y el id del medico, puesto que se irá actualizando por la fecha que fue atendido y el médico quién atienda
                        hc.setFecha(JOptionPane.showInputDialog(null, "Fecha actual: " + hc.getFecha()
				+ "\nIntroduzca nueva fecha:", "Modificar Historial Clínico", JOptionPane.QUESTION_MESSAGE));
                        hc.setIdPaciente(Integer.parseInt(JOptionPane.showInputDialog(null, "Médico actual: " + hc.getIdMedico()
				+ "\nIntroduzca id del médico actual:", "Modificar Historial Clínico", JOptionPane.QUESTION_MESSAGE)));
			
			hc.setObservaciones(JOptionPane.showInputDialog(null, "Observaciones actuales: " + hc.getObservaciones()
				+ "\nIntroduzca nuevas observaciones:", "Modificar Historial Clínico", JOptionPane.QUESTION_MESSAGE));
                        
			return true;
		}
	}
	/**
	 * Elimina el historial clínico indicado por el usuario mediante el ID del Paciente.
	 * @return True si tuvo éxito la eliminacion.
	 * False si no se encontró el Paciente indicado.
	 */       
	public boolean borrarHistorialClinico() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca Identificador del paciente para borrar su historial clínico:",
				"Borrar Historial clínico", JOptionPane.QUESTION_MESSAGE));
		
		HistorialClinico hc = null;
		for (int i = 0; i < historialclinico.size(); i++){
			if (historialclinico.get(i).getIdMedico()==id)
				hc = historialclinico.remove(i);//Al eliminar el objeto, el ArrayList nos lo devuelve y lo recogemos en "hc"
		}
		
		if (hc == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra historial clínico del paciente con el ID:\n" + id,
					"PHistorial clínico no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino el historial clínico del paciente con ID:\n" + id,
					"Paciente Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}
}

              

