package service;

//Clase ServiceException que extiende de la clase Exception
public class ServiceException extends  Exception{
	
	// Constructor que acepta un mensaje de error
    public ServiceException(String message) {
    	
    // Llama al constructor de la clase base (Exception) con el mensaje proporcionado
        super(message);
    }
}
