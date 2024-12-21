package com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentService {
	private static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	private static Connection con;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int save(Student stu) {
		int result=0;
		String query="Insert into student values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, stu.getId());
			pstmt.setString(2, stu.getName());
			pstmt.setInt(3, stu.getAge());
			pstmt.setString(4, stu.getEmailID());
			pstmt.setString(5, stu.getCourse());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	public int update(Student stu)
	{
		int result=0;
		String sql="UPDATE student SET  name=?,age=?,email=?,course=? WHERE id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			
			pstm.setString(1, stu.getName());
			pstm.setInt(2, stu.getAge());
			pstm.setString(3, stu.getEmailID());
			pstm.setString(4, stu.getCourse());
			pstm.setInt(5, stu.getId());
			 result=pstm.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;	
	}
	
	public int delete(int id)
	{
		int result=0;
		String sql="DELETE FROM student WHERE id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			 result=pstm.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;		
	}
	public List<Student> fetchAll()
	{
		
		List<Student> student=new ArrayList<>();
		
		String sql="SELECT * FROM student";
		
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String emailID=rs.getString(4);
				String course=rs.getString(5);
			
			student.add(new Student(id, name, age, emailID, course));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;	
	}
}
