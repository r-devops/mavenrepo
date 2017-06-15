package com.srk.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Student;

public class StudentDAO {
	/*public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }*/
	
	public static Connection getConnection() throws Exception {
		Connection conn=null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
		conn = ds.getConnection();
		return conn; 
	}
	public static void main(String[] args) {
		
	}
    public static int saveStudent(Student std){  
        int status=0;  
        try{  
            Connection con=StudentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into Students(student_name,student_addr,student_age,student_qual,student_percent,student_year_passed) values (?,?,?,?,?,?)");  
            ps.setString(1,std.getStudentName());  
            ps.setString(2,std.getStudentAddr());  
            ps.setString(3,std.getAge());  
            ps.setString(4,std.getQualification());  
            ps.setString(5,std.getPercentage());  
            ps.setString(6,std.getYearPassed());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int updateStudent(Student std){  
        int status=0;  
        try{  
            Connection con=StudentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("update Students set student_name=?,student_addr=?,student_age=?,student_qual=?,student_percent=?,student_year_passed=? where student_id=?");  
            ps.setString(1,std.getStudentName());  
            ps.setString(2,std.getStudentAddr());  
            ps.setString(3,std.getAge());  
            ps.setString(4,std.getQualification());  
            ps.setString(5,std.getPercentage());  
            ps.setString(6,std.getYearPassed());
            ps.setInt(7, std.getStudentId());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int deleteStudent(int stdId){  
        int status=0;  
        try{  
            Connection con=StudentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from Students where student_id=?");  
            ps.setInt(1,stdId);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Student getStudentById(int StdId){  
    	Student student=new Student();  
          
        try{  
            Connection con=StudentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Students where student_id=?");  
            ps.setInt(1,StdId);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
            	student.setStudentId(rs.getInt(1));
            	student.setStudentName(rs.getString(2));
            	student.setStudentAddr(rs.getString(3));
            	student.setAge(rs.getString(4));
            	student.setQualification(rs.getString(5));
            	student.setPercentage(rs.getString(6));
            	student.setYearPassed(rs.getString(7));
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return student;  
    }  
    public static List<Student> getAllStudents(){  
        List<Student> students=new ArrayList<Student>();  
          
        try{  
            Connection con=StudentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Students");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Student student=new Student();  
            	student.setStudentId(rs.getInt(1));
            	student.setStudentName(rs.getString(2));
            	student.setStudentAddr(rs.getString(3));
            	student.setAge(rs.getString(4));
            	student.setQualification(rs.getString(5));
            	student.setPercentage(rs.getString(6));
            	student.setYearPassed(rs.getString(7));  
            	students.add(student);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return students;  
    }  
}