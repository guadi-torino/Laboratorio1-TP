package service;

import Controlador.Alumno;
import Model.DAOAlumno;
import Model.DAOException;

//Servicio para gestionar operaciones relacionadas con la entidad Alumno
public class AlumnoService {
	private DAOAlumno daoAlumno;

// Constructor que inicializa el DAOAlumno
    public AlumnoService() {
        daoAlumno=new DAOAlumno();
    }
    
 // Método para guardar un alumno
    public void guardarAlumno(Alumno alumno) throws ServiceException {
        try {
            daoAlumno.guardar(alumno);
        } catch (DAOException e) {
        // Capturar excepción DAO y lanzar una ServiceException
            throw new ServiceException(e.getMessage());
        }
    }
    
    // Método para modificar un alumno
    public void modificarAlumno(Alumno alumno) throws ServiceException {
        try {
            daoAlumno.modificar(alumno);
        } catch (DAOException e) {
        	 // Capturar excepción DAO y lanzar una ServiceException
            throw new ServiceException(e.getMessage());
        }
    }
    
    // Método para eliminar un alumno por su legajo
    public void eliminarAlumno(String legajo) throws ServiceException
        {
            try{
                daoAlumno.eliminar(legajo);
            }
            catch (DAOException e)
            {
            	 // Capturar excepción DAO y lanzar una ServiceException
                throw  new ServiceException(e.getMessage());
            }
        }
  /*  public ArrayList<Alumno> buscarTodos() throws ServiceException {
    	 ArrayList<Alumno> alumno=null;
         try {
             alumno=daoAlumno.buscarTodos();
         }
         catch (DAOException e)
         {
             throw new ServiceException(e.getMessage());
         }
         return alumno;
    }
    */
/*    public Alumno buscar(String legajo)throws  ServiceException
     {
         Alumno alumno=null;
         try {
             alumno=daoAlumno.buscar(legajo);
         }
         catch (DAOException e)
         {
             throw new ServiceException(e.getMessage());
         }
         return alumno;
     }
     */
     
}