import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class DBHelper {
	
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String DBURL = "jdbc:mysql://localhost:3306/java";
	
	static final String USER = "jharvard";
	static final String PASS = "crimson";
	
	Connection con;
	
	DBHelper()
	{
		try 
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(DBURL,USER,PASS);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void insertRep(String name, String state, double commission, double rate) throws SQLException
	{
		String query = "INSERT INTO Representative(RepName,State,Commission,Rate) values(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, name);
		stmt.setString(2, state);
		stmt.setFloat(3, (float)commission);
		stmt.setFloat(4, (float)rate);
		System.out.println("Rows Affected:"+stmt.executeUpdate());
		stmt.close();
	}
	
	void insertCustomer(String name, String state, double creditLimit, int repNo) throws SQLException
	{
		String query = "INSERT INTO Customer(CustName,State,Credit_Limit,RepNo) values(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, name);
		stmt.setString(2, state);
		stmt.setInt(3, (int)creditLimit);
		stmt.setInt(4, repNo);
		System.out.println("Rows Affected:"+stmt.executeUpdate());
		stmt.close();
	}
	void getReps(DefaultTableModel model) throws SQLException	{		   //
		   String query =  "SELECT  Representative.RepNo ,  RepName FROM  Representative, Customer WHERE Customer.RepNo = Representative.RepNo  AND Customer.Credit_Limit >6000 GROUP BY  Representative.RepNo"; 
		   Statement stmt = con.createStatement();
		   ResultSet res = stmt.executeQuery(query);
		   while(res.next()){
			   String repNo = res.getString(1);
			   String repName = res.getString(2);
			   model.addRow(new Object []{repNo,repName});
		   }
		   stmt.close();
	   }
	   protected void finalize()	{
		   try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
}
