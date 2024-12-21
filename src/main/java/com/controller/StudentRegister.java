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
@WebServlet("/addstudent")
public class StudentRegister extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studid=req.getParameter("id");
		int id=Integer.parseInt(studid);
		String name=req.getParameter("name");
		String studage=req.getParameter("age");
		int age=Integer.parseInt(studage);
		String emailID=req.getParameter("emailID");
		String course=req.getParameter("course");
		Student stu=new Student(id,name,age,emailID,course);
		StudentService service=new StudentService();
		int res=service.save(stu);
		if(res!=0) {
			RequestDispatcher reqd=req.getRequestDispatcher("StudentHome.html");
			reqd.forward(req, resp);
		}
		else {
			RequestDispatcher reqd=req.getRequestDispatcher("StudentAdd.html");
			reqd.include(req, resp);
			PrintWriter write=resp.getWriter();
			write.print("Student Detail Not Added!");
		}
	}
}
