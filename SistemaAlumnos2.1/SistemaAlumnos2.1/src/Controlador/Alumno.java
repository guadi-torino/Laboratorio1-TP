package Controlador;

//La clase Alumno extiende la clase Usuario
public class Alumno extends Usuario {
	//atributos
    private int limiteCursos;
    private int cursosAnotados;
    private double nota;
    
 // Constructor por defecto de la clase Alumno
  public Alumno() {
	  
  }
  
//Constructor parametrizado de la clase Alumno
  public Alumno(String legajo, String nombre, String apellido, int limiteCursos) {
        super(legajo, nombre, apellido);
        this.limiteCursos = limiteCursos;
        this.cursosAnotados = 0;
        this.nota = 0.0;
    }
  

    /*
     * Constructor adicional con más parámetros (comentado para evitar duplicación)
    public Alumno(int legajo, String nombre, String apellido, int limiteCursos, int cursosAnotados, double nota) {
	super(legajo, nombre, apellido);
	this.limiteCursos = limiteCursos;
	this.cursosAnotados = 0;
	this.nota = 0.0;
}
    */
  
  // Métodos getter y setter para obtener el límite de cursos
	public int getLimiteCursos() {
        return limiteCursos;
    }
    
	public void setLimiteCursos(int limiteCursos) {
		this.limiteCursos = limiteCursos;
    }

	 // Métodos getter y setter para obtener la cantidad de cursos anotados
    public int getCursosAnotados() {
        return cursosAnotados;
    }
    public void setCursosAnotados(int cursosAnotados) {
        this.cursosAnotados = cursosAnotados;
    }

    // Método para incrementar la cantidad de cursos anotados
    public void incrementarCursosAnotados() {
        cursosAnotados++;
    }

    // Métodos getter y setter para obtener la nota promedio
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
}
