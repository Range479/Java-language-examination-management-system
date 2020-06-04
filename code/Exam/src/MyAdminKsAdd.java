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
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyAdminKsAdd extends JPanel implements ActionListener{

	JLabel jLabel = new JLabel("添 加 考 试 信 息");
	JLabel id = new JLabel("编号：");
	JLabel man = new JLabel("满分：");
	JLabel ause = new JLabel("命题人：");
	JLabel num = new JLabel("题目数量：");
	JLabel l1 = new JLabel("选择编号：");
	JLabel l2 = new JLabel("题号：");
	JLabel l3 = new JLabel("原题号：");
	JLabel l4 = new JLabel("分值：");
	JButton b1 = new JButton("添加");
	JButton b2 = new JButton("重置");
	JButton b3 = new JButton("添加");
	JButton b4 = new JButton("删除");
	
	JTextField idt = new JTextField(30);
	JTextField mant = new JTextField(30);
	JTextField auset = new JTextField(30);
	JTextField numt = new JTextField(30);
	JTextField pert = new JTextField(30);
	JTextField l1t = new JTextField(30);
	JTextField l2t = new JTextField(30);
	JTextField l3t = new JTextField(30);
	JTextField l4t = new JTextField(30);
	
	JTable table;
	JScrollPane pane;
	String[] colName = {"题号", "原题号", "分值", "正确数", "错误数"};
	Object[][] content = new Object[0][5];
	KstmCon bean;
	KsCon bean1;
	Ks ks;
	Kstm kstm;

	public MyAdminKsAdd() {
		this.setLayout(null);
		
		bean = new KstmCon();
		bean1 = new KsCon();
		
		jLabel.setFont(new Font("", 1, 30));
		id.setFont(new Font("", 1, 30));
		man.setFont(new Font("", 1, 30));
		ause.setFont(new Font("", 1, 30));
		num.setFont(new Font("", 1, 30));
		l1.setFont(new Font("", 1, 30));
		l2.setFont(new Font("", 1, 30));
		l3.setFont(new Font("", 1, 30));
		l4.setFont(new Font("", 1, 30));
		b1.setFont(new Font("", 1, 30));
		b2.setFont(new Font("", 1, 30));
		b3.setFont(new Font("", 1, 30));
		b4.setFont(new Font("", 1, 30));
		
		idt.setFont(new Font("", 1, 30));
		mant.setFont(new Font("", 1, 30));
		auset.setFont(new Font("", 1, 30));
		numt.setFont(new Font("", 1, 30));
		pert.setFont(new Font("", 1, 30));
		l1t.setFont(new Font("", 1, 30));
		l2t.setFont(new Font("", 1, 30));
		l3t.setFont(new Font("", 1, 30));
		l4t.setFont(new Font("", 1, 30));
		
		jLabel.setBounds(480,0,300,70);
		id.setBounds(30, 80, 170, 40);
		idt.setBounds(110, 80, 200, 40);
		man.setBounds(390, 80, 170, 40);
		mant.setBounds(470, 80, 210, 40);
		ause.setBounds(750, 80, 170, 40);
		auset.setBounds(880, 80, 210, 40);
		l2.setBounds(30, 600, 170, 40);
		l2t.setBounds(110, 600, 210, 40);
		l3.setBounds(390, 600, 170, 40);
		l3t.setBounds(500, 600, 210, 40);
		l4.setBounds(780, 600, 170, 40);
		l4t.setBounds(880, 600, 210, 40);
		b3.setBounds(780, 680, 150, 40);
		b4.setBounds(940, 680, 150, 40);
		l1.setBounds(30, 760, 170, 40);
		l1t.setBounds(180, 760, 210, 40);
		b1.setBounds(500, 760, 150, 40);
		b2.setBounds(700, 760, 150, 40);
		
		table = new JTable(content, colName);
		pane = new JScrollPane(table);
		pane.setBounds(30, 150, 1200, 400);
		
		this.add(jLabel);
		this.add(id);
		this.add(idt);
		this.add(man);
		this.add(mant);
		this.add(ause);
		this.add(auset);
		this.add(pane);
		this.add(l2);
		this.add(l3);
		this.add(l4);
		this.add(l1);
		this.add(l1t);
		this.add(l2t);
		this.add(l3t);
		this.add(l4t);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		
		b1.setEnabled(false);
		b4.setEnabled(false);
		b3.setEnabled(false);
		idt.setEditable(false);
		mant.setEditable(false);
		auset.setEditable(false);
		numt.setEditable(false);
		pert.setEditable(false);
		l2t.setEditable(false);
		l3t.setEditable(false);
		l4t.setEditable(false);
		l1t.setEditable(true);
		

		l1t.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	
	public void all(int ino) {
		LinkedList<Kstm> list = bean.findTm(ino);
		content = new Object[list.size()][5];
		for(int i = 0;i < list.size(); i++)
		{
			kstm = list.get(i);
			content[i][0] = kstm.getNo()+"";
			content[i][1] = kstm.getId();
			content[i][2] = kstm.getFen()+"";
			content[i][3] = kstm.getT()+"";
			content[i][4] = kstm.getF()+"";

			table = new JTable(content, colName);
			pane = new JScrollPane(table);
			pane.setBounds(30, 150, 1200, 400);
			this.add(pane);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj = e.getSource();
		if(obj == l1t) {
			String s1 = l1t.getText();
			if(s1.length() > 0) {
				int id = Integer.parseInt(s1);
				ks = bean1.findByNo(id);
				if(ks != null){
					JOptionPane.showMessageDialog(this, "题号已有！");
					return;
				}
				bean.AddKs(id);
				b1.setEnabled(true);
				b4.setEnabled(true);
				b3.setEnabled(true);
				idt.setEditable(true);
				mant.setEditable(true);
				auset.setEditable(true);
				numt.setEditable(true);
				pert.setEditable(true);
				l2t.setEditable(true);
				l3t.setEditable(true);
				l4t.setEditable(true);
				l1t.setEditable(false);
				
			}
				
		}
		else if(obj == b1) {
			String s1 = l1t.getText();
			int id = Integer.parseInt(s1);
			ks = bean1.findByNo(id);
			int a1 = Integer.parseInt(idt.getText());
			Double a2 = Double.valueOf(mant.getText());
			String a3 = auset.getText();
			LinkedList<Kstm> list = bean.findTm(id);
			Ks ks1 = new Ks(a1, a2, a3, list.size(), 0);
			if(bean1.add(ks1)) {
				idt.setText("");
				mant.setText("");
				auset.setText("");
				l1t.setText("");
				l2t.setText("");
				l3t.setText("");
				l4t.setText("");
				JOptionPane.showMessageDialog(this, "添加成功！");
			}
			
		}
		else if(obj == b2) {
			idt.setText("");
			mant.setText("");
			auset.setText("");
			l1t.setText("");
			l2t.setText("");
			l3t.setText("");
			l4t.setText("");
			content = new Object[0][5];
			table = new JTable(content, colName);
			pane = new JScrollPane(table);
			pane.setBounds(30, 150, 1200, 400);
			this.add(pane);
			

			b1.setEnabled(false);
			b4.setEnabled(false);
			b3.setEnabled(false);
			idt.setEditable(false);
			mant.setEditable(false);
			auset.setEditable(false);
			numt.setEditable(false);
			pert.setEditable(false);
			l2t.setEditable(false);
			l3t.setEditable(false);
			l4t.setEditable(false);
			l1t.setEditable(true);
		}
		else if(obj == b3) {
			String s1 = l1t.getText();
			int id = Integer.parseInt(s1);
			int a1 = Integer.parseInt(l2t.getText());
			int a2 = Integer.parseInt(l3t.getText());
			Double a3 = Double.valueOf(l4t.getText());
			kstm = new Kstm(a1, a2, a3, 0, 0);
			bean.AddTm(kstm, id);
			all(id);
		}
		else if(obj == b4) {
			String s1 = l1t.getText();
			int id = Integer.parseInt(s1);
			int a1 = Integer.parseInt(l2t.getText());
			bean.delTm(a1, id);
			all(id);
		}
	}

}
