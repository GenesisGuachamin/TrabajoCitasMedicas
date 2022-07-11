package Fuente;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * Autor: Alisson Curay, Génesis Guachamín.Paola Lucio
 */

public class AdministradorCita {
    
      private ArrayList<Cita> citaMedica;
	Paciente pacientes; 
	public AdministradorCita() {
		citaMedica = new ArrayList<Cita>();
	}
	/**
	 * Crea y registra una nueva cita médica.
	 * @return True si se pudo registrar con éxito la nueva.
	 * False si no fue posible registrarla.
	 */
	public boolean nuevCitaMedica() {
            
            
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el código de la cita médica: ", "Nueva Cita Médica ", JOptionPane.QUESTION_MESSAGE));
                String motivo = JOptionPane.showInputDialog(null, "Introduzca la especialidad de la cita médica: ", "Nueva Cita Médica ", JOptionPane.QUESTION_MESSAGE);
		String fecha = JOptionPane.showInputDialog(null, "Introduzca la fecha de la cita :", "Nueva Cita Médica ", JOptionPane.QUESTION_MESSAGE);
                String horaProgramadaInicio = JOptionPane.showInputDialog(null, "Introduzca la hora programa de inicio de la cita médica: ", "Nueva Cita Médica ", JOptionPane.QUESTION_MESSAGE);
                String horaProgramadaFin = JOptionPane.showInputDialog(null, "Introduzca la hora programa de fin de la cita médica: ", "Nueva Cita Médica ", JOptionPane.QUESTION_MESSAGE);
                 String horaInicio = JOptionPane.showInputDialog(null, "Introduzca la hora de inicio de la cita médica: ", "Nueva Cita Médica ", JOptionPane.QUESTION_MESSAGE);
                String horaFin = JOptionPane.showInputDialog(null, "Introduzca la hora programa de fin de la cita médica: ", "Nueva Cita Médica ", JOptionPane.QUESTION_MESSAGE);
		int idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca id del Paciente: ", "Nueva Cita Médica", JOptionPane.QUESTION_MESSAGE));
		int idMedico = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca id del Medico: ", "Nueva Cita Médica", JOptionPane.QUESTION_MESSAGE));
                String observaciones = JOptionPane.showInputDialog(null, "Observaciones: ", "Nueva Cita Médica ", JOptionPane.QUESTION_MESSAGE);
                
		Cita nuevacitaMedica = new Cita(id,motivo, fecha, horaProgramadaInicio,horaProgramadaFin, observaciones,idPaciente,idMedico,horaInicio,horaFin);
		return citaMedica.add(nuevacitaMedica);//Devuelve TRUE si se creó una nueva cita, FALSE si no se pudo crear	
	}
         //registra un nueva cita médica dados los parámetros, el método sirve para agilizar el proceso de ingreso de datos. 
	public void nuevoCitaMedica1(int id, String motivo, String fecha, String horaProgramadaInicio,String horaProgramadaFin, String observaciones, int idPaciente,int idMedico,String horaInicio, String horaFin) {
		int cont=0;
		for (int i = 0; i < citaMedica.size(); i++){
                    //se restringe la fecha y hora dado que un paciente no puede tener 2 citas en la misma hora
                    if( citaMedica.get(i).getFecha().equals(fecha) && citaMedica.get(i).getHoraProgramadaInicio().equals(horaProgramadaInicio)){
                        JOptionPane.showMessageDialog(null,"Hora no disponible");
                        cont=cont+1;
                        break;
                    }   
		}
                if(cont==0)
                {
                  Cita nuevacitaMedica = new Cita(id,motivo, fecha, horaProgramadaInicio,horaProgramadaFin, observaciones,idPaciente,idMedico,horaInicio,horaFin);
                citaMedica.add(nuevacitaMedica);  //Devuelve TRUE si se creó una nueva cita, FALSE si no se pudo crear	
	     }
        }
	/**
	 * Lista por pantalla las citas médica del paciente seleccionado.
	 */
        public void mostrarCitaMedica() {
            
            int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca Identificador del paciente para sus citas médicas:",
				"Historial clínico", JOptionPane.QUESTION_MESSAGE));
		for (int i = 0; i < citaMedica.size(); i++){
                    if(citaMedica.get(i).getIdPaciente()==id){
                        //System.out.println(citaMedica.get(i).getFecha()+" "+citaMedica.get(i).getHoraProgramadaFin()+" "+citaMedica.get(i).getObservaciones());
                        citaMedica.get(i).mostrar();  
                    }	
		}      
	}

	/**
	 * Modifica la cita medica que el usuario solicite mediante el ID de Paciente.
	 * @return True al finalizar la modificacion correctamente.
	 * False si no se encontró ningun paciente con el ID indicado.
	 */
       
	public boolean modificarCitaMedica() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca Identificador del paciente para reagendar cita medica:",
				"Modificar Cita Médica", JOptionPane.QUESTION_MESSAGE));
		/*
		 * Ahora buscaremos la cita medica con el id del paciente a buscar en el ArrayList y si lo encontramos lo referenciaremos
		 * a otro objeto de la clase Cita que incialmente tiene valor null.
		 * Si tras finalizar la búsqueda, este objeto sigue valiendo null significa que no hemos
		 * encontrado el Paciente que nos han pedido e informaremos al usuario.
		 */
		Cita cita=null;
		for (int i = 0; i < citaMedica.size(); i++){
			if (citaMedica.get(i).getIdPaciente()==id) {
				cita = citaMedica.get(i);//Referenciamos a otro nombre de objeto
				break;//No hace falta seguir buscando, "rompemos" el bucle for
			}
		}
		
		if (cita == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra agendada una cita para el paciente con el ID:\n" + id,
					"Cita no encontrada", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			//Comienza el proceso de modificacion
                        //tomando en cuenta que las citas médica solamente se pueden reagendar, es decir cambiar de fecha y de hora. 
			cita.setFecha(JOptionPane.showInputDialog(null, "Fecha para la cita actual: " + cita.getFecha()
				+ "\nIntroduzca nueva fecha de la cita:", "Reagendar Cita Médica", JOptionPane.QUESTION_MESSAGE));
                        cita.setHoraProgramadaInicio(JOptionPane.showInputDialog(null, "Hora programada de inicio actual: " + cita.getHoraProgramadaInicio()
				+ "\nIntroduzca nueva hora de inicio de la cita:", "Reagendar Cita Médica", JOptionPane.QUESTION_MESSAGE));
                        cita.setHoraProgramadaFin(JOptionPane.showInputDialog(null, "Hora programada de fin actual: " + cita.getHoraProgramadaFin()
				+ "\nIntroduzca nueva hora de fin de la cita:", "Reagendar Cita Médica", JOptionPane.QUESTION_MESSAGE));
			return true;
		}
	}
	
	/**
	 * Elimina la cita del Paciente indicado por el usuario mediante el ID del Paciente.
	 * @return True si tuvo éxito la eliminacion.
	 * False si no se encontró la cita médica para el paciente indicado.
	 */
                
	public boolean borrarCitaMedica() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca Identificador del paciente para borrar su cita medica:",
				"Borrar cita medica", JOptionPane.QUESTION_MESSAGE));
                int idcita = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca Identificador de la cita medica a borrar:",
				"Borrar cita medica", JOptionPane.QUESTION_MESSAGE));
		
		Cita cita = null;
		for (int i = 0; i < citaMedica.size(); i++){
			if (citaMedica.get(i).getIdPaciente()==id){
                            if(citaMedica.get(i).get_id()==idcita){
                              cita = citaMedica.remove(i);//Al eliminar el objeto, el ArrayList nos lo devuelve y lo recogemos en "cita"  
                            }
                            
                        }		
		}
		if (cita == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra cita médica para el paciente con el ID:\n" + id,
					"Cita médica no encontrada ", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino la cita médica el paciente con ID:\n" + idcita +"del paciente:\n "+id,
					"Cita médica eliminada", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}

	}

}

    

