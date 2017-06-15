package com.srk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srk.dao.StudentDAO;

import vo.Student;

@WebServlet("/editStudent")
public class EditStudent extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Student</h1>");  
	        String sid=request.getParameter("stdId");  
	        int stdId=Integer.parseInt(sid);  
	          
	        Student student=StudentDAO.getStudentById(stdId);  
	          
	        out.print("<form action='editStudent2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='stdId' value='"+student.getStudentId()+"'/></td></tr>");  
	        out.print("<tr><td>Full Name :</td><td><input type='text' name='stdname' value='"+student.getStudentName()+"'/></td></tr>");  
	        out.print("<tr><td>Address :</td><td><input type='text' name='stdaddrs' value='"+student.getStudentAddr()+"'/></td></tr>");  
	        out.print("<tr><td>Age :</td><td><input type='text' name='stdage' value='"+student.getAge()+"'/></td></tr>");
	        out.print("<tr><td>Qualification :</td><td><input type='text' name='stdqual' value='"+student.getQualification()+"'/></td></tr>");  
	        out.print("<tr><td>Percentage :</td><td><input type='text' name='stdpercent' value='"+student.getPercentage()+"'/></td></tr>");  
	        out.print("<tr><td>Year of Passout :</td><td><input type='text' name='stdyearpass' value='"+student.getYearPassed()+"'/></td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
	    }  
}
