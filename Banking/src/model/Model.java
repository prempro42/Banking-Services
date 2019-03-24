package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.driver.OracleDriver;

public class Model {

	private int acc;
	private String cid;
	private String pwd;
	private int balance;
	private String email;
	private String name;

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;

	public Model() {

		try {
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "oracle");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean login() throws Exception {

		pstmt = con.prepareStatement("select * from bank where custid=? and pwd=?");
		pstmt.setString(1, getCid());
		pstmt.setString(2, getPwd());
		res = pstmt.executeQuery();

		if (res.next() == true) {

			acc = res.getInt("accno");
			return true;

		}

		return false;

	}
	
	public boolean checkBalance() throws Exception{
		
		pstmt = con.prepareStatement("select * from bank where accno=?");
		pstmt.setInt(1, acc);
		res = pstmt.executeQuery();
		
		if(res.next()==true) {
			
			balance = res.getInt("balance");
			return true;
		}
		
		return false;
	}
	
	public boolean changePassword(String npwd) throws Exception
	{
		pstmt = con.prepareStatement("update bank set pwd=? where pwd=?");
		pstmt.setString(1, npwd);
		pstmt.setString(2, pwd);
		int s = pstmt.executeUpdate();
		
		if(s == 1) {
			
			
			return true;
		}
		
		else
		{
		return false;
		}
		
		
	}
	
	public boolean transfer(String tamt) throws SQLException {
		
		pstmt = con.prepareStatement("update bank set balance=balance-? where accno=?");
		pstmt.setString(1, tamt);
		pstmt.setInt(2, acc);
		int s = pstmt.executeUpdate();

		
		pstmt = con.prepareStatement("insert into bank_statement values(?,?)");
		pstmt.setInt(1, acc);
		pstmt.setString(2, tamt);
		pstmt.executeUpdate();
		
		
		
		if( s!=0 ) {
			
			
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	public  ArrayList<Integer> getStatement() throws SQLException
	{
		pstmt = con.prepareStatement("select * from bank_statement where accno=?");
		pstmt.setInt(1, acc);
		 res = pstmt.executeQuery();
		 
		 
		 ArrayList<Integer> al = new ArrayList<Integer>();
		 
		 while(res.next()==true) {
			 
			 int x = res.getInt("amount");
			 al.add(x);
		 }
		 return al;
		
		
	}
	
	public boolean forgotPassword(String npwd,String email) throws SQLException
	{

		pstmt = con.prepareStatement("update bank set pwd=? where email=?");
		pstmt.setString(1, npwd);
		pstmt.setString(2, email);
		System.out.println("inside model email  is "+email);
		System.out.println("inside model new pwd is "+npwd);
		int s = pstmt.executeUpdate();
		
		if(s != 0) {
			
			
			return true;
		}
		
		else
		{
		return false;
		}
		
	}
	
	
	

}
