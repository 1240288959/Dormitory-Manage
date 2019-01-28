package com.b10_608.DM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.b10_608.DM.pojo.Repair;
import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class ReturnrepairlistServlet
 */
@WebServlet("/Returnrepairlist")
public class ReturnrepairlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int rno;
	private int dno;
	private String reason;
	@JSONField(format="yyyy-MM-dd")
	private Date sdate;
	@JSONField(format="yyyy-MM-dd")
	private Date fdate;
	private double cost;
	
	private PrintWriter out=null;
	private String sql=null;
	private Repair repair=null;
	private ArrayList<Repair> arraylist=null;
	private Connection conn=null;
	private Statement stat=null;
	private ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnrepairlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("utf8");
		out=response.getWriter();
		sql="select * from repair";
		arraylist=new ArrayList<Repair>();
		try {
			conn=JdbcUtils.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				repair=new Repair();
				rno=rs.getInt(1);
				dno=rs.getInt(2);
				reason=rs.getString(3);
				sdate=rs.getDate(4);
				fdate=rs.getDate(5);
				cost=rs.getDouble(6);
				repair.setRno(rno);
				repair.setDno(dno);
				repair.setReason(reason);
				repair.setSdate(sdate);
				repair.setFdate(fdate);
				repair.setCost(cost);
				arraylist.add(repair);
			}
			String jsonstr=JSON.toJSONString(arraylist);
			System.out.println(jsonstr);
			out.print(jsonstr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
			JdbcUtils.free(rs, stat, conn);
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
