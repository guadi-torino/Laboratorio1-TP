package Model;

//Interfaz DAO (Data Access Object) genérica
public interface DAO<T>{
	// Método para guardar un elemento en la base de datos
    public void guardar(T elemento) throws DAOException;
    // Método para modificar un elemento en la base de datos
    public void modificar(T elemento) throws DAOException;
    // Método para eliminar un elemento en la base de datos
    public void eliminar(String legajo) throws DAOException;
 //   public T buscar(int legajo) throws DAOException;
//  public ArrayList<Alumno> buscarTodos() throws DAOException;

}
