public class TestClass {
    public static void main(String args[]) {
        try{
        StockExchange stockExchange = new StockExchange();
        System.out.println(stockExchange.getWinner(1,10));
        System.out.println(stockExchange.tendence(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
