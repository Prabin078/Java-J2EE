
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TelephoneSearch
 */
@WebServlet("/TelephoneSearch")
public class TelephoneSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String host = "jdbc:mysql://localhost:3306/java";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "jharvard";
    private static final String pass = "crimson";
    Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelephoneSearch() {
        super();
        // TODO Auto-generated constructor stub
        try {
        	Class.forName(driver);
			conn = DriverManager.getConnection(host,user,pass);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<form action=\"TelephoneSearch\" method=\"get\">");
		pw.println("Name: <input type=\"text\" name=\"name\"/><br/><b>OR</b><br/>");
		pw.println("Number: <input type=\"text\" name=\"number\"/>");
		pw.println("<input type=\"submit\" value=\"submit\"/>");
		pw.println("</form>\n</body>\n</html>");
		String name = request.getParameter("name");
		String number =  request.getParameter("number");
		if(name != null){
			if(!name.isEmpty())	{
				System.out.println("name: "+name);
				pw.println("<br/><br/><hr/><h2>Details</h2>");
				
				try {
					Statement s = conn.createStatement();
					String sql = "SELECT * from Telephone_Directory where name = '"+name+"'";
					ResultSet rs = s.executeQuery(sql);
					while(rs.next()){
						pw.println("<p>Name: "+rs.getString("name"));
						pw.println("<br/>Number: " + rs.getInt("number"));
						pw.println("<br/>Address: " + rs.getString("address"));
						pw.println("<br/>Zip Code: " + rs.getString("zipcode"));
						pw.println("<br/>Company: "+rs.getString("company")+"</p>");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		if(number != null){
			if(!number.isEmpty())	{
				System.out.println("number: "+number);
				pw.println("<br/><br/><hr/><h2>Details</h2>");
				
				try {
					Statement s = conn.createStatement();
					String sql = "SELECT * from Telephone_Directory where number = "+number;
					ResultSet rs = s.executeQuery(sql);
					while(rs.next()){
						pw.println("<p>Name: "+rs.getString("name"));
						pw.println("<br/>Number: " + rs.getInt("number"));
						pw.println("<br/>Address: " + rs.getString("address"));
						pw.println("<br/>Zip Code: " + rs.getString("zipcode"));
						pw.println("<br/>Company: "+rs.getString("company")+"</p>");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
