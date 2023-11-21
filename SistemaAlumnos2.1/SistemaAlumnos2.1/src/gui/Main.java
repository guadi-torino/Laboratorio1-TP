package gui;

import Controlador.Administrador;
import Controlador.Profesor;
import Model.DAOAlumno;
import Model.DAOException;
import Controlador.Alumno;
import Controlador.Curso;

//En el archivo Main.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
    //	PanelManager panel = new PanelManager();
   /* 	DAOAlumno tablaAlumno = new DAOAlumno();
        Alumno alumno = new Alumno("390405", "pedro", "perez", 5);
    	try {
    		tablaAlumno.guardar(alumno);
    		
    	}catch(DAOException d) {
    		System.out.println(d.getMessage());
    	}*/
    	 // Invocar la interfaz de usuario en el hilo de eventos de la interfaz gráfica
    	 SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
            	 // Crear una instancia de PanelManager
                 PanelManager panel = new PanelManager();
             }
         });
    }
}

    	//  SwingUtilities.invokeLater(() -> {
     /*       // Crear usuarios
            Administrador admin = new Administrador(1001, "John", "Doe");
            Profesor profesor = new Profesor(2001, "Jane", "Smith");
            Alumno alumno1 = new Alumno(3001, "Alice", "Johnson", 3);
            Alumno alumno2 = new Alumno(3002, "Bob", "Williams", 2);

            // Crear cursos
            Curso curso1 = new Curso("Programaci�n Java", 100.0, 20, 7.0);
            Curso curso2 = new Curso("Base de Datos", 80.0, 15, 6.5);

            // Administra usuarios y cursos
            admin.crearCurso(curso1);
            admin.crearCurso(curso2);
            admin.darDeAltaAlumno(alumno1);
            admin.darDeAltaAlumno(alumno2);

            // Inscribir alumnos en cursos
            curso1.inscribirAlumno(alumno1);
            curso1.inscribirAlumno(alumno2);
            curso2.inscribirAlumno(alumno1);

            // Calificar alumnos
            profesor.calificarAlumno(curso1, alumno1, 8.0);
            profesor.calificarAlumno(curso1, alumno2, 6.5);

            // Crear el formulario de entrada de datos
            FormularioUsuario formularioUsuario = new FormularioUsuario(admin, profesor, alumno1, alumno2, curso1, curso2);
*/
            // Crear el panel manager y mostrar la ventana
        //    PanelManager panelManager = new PanelManager(formularioUsuario);
        	
           // panelManager.mostrarVentana();
     //   });










    