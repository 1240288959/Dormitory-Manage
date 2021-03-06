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
 * Servlet implementation class UpdatedormitoryServlet
 */
@WebServlet("/Updatedormitory")
public class UpdatedormitoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrintWriter out;
	private String sql;
	private Connection conn;
	private PreparedStatement ps;
	private Boolean flag=true;
	
	private int dno;
	private String dname;
	private String dphone;
	private int maxpeople;
	private int nowpeople;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatedormitoryServlet() {
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
		sql="update dormitory set dname = ?,dphone = ?,maxpeople = ?,nowpeople = ? where dno = ?";
		String strdno=request.getParameter("dno");
	    dname=request.getParameter("dname");
	    dphone=request.getParameter("dphone");
	    String strmaxpeople=request.getParameter("maxpeople");
	    String strnowpeople=request.getParameter("nowpeople");
	    System.out.println("dname:"+dname+"  dphone :"+dphone+" maxpeople:"+strmaxpeople+"  nowpeople:"+strnowpeople);
	    try {
	    	dno=Integer.parseInt(strdno);
	    	maxpeople=Integer.parseInt(strmaxpeople); 
	 	    nowpeople=Integer.parseInt(strnowpeople);
	 	    
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, dname);
			ps.setString(2, dphone);
			ps.setInt(3, maxpeople);
			ps.setInt(4, nowpeople);
			ps.setInt(5, dno);
			flag=ps.execute();
			if(flag==false)
				out.print(1);
			else
				out.print(0);
			System.out.println("updatedormitory :"+flag);
			
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
