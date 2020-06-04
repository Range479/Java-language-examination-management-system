import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class MySign extends JFrame implements ActionListener {

	JPanel p1, p2, p3, p4, p5;
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1, t2;
	JPasswordField t3, t4;
	JButton b1, b2, b3;
	StuCon dao;
	ImageIcon icon, icon1;
	
	public MySign() {
		
		icon = new ImageIcon("img/log/logo.png");
		icon1 = new ImageIcon("img/log/Patientia.jpg");
		icon1.setImage(icon1.getImage().getScaledInstance(120, 120,  Image.SCALE_DEFAULT));
		l6=new JLabel(icon1);
		dao = new StuCon();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		l1=new JLabel("输入学号：");
		l2=new JLabel("输入姓名：");
		l3=new JLabel("输入密码：");
		l4=new JLabel("确认密码：");
		l5=new JLabel("xx考试系统");
		t1=new JTextField(30);
		t2=new JTextField(30);
		t3=new JPasswordField(30);
		t4=new JPasswordField(30);
		b1=new JButton("拍照");
		b2=new JButton("确定");
		b3=new JButton("取消");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
//		l1.setFont(new Font("", 0, 30));
//		l2.setFont(new Font("", 0, 30));
//		l3.setFont(new Font("", 0, 30));
//		l4.setFont(new Font("", 0, 30));
		l5.setFont(new Font("", 1, 30));
		p4.setLayout(new BorderLayout());
		
		p1.add(l5);
		p3.add(l1);
		p3.add(t1);
		p3.add(l2);
		p3.add(t2);
		p3.add(l3);
		p3.add(t3);
		p3.add(l4);
		p3.add(t4);
		p4.add(l6,BorderLayout.CENTER);
		p4.add(b1,BorderLayout.SOUTH);
		p5.add(b2);
		p5.add(b3);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p3,BorderLayout.CENTER);
		this.add(p4,BorderLayout.EAST);
		this.add(p5,BorderLayout.SOUTH);

		this.setTitle("注册页面");
		this.setBounds(700,300,510,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setIconImage(icon.getImage());// 给窗体设置图标方法
	}
	
	public boolean add() {
		String id = t1.getText();
		String sname = t2.getText();
		String key1 = new String(t3.getPassword());
		String key2 = new String(t4.getPassword());
		
		if(id.equals("")) {
			JOptionPane.showMessageDialog(this, "你还未输入学号");
			return false;
		}
		if(sname.equals("")) {
			JOptionPane.showMessageDialog(this, "你还未输入姓名");
			return false;
		}
		if(key1.equals("")) {
			JOptionPane.showMessageDialog(this, "你还未输入密码");
			return false;
		}
		if(key2.equals("")) {
			JOptionPane.showMessageDialog(this, "你还未确认密码");
			return false;
		}
		if(!key2.equals(key1.toString())) {
			JOptionPane.showMessageDialog(this, "两次输入的密码不同");
			return false;
		}
		
		stu stu = new stu(Integer.parseInt(id), sname, key1, 1);
		
		return dao.add(stu);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		JButton b=(JButton)arg0.getSource();
		if(b == b1) {
			String id = t1.getText();
			if(id.equals("")) {
				JOptionPane.showMessageDialog(this, "你还未输入学号");
				return;
			}
			try {
				String s = t1.getText();
				MyCemera.cemera(s, this);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				//e.printStackTrace();
			}
		}
		if(b == b2) {
			if(this.add()) {
				JOptionPane.showMessageDialog(this, "添加成功！");
				this.dispose();
			}
			else
				JOptionPane.showMessageDialog(this, "添加失败！");
				
				
		}
		if(b == b3) {
			this.dispose();
		}
	}
	

}
