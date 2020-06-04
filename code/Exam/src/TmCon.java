import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class TmCon {
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
	
	public Tm findByNo(int no) { // 查找某个
		Tm tm = null;
		this.getCon();
		try {
			sql=con.prepareStatement("select * from tm where id=?");
			sql.setInt(1, no);
			rs=sql.executeQuery();
			if(rs.next())
				tm = new Tm(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
		    rs.close();
		    sql.close();
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return tm;
	}
	
	public LinkedList<Tm> findAll() //查找全部
	{
		LinkedList<Tm> list=new LinkedList<Tm>();
		Tm tm;
		this.getCon();
		try {
			sql=con.prepareStatement("select * from tm");
			rs=sql.executeQuery();
			while(rs.next())
			{
				tm = new Tm(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			    list.add(tm);
			}
			rs.close();
			sql.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean add(Tm tm) //增
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("insert into tm values(?,?,?,?,?,?,?,?,?,?)");
			sql.setInt(1, tm.getId());
			sql.setString(2, tm.getName());
			sql.setString(3, tm.getMs());
			sql.setInt(4, tm.getTr());
			sql.setInt(5, tm.getFl());
			sql.setString(6, tm.getA());
			sql.setString(7, tm.getB());
			sql.setString(8, tm.getC());
			sql.setString(9, tm.getD());
			sql.setInt(10, tm.getDa());
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
	
	public boolean update(int no, Tm tm) //改
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("update tm set id=?, name=?, ms=?, tr=?, fl=?, a=?, b=?, c=?, d=?, da=? where id=?");
			sql.setInt(1, tm.getId());
			sql.setString(2, tm.getName());
			sql.setString(3, tm.getMs());
			sql.setInt(4, tm.getTr());
			sql.setInt(5, tm.getFl());
			sql.setString(6, tm.getA());
			sql.setString(7, tm.getB());
			sql.setString(8, tm.getC());
			sql.setString(9, tm.getD());
			sql.setInt(10, tm.getDa());
			sql.setInt(11, no);
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
			sql=con.prepareStatement("delete from tm where id=?");
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
