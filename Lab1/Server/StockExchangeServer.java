import java.rmi.*;

public class StockExchangeServer {
    public static void main(String args[]) {
        try{
            StockExchangeImpl stockExchangeImpl = new StockExchangeImpl();
            String localhost = "localhost";
            Naming.rebind("rmi://" + localhost + "/Stock", stockExchangeImpl);
            // System.out.println(stockExchangeImpl.getWinner(1,2).getAgName());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
        }
    }
}
