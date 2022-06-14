import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBManager291 {
	
	UIManager291 ui291;
	Connection conn291;
	ResultSet results291;
	
	// retrieve the parts table, returns as a 2d ArrayList of Strings excluding the QOH
	public ArrayList<ArrayList<String>> partsQuery291() {
		ArrayList<ArrayList<String>> ret = new ArrayList<>();
		
		doQuery291("SELECT * FROM parts291");
		try {
			while(results291.next() == true) {
				ArrayList<String> line = new ArrayList<String>();
				for(int i = 1; i <= 3; i++) {
					line.add(results291.getString(i));
				}
				ret.add(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	// retrieve the POs with clientComp291 = clientId291, returns as a 2d ArrayList of Strings
	public ArrayList<ArrayList<String>> POsQuery291(int clientID291) {
		ArrayList<ArrayList<String>> ret = new ArrayList<>();
		
		doQuery291("SELECT * FROM pos291 where clientCompId291 = " + clientID291);
		try {
			while(results291.next() == true) {
				ArrayList<String> line = new ArrayList<String>();
				for(int i = 1; i <= 4; i++) {
					line.add(results291.getString(i));
				}
				ret.add(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	// retrieve the Lines with poNo291 = poId291, returns as a 2d ArrayList of Strings 
	public ArrayList<ArrayList<String>> POLineQuery291(int poId291) {
		ArrayList<ArrayList<String>> ret = new ArrayList<>();
		
		doQuery291("SELECT * FROM lines291 where poNo291 = " + poId291);
		try {
			while(results291.next() == true) {
				ArrayList<String> line = new ArrayList<String>();
				for(int i = 1; i <= 5; i++) {
					line.add(results291.getString(i));
				}
				ret.add(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	// insert a new purchase order to DB from parameters, returns false if insert fails
	public boolean addPO291(int poNo291, Date date291, String status291, int clientId291) {
		
		// check if PO meets criteria
		try {
			doQuery291("Select poNo291 from pos291");
			while(results291.next() == true) {
				if(poNo291 == results291.getInt("poNo291")) {
					return false;
				}
			}
			doQuery291("Select clientId291 from clients291 where clientId291 = " + clientId291);
			if(!results291.next()) {
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		return doUpdate291(  "INSERT into pos291 (`poNo291`,`dateOfPO291`,`status291`,`clientCompID291`)"
				+ " values ('"+poNo291+"','"+date291+"','"+status291+"','"+clientId291+"')"  );
	}
	// insert a new line to DB from parameters, returns false if insert fails
	public boolean addLine291(int poNo291, int partNo291, int qty291, double price291, int lineNo291) {
		try {
			doQuery291("Select poNo291 from pos291");
			boolean valid = false;
			while(results291.next() == true) {
				if(poNo291 == results291.getInt("poNo291")) {
					valid = true;
					break;
				}
			}
			if(!valid) {return false;}
			doQuery291("Select qoh291, partPrice291 from parts291 where partNo291 = " + partNo291);
			if(results291.next() == false) { // if no items returned
				return false;
			}
			// qty check
			if(results291.getInt("qoh291") < qty291) {
				return false;
			}
			// price check
			if(results291.getDouble("partPrice291") != price291) {
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		
		return doUpdate291("INSERT into lines291 (`qty291`,`priceOrdered291`,`partNo291`,`poNo291`,`lineNo291`)"
				+ " values ('"+qty291+"','"+price291+"','"+partNo291+"','"+poNo291+"','"+lineNo291+"')");
	}
	
	// method for executing SELECT sql statements from String q
	private boolean doQuery291(String q) {
		ui291.println291("Querying DataBase with: '" + q + "'");
		try {
			results291 = conn291.createStatement().executeQuery(q);
			return true;
		} catch (SQLException e) {
			ui291.println291("Query Failed");
			e.printStackTrace();
			return false;
		}
	}
	// method for executing UPDATE/INSERT/DELETE sql queries from string q
	private boolean doUpdate291(String q) {
		ui291.println291("Updating DataBase with: '" + q + "'");
		try {
			conn291.createStatement().executeUpdate(q);
			return true;
		} catch (SQLException e) {
			ui291.println291("Update Failed");
			e.printStackTrace();
			return false;
		}
	}
	
	DBManager291(UIManager291 ui){
		this.ui291 = ui;

		// Setup database connection
		try {
			conn291 = DriverManager.getConnection("jdbc:mysql://localhost/a2?user=A2User&password=291");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
