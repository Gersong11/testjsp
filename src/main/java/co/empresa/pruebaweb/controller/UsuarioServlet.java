package co.empresa.pruebaweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.empresa.pruebaweb.dao.UsuarioDao;
import co.empresa.pruebaweb.modelo.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UsuarioDao usuarioDao; 
	
	
    /**
     * Default constructor. 
     */
    public UsuarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.usuarioDao = new UsuarioDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			
		
		switch (action) {
		case "/new": 
			showNewForm(request, response);
			break;
		case "/insert":
			insertarUsuario(request, response);
			break;
		case "/delete":
			eliminarUsuario(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			ActualizarUsuario(request, response);
			break;
		default:
			listusuarios(request,response);
				break;
				
		}} catch (SQLException e) {
			
		}
		
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	public void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		
		
			Usuario usuario = new Usuario(nombre,email,pais);
	
		this.usuarioDao.insert(usuario);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario usuarioactual = this.usuarioDao.selec(id);
		request.setAttribute("usuario", usuarioactual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
		
	}
	
	public void ActualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		
		
			Usuario usuario = new Usuario(id,nombre,email,pais);
	
		this.usuarioDao.update(usuario);
		response.sendRedirect("list");
	}
	
	public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	int id = Integer.parseInt(request.getParameter("id"));
	
	
	
		

	this.usuarioDao.delete(id);
	response.sendRedirect("list");
	}
	
	private void listusuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	
	List<Usuario> listUsuarios = this.usuarioDao.selecAll();
	request.setAttribute("listUsuarios", listUsuarios);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("usuariolist.jsp");
	dispatcher.forward(request, response);
	
	}

}
