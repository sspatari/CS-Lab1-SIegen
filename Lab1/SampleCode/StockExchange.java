import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockExchange {
	private ConnectDB dbHandle;

	public StockExchange() {
		dbHandle = new ConnectDB();
		// Verbindung zur Datenbank herstellen
		System.out.println("StockExchange: Opening database");
		if (!dbHandle.open()) {
			System.out.println("StockExchange: Can't open database");
		}
	}

	public void close() {
		System.out.println("StockExchange: Closing database");
		dbHandle.close();
	}

	public String[] getAGs() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			ResultSet res;
			res = dbHandle.execute("SELECT AG_NAME FROM ag_name");
			while (res.next())
				list.add(res.getString(1));
		} catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage());
		}
		return list.toArray(new String[0]);
	}

	public double getMarketValue(String ag, int day) {
		try {
			ResultSet res;
			res = dbHandle.execute("SELECT VALUE "
					+ "FROM ag_data, ag_name "
					+ "WHERE ag_data.AG_ID = ag_name.AG_ID AND "
					+ "AG_NAME = '" + ag + "' AND "
					+ "DAY = '" + day + "'");
			if (res.next())
				return res.getDouble(1);
		} catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage());
		}
		return -1.0;
	}

	public Depot openDepot() {
		return new Depot(this);
	}

	public WinnerInfo getWinner(int d1, int d2) throws StockException {
		String[] agNames = getAGs();
		if(agNames.length == 0) {
			throw new StockException("Test Exeption");
		}
		WinnerInfo winnerInfo = new WinnerInfo(agNames[0], ((getMarketValue(agNames[0],d2) - getMarketValue(agNames[0],d1))/getMarketValue(agNames[0],d1)) * 100);
		for(int i = 1; i < agNames.length; ++i) {
			double marketValue1 = getMarketValue(agNames[i],d1);
			double marketValue2 = getMarketValue(agNames[i],d2);
			double percentageGain = (marketValue2 - marketValue1)/marketValue1 * 100;
			if(winnerInfo.getPercentageGain() < percentageGain) {
				winnerInfo.setAgName(agNames[i]);
				winnerInfo.setPercentageGain(percentageGain);
			}
		}
		return winnerInfo;
	}

	public double tendence(int d1) throws StockException {
		int d2 = d1 + 1;
		double sumD1 = 0, sumD2 = 0 ;
		String[] agNames = getAGs();
		for(String agName: agNames) {
			sumD1 += getMarketValue(agName, d1);
			sumD2 += getMarketValue(agName, d2);
		}
		return (sumD2 - sumD1)/sumD1 * 100;
	}

	private class StockException extends Exception {
		String message;

		public StockException(String message) {
			this.message = message;
		}
		public String toString() {
			return ("StockException Occurred: " + message) ;
		}
	}
}
