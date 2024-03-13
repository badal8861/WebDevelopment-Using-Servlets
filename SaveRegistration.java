package registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveresg")
public class SaveRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SaveRegistration() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("Name");
		String email=request.getParameter("email");
		String phonenum=request.getParameter("phoneno");
		String city=request.getParameter("City");
		System.out.println(name);
		System.out.println(email);
		System.out.println(phonenum);
		System.out.println(city);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","password");
            Statement stmt=conn.createStatement();
            stmt.execute("insert into registration values('"+name+"','"+email+"','"+phonenum+"','"+city+"')");
            System.out.println(stmt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
