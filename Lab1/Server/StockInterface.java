import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockInterface extends Remote
{
    public void close() throws RemoteException;
    public String[] getAGs() throws RemoteException;
    public double getMarketValue(String ag, int day) throws RemoteException;
    public Depot openDepot() throws RemoteException;
    public WinnerInfoInterface getWinner(int d1, int d2) throws RemoteException;
    public double tendence(int d1) throws RemoteException;

    public interface WinnerInfoInterface {
        public String getAgName();
	    public double getPercentageGain();
        public String toString();
    }
}
