package com.clm.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.clm.Model.*;
import com.mysql.cj.protocol.Resultset;

public class WorkerDao {
	public  boolean AddWorker(Worker worker)
	{
		Integer s1=null,s2=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String insert1="INSERT INTO worker(workId,name,position,phoneNumber,email) VALUES("+worker.getWorkId()+",'"+worker.getName()+"','"+worker.getPosition()+"','"+worker.getPhoneNumber()+"','"+worker.getEmail()+"')";
			String insert2="INSERT INTO userInfo(workId,password) VALUES("+worker.getWorkId()+",'"+worker.getPassword()+"')";
			s1=stmt.executeUpdate(insert1);
			s2=stmt.executeUpdate(insert2);
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfully insert");
		if(s1!=0&&s2!=0)
		{
			return true;
		}
		else return false;
		
	}
	public  boolean DelWorker(Worker worker)
	{
		Integer s1=null,s2=null;
		try 
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String delete1="DELETE FROM worker WHERE workId="+worker.getWorkId();
			String delete2="DELETE FROM userInfo WHERE workId="+worker.getWorkId();
			s1=stmt.executeUpdate(delete1);
			s2=stmt.executeUpdate(delete2);
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfully delete");
		if(s1!=0&&s2!=0)
		{
			return true;
		}
		else return false;
		
	}
	public  boolean ModifyPoisiton(Worker worker)
	{
		Integer s=null;
		try 
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String modify="UPDATE worker SET position='"+worker.getPosition()+"' WHERE workerId="+worker.getWorkId();
			stmt.executeUpdate(modify);
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfullly ModifyPosition");
		if(s!=0)
		{
			return true;
		}
		else return false;
	}
	public  boolean ModifyPhoneNumber(Worker worker)
	{
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String modify="UPDATE worker SET phoneNumber='"+worker.getPhoneNumber()+"' WHERE workerId="+worker.getWorkId();
			stmt.executeUpdate(modify);
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfully modifyPhoneNumber");
		if(s!=0)
		{
			return true;
		}
		else return false;
	}
	public void  QueryWorker(Integer workerId)
	{
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT * FROM worker WHERE workId="+workerId;
			ResultSet rs=(ResultSet) stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getInt("workerId")+"\t"+rs.getString("name")+"\t"+rs.getString("phonNumber")+"\t"+rs.getString("email"));
			}
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public static String CheckPas(Worker worker)
	{
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String check="SELECT COUNT(*) FROM userInfo WHERE workId="+worker.getWorkId()+" and password="+"'"+worker.getPassword()+"'";
			ResultSet rs=stmt.executeQuery(check);
			while(rs.next())
			{
				s=rs.getInt(1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(s!=0)
		{
			return "success";
		}
		else return "password error";
			
	}
	public static void main(String[] args)
	{
		Worker worker=new Worker(001,"1999");
		worker.setName("OSW");
		worker.setPosition("boss");
		worker.setPhoneNumber("13325303000");
		worker.setEmail("osw@ins");
		worker.setPassword("123456");
		WorkerDao workerdao=new WorkerDao();
		workerdao.AddWorker(worker);
		System.out.println(workerdao.CheckPas(worker));
		
	}
}
