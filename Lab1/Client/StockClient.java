import java.rmi.*;
import java.util.Scanner;

public class StockClient {
    public static void main( String args[]) {
        StockInterface obj;

        try {
            obj = (StockInterface)Naming.lookup("rmi://localhost/Stock");
            
            System.out.println("=========Companies=========");
            System.out.println(obj.getAGs());
            System.out.println("=========getMarketValue=========");
            Scanner in = new Scanner(System.in);
            System.out.println("Company name: ");
            String ag_name = in.nextLine();
            System.out.println("day : ");
            int day = in.nextInt();
            System.out.println(obj.getMarketValue(ag_name, day));
            System.out.println("=========Get Winner=========");
            System.out.println("Enter first and last day: ");
            int d1 = in.nextInt();
            int d2 = in.nextInt();
            System.out.println(obj.getWinner(d1, d2));
            System.out.println("=========Tendence=========");
            System.out.println("Enter a day from 1 to 30: ");
            int tendence_day = in.nextInt();
            System.out.println(obj.tendence(tendence_day));
        }
        catch (Exception e) {
            System.out.println("HelloClient: " + e.getMessage());
			e.printStackTrace();
        }
    }
}