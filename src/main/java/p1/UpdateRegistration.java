package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateRegistration() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  String name = request.getParameter("name");
	  String city = request.getParameter("city");
	  String email = request.getParameter("email");
	  String mobile = request.getParameter("mobile");
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_z","root","Kanpur");
		  Statement stmnt = con.createStatement();
		  stmnt.executeUpdate("update registration set mobile='"+mobile+"' where email= '"+email+"'");
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
