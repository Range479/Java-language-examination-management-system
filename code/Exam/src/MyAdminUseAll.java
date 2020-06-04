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

	//�������õ����
	JPanel upPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel downPanel = new JPanel();
	
	//����ͼ�ν���Ԫ��
	JLabel jLabel = new JLabel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JButton b1 = new JButton("�鿴");
	JButton b2 = new JButton("����ȫ��");
	
	//������
	JScrollPane jScrollPanel;
	JTable jTable;
	ListSelectionModel listSelectionModel = null;
	String[] colName = {"ѧ��", "����", "����", "���"};
	Object[][] content;
	stu stu;
	
	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;
	
	public MyAdminUseAll() {
		this.setLayout(new BorderLayout());
		try {
			upInit();     //�ϲ���岼��
			//centerInit(); //�в���岼��
			downInit();   //�²���岼��
			addListener();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upInit() throws Exception{ //�ϲ����Ĳ���
		StuCon bean = new StuCon();
		upPanel.setLayout(girdBag);
		
		try {
			jLabel.setText("�鿴ѧ����Ϣ");
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
					content[i][3] = "ѧ��";
				else content[i][3] = "��ʦ";
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
		// TODO �Զ����ɵķ������
		Object obj = e.getSource();
		if(obj == b1) {
			int row=jTable.getSelectedRow();
			if(row < 0) 
				JOptionPane.showMessageDialog(this, "�㻹δѡ���κ���Ϣ");
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
				if(suse.equals("ѧ��"))
					stu = new stu(sid, sname, skey, 1);
				else stu = new stu(sid, sname, skey, 0);
				new MyAdminUseOne(this, stu);
			}
		}
		if(obj == b2) {
			try {
				new MyAdminUseAllExc().generateReport();
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			};
			JOptionPane.showMessageDialog(this, "���سɹ�");
		}
	}

}
