import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Depot
{
	private StockExchange market;
	private double cashBalance;
	private HashMap<String,Integer> stock;
	
	Depot(StockExchange market)
	{
		this.market = market;
		cashBalance = 10000.0;
		stock = new HashMap<String,Integer>();
	}
	
	public boolean buy(String ag, int amount, int day)
	{
		double val = market.getMarketValue(ag, day);
		if ((val < 0) || (cashBalance < val * amount))
			return false;
		cashBalance -= val * amount;
		Integer old = stockAmount(ag);
		stock.put(ag, old + amount);
		return true;
	}
	
	public boolean sell(String ag, int amount, int day)
	{
		int avail = stockAmount(ag);
		double val = market.getMarketValue(ag, day);
		if ((val < 0) || (avail < amount))
			return false;
		cashBalance += val * amount;
		stock.put(ag, avail - amount);
		return true;
	}
	
	public int stockAmount(String ag)
	{
		Integer num = stock.get(ag);
		if (num == null)
			return 0;
		return num;
	}

	public double cashBalance()
	{
		return cashBalance;
	}

	public List<DepotEntry> getStatement(int day)
	{
		ArrayList<DepotEntry> result = new ArrayList<DepotEntry>();
		double total = cashBalance;
		for (Map.Entry<String,Integer> i : stock.entrySet()) {
			String ag = i.getKey();
			int num = i.getValue();
			double val = market.getMarketValue(ag, day) * num;
			result.add(new DepotEntry(ag, num, val));
			total += val;
		}
		result.add(new DepotEntry("Cash", 0, cashBalance));
		result.add(new DepotEntry("Total", 0, total));
		return result;
	}
}
