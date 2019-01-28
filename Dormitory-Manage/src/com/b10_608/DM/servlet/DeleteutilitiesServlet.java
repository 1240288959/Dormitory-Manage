package com.b10_608.DM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class DeleteutilitiesServlet
 */
@WebServlet("/Deleteutilities")
public class DeleteutilitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrintWriter out;
	private String sql;
	private Connection conn;
	private PreparedStatement ps;
	private Boolean flag=true;
	
	private int uno;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteutilitiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf8");
		out=response.getWriter();
		sql="delete  from utilities where uno = ?";
	    String struno=request.getParameter("uno");
	    System.out.println("uno:"+struno);
	    try {
	    	
	    	uno=Integer.parseInt(struno);
	 	    
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, uno);
			flag=ps.execute();
			if(flag==false)
				out.print(1);
			else
				out.print(0);
			System.out.println("deleteutilities :"+flag);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(flag==false)
				out.print(1);
			else
				out.print(0);
			e.printStackTrace();
		}finally{
			out.close();
			JdbcUtils.free(null, ps, conn);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
