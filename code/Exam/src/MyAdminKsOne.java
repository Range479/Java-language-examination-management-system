import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class MyAdminKsOne extends JFrame implements ActionListener {

	JPanel p1, p2;
	ImageIcon icon;
	JButton b1,b2;
	JTable table;
	JScrollPane pane;
	KstmCon dao;
	JLabel l1;
	Kstm ks;
	int no;
	
	
	public MyAdminKsOne(int no) {

		this.no = no;
		icon = new ImageIcon("img/log/logo.png");
		l1=new JLabel("考试信息");
		dao=new KstmCon();
		p1=new JPanel();
		p2=new JPanel();
		b1=new JButton("确定");
		b2=new JButton("下载");
		table=new JTable();
		pane=new JScrollPane(table);
		b1.addActionListener(this);
		b2.addActionListener(this);

		p1.add(l1);
		p2.add(b1);
		p2.add(b2);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(pane,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
		
		this.setTitle("Admin");
		this.setBounds(300,300,700,500);
		this.setResizable(false);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());// 给窗体设置图标方法
		
		LinkedList<Kstm> list=dao.findTm(no);
		Object[][] content=new Object[list.size()][5];
		for(int i=0;i<list.size();i++)
		{
			ks=list.get(i);
			content[i][0]=ks.getNo() + "";
			content[i][1]=ks.getId() + "";
			content[i][2]=ks.getFen() + "";
			content[i][3]=ks.getT() + "";
			content[i][4]=ks.getF() + "";
		}
		Object head[]={"题号","原题号","分值", "正确数", "错误数"};
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setDataVector(content, head); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj = e.getSource();
		if(obj == b1) {
			this.dispose();
			return;
		}
		else if(obj == b2) {
			try {
				new MyAdminKsOneExc(no).generateReport();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			};
			JOptionPane.showMessageDialog(this, "下载成功");
			return;
		}
	}
	public static void main(String args[])
	{
		try
	    {
	    	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
	    UIManager.put("RootPane.setupButtonVisible", false);
		new MyAdminKsOne(1001);
	}
	
}
