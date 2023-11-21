package Controlador;

//La clase Profesor extiende la clase Usuario
public class Profesor extends Usuario {
	
	// Constructor de la clase Profesor que utiliza el constructor de la clase base (Usuario)
    public Profesor(String legajo, String nombre, String apellido) {
        super(legajo, nombre, apellido);
    }

 // Método para calificar a un alumno en un curso específico
    public void calificarAlumno(Curso curso, Alumno alumno, double nota) {
    	
   // Llama al método calificarAlumno del objeto Curso para asignar una nota al alumno
        curso.calificarAlumno(alumno, nota);
    }
}
