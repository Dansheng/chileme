package com.clm.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.clm.Model.*;
public class CardDao {
	CardDao(){
		
	}
	public  boolean AddCard(Card card)
	{
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String insert="INSERT INTO cardInfo(workId,cardNumber,balance) VALUES("+card.getWorkerId()+",'"+card.getCardNumber()+"',"+card.getBalance()+")";
//			System.out.println(insert);
			s=stmt.executeUpdate(insert);
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
		if(s!=0)
		{
			return true;
		}
		else return false;
	}
	public  boolean DelCard(Card card)
	{	
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String delete="DELETE FROM cardInfo WHERE workId="+card.getWorkerId();
			s=stmt.executeUpdate(delete);
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
//			System.out.println("Successfully delete");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(s!=0)
		{
			return true;
		}
		else return false;
	}
//	public static boolean ModifyCardNumber(Card card)
//	{
//		Integer s=null;
//		try
//		{
//			Statement stmt=JdbcUnit.getConnection().createStatement();
//			String modify="UPDATE cardInfo SET cardNumber='"+card.getCardNumber()+"'";
//			s=stmt.executeUpdate(modify);
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
//		}catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		System.out.print("Successfully modifyCardNumber");
//		if(s!=0)
//		{
//			return true;
//		}
//		else return false;
//	}
	public  void Query(Worker worker)
	{
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT* FROM cardInfo WHERE workId="+worker.getWorkId();
			ResultSet rs=(ResultSet) stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getInt("workId")+"\t"+rs.getString("cardNumber")+"\t"+rs.getDouble("balance"));
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
//				JdbcUnit.CloseConnection();
//			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public boolean UpdateBalance(Card card)
	{
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="UPDATE cardInfo SET balance="+card.getBalance()+"WHERE workId="+card.getWorkerId();
			System.out.println(query);
			s=stmt.executeUpdate(query);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(s!=null)
		{
			return true;
		}
		else return false;
	}
	public static void main(String[] args)
	{
		Card card=new Card();
		card.setWorkerId(001);
		card.setCardNumber("12345");
		card.setBalance(3220.4);
		card.setBalance(825);
//		AddCard(card);
//		DelCard(card);
		CardDao carddao=new CardDao();
		System.out.println(carddao.UpdateBalance(card));
		
		
	}
}

