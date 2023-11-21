package Model;
//Excepción personalizada para manejar errores específicos de la capa DAO
public class DAOException extends Exception{

// Constructor que recibe un mensaje de error
    public DAOException(String message) {
        super(message);
    }
}
