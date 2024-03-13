package update;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateresg")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateRegistration() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 

	String name=request.getParameter("Name");
	String phonenum=request.getParameter("Phonenumber");
	System.out.println(name);
	System.out.println(phonenum);
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","password");
		Statement stmt=conn.createStatement();
		stmt.execute("update registration set name='"+name+"' where mobile='"+phonenum+"'");
		System.out.println(stmt);
	}
catch(Exception e) {
	e.printStackTrace();
}
}
}
