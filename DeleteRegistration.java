package delete;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteresg")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteRegistration() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("Name");
		System.out.println(name);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","password");
			Statement stmt=conn.createStatement();
			stmt.execute("delete from registration where name='"+name+"'");
			System.out.println(stmt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
