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
import com.b10_608.DM.pojo.Staff;
import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class ReturnstaffServlet
 */
@WebServlet("/Returnstaff")
public class ReturnstaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String staffno;
	private int dno;
	private String staffname;
	private String sex;
	private String duty;
	private String mobilephone;
	private int age;
	
	private String sql=null;
	private Staff staff=null;
	private PrintWriter out=null;
	private ArrayList<Staff> arraylist=null;
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnstaffServlet() {
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
		sql="select * from staff where staffno = ?";
		staffno=request.getParameter("staffno");
		out=response.getWriter();
		arraylist=new ArrayList<Staff>();
		try {
			
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, staffno);
			rs=ps.executeQuery();
			while(rs.next()){
				staff=new Staff();
				staffno=rs.getString(1);
				dno=rs.getInt(2);
				staffname=rs.getString(3);
				sex=rs.getString(4);
				duty=rs.getString(5);
				mobilephone=rs.getString(6);
				age=rs.getInt(7);
				staff.setStaffno(staffno);
				staff.setDno(dno);
				staff.setStaffname(staffname);
				staff.setSex(sex);
				staff.setDuty(duty);
				staff.setMobilephone(mobilephone);
				staff.setAge(age);
				arraylist.add(staff);
			}
			String jsonstr=JSON.toJSONString(arraylist);
			System.out.println(jsonstr);
			out.print(jsonstr);
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
