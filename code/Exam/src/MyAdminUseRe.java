import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyAdminUseRe extends JPanel implements ActionListener, ItemListener{
	JPanel centerPanel = new JPanel();
	JPanel upPanel = new JPanel();

	ImageIcon icon = new ImageIcon("img/log/Patientia.jpg");
	//定义图形界面元素
	JLabel jLabel = new JLabel("修 改 用 户 信 息");
	JLabel jLabel1 = new JLabel("用 户 学 号：");
	JLabel jLabel2 = new JLabel("用 户 姓 名：");
	JLabel jLabel3 = new JLabel("用 户 密 码：");
	JLabel jLabel4 = new JLabel("用 户 身 份：");
	JLabel jLabel5 = new JLabel("选 择 学 号：");
	JLabel jLabel6;
	
	JTextField jTextField1 = new JTextField(30);  // 学号
	JTextField jTextField2 = new JTextField(30);  // 姓名
	JTextField jTextField3 = new JTextField(30);  // 密码
	JTextField jTextField4 = new JTextField(30);  // 身份
	
	JButton b1 = new JButton("修改");
	JButton b2 = new JButton("重新拍照");
	JButton b3 = new JButton("重置");

	StuCon bean = new StuCon();
	String[] us = new String[] {"空", "学生", "老师"};
	JComboBox<String> comboBox = new JComboBox<String>(us);
	
	public MyAdminUseRe() {
		this.setLayout(null);

		icon.setImage(icon.getImage().getScaledInstance(200, 200,  Image.SCALE_DEFAULT));
		jLabel6 = new JLabel(icon);
		jLabel.setFont(new Font("", 1, 30));
		jLabel1.setFont(new Font("", 0, 30));
		jLabel2.setFont(new Font("", 0, 30));
		jLabel3.setFont(new Font("", 0, 30));
		jLabel4.setFont(new Font("", 0, 30));
		jLabel5.setFont(new Font("", 0, 30));
		jTextField1.setFont(new Font("", 0, 30));
		jTextField2.setFont(new Font("", 0, 30));
		jTextField3.setFont(new Font("", 0, 30));
		jTextField4.setFont(new Font("", 0, 30));
		b1.setFont(new Font("", 0, 30));
		b2.setFont(new Font("", 0, 30));
		b3.setFont(new Font("", 0, 30));
		comboBox.setFont(new Font("", 0, 30));
		try {
			jScrollPanelInit(); //上部面板布局
			addListener();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//上部面板布局
	public void jScrollPanelInit() throws Exception{
		this.setLayout(null);
		jLabel.setBounds(480,0,300,70);
		jLabel6.setBounds(60,100,200,200);
		b2.setBounds(90, 320, 140, 50);
		jLabel1.setBounds(300,100,200,80);
		jLabel2.setBounds(300,180,200,80);
		jLabel3.setBounds(300,260,200,80);
		jLabel4.setBounds(300,340,200,80);
		jLabel5.setBounds(100,600,200,80);
		jTextField1.setBounds(480,100,400,60);
		jTextField2.setBounds(480,180,400,60);
		jTextField3.setBounds(480,260,400,60);
		jTextField4.setBounds(280,600,400,60);
		comboBox.setBounds(480,340,400,60);
		b1.setBounds(300,700,140,50);
		b3.setBounds(500,700,140,50);
		
		this.add(jLabel);
		this.add(jLabel1);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(jTextField1);
		this.add(jTextField2);
		this.add(jTextField3);
		this.add(jTextField4);
		this.add(comboBox);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		comboBox.setEnabled(false);
		b1.setEnabled(false);
		b2.setEnabled(false);
		
	}
	
	public void addListener() throws Exception{
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		jTextField4.addActionListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj = e.getSource();
		if(obj == jTextField4) {
			String s1 = jTextField4.getText();
			if(s1.length() > 0) {
				int id = Integer.parseInt(jTextField4.getText());
				stu stu = bean.findByNo(id);
				if(stu == null){
					JOptionPane.showMessageDialog(this, "学号错误！");
					return;
				}
				b1.setEnabled(true);
				b2.setEnabled(true);
				jTextField4.setEnabled(false);
				jTextField1.setEditable(true);
				jTextField2.setEditable(true);
				jTextField3.setEditable(true);
				comboBox.setEnabled(true);
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
				jLabel6.setIcon(icon1);
				
			}
			return;
			
		}
		
		
		if(obj == b1) {
			int sid = Integer.parseInt(jTextField1.getText());
			int zzd = Integer.parseInt(jTextField4.getText());
			String sna = jTextField2.getText();
			String skey = jTextField3.getText();
			int ius = comboBox.getSelectedIndex();
			stu stu;
			if(ius == 0) {
				JOptionPane.showMessageDialog(this, "你还未选择身份");
				return;
			}
			stu = new stu(sid, sna, skey, ius);
			if(bean.update(zzd, stu))
				JOptionPane.showMessageDialog(this, "修改成功");
			return;
		}
		
		if(obj == b2) {
			String s = jTextField4.getText();
			try {
				MyAdminUseReCe.cemera(s, this);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		
		if(obj == b3) {
			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
	        comboBox.setSelectedIndex(0);
			ImageIcon icon = new ImageIcon("img/log/Patientia.jpg");
			icon.setImage(icon.getImage().getScaledInstance(200, 200,  Image.SCALE_DEFAULT));
			jLabel6.setIcon(icon);
			
			jTextField1.setEditable(false);
			jTextField2.setEditable(false);
			jTextField3.setEditable(false);
			comboBox.setEnabled(false);
			b1.setEnabled(false);
			b2.setEnabled(false);
			jTextField4.setEnabled(true);
			
		}
		
	}

}
