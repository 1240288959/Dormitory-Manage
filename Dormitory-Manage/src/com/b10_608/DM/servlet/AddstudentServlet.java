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
 * Servlet implementation class AddstudentServlet
 */
@WebServlet("/Addstudent")
public class AddstudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrintWriter out;
	private String sql;
	private Connection conn;
	private PreparedStatement ps;
	private Boolean flag=true;
	
	private String sno;
	private int dno;
	private String sname;
	private String sex;
	private String major;
	private String mobilephone;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddstudentServlet() {
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
		sql="insert into student values(?,?,?,?,?,?)";
	    sno=request.getParameter("sno");
	    String strdno=request.getParameter("dno");
	    sname=request.getParameter("sname");
	    sex=request.getParameter("sex");
	    major=request.getParameter("major");
	    mobilephone=request.getParameter("mobilephone");
	    String strage=request.getParameter("age");
	    System.out.println("sno: "+sno+" dno:"+strdno+" sname: "+sname+" sex: "+sex+" major: "+major+" mobilephone: "+mobilephone);
	    
	    try {
	    	dno=Integer.parseInt(strdno);
	    	
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setInt(2, dno);
			ps.setString(3, sname);
			ps.setString(4, sex);
			ps.setString(5, major);
			ps.setString(6, mobilephone);
			flag=ps.execute();
			if(flag==false)
				out.print(1);
			else
				out.print(0);
			System.out.println("addstudent :"+flag);
			
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
