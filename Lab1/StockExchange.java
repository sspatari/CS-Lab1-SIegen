import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockExchange
{
	private ConnectDB dbHandle;

	public StockExchange()
	{
		dbHandle = new ConnectDB();
		// Verbindung zur Datenbank herstellen
		System.out.println("StockExchange: Opening database");
		if (!dbHandle.open()) {
			System.out.println("StockExchange: Can't open database");
		}
	}

	public void close()
	{
		System.out.println("StockExchange: Closing database");
		dbHandle.close();
	}

	public String[] getAGs()
	{
		ArrayList<String> list = new ArrayList<String>();
		try {
			ResultSet res;
			res = dbHandle.execute("SELECT AG_NAME FROM ag_name");
			while (res.next())
				list.add(res.getString(1));
		}
		catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage());
		}
		return list.toArray(new String[0]);
	}
	
	public double getMarketValue(String ag, int day)
	{
		try {
			ResultSet res;
			res = dbHandle.execute("SELECT VALUE "
								   + "FROM ag_data, ag_name "
								   + "WHERE ag_data.AG_ID = ag_name.AG_ID AND "
								   + "AG_NAME = '" + ag + "' AND "
								   + "DAY = '" + day + "'");
			if (res.next())
				return res.getDouble(1);
		}
		catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage());
		}
		return -1.0;
	}
	
	public Depot openDepot()
	{
		return new Depot(this);
	}
}
