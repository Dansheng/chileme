package com.clm.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.clm.Model.*;
import com.mysql.cj.protocol.Resultset;

public class WorkerDao {
	public static void  AddWorker(Worker worker)
	{
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String insert="INSERT INTO worker(workId,name,position,phoneNumber,email) VALUES('"+worker.getWorkId()+"','"+worker.getName()+"','"+worker.getPosition()+"','"+worker.getPhoneNumber()+"','"+worker.getEmail()+"')";
			stmt.executeUpdate(insert);
			System.out.println("Successfully insert");
			stmt.close();
			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void DelWorker(Worker worker)
	{
		try 
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String delete="DELETE FROM worker WHERE workId="+worker.getWorkId();
			stmt.executeUpdate(delete);
			System.out.println("Successfully delete");
			stmt.close();
			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void ModifyPoisiton(Worker worker)
	{
		try 
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String modify="UPDATE worker SET position='"+worker.getPosition()+"' WHERE workerId="+worker.getWorkId();
			stmt.executeUpdate(modify);
			stmt.close();
			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfullly ModifyPosition");
	}
	public static void ModifyPhoneNumber(Worker worker)
	{
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String modify="UPDATE worker SET phoneNumber='"+worker.getPhoneNumber()+"' WHERE workerId="+worker.getWorkId();
			stmt.executeUpdate(modify);
			stmt.close();
			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfully modifyPhoneNumber");
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
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public static void main(String[] args)
	{
		Worker worker=new Worker(1,"1999");
		System.out.println(worker.getWorkId());
//		
//		worker.setName("OSW");
//		worker.setPosition("boss");
//		worker.setPhoneNumber("13325303000");
//		worker.setEmail("osw@ins");
//		AddWorker(worker);
	}
	

}
