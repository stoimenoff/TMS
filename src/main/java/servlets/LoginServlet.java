package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accounts.Registrator;
import accounts.User;
import accounts.UserAuthenticator;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		String forwardAddres = "/login.html";
		
		if (userName != null && userPassword != null) {
			User loggedUser = new User(userName, userPassword);
			if(UserAuthenticator.authenticate(loggedUser)){
				HttpSession session = request.getSession();
				session.setAttribute("user", loggedUser);
				forwardAddres = "/index.html";
			}
		}	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardAddres);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
