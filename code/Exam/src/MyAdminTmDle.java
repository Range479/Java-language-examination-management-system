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

public class MyAdminTmDle extends JPanel implements ActionListener{

	JLabel jLabel = new JLabel("删 除 题 目 信 息");
	JLabel id = new JLabel("题号：");
	JLabel name = new JLabel("题目：");
	JLabel ms = new JLabel("描述：");
	JLabel tr = new JLabel("正确次数：");
	JLabel fl = new JLabel("错误次数：");
	JLabel l1 = new JLabel("选择题号：");
	JLabel a = new JLabel("A.");
	JLabel b = new JLabel("B.");
	JLabel c = new JLabel("C.");
	JLabel d = new JLabel("D.");
	JLabel da = new JLabel("正确选项：");
	JButton b1 = new JButton("删除");
	JButton b2 = new JButton("重置");

	JTextField idt = new JTextField(20);
	JTextField namet = new JTextField(30);
	JTextField mst = new JTextField(50);
	JTextField trt = new JTextField(20);
	JTextField flt = new JTextField(20);
	JTextField at = new JTextField(20);
	JTextField bt = new JTextField(20);
	JTextField ct = new JTextField(20);
	JTextField dt = new JTextField(20);
	JTextField dat = new JTextField(20);
	JTextField l1t = new JTextField(20);
	
	TmCon bean;
	
	public MyAdminTmDle() {
		this.setLayout(null);

		bean = new TmCon();
		jLabel.setFont(new Font("", 1, 30));
		id.setFont(new Font("", 0, 30));
		name.setFont(new Font("", 0, 30));
		ms.setFont(new Font("", 0, 30));
		tr.setFont(new Font("", 0, 30));
		fl.setFont(new Font("", 0, 30));
		a.setFont(new Font("", 0, 30));
		b.setFont(new Font("", 0, 30));
		c.setFont(new Font("", 0, 30));
		d.setFont(new Font("", 0, 30));
		da.setFont(new Font("", 0, 30));
		l1.setFont(new Font("", 0, 30));
		
		idt.setFont(new Font("", 0, 30));
		namet.setFont(new Font("", 0, 30));
		mst.setFont(new Font("", 0, 30));
		trt.setFont(new Font("", 0, 30));
		flt.setFont(new Font("", 0, 30));
		at.setFont(new Font("", 0, 30));
		bt.setFont(new Font("", 0, 30));
		ct.setFont(new Font("", 0, 30));
		dt.setFont(new Font("", 0, 30));
		dat.setFont(new Font("", 0, 30));
		l1t.setFont(new Font("", 0, 30));
		b1.setFont(new Font("", 0, 30));
		b2.setFont(new Font("", 0, 30));

		jLabel.setBounds(480,0,300,70);
		id.setBounds(30, 80, 170, 40);
		idt.setBounds(110, 80, 200, 40);
		name.setBounds(350, 80, 170, 40);
		namet.setBounds(430, 80, 800, 40);
		ms.setBounds(30, 150, 170, 40);
		mst.setBounds(30, 200, 1200, 270);
		a.setBounds(30, 500, 170, 40);
		at.setBounds(80,500, 900, 40);
		b.setBounds(30, 560, 170, 40);
		bt.setBounds(80, 560, 900, 40);
		c.setBounds(30, 620, 170, 40);
		ct.setBounds(80, 620, 900, 40);
		d.setBounds(30, 680, 170, 40);
		dt.setBounds(80, 680, 900, 40);
		da.setBounds(30, 740, 170, 40);
		dat.setBounds(180, 740, 170, 40);
		tr.setBounds(30, 800, 170, 40);
		trt.setBounds(180, 800, 170, 40);
		fl.setBounds(400, 800, 170, 40);
		flt.setBounds(550, 800, 170, 40);
		l1.setBounds(30, 860, 170, 40);
		l1t.setBounds(180, 860, 200, 40);
		b1.setBounds(800, 860, 150, 40);
		b2.setBounds(1000, 860, 150, 40);
		
		this.add(id);
		this.add(idt);
		this.add(name);
		this.add(namet);
		this.add(ms);
		this.add(mst);
		this.add(a);
		this.add(at);
		this.add(b);
		this.add(bt);
		this.add(c);
		this.add(ct);
		this.add(d);
		this.add(dt);
		this.add(da);
		this.add(dat);
		this.add(tr);
		this.add(trt);
		this.add(fl);
		this.add(flt);
		this.add(l1);
		this.add(l1t);
		this.add(b1);
		this.add(b2);
		this.add(jLabel);
		
		idt.setEditable(false);
		namet.setEditable(false);
		mst.setEditable(false);
		trt.setEditable(false);
		flt.setEditable(false);
		at.setEditable(false);
		bt.setEditable(false);
		ct.setEditable(false);
		dt.setEditable(false);
		dat.setEditable(false);
		b1.setEnabled(false);
		l1t.setEditable(true);
		
		l1t.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj = e.getSource();
		if(obj == l1t) {
			String s1 = l1t.getText();
			if(s1.length() > 0) {
				int id = Integer.parseInt(s1);
				Tm tm = bean.findByNo(id);
				if(tm == null){
					JOptionPane.showMessageDialog(this, "题号错误！");
					return;
				}
				b1.setEnabled(true);
				l1t.setEditable(false);
				
				idt.setText(tm.getId()+ "");
				namet.setText(tm.getName());
				mst.setText(tm.getMs());
				trt.setText(tm.getTr() + "");
				flt.setText(tm.getFl() + "");
				at.setText(tm.getA());
				bt.setText(tm.getB());
				ct.setText(tm.getC());
				dt.setText(tm.getD());
				if(tm.getDa() == 1) dat.setText("A");
				if(tm.getDa() == 2) dat.setText("B");
				if(tm.getDa() == 3) dat.setText("C");
				if(tm.getDa() == 4) dat.setText("D");
			}
		}
		else if(obj == b1) {
			int sid = Integer.parseInt(idt.getText());
			String sname = namet.getText();
			String sms = mst.getText();
			String s1 = l1t.getText();
			
			int no = Integer.parseInt(s1);
			if(bean.del(no)) {
				idt.setText("");
				namet.setText("");
				mst.setText("");
				trt.setText("");
				flt.setText("");
				at.setText("");
				bt.setText("");
				ct.setText("");
				dt.setText("");
				dat.setText("");
				l1t.setText("");
				JOptionPane.showMessageDialog(this, "删除成功！");
			}
		}
		else if(obj == b2) {
			idt.setText("");
			namet.setText("");
			mst.setText("");
			trt.setText("");
			flt.setText("");
			at.setText("");
			bt.setText("");
			ct.setText("");
			dt.setText("");
			dat.setText("");
			l1t.setText("");
			
			l1t.setEditable(true);
			b1.setEnabled(false);
		}
	}
}
