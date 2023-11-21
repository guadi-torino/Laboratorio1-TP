package Controlador;
import java.util.ArrayList;
import java.util.List;

//La clase Administrador extiende la clase Usuario
public class Administrador extends Usuario {
	// Lista de cursos administrados
    private List<Curso> cursos;

 // Constructor de la clase Administrador
    public Administrador(String legado, String nombre, String apellido) {
        super(legado, nombre, apellido);
        this.cursos = new ArrayList<>();
    }

    // Método para crear un nuevo curso y agregarlo a la lista de cursos
    public void crearCurso(Curso curso) {
        cursos.add(curso);
    }
 // Método para dar de alta a un alumno, reiniciando su contador de cursos anotados
    public void darDeAltaAlumno(Alumno alumno) {
        alumno.setCursosAnotados(0); // Reiniciar contador de cursos anotados
    }

 // Método para emitir un reporte de cursos con información detallada
    public void emitirReporteCursos() {
        System.out.println("Reporte de Cursos:");
        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getNombre());
            System.out.println("Anotados: " + curso.getAnotados());
            System.out.println("Recaudaci�n: " + curso.calcularRecaudacion());
            System.out.println("-----------------------------");
        }
    }
    
    // Método para emitir un reporte de recaudación total de todos los cursos
    public void emitirReporteRecaudacion() {
        double totalRecaudado = 0;
        for (Curso curso : cursos) {
            totalRecaudado += curso.calcularRecaudacion();
        }
        System.out.println("Recaudaci�n total: " + totalRecaudado);
    }
}
