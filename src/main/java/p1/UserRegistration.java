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


@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserRegistration() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String phone =request.getParameter("phone");
		String city =request.getParameter("city");
		String emailId =request.getParameter("emailId");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/web_app_demo_1",
							"root","6361");
			Statement st = con.createStatement();
			st.executeUpdate("insert into register values ('"+name+"','"+phone+"', '"+city+"', '"+emailId+"')");
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	
	
	}

}
