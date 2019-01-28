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
 * Servlet implementation class AddutilitiesServlet
 */
@WebServlet("/Addutilities")
public class AddutilitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PrintWriter out;
	private String sql;
	private Connection conn;
	private PreparedStatement ps;
	private Boolean flag=true;
	
	private int uno;
	private int dno;
	private int month;
	private double wcost;
	private double ecost;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddutilitiesServlet() {
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
		sql="insert into utilities(dno,month,wcost,ecost) values(?,?,?,?)";
	    String strdno=request.getParameter("dno");
	    String strmonth=request.getParameter("month");
	    String strwcost=request.getParameter("wcost");
	    String strecost=request.getParameter("ecost");
	    System.out.println("dno: "+strdno+" month:"+strmonth+" wcost: "+strwcost+" ecost: "+strecost);
	    try {
	    	dno=Integer.parseInt(strdno);
		    month=Integer.parseInt(strmonth);
		    wcost=Integer.parseInt(strwcost);
		    ecost=Integer.parseInt(strecost);
	    	
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, dno);
			ps.setInt(2, month);
			ps.setDouble(3, wcost);
			ps.setDouble(4, ecost);
			flag=ps.execute();
			if(flag==false)
				out.print(1);
			else
				out.print(0);
			System.out.println("addutilities :"+flag);
			
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
