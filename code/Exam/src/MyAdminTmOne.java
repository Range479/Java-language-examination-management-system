import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class MyAdminTmOne extends JFrame implements ActionListener {

	Tm tm;
	JPanel p1;
	JLabel ln, l1, l2, lA, lB, lC, lD, lDA, t, f;
	JButton b1;
	ImageIcon icon;
	
	
	public MyAdminTmOne(Tm tm) {
		this.tm = tm;
		p1 = new JPanel();
		icon = new ImageIcon("img/log/logo.png");

		ln = new JLabel(tm.getId() + ".");
		l1 = new JLabel(tm.getName());
		l2 = new JLabel("描述:" + tm.getMs());
		lA = new JLabel("A." + tm.getA());
		lB = new JLabel("B." + tm.getB());
		lC = new JLabel("C." + tm.getC());
		lD = new JLabel("D." + tm.getD());
		t = new JLabel("正确次数：" + tm.getTr());
		f = new JLabel("错误次数：" + tm.getFl());
		if(tm.getDa() == 1) lDA = new JLabel("正确答案：A");
		else if(tm.getDa() == 2) lDA = new JLabel("正确答案：B");
		else if(tm.getDa() == 3) lDA = new JLabel("正确答案：C");
		else lDA = new JLabel("正确答案：D");
		b1 = new JButton("确认");

		ln.setFont(new Font("", 0, 25));
		l1.setFont(new Font("", 0, 25));
		l2.setFont(new Font("", 0, 25));
		lA.setFont(new Font("", 0, 25));
		lB.setFont(new Font("", 0, 25));
		lC.setFont(new Font("", 0, 25));
		lD.setFont(new Font("", 0, 25));
		lDA.setFont(new Font("", 0, 25));
		t.setFont(new Font("", 0, 25));
		f.setFont(new Font("", 0, 25));
		b1.setFont(new Font("", 0, 25));
		
		p1.setLayout(null);
		ln.setBounds(5,10,170,30);
		l1.setBounds(70,10,300,30);
		l2.setBounds(5,50,700,30);
		lA.setBounds(5,100,700,30);
		lB.setBounds(5,150,700,30);
		lC.setBounds(5,200,700,30);
		lD.setBounds(5,250,700,30);
		lDA.setBounds(5,300,700,30);
		t.setBounds(5,350,700,30);
		f.setBounds(200,350,700,30);
		b1.setBounds(310,400,80,40);
		
		p1.add(ln);
		p1.add(l1);
		p1.add(l2);
		p1.add(lA);
		p1.add(lB);
		p1.add(lC);
		p1.add(lD);
		p1.add(lDA);
		p1.add(t);
		p1.add(f);
		p1.add(b1);
		
		this.add(p1);
		
		b1.addActionListener(this);
		
		this.setTitle("Admin");
		this.setBounds(300,300,700,500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());// 给窗体设置图标方法
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.dispose();
	}
	
}
