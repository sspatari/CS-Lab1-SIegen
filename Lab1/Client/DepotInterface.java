import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DepotInterface {
	public boolean buy(String ag, int amount, int day);
	public boolean sell(String ag, int amount, int day);
	public int stockAmount(String ag);
	public double cashBalance();
	public List<DepotEntryInterface> getStatement(int day);

	public interface DepotEntryInterface {
		public String getName();
		public int getQuantity();
		public double getValue();
		public String toString();
	}
}
