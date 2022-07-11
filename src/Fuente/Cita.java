package Fuente;

import javax.swing.JOptionPane;

/**
 *
 * Autor: Alisson Curay, Génesis Guachamín.Paola Lucio
 */

public class Cita {
   
	public int _id;
	public String motivo;
	public String fecha;
	public String horaProgramadaInicio;
	public String horaProgramadaFin;
	public String observaciones;
	public int idPaciente;
        public int idMedico;
	public String horaInicio;
	public String horaFin;
	
	public Cita(){
		set_id(0);
		setFecha("00-00-0000");
		setHoraProgramadaInicio("");
		setHoraProgramadaFin("");
		setObservaciones("");
		setIdPaciente(0);
                setIdMedico(0);
		setHoraInicio("");
		setHoraFin("");
	}

    public Cita(int _id, String motivo, String fecha, String horaProgramadaInicio, String horaProgramadaFin, String observaciones, int idPaciente,int idMedico, String horaInicio, String horaFin) {
        this._id = _id;
        this.motivo = motivo;
        this.fecha = fecha;
        this.horaProgramadaInicio = horaProgramadaInicio;
        this.horaProgramadaFin = horaProgramadaFin;
        this.observaciones = observaciones;
        this.idPaciente = idPaciente;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
        
	public int get_id() {
		return _id;
	}
	
	public void set_id(int id) {
		_id = id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getHoraProgramadaInicio() {
		return horaProgramadaInicio;
	}
	
	public void setHoraProgramadaInicio(String horaProgramadaInicio) {
		this.horaProgramadaInicio = horaProgramadaInicio;
	}
	
	public String getHoraProgramadaFin() {
		return horaProgramadaFin;
	}
	
	public void setHoraProgramadaFin(String horaProgramadaFin) {
		this.horaProgramadaFin = horaProgramadaFin;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
        
	
	public String getHoraInicio() {
		return horaInicio;
	}
	
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public String getHoraFin() {
		return horaFin;
	}
	
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public void mostrar() {
		String mensaje = "Identificador de cita: " + _id + "\nMotivo: " + motivo
				+"\nFecha: " + fecha+ "\nHora programada de inicio: "+horaProgramadaInicio+"\nHora programada de fin: "+horaProgramadaFin+ "\nObservaciones:\n" 
                                 + observaciones+"\nID Paciente: " + idPaciente +  "\nHora de inicio: "+horaInicio+"\nHora de fin: "+horaFin;
		JOptionPane.showMessageDialog(null, mensaje, "Mostrar Medico", JOptionPane.INFORMATION_MESSAGE);
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getMotivo() {
		return motivo;
	}
}

