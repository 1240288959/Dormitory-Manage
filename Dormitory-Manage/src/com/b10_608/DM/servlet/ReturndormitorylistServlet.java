package com.b10_608.DM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import com.alibaba.fastjson.annotation.JSONField;
import com.b10_608.DM.pojo.Dormitory;
import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class Returndormitorylist
 */
@WebServlet("/Returndormitorylist")
public class ReturndormitorylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Dormitory dormitory=null;
	private ArrayList<Dormitory> arraylist=null;
	private PrintWriter out=null;
	private String sql=null;
	private Connection conn=null;
	private Statement stat=null;
	private ResultSet rs=null;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturndormitorylistServlet() {
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
		sql="select * from dormitory";
		arraylist=new ArrayList<Dormitory>();
		try {
			conn=JdbcUtils.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				dormitory=new Dormitory();
				int dno=rs.getInt(1);
				dormitory.setDno(dno);
				String dname=rs.getString(2);
				dormitory.setDname(dname);
				String dphone=rs.getString(3);
				dormitory.setDphone(dphone);
				int maxpeople=rs.getInt(4);
				dormitory.setMaxpeople(maxpeople);
				int nowpeople=rs.getInt(5);
				dormitory.setNowpeople(nowpeople);
				arraylist.add(dormitory);
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
