import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class MyUseKsTmAll extends JFrame implements ActionListener {

	JPanel p1, p2;
	JButton b1;
	JTable table;
	JScrollPane pane;
	JLabel l1;
	int no;
	Kstm ks;
	KsCon bean = new KsCon();
	KstmCon bean1 = new KstmCon();
	DefaultTableModel dtm;
	stu stu;
	ImageIcon icon;
	int sid;
	
	public MyUseKsTmAll(int sid) {
		icon = new ImageIcon("img/log/logo.png");
		this.sid = sid;
		this.setLayout(new BorderLayout());
		
		
		l1=new JLabel("考试题目");
		p1=new JPanel();
		p2=new JPanel();
		b1=new JButton("选择");
		table=new JTable();
		pane=new JScrollPane(table);
		b1.addActionListener(this);
		
		l1.setFont(new Font("", 1, 30));
		b1.setFont(new Font("", 1, 20));
		table.setFont(new Font("", 0, 20));

		p1.add(l1);
		p2.add(b1);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(pane,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		LinkedList<Kstm> list=bean1.findTm(sid);
		Object[][] content=new Object[list.size()][5];
		for(int i=0;i<list.size();i++)
		{
			ks=list.get(i);
			content[i][0]=ks.getNo() + "";
			content[i][1]=ks.getId() + "";
			content[i][2]=ks.getFen() + "";
			content[i][3]=ks.getT() + "";
			content[i][4]=ks.getF() + "";
		}
		Object head[]={"题号","原题号","分值", "正确数", "错误数"};
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setDataVector(content, head);

		this.setTitle("xxx考试系统");
		this.setBounds(150,20,1500,1000);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setIconImage(icon.getImage());// 给窗体设置图标方法
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj = e.getSource();
		if(obj == b1) {
			int row=table.getSelectedRow();
			if(row < 0) 
				JOptionPane.showMessageDialog(this, "你还未选中任何信息");
			else {
				row=table.getSelectedRow();
				if(row < 0) 
					JOptionPane.showMessageDialog(this, "你还未选中任何信息");
				else {
					Object value = table.getValueAt(row, 1);
					int r1 = Integer.parseInt(value + "");
					TmCon bean2 = new TmCon();
					Tm tm = bean2.findByNo(r1);
					new MyUseKsTmOne(this, tm, sid);
				}
				return;
			}
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
		
		new MyUseKsTmAll(1001);
	}
}
