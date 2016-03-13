package authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import accounts.Registrator;
import accounts.User;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/login.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//StringBuilder body = new StringBuilder();
		String body = request.getReader().lines()
			    .reduce("", (accumulator, actual) -> accumulator + actual);
		/*
		try(BufferedReader reader = request.getReader()) {
			String line;
			while((line = reader.readLine()) != null) {
				body.append(line);
			}
		}
		*/
		System.out.println("body " + body);
		Gson gson = new Gson();
		User loggedUser = gson.fromJson(body.toString(), User.class);
		
		if (UserAuthenticator.authenticate(loggedUser)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", loggedUser);
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}

	}

}
