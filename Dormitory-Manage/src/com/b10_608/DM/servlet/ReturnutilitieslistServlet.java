package com.b10_608.DM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.b10_608.DM.pojo.Utilities;
import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class ReturnutilitiesServlet
 */
@WebServlet("/Returnutilitieslist")
public class ReturnutilitieslistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String sql;
	private PrintWriter out=null;
	private Utilities utilities;
	private ArrayList<Utilities> arraylist;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private int uno;
	private int dno;
	private int month;
	private double wcost;
	private double ecost;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnutilitieslistServlet() {
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
		sql="select * from utilities";
		out=response.getWriter();
		arraylist=new ArrayList<Utilities>();
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				utilities=new Utilities();
				uno=rs.getInt(1);
				utilities.setUno(uno);
				dno=rs.getInt(2);
				utilities.setDno(dno);
				month=rs.getInt(3);
				utilities.setMonth(month);
				wcost=rs.getDouble(4);
				utilities.setWcost(wcost);
				ecost=rs.getDouble(5);
				utilities.setEcost(ecost);
				arraylist.add(utilities);
			}
			String jsonstr=JSON.toJSONString(arraylist);
			out.print(jsonstr);
			System.out.println(jsonstr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
			JdbcUtils.free(rs, ps, conn);
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
