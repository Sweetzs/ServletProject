package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.StudentService;
@WebServlet("/deletestudent")
public class Delete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids=req.getParameter("id");
		  int id=Integer.parseInt(ids);	
		  
		  StudentService service=new StudentService();
		  int res=service.delete(id);
		  if(res!=0) {
			  RequestDispatcher reqd=req.getRequestDispatcher("StudentHome.html");
			  reqd.forward(req, resp);
		  }
		  else {
			  req.setAttribute("errorMessage", "Student Details Not Deleted! Try Again.");
	            RequestDispatcher reqd = req.getRequestDispatcher("StudentDelete.html");
	            reqd.forward(req, resp);
			}
	}
}
