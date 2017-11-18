import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Depot implements DepotInterface
{
	private StockExchangeImpl market;
	private double cashBalance;
	private HashMap<String,Integer> stock;

	Depot(StockExchangeImpl market)
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

	public List<DepotEntryInterface> getStatement(int day)
	{
		ArrayList<DepotEntryInterface> result = new ArrayList<DepotEntryInterface>();
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

	public class DepotEntry implements DepotEntryInterface {
		private String name;
		private int    num;
		private double value;

		public DepotEntry(String name, int num, double value) {
			this.name = name;
			this.num = num;
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public int getQuantity() {
			return num;
		}
		public double getValue() {
			return value;
		}
		public String toString() {
			if (num > 0)
				return name + ", " + num + ": " + value;
			return name + ": " + value;
		}
	}
}
