import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MyAdminUseAll extends JPanel implements ActionListener {

	//定义所用的面板
	JPanel upPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel downPanel = new JPanel();
	
	//定义图形界面元素
	JLabel jLabel = new JLabel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JButton b1 = new JButton("查看");
	JButton b2 = new JButton("下载全部");
	
	//定义表格
	JScrollPane jScrollPanel;
	JTable jTable;
	ListSelectionModel listSelectionModel = null;
	String[] colName = {"学号", "姓名", "密码", "身份"};
	Object[][] content;
	stu stu;
	
	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;
	
	public MyAdminUseAll() {
		this.setLayout(new BorderLayout());
		try {
			upInit();     //上部面板布局
			//centerInit(); //中部面板布局
			downInit();   //下部面板布局
			addListener();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upInit() throws Exception{ //上部面板的布局
		StuCon bean = new StuCon();
		upPanel.setLayout(girdBag);
		
		try {
			jLabel.setText("查看学生信息");
			jLabel.setFont(new Font("", 1, 20));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 0;
			girdBagCon.gridy = 0;
			girdBagCon.insets = new Insets(0, 10, 0, 10);
			girdBag.setConstraints(jLabel, girdBagCon);
			centerPanel.add(jLabel);
			upPanel.add(jLabel);
			
			LinkedList<stu> list = bean.findAll();
			content = new Object[list.size()][4];
			for(int i = 0;i < list.size(); i++)
			{
				stu = list.get(i);
				content[i][0] = stu.getId()+"";
				content[i][1] = stu.getName();
				content[i][2] = stu.getPassword()+"";
				if(stu.getUse() == 1)
					content[i][3] = "学生";
				else content[i][3] = "老师";
			}
			jTable = new JTable(content, colName);
			jTable.setPreferredScrollableViewportSize(new Dimension(1200, 880));
			jScrollPanel = new JScrollPane(jTable);
			jScrollPanel.setPreferredSize(new Dimension(1200, 870));

			jTable.setFont(new Font("", 0, 19));
			
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 0;
			girdBagCon.gridy = 1;
			girdBagCon.insets = new Insets(0, 0, 0, 0);
			girdBag.setConstraints(jScrollPanel, girdBagCon);
			upPanel.add(jScrollPanel);
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.add(upPanel, BorderLayout.NORTH);
	}
	
	public void downInit() {
		downPanel.add(b1);
		downPanel.add(b2);
		this.add(downPanel, BorderLayout.SOUTH);
		b1.setEnabled(true);
		b2.setEnabled(true);
	}
	
	public void addListener() throws Exception{
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj = e.getSource();
		if(obj == b1) {
			int row=jTable.getSelectedRow();
			if(row < 0) 
				JOptionPane.showMessageDialog(this, "你还未选中任何信息");
			else {
				Object value = jTable.getValueAt(row, 0);
				Object value2 = jTable.getValueAt(row, 1);
				Object value3 = jTable.getValueAt(row, 2);
				Object value4 = jTable.getValueAt(row, 3);
				int sid = Integer.parseInt(value + "");
				String sname = String.valueOf(value2);
				String skey = String.valueOf(value3);
				String suse = String.valueOf(value4);
				stu stu;
				if(suse.equals("学生"))
					stu = new stu(sid, sname, skey, 1);
				else stu = new stu(sid, sname, skey, 0);
				new MyAdminUseOne(this, stu);
			}
		}
		if(obj == b2) {
			try {
				new MyAdminUseAllExc().generateReport();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			};
			JOptionPane.showMessageDialog(this, "下载成功");
		}
	}

}
