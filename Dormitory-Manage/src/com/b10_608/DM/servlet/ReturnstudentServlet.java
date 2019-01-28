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
import com.b10_608.DM.pojo.Student;
import com.b10_608.DM.utils.JdbcUtils;

/**
 * Servlet implementation class ReturnstudentServlet
 */
@WebServlet("/Returnstudent")
public class ReturnstudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String sql=null;
	private PrintWriter out=null;
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	private ArrayList<Student> arraylist;
	private Student student;
	private String sno;
	private int dno;
	private String sname;
	private String sex;
	private String major;
	private String mobilephone;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnstudentServlet() {
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
		sno=request.getParameter("sno");
		sql="select * from student where sno = ?";
		System.out.println("sno= "+sno);
		arraylist=new ArrayList<Student>();
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()){
				student=new Student();
				sno=rs.getString(1);
				student.setSno(sno);
				dno=rs.getInt(2);
				student.setDno(dno);
				sname=rs.getString(3);
				student.setSname(sname);
				sex=rs.getString(4);
				student.setSex(sex);
				major=rs.getString(5);
				student.setMajor(major);
				mobilephone=rs.getString(6);
				student.setMobilephone(mobilephone);
				arraylist.add(student);
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
