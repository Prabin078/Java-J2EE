import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ITServlet
 */
@WebServlet("/ITServlet")
public class ITServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ITServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String salary=request.getParameter("salary");
        String tax=request.getParameter("tax");
        PrintWriter out=response.getWriter();
        File file = new File("/Users/prashanga/Documents/1.txt");
        file.createNewFile();
        FileOutputStream fout = new FileOutputStream(file);
        out.println(""+name+gender+salary+tax);
        fout.write(("hello"+name+gender+salary+tax).getBytes());
        fout.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
