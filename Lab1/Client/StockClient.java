import java.rmi.*;
import java.util.Scanner;

public class StockClient {
    public static void main( String args[]) {
        StockInterface obj;

        try {
            obj = (StockInterface)Naming.lookup("rmi://localhost/Stock");

            System.out.println("=========Companies=========");
            for (String agName: obj.getAGs()) {
                System.out.println(agName);
            }
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
            System.out.println(obj.getWinner(d1, d2).getPercentageGain());
            System.out.println("=========Tendence=========");
            System.out.println("Enter a day from 1 to 30: ");
            int tendence_day = in.nextInt();
            System.out.println(obj.tendence(tendence_day));

            DepotInterface depot = obj.openDepot();
            System.out.println("Cash Balance = " + depot.cashBalance());

            System.out.print("Enter name of stock to find what amount of it do you have: ");
            ag_name = in.nextLine(); // need to solve problem with previos newline detection.
            ag_name = in.nextLine();
            System.out.println("Stock to search " + ag_name + "." );
            System.out.println("BMW stockAmount = " + depot.stockAmount(ag_name));

            System.out.print("What stock to buy: ");
            ag_name = in.nextLine();
            System.out.print("What amount to buy: ");
            amount = in.nextInt();
            System.out.print("What stock to buy: ");
            day = in.nextInt();
            if(depot.buy(ag_name, amount, day)) {
                System.out.println("Succes");
            }

            System.out.print("Enter day for which to print the statement: ");
            day = in.nextInt();
            System.out.println("Printing statement:");
            for(DepotInterface.DepotEntryInterface depotEntry: depot.getStatement(day)) {
                System.out.println("ag_name:" + depotEntry.getName() + " quantity:" + depotEntry.getQuantity() + " value:" + depotEntry.getValue());
            }

            // System.out.println("Cash Balance = " + obj.openDepot().cashBalance());


        }
        catch (Exception e) {
            System.out.println("HelloClient: " + e.getMessage());
			e.printStackTrace();
        }
    }
}
