package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.service.StudentService;
@WebServlet("/updatestudent")
public class Update extends HttpServlet {
	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studid=req.getParameter("id");
		String name=req.getParameter("name");
		String studage=req.getParameter("age");
		String emailID=req.getParameter("emailID");
		String course=req.getParameter("course");
		
		int id=Integer.parseInt(studid);
		int age=Integer.parseInt(studage);
		
		Student stu=new Student(id, name, age, emailID, course);
		StudentService service=new StudentService();
		int res=service.update(stu);
		if(res!=0) {
		RequestDispatcher reqd=req.getRequestDispatcher("StudentHome.html");
		reqd.forward(req, resp);
		}
		else {
			RequestDispatcher reqd=req.getRequestDispatcher("StudentUpdate.html");
			reqd.forward(req, resp);
			PrintWriter write=resp.getWriter();
			write.print("Student Details Not Updated! Try Again.");
		}
	}
}


