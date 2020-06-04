import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class MyFrame extends JFrame implements ActionListener {
	JPanel p1, p2, p3;
	JLabel l1, l2, l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2, b3;
	StuCon dao;
	
	public MyFrame(String title, int a, int b, int width, int height) {
		dao = new StuCon();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		l1=new JLabel("�˺ţ�");
		l2=new JLabel("���룺");
		l3=new JLabel("xx����ϵͳ");
		t1=new JTextField(20);
		t2=new JPasswordField (20);
		b1=new JButton("ȷ��");
		b2=new JButton("ע��");
		b3=new JButton("ȡ�� ");
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		l1.setFont(new Font("", 0, 30));
		l2.setFont(new Font("", 0, 30));
		l3.setFont(new Font("", 1, 30));
		
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p2.add(b1);
		p2.add(b2);
		p3.add(l3);
		ImageIcon icon = new ImageIcon("img/log/logo.png");

		this.add(p3,BorderLayout.NORTH);
		this.add(p1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
		this.setTitle(title);
		this.setBounds(a, b, width, height);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());// ����������ͼ�귽��
		this.setResizable(false);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		JButton b=(JButton)e.getSource();
		if(b == b1) {
			String sid = t1.getText();
			String skey = new String(t2.getPassword());
			if(sid.equals("") || skey.equals("")) {
				JOptionPane.showMessageDialog(this, "�˺Ż����뻹δ����");
				return;
			}
			stu stu = dao.findByNo(Integer.parseInt(sid));
			if(stu != null && skey.equals(stu.getPassword())) {
				if(stu.getUse() == 1){
					new MyUse(stu);
					this.dispose();
				}
				else {
					new MyAdmin(stu);
					this.dispose();
				}
			}
			else
				JOptionPane.showMessageDialog(this, "��¼ʧ��");
		}
		if(b == b2) {
			new MySign();
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
		
		new MyFrame("����ϵͳ",800,350,350,250);
	}

}
