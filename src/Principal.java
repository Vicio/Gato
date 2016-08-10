import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Principal 
{

	public static void main(String[] args)
	{
		try
		{
			if(args[0].trim().toString().length() > 0)
			{
				Integer.parseInt(args[0]);
				//Nombre del servidor
				String nombre = "Gato";
				//nuevo servidor
				Servidor servidor = new Servidor();
				//inicio de la interfaz remota
				Interfaz stub = (Interfaz) UnicastRemoteObject.exportObject(servidor, 0);
				//Creacion del rmi
				LocateRegistry.createRegistry(Integer.parseInt(args[0]));
				//Registro del servidor
			    Registry registry = LocateRegistry.getRegistry();
				//union con el registro
			    registry.bind(nombre, stub);
				//mensaje de exito
				System.out.println("Servidor listo");		    
			}
			else
			{
				System.out.println("Puerto en mala configuración");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			TicTacToe ticTacToe = new TicTacToe();
			ticTacToe.start();
		}
	}

}
