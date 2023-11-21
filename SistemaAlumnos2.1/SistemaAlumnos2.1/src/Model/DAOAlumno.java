package Model;


import Controlador.Alumno;
import java.sql.*;


//Implementación de la interfaz DAO para la entidad Alumno
public class DAOAlumno implements DAO<Alumno>{
	 private String DB_JDBC_DRIVER="org.h2.Driver";
	    private String DB_URL="jdbc:h2:file:C:\\Users\\guadi\\Desktop\\Basededatos";
	    private String DB_USER="sa";
	    private String DB_PASSWORD="";
	    @Override
	    public void guardar(Alumno elemento) throws DAOException {
	        Connection connection=null;
	        PreparedStatement preparedStatement=null;
	        try {
	         // Establecer la conexión con la base de datos
	            Class.forName(DB_JDBC_DRIVER);
	            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	         // Preparar la declaración SQL para la inserción de un nuevo alumno
	            preparedStatement=connection.prepareStatement("INSERT into Alumno Values(?,?,?,?,?,?)");
	            preparedStatement.setString(1,elemento.getLegajo());
	            preparedStatement.setString(2, elemento.getNombre());
	            preparedStatement.setString(3, elemento.getApellido());
	            preparedStatement.setInt(4, elemento.getLimiteCursos());
	            preparedStatement.setInt(5, elemento.getCursosAnotados());
	            preparedStatement.setDouble(6, elemento.getNota());
	        // Ejecutar la inserción y obtener el número de filas afectadas.
	            int res=preparedStatement.executeUpdate();
	            System.out.println("Se agregaron " + res);
	        }
	        catch (ClassNotFoundException | SQLException e)
	        {
	        // Capturar excepciones y lanzar una DAOException
	            throw  new DAOException(e.getMessage());
	        }
	    }
/*
	    @Override
	    public void modificar(Alumno elemento) throws DAOException {

	        Connection connection=null;
	        PreparedStatement preparedStatement=null;
	        try {
	            Class.forName(DB_JDBC_DRIVER);
	            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	            preparedStatement=connection.prepareStatement("UPDATE Alumno SET legajo=?, nombre=?, apellido=?, limitecursos=?, cursosanotados=?, nota=? WHERE legajo=?");

	            preparedStatement.setString(1,elemento.getLegajo());
	            preparedStatement.setString(2, elemento.getNombre());
	            preparedStatement.setString(3, elemento.getApellido());
	            preparedStatement.setInt(4, elemento.getLimiteCursos());
	            preparedStatement.setInt(5, elemento.getCursosAnotados());
	            preparedStatement.setDouble(6, elemento.getNota());
	            	            
	            int res=preparedStatement.executeUpdate();
	            System.out.println("Se modificaron " + res);
	        }
	        catch (ClassNotFoundException | SQLException e)
	        {
	            throw  new DAOException(e.getMessage());
	        }


	    }
	    */
	    @Override
	    public void modificar(Alumno elemento) throws DAOException {
	        Connection connection=null;
	        PreparedStatement preparedStatement=null;
	        try {
	        	// Establecer la conexión con la base de datos
	            Class.forName(DB_JDBC_DRIVER);
	            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	            // Preparar la declaración SQL para la actualización de un alumno
	            preparedStatement = connection.prepareStatement("UPDATE Alumno SET nombre=?, apellido=? WHERE legajo=?");
	            preparedStatement.setString(1,elemento.getLegajo());
	            preparedStatement.setString(2, elemento.getNombre());
	            preparedStatement.setString(3, elemento.getApellido());
	            // Ejecutar la actualización y obtener el número de filas afectadas
	            int res=preparedStatement.executeUpdate();
	            System.out.println("Se modificaron " + res);
	        }
	        catch (ClassNotFoundException | SQLException e)
	        {
	           // Capturar excepciones y lanzar una DAOException
	            throw  new DAOException(e.getMessage());
	        }


	    }

	    @Override
	    public void eliminar(String legajo) throws DAOException {
	        Connection connection=null;
	        PreparedStatement preparedStatement=null;
	        try {
	          // Establecer la conexión con la base de datos
	            Class.forName(DB_JDBC_DRIVER);
	            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	          // Preparar la declaración SQL para la eliminación de un alumno por legajo
	            preparedStatement=connection.prepareStatement("DELETE FROM alumno  WHERE legajo=?");
	            preparedStatement.setString(1,legajo);
	         // Ejecutar la eliminación y obtener el número de filas afectadas
	            int res=preparedStatement.executeUpdate();
	            System.out.println("Se elimino" + res);
	        }
	        catch (ClassNotFoundException | SQLException e)
	        {
	        	// Capturar excepciones y lanzar una DAOException
	            throw  new DAOException(e.getMessage());
	        }
	    }
	    
	    

/*	   
    @Override
	    public Alumno buscar(String legajo) throws DAOException {
	        Connection connection=null;
	        PreparedStatement preparedStatement=null;
	        Alumno alumno=null;
	        try {
	            Class.forName(DB_JDBC_DRIVER);
	            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	            preparedStatement=connection.prepareStatement("SELECT * FROM alumno  WHERE legajo=?");
	            preparedStatement.setString(1,legajo);
	            ResultSet resultSet =preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                alumno = new Alumno();
	                alumno.setNombre(resultSet.getString("NOMBRE"));
	                alumno.setApellido(resultSet.getString("APELLIDO"));
	                alumno.setLimiteCursos(resultSet.getInt("LIMITE CURSOS"));
	                alumno.setCursosAnotados(resultSet.getInt("CURSOS ANOTADOS"));
	                alumno.setNota(resultSet.getDouble("NOTA"));
	                alumno.setLegajo(legajo);
	                }
	        }
	        catch (ClassNotFoundException | SQLException e)
	        {
	            throw  new DAOException(e.getMessage());
	        }
	        return alumno;
	    }


	    @Override
	    public ArrayList buscarTodos() throws DAOException {
	        Connection connection=null;
	        PreparedStatement preparedStatement=null;
	        ArrayList<Alumno> datos=new ArrayList<>();
	        Alumno alumno;
	        try {
	            Class.forName(DB_JDBC_DRIVER);
	            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	            preparedStatement=connection.prepareStatement("SELECT * FROM alumno");
	            ResultSet resultSet =preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                alumno = new Alumno();
	                alumno.setNombre(resultSet.getString("NOMBRE"));
	                alumno.setApellido(resultSet.getString("APELLIDO"));
	                alumno.setLimiteCursos(resultSet.getInt("LIMITE CURSOS"));
	                alumno.setCursosAnotados(resultSet.getInt("CURSOS ANOTADOS"));
	                alumno.setNota(resultSet.getDouble("NOTA"));
	                alumno.setLegajo(resultSet.getString("LEGAJO"));
	                
	                datos.add(alumno);
	            }
	        }
	        catch (ClassNotFoundException | SQLException e)
	        {
	            throw  new DAOException(e.getMessage());
	        }
	        return datos;
	    }
*/
	}
