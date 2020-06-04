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

public class MyAdminKsAll extends JPanel implements ActionListener {

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
	
	//������
	JScrollPane jScrollPanel;
	JTable jTable;
	ListSelectionModel listSelectionModel = null;
	String[] colName = {"���", "����", "������", "����", "��������"};
	Object[][] content;
	Ks ks;
	KsCon bean = new KsCon();
	
	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;
	
	public MyAdminKsAll() {
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
		upPanel.setLayout(girdBag);
		
		try {
			jLabel.setText("�鿴������Ϣ");
			jLabel.setFont(new Font("", 1, 20));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 0;
			girdBagCon.gridy = 0;
			girdBagCon.insets = new Insets(0, 10, 0, 10);
			girdBag.setConstraints(jLabel, girdBagCon);
			centerPanel.add(jLabel);
			upPanel.add(jLabel);
			
			LinkedList<Ks> list = bean.findAll();
			content = new Object[list.size()][5];
			for(int i = 0;i < list.size(); i++)
			{
				ks = list.get(i);
				content[i][0] = ks.getId() + "";
				content[i][1] = ks.getMan() + "";
				content[i][2] = ks.getUse();
				content[i][3] = ks.getNum();
				content[i][4] = ks.getPer();
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
		this.add(downPanel, BorderLayout.SOUTH);
		b1.setEnabled(true);
	}
	
	public void addListener() throws Exception{
		b1.addActionListener(this);
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
				int sid = Integer.parseInt(value + "");
				new MyAdminKsOne(sid);
			}
		}
	}

}
