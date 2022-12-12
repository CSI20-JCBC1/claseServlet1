package edu.claseServlet1.Controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet(name="operar", urlPatterns={"/operar"})
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Uno = request.getParameter("nUno");
		String Dos = request.getParameter("nDos");
		Integer iUno=Integer.parseInt(Uno);
        Integer iDos=Integer.parseInt(Dos);
		String btnSumar= request.getParameter("btnSuma");
		String btnRestar= request.getParameter("btnRestar");
		
		Integer resultado=0;
		
		if (btnSumar!=null ) {
			resultado=iUno+iDos;
			
		}
		
		if (btnRestar!=null ) {
			resultado=iUno-iDos;
			
		}
		
		request.setAttribute("resultadoR", resultado);
        request.getSession().setAttribute("resultadoS", resultado);
        getServletContext().setAttribute("resultadoC", resultado);
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/resultado.jsp");
        rd.forward(request, response);
		
		
	}

}
