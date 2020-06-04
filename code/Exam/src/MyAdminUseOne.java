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

public class MyAdminUseOne extends JFrame implements ActionListener {

	stu stu;
	JPanel p1;
	JLabel l1, l2, l3, l4, l5;
	JLabel l21, l31, l41, l51;
	JButton b1;
	ImageIcon icon, icon1;
	
	
	public MyAdminUseOne(MyAdminUseAll al, stu stu) {
		this.stu = stu;
		String s = stu.getId() + "";
		p1 = new JPanel();
		icon = new ImageIcon("img/log/logo.png");
		icon1 = new ImageIcon("img/log/Patientia.jpg");

		File file = new File("img/use/" + s + ".png");
		if (file.exists()) {
			icon1 = new ImageIcon("img/use/" + s + ".png");
		} 
			
		icon1.setImage(icon1.getImage().getScaledInstance(170, 170,  Image.SCALE_DEFAULT));
		l1 = new JLabel(icon1);
		l2 = new JLabel("ѧ��:");
		l3 = new JLabel("����:");
		l4 = new JLabel("����:");
		l5 = new JLabel("���:");
		l21 = new JLabel(stu.getId() + "");
		l31 = new JLabel(stu.getName());
		l41 = new JLabel(stu.getPassword());
		if(stu.getUse() == 1)
			l51 = new JLabel("ѧ��");
		else l51 = new JLabel("��ʦ");
		b1 = new JButton("ȷ��");
		l1.setFont(new Font("", 0, 30));
		l2.setFont(new Font("", 0, 30));
		l3.setFont(new Font("", 0, 30));
		l4.setFont(new Font("", 0, 30));
		l5.setFont(new Font("", 0, 30));
		l21.setFont(new Font("", 0, 30));
		l31.setFont(new Font("", 0, 30));
		l41.setFont(new Font("", 0, 30));
		l51.setFont(new Font("", 0, 30));
		
		p1.setLayout(null);
		l1.setBounds(40,40,170,170);
		l2.setBounds(250,40,100,40);
		l3.setBounds(250,100,100,40);
		l4.setBounds(250,160,100,40);
		l5.setBounds(250,220,100,40);
		l21.setBounds(330,40,200,40);
		l31.setBounds(330,100,200,40);
		l41.setBounds(330,160,200,40);
		l51.setBounds(330,220,200,40);
		b1.setBounds(310,400,80,40);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l21);
		p1.add(l31);
		p1.add(l41);
		p1.add(l51);
		p1.add(b1);
		
		this.add(p1);
		
		b1.addActionListener(this);
		
		this.setTitle("Admin");
		this.setBounds(300,300,700,500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());// ����������ͼ�귽��
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		this.dispose();
	}
	
}
