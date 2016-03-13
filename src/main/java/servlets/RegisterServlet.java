package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accounts.Registrator;
import accounts.User;

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		String forwardAddres = "/login.html";
		
		if (userName != null && userPassword != null) {
			// register user to DB
			User registredUser = new User(userName, userPassword);
			Registrator.register(registredUser);
			
			HttpSession session = request.getSession();
			session.setAttribute("registration", true);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardAddres);
		dispatcher.forward(request, response);
		
		//response.sendRedirect("/TaskManagementSystem/index.jsp");
		
	}

}
