import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class KsCon {
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
	
	public Ks findByNo(int no) { // 查找某个
		Ks ks = null;
		this.getCon();
		try {
			sql=con.prepareStatement("select * from ks where id=?");
			sql.setInt(1, no);
			rs=sql.executeQuery();
			if(rs.next())
				ks = new Ks(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
		    rs.close();
		    sql.close();
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return ks;
	}
	
	public LinkedList<Ks> findAll() //查找全部
	{
		LinkedList<Ks> list=new LinkedList<Ks>();
		Ks ks;
		this.getCon();
		try {
			sql=con.prepareStatement("select * from ks");
			rs=sql.executeQuery();
			while(rs.next())
			{
				ks=new Ks(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				list.add(ks);
			}
			rs.close();
			sql.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean add(Ks ks) //增
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("insert into ks values(?,?,?,?,?)");
			sql.setInt(1, ks.getId());
			sql.setDouble(2, ks.getMan());
			sql.setString(3, ks.getUse());
			sql.setInt(4, ks.getNum());
			sql.setInt(5, ks.getPer());
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
	
	public boolean update(int no, Ks ks) //改
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("update ks set id=?, man=?, ause=?, num=?, per=? where id=?");
			sql.setInt(1, ks.getId());
			sql.setDouble(2, ks.getMan());
			sql.setString(3, ks.getUse());
			sql.setInt(4, ks.getNum());
			sql.setInt(5, ks.getPer());
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
	
	public boolean del(int no) //删除
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("delete from ks where id=?");
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

}