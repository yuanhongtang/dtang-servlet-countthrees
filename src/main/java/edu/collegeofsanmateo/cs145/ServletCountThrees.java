package edu.collegeofsanmateo.cs145;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletCountThrees
 */
public class ServletCountThrees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int count;
	int threesCount;
	private ReadInt32BitLE dao;

	/**
	 * Default constructor.
	 */
	public ServletCountThrees() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set a cookie for the user, so that the counter does not increate
		// every time the user press refresh
		HttpSession session = request.getSession(true);
		// Set the session valid for 5 secs
		session.setMaxInactiveInterval(5);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		if (session.isNew()) {
			count++;
		}
		out.println("ServletCountThrees has been accessed " + count + " times. There are "+threesCount+"3s");
	}

	@Override
	public void init() throws ServletException {
		dao = new ReadInt32BitLE(getServletContext().getRealPath("threesData.bin"));
		try {
			dao.open();
			while (!dao.EOF()) {
				dao.read();
			}
			threesCount = dao.getCount();
		} catch (Exception e) {
			getServletContext().log("An exception occurred in FileCounter", e);
			throw new ServletException("An exception occurred in FileCounter"
					+ e.getMessage());
		} finally {
			dao.close();
		}
	}

	public void destroy() {
		super.destroy();
		try {
			// release any dao resources
			dao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
