import java.rmi.RemoteException;
import java.util.ArrayList;

public class Servidor implements Interfaz
{
	private int posicion;
	private String atacado;
	private ArrayList<String> jugadores;
	
	protected Servidor() throws RemoteException
	{
		posicion = -1;
		jugadores = new ArrayList<String>();
		atacado = "";
	}

	@Override
	public boolean iniciarPartida() throws RemoteException
	{
		if(jugadores.size() == 2)
			return true;
		else
			return false;
	}

	@Override
	public void agregarJugador(String jugador) throws RemoteException
	{
		jugadores.add(jugador);
	}
	

	@Override
	public int leerEntero() throws RemoteException 
	{
		return posicion;
	}

	@Override
	public void escribirEntero(int posicion, String jugador) throws RemoteException 
	{
		this.posicion = posicion;
		atacado = jugador;
	}

	@Override
	public boolean recibirAtaque(String jugador) throws RemoteException 
	{
		if(atacado.equals(jugador))
		{
			atacado = "";
			return true;
		}
		else
			return false;
	}

	@Override
	public String obtenerContrincante(String jugador) throws RemoteException
	{
		for(int i = 0; i < jugadores.size(); i++)
		{
			if(!jugadores.get(i).equals(jugador))
				return jugadores.get(i);
		}
		
		return "";
	}
	
	
}
