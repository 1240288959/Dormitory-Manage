package com.b10_608.DM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.b10_608.DM.pojo.Mechine;
import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class ReturnmechineServlet
 */
@WebServlet("/Returnmechine")
public class ReturnmechineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String sql=null;
	private Mechine mechine=null;
	private ArrayList<Mechine> arraylist=null;
	private PrintWriter out=null;
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	private String mno;
	private String mname;
	private Date sdate;
	private Date fdate;
	private double cost;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnmechineServlet() {
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
		mno=request.getParameter("mno");
		sql="select * from mechine where mno = ?";
		out=response.getWriter();
		arraylist=new ArrayList<Mechine>();
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, mno);
			rs=ps.executeQuery();
			while(rs.next()){
				mechine=new Mechine();
				mno=rs.getString(1);
				mechine.setMno(mno);
				mname=rs.getString(2);
				mechine.setMname(mname);
				sdate=rs.getDate(3);
				mechine.setSdate(sdate);
				fdate=rs.getDate(4);
				mechine.setFdate(fdate);
				cost=rs.getDouble(5);
				mechine.setCost(cost);
				arraylist.add(mechine);
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
