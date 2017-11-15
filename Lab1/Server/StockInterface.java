import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockInterface extends Remote
{
    String[] getAGs() throws RemoteException;
    double getMarketValue(String ag, int day) throws RemoteException;
    WinnerInfoInterface getWinner(int d1, int d2) throws RemoteException;
    double tendence(int d1) throws RemoteException;

    public interface WinnerInfoInterface {
        public String getAgName();
	    public double getPercentageGain();
        public String toString();
    }
}
