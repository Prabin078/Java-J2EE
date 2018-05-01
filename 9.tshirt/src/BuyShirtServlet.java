

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class BuyShirtServlet
 */
@WebServlet("/BuyShirtServlet")
public class BuyShirtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String host = "jdbc:mysql://localhost:3306/java";
	private static final String user = "jharvard";
	private static final String pass = "crimson";
	
	Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyShirtServlet() {
        super();
        try
        {
        	Class.forName(driver);
        	con = DriverManager.getConnection(host,user,pass);
        	
        }
        catch(Exception e){}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tag = request.getParameter("tag");
		String[] accessories = request.getParameterValues("accessories");
		String color =  request.getParameter("color");
		int pocket = Integer.parseInt(request.getParameter("pocket"));

		String acc="";
		for(String s: accessories){
			acc+=s+" ";			
		}
		String sql = "INSERT INTO tshirt (color, chest_pocket, tag, accessories) VALUES (?,?,?,?)";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, color);
			stmt.setInt(2, pocket);
			stmt.setString(3, tag);
			stmt.setString(4, acc);
			stmt.executeUpdate();
		}catch(Exception e){ e.printStackTrace();}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
