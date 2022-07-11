package Fuente;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * Autor: Alisson Curay, Génesis Guachamín.Paola Lucio
 */

public class AdministradorMedicos {
    private ArrayList<Medico> medicos;
	
	public AdministradorMedicos() {
		medicos = new ArrayList<Medico>();
	}
	
	/**
	 * Crea y registra un nuevo médico.
	 * @return True si se pudo registrar con éxito el nuevo medico.
	 * False si no fue posible registrarlo.
	 */
	public boolean nuevoMedico() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE);
		String nombre = JOptionPane.showInputDialog(null, "Nombre:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE);
		String apellidos = JOptionPane.showInputDialog(null, "Apellidos:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE);
		String especialidad = JOptionPane.showInputDialog(null, "Especialidad:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE);
		
		Medico nuevoMedico = new Medico(id, nombre, apellidos, especialidad);
		return medicos.add(nuevoMedico);//Devuelve TRUE si se insertó correctamente, FALSE si no se pudo insertar
	}
         //registra un nuevo medico dados los parámetros, el método sirve para agilizar el proceso de ingreso de datos. 
        public boolean nuevoMedico1(String id,String nombre,String apellidos,String especialidad) {
		
		Medico nuevoMedico = new Medico(id, nombre, apellidos, especialidad);
		return medicos.add(nuevoMedico);//Devuelve TRUE si se insertó correctamente, FALSE si no se pudo insertar
	}
	/**
	 * Lista por pantalla los datos de todos los Medicos registrados.
	 */
	public void mostrarMedicos() {
		if (medicos.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay Medicos registrados", "Mostrar Medicos",
					JOptionPane.WARNING_MESSAGE);
		else {
			for (Medico m: medicos)
				m.mostrar();
		}
	}
	/**
	 * Modifica el Medico que el administrador solicite mediante el ID de Medico.
	 * @return True al finalizar la modificacion correctamente.
	 * False si no se encontró ningun medico con el ID indicado.
	 */
	public boolean modificarMedicos() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del medico a modificar:",
				"Modificar Medicos", JOptionPane.QUESTION_MESSAGE);
		/*
		 * Ahora buscaremos el Medico en el ArrayList y si lo encontramos lo referenciaremos
		 * a otro objeto de la clase Medico que incialmente tiene valor null.
		 * Si tras finalizar la búsqueda, este objeto sigue valiendo null significa que no hemos
		 * encontrado el Medico que nos han pedido e informaremos al usuario.
		 */
		Medico medico = null;
		for (int i = 0; i < medicos.size(); i++){
			if (medicos.get(i).getId().equals(id)) {
				medico = medicos.get(i);//Referenciamos a otro nombre de objeto
				break;//No hace falta seguir buscando, "rompemos" el bucle for
			}
		}
		if (medico == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Medico con el ID:\n" + id,
					"Medico no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			//Comienza el proceso de modificacion
			medico.setId(JOptionPane.showInputDialog(null, "ID actual: " + medico.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar medico", JOptionPane.QUESTION_MESSAGE));
			medico.setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + medico.getNombre()
				+ "\nIntroduzca nuevo nombre:", "Modificar medico", JOptionPane.QUESTION_MESSAGE));
			medico.setApellidos(JOptionPane.showInputDialog(null, "Apellidos actuales: " + medico.getApellidos()
				+ "\nIntroduzca nuevos apellidos:", "Modificar medico", JOptionPane.QUESTION_MESSAGE));
			return true;
		}
	}
	/**
	 * Elimina el Medico indicado por el usuario mediante el ID del Medico.
	 * @return True si tuvo éxito la eliminacion.
	 * False si no se encontró el Medico indicado.
	 */
	public boolean borrarMedicos() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del Medico a borrar:",
				"Borrar Medico", JOptionPane.QUESTION_MESSAGE);
		
		Medico medico = null;
		for (int i = 0; i < medicos.size(); i++){
			if (medicos.get(i).getId().equals(id))
				medico = medicos.remove(i);//Al eliminar el objeto, el ArrayList nos lo devuelve y lo recogemos en "Medico"
		}
		if (medico == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Medico con el ID:\n" + id,
					"Medico no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino el Medico con ID:\n" + id,
					"Medico Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}
}
    

