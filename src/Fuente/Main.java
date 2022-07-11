
package Fuente;

import javax.swing.JOptionPane;

/**
 *
 * Autor: Alisson Curay, Génesis Guachamín.Paola Lucio
 */

public class Main {

    static AdministradorPacientes pacientes = new AdministradorPacientes();

	public static void main(String[] args) 
        {
		
		AdministradorHistorialClinico hc=new AdministradorHistorialClinico();
                AdministradorPacientes pac1=new AdministradorPacientes();
                AdministradorMedicos med1=new AdministradorMedicos();
                AdministradorCita cita =new AdministradorCita();
                
                //se ingresan los siguientes datos para probar el funcionamiento del sistema
                
                pac1.nuevoPaciente1(1, "Alisson", "Curay", "F", 20);
                pac1.nuevoPaciente1(2, "Samara", "Vela", "F", 20);
                pac1.nuevoPaciente1(3, "Alex", "Pogo", "M", 26);
                pac1.nuevoPaciente1(4, "Damián", "Lopez", "M", 26);
                pac1.nuevoPaciente1(5, "Gerardo", "Yepez", "M", 18);
                pac1.nuevoPaciente1(6, "Alexandra", "Ramirez", "F", 42);
                
                
                hc.nuevoHistorialClinico1("as", "05-02-2021",1, 12, "El paciente está estable");
                hc.nuevoHistorialClinico1("az", "06-02-2019",2, 34, "El paciente presenta glucosa alta en la sangre");
                hc.nuevoHistorialClinico1("ab", "13-05-2022",3, 56, "El paciente no cumple con las instrucciones de la medicaciín");
                hc.nuevoHistorialClinico1("aw", "04-03-2020",4, 34, "El paciente requiere de medicación para tratar la presión arterial");
                hc.nuevoHistorialClinico1("at", "10-28-2021",5, 7, "El paciente requiere de una endoscopia gastrointestinal");
                hc.nuevoHistorialClinico1("am", "12-14-2019",6, 14, "El paciente recibirá el alta");
                
                cita.nuevoCitaMedica1(123, "Ginecologia", "05-07-2019", "13:00", "13:30", "30 min antes", 1, 22,"13::05", "13:25");
                cita.nuevoCitaMedica1(124, "Medi Gen", "05-07-2020", "14:15", "13:30", "30 min antes", 1,34, "13::05", "13:25");
                cita.nuevoCitaMedica1(126, "Onco", "05-07-2022", "13:00", "13:30", "30 min antes", 1,56, "13::05", "13:25");
                cita.nuevoCitaMedica1(123, "Cirugía", "07-22-22", "11:00", "11:30", "30 min antes", 1, 14,"11::05", "11:25");
                cita.nuevoCitaMedica1(124, "Cardiología", "08-07-22", "14:00", "14:30", "30 min antes", 1,34, "14::05", "14:25");
                cita.nuevoCitaMedica1(126, "Odontología", "09-17-22", "13:30", "14:00", "30 min antes", 1,7, "13::35", "13:55");
               
            
                
                String opcion="";
                while (!opcion.equals("s"))
                {
                    opcion=JOptionPane.showInputDialog(null, "\n Introduzca:\n a: Si usted es médico\n b: Si usted es Administrador\n c: Si usted es Paciente "
                        + "\n s: Salir del sistema\n","Agendamiento de citas médicas",JOptionPane.DEFAULT_OPTION);
                  switch (opcion){
                        case "a":
                            String opcionMe="";
                            while (!opcionMe.equals("s"))
                            {
                                opcionMe=JOptionPane.showInputDialog(null, " \n Introduzca:\n a: Modificar Historial Clinico\n b: MostraR Historial Clinico\n "
                                    + "c: Borrar Historial Clínico\n  s: Salir del menú\n","PANEL MÉDICO",JOptionPane.DEFAULT_OPTION);
                                switch (opcionMe)
                                    {
                                case "a":  
                                    hc.modificarHistorialClinico();
                                    break;
                                case "b":
                                    hc.mostrarHistorialClinico();
                                    break;
                                case "c":
                                    hc.borrarHistorialClinico();
                                    break;
                               default:
                                   if(opcionMe.equals("s"))
                                   {
                                       JOptionPane.showMessageDialog(null,"Menú MÉDICO finalizado");
                                       break;
                                   }else
                                   {
                                     JOptionPane.showMessageDialog(null,"Opción no reconocida");
                                    break; 
                                   }
                                    
                                    }
                            }
                            
                            break;
                        case "b":
                             String opcionAd="";
                             while(!opcionAd.equals("s"))
                                     {
                                         opcionAd=JOptionPane.showInputDialog(null, "\n Introduzca:\n a: Crear nuevo paciente\n b: Modificar paciente\n "
                                     + "c: Eliminar paciente\n d: Mostrar pacientes paciente\n e: Crear medico\n "
                                     + "f: Modificar medico\n g: Eliminar medico\n h: Mostrar médicos\n s: Salir del menú\n","PANEL ADMINISTRADOR",JOptionPane.DEFAULT_OPTION);
                           switch (opcionAd)
                            {
                                case "a":  
                                    pac1.nuevoPaciente();
                                    break;
                                case "b":
                                    pac1.modificarPaciente();
                                    break;
                                case "c":
                                    pac1.borrarPaciente();
                                    break;
                                case "d":
                                pac1.modificarPaciente();
                                break;
                                case "e":  
                                    med1.nuevoMedico();
                                    break;
                                case "f":
                                    med1.modificarMedicos();
                                    break;
                                case "g":
                                    med1.borrarMedicos();
                                    break;
                                case "h":
                                    med1.mostrarMedicos();
                                break;
                                default:
                                    if(opcionAd.equals("s"))
                                   {
                                       JOptionPane.showMessageDialog(null,"Menú Administrador finalizado");
                                       break;
                                   }else
                                   {
                                     JOptionPane.showMessageDialog(null,"Opción no reconocida");
                                    break; 
                                   }
                            }   
                                     }
                            break;
                        case "c":
                             String opcionPac="";
                             while (!opcionPac.equals("s"))
                             {
                                 opcionPac=JOptionPane.showInputDialog(null, "\n Introduzca:\n a: Agendar Cita\n b: Reagendar cita\n "
                                     + "c: Eliminar cita\n d: Listar citas\n s: Salir del menú\n","PANEL PACIENTE",JOptionPane.DEFAULT_OPTION);
                              switch (opcionPac)
                            {
                                case "a":  
                                    cita.nuevCitaMedica();
                                    break;
                                case "b":
                                    cita.modificarCitaMedica();
                                    break;
                                case "c":
                                    cita.borrarCitaMedica();
                                    break;
                                case "d":
                                    cita.mostrarCitaMedica();
                                    break;
                                default:
                                    if(opcionPac.equals("s"))
                                   {
                                       JOptionPane.showMessageDialog(null,"Menú Paciente finalizado");
                                       break;
                                   }else
                                   {
                                     JOptionPane.showMessageDialog(null,"Opción no reconocida");
                                    break; 
                                   }
                            }   
                             }
                             
                            break;
                             default:
                                   if(opcion.equals("s"))
                                   {
                                       JOptionPane.showMessageDialog(null,"Sistema finalizado");
                                       break;
                                   }else
                                   {
                                     JOptionPane.showMessageDialog(null,"Opción no reconocida");
                                    break; 
                                   }
                       
	}  
                }
                    

    }
}


