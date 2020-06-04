import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class MyAdmin extends JFrame implements ActionListener {

	JPanel p1;
	JMenuBar menuber;
	JMenu menu0, menu1, menu2, menu3;
	JMenuItem item11, item12, item13, item14, item21, item22 ,item23 ,item24 ,item25 ,item31 ,item32 ,item33 ,item34 ,item35;
	ImageIcon icon, icon1, icon2, icon3;
	JLabel l1, l2, l3;
	JButton b1, b2, b3;
	stu stu;
	//MyAdminUse mau;
	
	public MyAdmin(stu stu) {
		
		this.stu = stu;
		//mau = new MyAdminUse();
		icon = new ImageIcon("img/log/logo.png");
		icon1 = new ImageIcon("img/log/use0.png");
		icon2 = new ImageIcon("img/log/exam0.png");
		icon3 = new ImageIcon("img/log/tm0.png");
		p1 = new JPanel();
		l1 = new JLabel(icon1);
		l2 = new JLabel(icon2);
		l3 = new JLabel(icon3);
		b1 = new JButton("管理用户");
		b2 = new JButton("管理考试");
		b3 = new JButton("管理题库");
		menuber = new JMenuBar();
		menu0 = new JMenu("首页");
		menu1 = new JMenu("用户");
		menu2 = new JMenu("考试");
		menu3 = new JMenu("题库");
		item11 = new JMenuItem("管理用户", new ImageIcon("img/log/use1.png"));
		item12 = new JMenuItem("查看用户信息", new ImageIcon("img/log/use2.png"));
		item13 = new JMenuItem("修改用户信息", new ImageIcon("img/log/use3.png"));
		item14 = new JMenuItem("删除用户信息", new ImageIcon("img/log/use4.png"));
		item21 = new JMenuItem("管理考试", new ImageIcon("img/log/exam1.png"));
		item22 = new JMenuItem("查看考试", new ImageIcon("img/log/exam2.png"));
		item23 = new JMenuItem("修改考试", new ImageIcon("img/log/exam3.png"));
		item24 = new JMenuItem("删除考试", new ImageIcon("img/log/exam4.png"));
		item25 = new JMenuItem("添加考试", new ImageIcon("img/log/exam5.png"));
		item31 = new JMenuItem("管理题库", new ImageIcon("img/log/tm1.png"));
		item32 = new JMenuItem("查看题库", new ImageIcon("img/log/tm2.png"));
		item33 = new JMenuItem("修改题目", new ImageIcon("img/log/tm3.png"));
		item34 = new JMenuItem("删除题目", new ImageIcon("img/log/tm4.png"));
		item35 = new JMenuItem("添加题目", new ImageIcon("img/log/tm5.png"));
		menu1.add(item11);
		menu1.addSeparator();
		menu1.add(item12);
		menu1.add(item13);
		menu1.add(item14);
		menu2.add(item21);
		menu2.addSeparator();
		menu2.add(item22);
		menu2.add(item23);
		menu2.add(item24);
		menu2.add(item25);
		menu3.add(item31);
		menu3.addSeparator();
		menu3.add(item32);
		menu3.add(item33);
		menu3.add(item34);
		menu3.add(item35);
		menuber.add(menu0);
		menuber.add(menu1);
		menuber.add(menu2);
		menuber.add(menu3);
		setJMenuBar(menuber);
		
		p1.setLayout(null);
		l1.setBounds(300,300,120,120);
		b1.setBounds(300,450,120,50);
		l2.setBounds(700,300,120,120);
		b2.setBounds(700,450,120,50);
		l3.setBounds(1100,300,120,120);
		b3.setBounds(1100,450,120,50);
		p1.add(l1);
		p1.add(b1);
		p1.add(l2);
		p1.add(b2);
		p1.add(l3);
		p1.add(b3);


		//this.add(mau);
		this.add(p1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		item11.addActionListener(this);
		item12.addActionListener(this);
		
		this.setTitle("Admin");
		this.setBounds(150,20,1500,1000);
		this.setResizable(false);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());// 给窗体设置图标方法
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == b1 ) { 
			new MyAdminUse();
		}
		if(e.getSource() == b2) { 
			new MyAdminUse();
		}
		if(e.getSource() == b3) { 
			new MyAdminUse();
		}

	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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
		
		new MyAdmin(null);
	}

}
