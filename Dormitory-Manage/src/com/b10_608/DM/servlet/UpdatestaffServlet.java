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
 * Servlet implementation class UpdatestaffServlet
 */
@WebServlet("/Updatestaff")
public class UpdatestaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PrintWriter out;
	private String sql;
	private Connection conn;
	private PreparedStatement ps;
	private Boolean flag=true;
	
	private String staffno;
	private int dno;
	private String staffname;
	private String sex;
	private String duty;
	private String mobilephone;
	private int age;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatestaffServlet() {
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
		sql="update staff set dno = ?,staffname = ?,sex = ?,duty = ?,mobilephone = ?,age = ? where staffno =?";
	    staffno=request.getParameter("staffno");
	    String strdno=request.getParameter("dno");
	    staffname=request.getParameter("staffname");
	    sex=request.getParameter("sex");
	    duty=request.getParameter("duty");
	    mobilephone=request.getParameter("mobilephone");
	    String strage=request.getParameter("age");
	    System.out.println("staffno: "+staffno+" dno:"+strdno+" staffname: "+staffname+" sex: "+sex+" duty: "+duty+" mobilephone: "+mobilephone+" age: "+strage);
	    
	    try {
	    	dno=Integer.parseInt(strdno);
		    age=Integer.parseInt(strage);
	    	
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, dno);
			ps.setString(2, staffname);
			ps.setString(3, sex);
			ps.setString(4, duty);
			ps.setString(5, mobilephone);
			ps.setInt(6, age);
			ps.setString(7, staffno);
			flag=ps.execute();
			if(flag==false)
				out.print(1);
			else
				out.print(0);
			System.out.println("updatestaff :"+flag);
			
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
