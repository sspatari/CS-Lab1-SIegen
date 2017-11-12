import java.sql.*;

public class ConnectDB
{
	private Connection connection;
	private Statement statement;

	final static String myhostdb = "localhost/databaseName"; // change databaseName
		
	public ConnectDB() 
	{
		connection= null;
		statement = null;
		try {
			// Load the JDBC driver - jdbc:mysql
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
	  	}
		catch (Exception e) // ClassNotFoundException
		{
			System.out.println("DBError: Driver Missing" + e);
		}
	}
	
	// Establish a connection to DB.
	//
	public boolean open()
	{
		return open(myhostdb);
	}

	// In case you use another db
	public boolean open( String hostdb )
	{
		String dbUrl="jdbc:mysql://"+hostdb;
		try {
			connection = DriverManager.getConnection(dbUrl,"user","password"); // write user & password for connecting to DB
			System.out.println("Database connected to "+ dbUrl);
	  	}
		catch ( SQLException e)
		{
			System.out.println("DBError: Cannot connect" + e);
		}
	 	return(connection != null);
	}


	/*
	 Close DB.
	*/
	public boolean close()
	{
		try
		{
			if ( statement != null) statement.close();
			if ( connection != null) connection.close();
			return true;
		}
		catch( SQLException e)
		{
			// close failed !
			System.out.println("DBError: Cannot close" + e);
		}
		return false;
	}

	/*
	 Executes sql-query and returns a ResultSet object.
	 @param SQL - sql-query
	 @throw SQLException if cannot create statement or
	 cannot execute query.
	*/
	public ResultSet execute( String SQL) throws SQLException
	{

		// Create & execute a statement
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery( SQL);

		return( resultSet);
	}
} // end class






