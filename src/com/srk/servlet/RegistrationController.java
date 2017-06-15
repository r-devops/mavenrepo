package com.srk.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srk.dao.StudentDAO;

import vo.Student;
@WebServlet("/registrationController")
public class RegistrationController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("fullname");
		String Addr = request.getParameter("address");
		String age = request.getParameter("age");
		String Qual = request.getParameter("qual");
		String Persent = request.getParameter("percent");
		String Year = request.getParameter("yop");
		if(name.isEmpty()||Addr.isEmpty()||age.isEmpty()||Qual.isEmpty()||Persent.isEmpty()||Year.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			Student student = new Student();
			student.setStudentName(name);
        	student.setStudentAddr(Addr);
        	student.setAge(age);
        	student.setQualification(Qual);
        	student.setPercentage(Persent);
        	student.setYearPassed(Year); 
			int status=StudentDAO.saveStudent(student);  
	        if(status>0){  
	        	response.sendRedirect("viewStudents");
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
			
		}
	}
}