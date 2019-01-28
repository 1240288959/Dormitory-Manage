package com.b10_608.DM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class AddstaffServlet
 */
@WebServlet("/Addstaff")
public class AddstaffServlet extends HttpServlet {
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
    public AddstaffServlet() {
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
		sql="insert into staff values(?,?,?,?,?,?,?)";
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
			ps.setString(1, staffno);
			ps.setInt(2, dno);
			ps.setString(3, staffname);
			ps.setString(4, sex);
			ps.setString(5, duty);
			ps.setString(6, mobilephone);
			ps.setInt(7, age);
			flag=ps.execute();
			if(flag==false)
				out.print(1);
			else
				out.print(0);
			System.out.println("addstaff :"+flag);
			
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
