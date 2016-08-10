import java.lang.reflect.Array;
import java.rmi.*;
import java.util.ArrayList;

public interface Interfaz extends Remote
{
	public boolean iniciarPartida() throws RemoteException;
	
	public String obtenerContrincante(String jugador) throws RemoteException;
	
	public void agregarJugador(String jugador) throws RemoteException;
	
	public boolean recibirAtaque(String jugador) throws RemoteException;
	
	public int leerEntero() throws RemoteException;
	
	public void escribirEntero(int posicion, String jugador) throws RemoteException;
	
}
