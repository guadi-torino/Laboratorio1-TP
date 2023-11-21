package Controlador;
import java.util.ArrayList;
import java.util.List;

public class Curso {
	//atributos clase curso y lista de alumnos inscriptos del tipo alumno
    private String nombre;
    private double precio;
    private int cupo;
    private double notaAprobacion;
    private List<Alumno> alumnosInscriptos;

    //Constructor de la clase Curso
    public Curso(String nombre, double precio, int cupo, double notaAprobacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.cupo = cupo;
        this.notaAprobacion = notaAprobacion;
        this.alumnosInscriptos = new ArrayList<>();
    }

    //Método getter para obtener el nombre del curso
    public String getNombre() {
        return nombre;
    }

    //Método para obtener la cantidad de alumnos inscritos en el curso
    public int getAnotados() {
        return alumnosInscriptos.size();
    }

    // Método para inscribir a un alumno en el curso
    public void inscribirAlumno(Alumno alumno) {
    	// Verifica si hay cupo disponible y si el alumno no ha alcanzado su límite de cursos
        if (alumnosInscriptos.size() < cupo && alumno.getCursosAnotados() < alumno.getLimiteCursos()) {
            alumnosInscriptos.add(alumno); // Agrega al alumno a la lista de inscritos
            alumno.incrementarCursosAnotados();  // Incrementa la cantidad de cursos anotados por el alumno
        } else {
            System.out.println("No se pudo inscribir al alumno " + alumno.getLegajo() + " al curso " + nombre);
        }
    }
    
 // Método para calcular la recaudación del curso
    public double calcularRecaudacion() {
        return alumnosInscriptos.size() * precio;
    }

    // Método para calificar a un alumno en el curso
    public void calificarAlumno(Alumno alumno, double notaFinal) {
        if (alumnosInscriptos.contains(alumno)) {
            // Realizar las validaciones necesarias para las calificaciones
            // (por ejemplo, verificar si se cumplieron las notas parciales)
            // y luego asignar la nota final al alumno.
        } else {
            System.out.println("El alumno " + alumno.getNombre() + " no est� inscripto en el curso " + nombre + ".");
        }
    }

    // Método para emitir un reporte de aprobados vs. inscritos en el curso
    public void emitirReporteAnotadosVsAprobados() {
        int aprobados = 0;
        for (Alumno alumno : alumnosInscriptos) {
            if (alumno.getNota() >= notaAprobacion) {
                aprobados++;
            }
        }
        System.out.println("Reporte de Aprobados vs. Anotados en el Curso " + nombre);
        System.out.println("Anotados: " + alumnosInscriptos.size());
        System.out.println("Aprobados: " + aprobados);
    }
}

   
