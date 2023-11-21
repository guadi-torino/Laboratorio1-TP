
package Controlador;
//Atributos de la clase Usuario
public class Usuario {
    protected String legajo;
    protected String nombre;
    protected String apellido;
    
    // Constructor por defecto, inicializa el objeto con valores predeterminados
    public Usuario() {
    	
    }
    
    // Constructor parametrizado, establece los valores de los atributos al crear un objeto
    public Usuario(String legajo, String nombre, String apellido) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

 // Métodos getter y setter para los atributos legajo, nombre y apellido.
    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
