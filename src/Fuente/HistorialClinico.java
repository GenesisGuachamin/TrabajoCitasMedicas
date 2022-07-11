package Fuente;
/**
 *
 * Autor: Alisson Curay, Génesis Guachamín.Paola Lucio
 */
import javax.swing.JOptionPane;

public final class HistorialClinico {

	public String codigo;
	public String fecha;
	public int idPaciente;
	public int idMedico;
	public String observaciones;
	
	public HistorialClinico(String codigo, String fecha, int idPaciente,
			int idMedico, String observaciones) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.observaciones = observaciones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * Muestra por panel todos los datos del Historial Clinico
	 */
	public void mostrar() {
		String mensaje = "Codigo Historial: " + codigo + "\nFecha: " + fecha
				+ "\nID Paciente: " + idPaciente + "\nID Medico: " + idMedico
				+ "\nObservaciones:\n" + observaciones;
		JOptionPane.showMessageDialog(null, mensaje, "Mostrar Historial clínico", JOptionPane.INFORMATION_MESSAGE);
	}
}