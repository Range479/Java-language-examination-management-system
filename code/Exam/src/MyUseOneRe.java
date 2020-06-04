import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class MyUseOneRe extends JFrame implements ActionListener {
	JPanel p = new JPanel();

	ImageIcon icon = new ImageIcon("img/log/Patientia.jpg");
	//定义图形界面元素
	JLabel jLabel = new JLabel("修 改 用 户 信 息");
	JLabel jLabel1 = new JLabel("用 户 学 号：");
	JLabel jLabel2 = new JLabel("用 户 姓 名：");
	JLabel jLabel3 = new JLabel("用 户 密 码：");
	JLabel jLabel4 = new JLabel("用 户 身 份：");
	JLabel jLabel6;
	
	JTextField jTextField1 = new JTextField(30);  // 学号
	JTextField jTextField2 = new JTextField(30);  // 姓名
	JTextField jTextField3 = new JTextField(30);  // 密码
	
	JButton b1 = new JButton("修改");
	JButton b2 = new JButton("重新拍照");
	JButton b3 = new JButton("重置");

	StuCon bean = new StuCon();
	String[] us = new String[] {"空", "学生", "老师"};
	JComboBox<String> comboBox = new JComboBox<String>(us);
	
	int id;
	stu sstu;
	
	public MyUseOneRe(stu stu) {
		p.setLayout(null);
		id = stu.getId();
		sstu = stu;
		
		jTextField1.setText(stu.getId() + "");
		jTextField2.setText(stu.getName());
		jTextField3.setText(stu.getPassword());
        comboBox.setSelectedIndex(stu.getUse());
        ImageIcon icon1;
        File file = new File("img/use/" + id + ".png");
		if (file.exists()) 
			icon1 = new ImageIcon("img/use/" + id + ".png");
		else icon1 = new ImageIcon("img/log/Patientia.jpg");
		icon1.setImage(icon1.getImage().getScaledInstance(200, 200,  Image.SCALE_DEFAULT));
		jLabel6 = new JLabel(icon1);
		jLabel.setFont(new Font("", 1, 30));
		jLabel1.setFont(new Font("", 0, 30));
		jLabel2.setFont(new Font("", 0, 30));
		jLabel3.setFont(new Font("", 0, 30));
		jLabel4.setFont(new Font("", 0, 30));
		jTextField1.setFont(new Font("", 0, 30));
		jTextField2.setFont(new Font("", 0, 30));
		jTextField3.setFont(new Font("", 0, 30));
		b1.setFont(new Font("", 0, 30));
		b2.setFont(new Font("", 0, 30));
		b3.setFont(new Font("", 0, 30));
		comboBox.setFont(new Font("", 0, 30));
		
		jLabel.setBounds(480,0,300,70);
		jLabel6.setBounds(60,100,200,200);
		b2.setBounds(90, 320, 140, 50);
		jLabel1.setBounds(300,100,200,80);
		jLabel2.setBounds(300,180,200,80);
		jLabel3.setBounds(300,260,200,80);
		jLabel4.setBounds(300,340,200,80);
		jTextField1.setBounds(480,100,400,60);
		jTextField2.setBounds(480,180,400,60);
		jTextField3.setBounds(480,260,400,60);
		comboBox.setBounds(480,340,400,60);
		b1.setBounds(300,500,140,50);
		b3.setBounds(500,500,140,50);
		comboBox.setEnabled(false);
		jTextField1.setEditable(false);
		
		p.add(jLabel);
		p.add(jLabel1);
		p.add(jLabel2);
		p.add(jLabel3);
		p.add(jLabel4);
		p.add(jLabel6);
		p.add(jTextField1);
		p.add(jTextField2);
		p.add(jTextField3);
		p.add(comboBox);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		this.add(p);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		this.setTitle("xxx考试系统");
		this.setBounds(100,100,1000,600);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());// 给窗体设置图标方法
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj = e.getSource();

		if(obj == b1) {
			int sid = Integer.parseInt(jTextField1.getText());
			String sna = jTextField2.getText();
			String skey = jTextField3.getText();
			sstu = new stu(sid, sna, skey, sstu.getUse());
			if(bean.update(id, sstu))
				JOptionPane.showMessageDialog(this, "修改成功");
			return;
		}
		
		if(obj == b2) {
			try {
				MyUseReCe.cemera(id + "", this);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		
		if(obj == b3) {
			//jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
	        //comboBox.setSelectedIndex(0);
			ImageIcon icon = new ImageIcon("img/log/Patientia.jpg");
			icon.setImage(icon.getImage().getScaledInstance(200, 200,  Image.SCALE_DEFAULT));
			jLabel6.setIcon(icon);
		}
		
	}
	
}
