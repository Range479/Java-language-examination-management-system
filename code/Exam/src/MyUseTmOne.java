import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyUseTmOne extends JFrame implements ActionListener{

	JLabel jLabel = new JLabel("题 目 信 息");
	JLabel id = new JLabel("题号：");
	JLabel name = new JLabel("题目：");
	JLabel ms = new JLabel("描述：");
	JLabel tr = new JLabel("正确次数：");
	JLabel fl = new JLabel("错误次数：");
	JLabel l1 = new JLabel("选择答案：");
	JLabel a = new JLabel("A.");
	JLabel b = new JLabel("B.");
	JLabel c = new JLabel("C.");
	JLabel d = new JLabel("D.");
    JRadioButton rb1 = new JRadioButton("A");
    JRadioButton rb2 = new JRadioButton("B");
    JRadioButton rb3 = new JRadioButton("C");
    JRadioButton rb4 = new JRadioButton("D");
	JButton b1 = new JButton("确定");
	
	JTextField idt = new JTextField(20);
	JTextField namet = new JTextField(30);
	JTextField mst = new JTextField(50);
	JTextField trt = new JTextField(20);
	JTextField flt = new JTextField(20);
	JTextField at = new JTextField(20);
	JTextField bt = new JTextField(20);
	JTextField ct = new JTextField(20);
	JTextField dt = new JTextField(20);
	ButtonGroup btnGroup = new ButtonGroup();
	
	TmCon bean;
	Tm tmmm;
	int daan;
	JPanel p = new JPanel();
	MyUseTmAll ff;
	
	public MyUseTmOne(MyUseTmAll ff, Tm tmmm) {
		this.ff = ff;
		p.setLayout(null);

		this.tmmm = tmmm;
		
		idt.setText(tmmm.getId() + "");
		namet.setText(tmmm.getName());
		mst.setText(tmmm.getMs());
		trt.setText(tmmm.getTr() + "");
		flt.setText(tmmm.getFl() + "");
		at.setText(tmmm.getA());
		bt.setText(tmmm.getB());
		ct.setText(tmmm.getC());
		dt.setText(tmmm.getD());
		daan = tmmm.getDa();
		
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
		l1.setFont(new Font("", 0, 30));
		rb1.setFont(new Font("", 0, 30));
		rb2.setFont(new Font("", 0, 30));
		rb3.setFont(new Font("", 0, 30));
		rb4.setFont(new Font("", 0, 30));
		b1.setFont(new Font("", 0, 30));
		
		idt.setFont(new Font("", 0, 30));
		namet.setFont(new Font("", 0, 30));
		mst.setFont(new Font("", 0, 30));
		trt.setFont(new Font("", 0, 30));
		flt.setFont(new Font("", 0, 30));
		at.setFont(new Font("", 0, 30));
		bt.setFont(new Font("", 0, 30));
		ct.setFont(new Font("", 0, 30));
		dt.setFont(new Font("", 0, 30));

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
		tr.setBounds(30, 740, 170, 40);
		trt.setBounds(180, 740, 170, 40);
		fl.setBounds(400, 740, 170, 40);
		flt.setBounds(550, 740, 170, 40);
		l1.setBounds(30, 800, 170, 40);
		b1.setBounds(800, 860, 150, 40);
		rb1.setBounds(180, 800, 100, 40);
		rb2.setBounds(300, 800, 100, 40);
		rb3.setBounds(420, 800, 100, 40);
		rb4.setBounds(540, 800, 100, 40);
	    btnGroup.add(rb1);
	    btnGroup.add(rb2);
	    btnGroup.add(rb3);
	    btnGroup.add(rb4);
		
		p.add(id);
		p.add(idt);
		p.add(name);
		p.add(namet);
		p.add(ms);
		p.add(mst);
		p.add(a);
		p.add(at);
		p.add(b);
		p.add(bt);
		p.add(c);
		p.add(ct);
		p.add(d);
		p.add(dt);
		p.add(tr);
		p.add(trt);
		p.add(fl);
		p.add(flt);
		p.add(l1);
		p.add(b1);
		p.add(jLabel);
		p.add(rb1);
		p.add(rb2);
		p.add(rb3);
		p.add(rb4);
		this.add(p);
		
		idt.setEditable(false);
		namet.setEditable(false);
		mst.setEditable(false);
		trt.setEditable(false);
		flt.setEditable(false);
		at.setEditable(false);
		bt.setEditable(false);
		ct.setEditable(false);
		dt.setEditable(false);
		
		b1.addActionListener(this);

		this.setTitle("xxx考试系统");
		this.setBounds(150,20,1500,1000);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj = e.getSource();
		TmCon co = new TmCon();
		int iii = 0;
		if(obj == b1) {
			if(rb1.isSelected()) iii = 1;
			else if(rb2.isSelected()) iii = 2;
			else if(rb3.isSelected()) iii = 3;
			else if(rb4.isSelected()) iii = 4;
			else {
				JOptionPane.showMessageDialog(this, "还未选择答案");
				return;
			}
			if(iii == daan) {
				int t = Integer.parseInt(trt.getText());
				t++;
				trt.setText(t + "");
				tmmm.setTr(t);
				co.update(tmmm.getId(), tmmm);
				JOptionPane.showMessageDialog(this, "答对了！");
			}
			else {
				int f = Integer.parseInt(flt.getText());
				f++;
				flt.setText(f + "");
				tmmm.setFl(f);
				co.update(tmmm.getId(), tmmm);
				JOptionPane.showMessageDialog(this, "答错了！");
			}
			Tm tm;
			LinkedList<Tm> list = bean.findAll();
			Object[][] content=new Object[list.size()][4];
			Object head[]={"题号", "题目", "正确次数", "错误次数"};
			for(int i = 0;i < list.size(); i++)
			{
				tm = list.get(i);
				content[i][0] = tm.getId() + "";
				content[i][1] = tm.getName();
				content[i][2] = tm.getTr();
				content[i][3] = tm.getFl();
			}
			ff.dtm=(DefaultTableModel)ff.table.getModel();
			ff.dtm.setDataVector(content, head); 
		}
	}
}
