// Einfache Klasse zum Testen der Datenbankverbindung
// 
// Autor: RW, 18.10.2007
//

import java.sql.*;
import java.util.*;


public class TestDB 
{
  public static void main(String args[])
  {
	  ResultSet res;
	  ConnectDB db_handle = new ConnectDB();
  		
	  // Verbindung zur Datenbank herstellen
	  if (!db_handle.open())
		  System.out.println("Kann DB nicht offnen");

	  try {
		  // Auslesen von ag_name aus der DB
		  res = db_handle.execute("SELECT `AG_ID`,`AG_NAME` FROM ag_name");
			
		  // Ausgabe des ResultSets
		  System.out.println("ag_name:");
		  System.out.println("========");
		  while (res.next()) {
			  System.out.println("" + res.getInt(1) + ", " + res.getString(2));
		  }

		  // Auslesen von ag_data aus der DB
		  res = db_handle.execute("SELECT `ID`,`AG_ID`,`DAY`,`VALUE` FROM `ag_data`");

		  // Ausgabe des ResultSets
		  System.out.println();
		  System.out.println("ag_data:");
		  System.out.println("========");
		  while (res.next()) {
			  System.out.println("" + res.getInt(1) + ", "
								 + res.getInt(2) + ", "
								 + res.getInt(3) + ", "
								 + res.getDouble(4));
		  }
	  }
	  catch(Exception e) {
		  System.out.println("Fehler beim Auslesen der DB-Daten!");
	  }
	  
	  // Schliesen der Datenbankverbindung
	  db_handle.close();
  }
}
