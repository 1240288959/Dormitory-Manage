package com.b10_608.DM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.annotation.JSONField;
import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class AddmechineServlet
 */
@WebServlet("/Addmechine")
public class AddmechineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PrintWriter out=null;
	private String sql;
	private Connection conn;
	private PreparedStatement ps;
	private Boolean flag=true;
	
	private String mno;
	private String mname;
	@JSONField(format="yyyy-MM-dd")
	private Date sdate;
	@JSONField(format="yyyy-MM-dd")
	private Date fdate;
	private double cost;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddmechineServlet() {
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
		sql="insert into mechine values(?,?,?,?,?)";
	    mno=request.getParameter("mno");
	    mname=request.getParameter("mname");
	    String strsdate=request.getParameter("sdate");
	    String strfdate=request.getParameter("fdate");
	    String strcost=request.getParameter("cost");
	    System.out.println("mno: "+mno+" mname:"+mname+" sdate: "+strsdate+" fdate: "+strfdate+" cost: "+strcost);
	    
	    try {
	    	
	    	cost=Double.parseDouble(strcost);
		    sdate=Date.valueOf(strsdate);
		    fdate=Date.valueOf(strfdate);
	    	
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, mno);
			ps.setString(2, mname);
			ps.setDate(3, sdate);
			ps.setDate(4, fdate);
			ps.setDouble(5, cost);
			flag=ps.execute();
			if(flag==false)
				out.print(1);
			else
				out.print(0);
			System.out.println("addmechine :"+flag);
			
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
