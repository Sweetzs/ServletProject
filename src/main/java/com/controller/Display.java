package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.service.StudentService;
@WebServlet("/displayData")
public class Display extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		StudentService service=new StudentService();
		List<Student> stu=service.fetchAll();
		PrintWriter write=resp.getWriter();
		
		write.print("<!DOCTYPE html>\r\n"
	            + "<html lang=\"en\">\r\n"
	            + "<head>\r\n"
	            + "    <meta charset=\"UTF-8\">\r\n"
	            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	            + "    <title>Student Details</title>\r\n"
	            + "    <style>\r\n"
	            + "        body {\r\n"
	            + "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n"
	            + "            background-color: #f4f8fb;\r\n"
	            + "            margin: 0;\r\n"
	            + "            padding: 0;\r\n"
	            + "            display: flex;\r\n"
	            + "            justify-content: center;\r\n"
	            + "            align-items: center;\r\n"
	            + "            height: 100vh;\r\n"
	            + "        }\r\n"
	            + "        .container {\r\n"
	            + "            background: #fff;\r\n"
	            + "            padding: 30px 40px;\r\n"
	            + "            border-radius: 10px;\r\n"
	            + "            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);\r\n"
	            + "            width: 90%;\r\n"
	            + "            max-width: 900px;\r\n"
	            + "        }\r\n"
	            + "        h1 {\r\n"
	            + "            color: #333;\r\n"
	            + "            text-align: center;\r\n"
	            + "            margin-bottom: 30px;\r\n"
	            + "            font-size: 32px;\r\n"
	            + "            font-weight: bold;\r\n"
	            + "        }\r\n"
	            + "        table {\r\n"
	            + "            width: 100%;\r\n"
	            + "            border-collapse: collapse;\r\n"
	            + "            margin-top: 20px;\r\n"
	            + "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\r\n"
	            + "        }\r\n"
	            + "        table, th, td {\r\n"
	            + "            border: 1px solid #ddd;\r\n"
	            + "        }\r\n"
	            + "        th, td {\r\n"
	            + "            text-align: center;\r\n"
	            + "            padding: 15px;\r\n"
	            + "        }\r\n"
	            + "        th {\r\n"
	            + "            background-color: #007bff;\r\n"
	            + "            color: #fff;\r\n"
	            + "            position: sticky;\r\n"
	            + "            top: 0;\r\n"
	            + "            z-index: 2;\r\n"
	            + "        }\r\n"
	            + "        tr:nth-child(even) {\r\n"
	            + "            background-color: #f9f9f9;\r\n"
	            + "        }\r\n"
	            + "        tr:hover {\r\n"
	            + "            background-color: #f1f1f1;\r\n"
	            + "        }\r\n"
	            + "        a {\r\n"
	            + "            padding: 8px 16px;\r\n"
	            + "            margin: 0 6px;\r\n"
	            + "            color: #fff;\r\n"
	            + "            border-radius: 5px;\r\n"
	            + "            text-decoration: none;\r\n"
	            + "            font-size: 16px;\r\n"
	            + "            display: inline-block;\r\n"
	            + "            transition: background-color 0.3s, transform 0.2s;\r\n"
	            + "        }\r\n"
	            + "        .edit {\r\n"
	            + "            background-color: #28a745;\r\n"
	            + "        }\r\n"
	            + "        .edit:hover {\r\n"
	            + "            background-color: #218838;\r\n"
	            + "            transform: scale(1.05);\r\n"
	            + "        }\r\n"
	            + "        .delete {\r\n"
	            + "            background-color: #dc3545;\r\n"
	            + "        }\r\n"
	            + "        .delete:hover {\r\n"
	            + "            background-color: #c82333;\r\n"
	            + "            transform: scale(1.05);\r\n"
	            + "        }\r\n"
	            + "        footer {\r\n"
	            + "            text-align: center;\r\n"
	            + "            font-size: 14px;\r\n"
	            + "            color: #777;\r\n"
	            + "            margin-top: 20px;\r\n"
	            + "        }\r\n"
	            + "    </style>\r\n"
	            + "</head>\r\n"
	            + "<body>\r\n"
	            + "    <div class=\"container\">\r\n"
	            + "        <h1>Student Details</h1>\r\n"
	            + "        <table>\r\n"
	            + "            <thead>\r\n"
	            + "                <tr>\r\n"
	            + "                    <th>ID</th>\r\n"
	            + "                    <th>Name</th>\r\n"
	            + "                    <th>Age</th>\r\n"
	            + "                    <th>Email</th>\r\n"
	            + "                    <th>Course</th>\r\n"
	            + "                    <th>Actions</th>\r\n"
	            + "                </tr>\r\n"
	            + "            </thead>\r\n"
	            + "            <tbody>");
		for (Student stud : stu) {
		    int id = stud.getId();
		    String name = stud.getName();
		    int age = stud.getAge();
		    String emailID = stud.getEmailID();
		    String course = stud.getCourse();
		    write.print("                <tr>\r\n"
		            + "                    <td>" + id + "</td>\r\n"
		            + "                    <td>" + name + "</td>\r\n"
		            + "                    <td>" + age + "</td>\r\n"
		            + "                    <td>" + emailID + "</td>\r\n"
		            + "                    <td>" + course + "</td>\r\n"
		            + "                    <td>\r\n"
		            + "                        <a href=\"StudentUpdate.html\" class=\"edit\">Edit</a>\r\n"
		            + "                        <a href=\"StudentDelete.html\" class=\"delete\">Delete</a>\r\n"
		            + "                    </td>\r\n"
		            + "                </tr>\r\n");
		}
		write.print("            </tbody>\r\n"
		            + "        </table>\r\n"
		            + "        <footer>\r\n"
		            + "            &copy; 2024 Student Management System. All rights reserved.\r\n"
		            + "        </footer>\r\n"
		            + "    </div>\r\n"
		            + "</body>\r\n"
		            + "</html>");

	}
}
