package com.clm.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.clm.Model.*;
import com.mysql.cj.protocol.Resultset;

public class WorkerDao {
	public static boolean AddWorker(Worker worker)
	{
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String insert="INSERT INTO worker(workId,name,position,phoneNumber,email) VALUES("+worker.getWorkId()+",'"+worker.getName()+"','"+worker.getPosition()+"','"+worker.getPhoneNumber()+"','"+worker.getEmail()+"')";
			s=stmt.executeUpdate(insert);
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfully insert");
		if(s!=0)
		{
			return true;
		}
		else return false;
		
	}
	public static boolean DelWorker(Worker worker)
	{
		Integer s=null;
		try 
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String delete="DELETE FROM worker WHERE workId="+worker.getWorkId();
			s=stmt.executeUpdate(delete);
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfully delete");
		if(s!=0)
		{
			return true;
		}
		else return false;
		
	}
	public static boolean ModifyPoisiton(Worker worker)
	{
		Integer s=null;
		try 
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String modify="UPDATE worker SET position='"+worker.getPosition()+"' WHERE workerId="+worker.getWorkId();
			stmt.executeUpdate(modify);
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			JdbcUnit.CloseConnection();
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
	public static boolean ModifyPhoneNumber(Worker worker)
	{
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String modify="UPDATE worker SET phoneNumber='"+worker.getPhoneNumber()+"' WHERE workerId="+worker.getWorkId();
			stmt.executeUpdate(modify);
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			JdbcUnit.CloseConnection();
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
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public static void main(String[] args)
	{
		Worker worker=new Worker(001,"1999");
		worker.setName("OSW");
		worker.setPosition("boss");
		worker.setPhoneNumber("13325303000");
		worker.setEmail("osw@ins");
		//AddWorker(worker);
		//DelWorker(worker);
	}
}
