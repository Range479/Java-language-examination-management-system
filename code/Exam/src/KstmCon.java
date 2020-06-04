import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class KstmCon {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/exam";
	Connection con;
	PreparedStatement sql;
	ResultSet rs;
	
	public void getCon(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public LinkedList<Kstm> findTm(int ksid){
		
		LinkedList<Kstm> list=new LinkedList<Kstm>();
		Kstm kstm = null;
		String s;
		this.getCon();
		try {
			s = "select * from TM" + ksid;
			sql=con.prepareStatement(s);
			rs=sql.executeQuery();
			while(rs.next())
			{
				kstm = new Kstm(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5));
				list.add(kstm);
			}
			rs.close();
			sql.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean AddKs(int ksid){ //Ìí¼Ó¿¼ÊÔ
		
		Kstm kstm = null;
		String s1,s;
		Statement stmt = null;
		boolean flag = false;
		this.getCon();
		try {
			s1 = "TM" + ksid;
			s = "create table " + s1 + "(no int,id int,fen double,t int,f int);";
			//stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.executeUpdate(s);
			
			
			flag = true;
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean AddTm(Kstm kstm, int no) {
		
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("insert into TM" + no + " values(?,?,?,?,?)");
			sql.setInt(1, kstm.getNo());
			sql.setInt(2, kstm.getId());
			sql.setDouble(3, kstm.getFen());
			sql.setInt(4, kstm.getT());
			sql.setInt(5, kstm.getF());
			sql.executeUpdate();
			flag=true;
			sql.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(int no, int si, Kstm kstm) //¸Ä
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("update TM" + si + " set no=?, id=?, fen=?, t=?, f=? where no=?");
			sql.setInt(1, kstm.getNo());
			sql.setInt(2, kstm.getId());
			sql.setDouble(3, kstm.getFen());
			sql.setInt(4, kstm.getT());
			sql.setInt(5, kstm.getF());
			sql.setInt(6, no);
			sql.executeUpdate();
			flag=true;
			sql.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return flag;
	}
	
	public boolean delTm(int no, int si) //É¾³ý
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("delete from TM" + si +" where no=?");
			sql.setInt(1, no);
			sql.executeUpdate();
			flag=true;
			sql.close(); 
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	public boolean delKs(int si) //É¾³ý¿¼ÊÔ
	{
		Kstm kstm = null;
		String s1,s;
		Statement stmt = null;
		boolean flag = false;
		this.getCon();
		try {
			s1 = "TM" + si;
			s = "Drop table " + s1 + " ;";
			//stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.executeUpdate(s);
			
			
			flag = true;
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}