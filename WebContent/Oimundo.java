package agenda;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Oimundo extends HttpServlet {
		protected void service (HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("Primeira servlet");
		out.println("</body>");
		out.println("</html>");
		
	
		}
		}

