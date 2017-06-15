package com.srk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srk.dao.StudentDAO;

import vo.Student;

@WebServlet("/viewStudents")
public class ViewStudents extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
     response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     out.println("<a href='index.jsp'>Register Student</a>");  
     out.println("<h1>Students List</h1>");  
       
     List<Student> list=StudentDAO.getAllStudents();  
       
     out.print("<table border='1' width='100%'");  
     out.print("<tr><th>Student ID</th><th>StudentName</th><th>Student Addrs</th><th>Student Age</th><th>Student Qualification</th><th>Student Percentage</th><th>Student Year Passed</th><th>Edit</th><th>Delete</th></tr>");  
     for(Student student : list){  
      out.print("<tr><td>"+student.getStudentId()+"</td><td>"+student.getStudentName()+"</td><td>"+student.getStudentAddr()+"</td><td>"+student.getAge()+"</td><td>"+student.getQualification()+"</td><td>"+student.getPercentage()+"</td><td>"+student.getYearPassed()+"</td><td><a href='editStudent?stdId="+student.getStudentId()+"'>edit</a></td><td><a href='deleteStudent?stdId="+student.getStudentId()+"'>delete</a></td></tr>");  
     }  
     out.print("</table>");  
       
     out.close();  
 }  
}
