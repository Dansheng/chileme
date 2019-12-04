package com.clm.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.clm.Model.Worker;

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
	public static HashMap<String,Integer> CheckPas(Worker worker)
	{
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String check1="SELECT COUNT(*) FROM worker where workId="+worker.getWorkId();
			ResultSet rs=stmt.executeQuery(check1);
			while(rs.next())
			{
				s=rs.getInt(1);
			}
			if(s==0)
			{
				map.put("data", -1);//represents worker doesn't exist
				return map;
			}
			String check2="SELECT COUNT(*) FROM userInfo WHERE workId="+worker.getWorkId()+" and password="+"'"+worker.getPassword()+"'";
			rs=stmt.executeQuery(check2);
			while(rs.next())
			{
				s=rs.getInt(1);
			}
			if(s==0)
			{
				map.put("data",0);//represents password doesn't match
				return map;
			}
			else 
			{
				String check3="SELECT COUNT(*) FROM worker WHERE workId="+worker.getWorkId()+" and position='"+worker.getPosition()+"'";
//				System.out.println(check3);
				rs=stmt.executeQuery(check3);
				while(rs.next())
				{
					s=rs.getInt(1);
				}
				if(s==0)
				{
					map.put("data",4);
				}
				else 
				{
					if(worker.getPosition().equals("普通员工"))
					{
						map.put("data",1);
					}
					else if(worker.getPosition().equals("餐厅员工"))
					{
						map.put("data",2);
					}
					else if(worker.getPosition().equals("管理员"))
					{
						map.put("data",3);
					}
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
		return map;
	}
	public static void main(String[] args)
	{
		Worker worker=new Worker(3,"1999");
		worker.setName("OSW");
		worker.setPosition("boss");
		worker.setPhoneNumber("13325303000");
		worker.setEmail("osw@ins");
		worker.setPassword("123456");
		WorkerDao workerdao=new WorkerDao();
		System.out.println(workerdao.CheckPas(worker));
		Worker worker1=new Worker(1,"fewfew");
		worker1.setName("why");
		worker1.setPosition("boss");
		worker1.setPhoneNumber("1332530300");
		worker1.setEmail("osw@ins");
		System.out.println(workerdao.CheckPas(worker1));
		Worker worker2=new Worker(567,"567");
		worker2.setName("567");
		worker2.setPosition("普通员工");
		worker2.setPhoneNumber("13092979567");
		worker2.setEmail("wjk@ins");
		System.out.println(workerdao.CheckPas(worker2));
		System.out.println("haha");
	}
}
