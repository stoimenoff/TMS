package registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accounts.User;
import accounts.UserUtils;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/register.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//extract and validate user
		User registredUser = UserUtils.getUser(request);
		if (!UserUtils.validateUserData(registredUser)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("User information wrong!");
			return;
		}
		// register user to DB
		try {
			Registrator.register(registredUser);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (UsernameAlreadyInUseException | EmailAlreadyInUseException e) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
			response.getWriter().write("Username or email in use!");
		}
	}

}
