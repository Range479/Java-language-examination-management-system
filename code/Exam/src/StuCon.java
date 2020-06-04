import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class StuCon {
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
	
	public stu findByNo(int no) { // 查找某个
		stu stu = null;
		this.getCon();
		try {
			sql=con.prepareStatement("select * from stu where id=?");
			sql.setInt(1, no);
			rs=sql.executeQuery();
			if(rs.next())
				stu=new stu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		    rs.close();
		    sql.close();
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return stu;
	}
	
	public LinkedList<stu> findAll() //查找全部
	{
		LinkedList<stu> list=new LinkedList<stu>();
		stu stu;
		this.getCon();
		try {
			sql=con.prepareStatement("select * from stu");
			rs=sql.executeQuery();
			while(rs.next())
			{
				stu=new stu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(stu);
			}
			rs.close();
			sql.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean add(stu stu) //增
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("insert into stu values(?,?,?,?)");
			sql.setInt(1, stu.getId());
			sql.setString(2, stu.getName());
			sql.setString(3, stu.getPassword());
			sql.setInt(4, stu.getUse());
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
	
	public boolean update(int no, stu stu) //改
	{
		boolean flag=false;
		this.getCon();
		try {
			sql=con.prepareStatement("update stu set id=?, name=?, password=?, suse=? where id=?");
			sql.setInt(1, stu.getId());
			sql.setString(2, stu.getName());
			sql.setString(3, stu.getPassword());
			sql.setInt(4, stu.getUse());
			sql.setInt(5, no);
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
			sql=con.prepareStatement("delete from stu where id=?");
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
