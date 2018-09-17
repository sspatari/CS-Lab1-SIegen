import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DepotInterface extends Remote {
	public boolean buy(String ag, int amount, int day) throws RemoteException;
	public boolean sell(String ag, int amount, int day) throws RemoteException;
	public int stockAmount(String ag) throws RemoteException;
	public double cashBalance() throws RemoteException;
	public List<DepotEntryInterface> getStatement(int day) throws RemoteException;

	public interface DepotEntryInterface extends Remote{
		public String getName() throws RemoteException;
		public int getQuantity() throws RemoteException;
		public double getValue() throws RemoteException;
	}
}
