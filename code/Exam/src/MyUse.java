import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class MyUse extends JFrame implements ActionListener {

	JPanel p1;
	JMenuBar menuber;
	JMenu menu0, menu1, menu2, menu3;
	JMenuItem item0, item11, item12, item13, item21, item22 ,item23 ,item24 ,item31 ,item32 ,item33 ,item34;
	ImageIcon icon, icon1, icon2, icon3;
	JLabel l1, l2, l3;
	JButton b1, b2, b3;
	stu stu;
	MyUseTmAll f1;
	MyUseKsAll f2;
	
	public MyUse(stu stu) {

		this.stu = stu;
		f1 = new MyUseTmAll();
		f2 = new MyUseKsAll(stu);
		icon = new ImageIcon("img/log/logo.png");
		icon1 = new ImageIcon("img/log/use0.png");
		icon2 = new ImageIcon("img/log/exam0.png");
		icon3 = new ImageIcon("img/log/tm0.png");
		p1 = new JPanel();
		l1 = new JLabel(icon1);
		l2 = new JLabel(icon2);
		l3 = new JLabel(icon3);
		b1 = new JButton("�� ��");
		b2 = new JButton("�� ��");
		b3 = new JButton("�� ��");
		menuber = new JMenuBar();
		menu0 = new JMenu("��ҳ");
		menu1 = new JMenu("�û�");
		menu2 = new JMenu("����");
		menu3 = new JMenu("���");
		item0 = new JMenuItem("������ҳ", new ImageIcon("img/log/logo.png"));
		item11 = new JMenuItem("����ҳ��", new ImageIcon("img/log/use1.png"));
		item12 = new JMenuItem("�鿴������Ϣ", new ImageIcon("img/log/use2.png"));
		item13 = new JMenuItem("�޸ĸ�����Ϣ", new ImageIcon("img/log/use3.png"));
		item21 = new JMenuItem("����ҳ��", new ImageIcon("img/log/exam1.png"));
		item22 = new JMenuItem("�鿴������Ϣ", new ImageIcon("img/log/exam2.png"));
		item23 = new JMenuItem("���п���", new ImageIcon("img/log/exam3.png"));
		item24 = new JMenuItem("�ҵĿ���", new ImageIcon("img/log/exam5.png"));
		item31 = new JMenuItem("�鿴���", new ImageIcon("img/log/tm1.png"));
		item32 = new JMenuItem("������Ŀ", new ImageIcon("img/log/tm2.png"));
		item33 = new JMenuItem("�ѹ���Ŀ", new ImageIcon("img/log/tm3.png"));
		item34 = new JMenuItem("δ����Ŀ", new ImageIcon("img/log/tm4.png"));
		menu0.add(item0);
		menu1.add(item11);
		menu1.addSeparator();
		menu1.add(item12);
		menu1.add(item13);
		menu2.add(item21);
		menu2.addSeparator();
		menu2.add(item22);
		menu2.add(item23);
		menu2.add(item24);
		menu3.add(item31);
		menu3.addSeparator();
		menu3.add(item32);
		menu3.add(item33);
		menu3.add(item34);
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


		this.add(p1);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		item0.addActionListener(this);
		item11.addActionListener(this);
		item12.addActionListener(this);
		item13.addActionListener(this);
		item31.addActionListener(this);
		item32.addActionListener(this);
		item21.addActionListener(this);
		item22.addActionListener(this);
		
		this.setTitle("xx����ϵͳ");
		this.setBounds(150,20,1500,1000);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());// ����������ͼ�귽��
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		Object obj = e.getSource();
		if(obj == b1 || obj == item11 || obj == item12) {
			StuCon con = new StuCon();
			int i = stu.getId();
			stu = con.findByNo(i);
			new MyUseOne(stu);
		}
		if(obj == item13) {
			new MyUseOneRe(stu);
			StuCon con = new StuCon();
			int i = stu.getId();
			stu = con.findByNo(i);
		}
		
		if(obj == b2 || obj == item21 || obj == item22) {
			this.remove(p1);
			this.remove(f1);
			this.setContentPane(f2);//��frame����������л�ΪpanelB
	        this.revalidate();
	        this.repaint();
		}
		
		if(obj == b3 || obj == item31 || obj == item32) {
			this.remove(p1);
			this.setContentPane(f1);//��frame����������л�ΪpanelB
	        this.revalidate();
	        this.repaint();
			
		}
		if(obj == item0) {
			this.remove(f1);
			this.setContentPane(p1);//��frame����������л�Ϊpanep1
	        this.revalidate();
	        this.repaint();
			
		}
	}
	

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
		
		new MyUse(new stu(1001, "Ƚ����", "123456qwe", 1));
	}
}
