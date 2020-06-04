import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyUseKsAll extends JPanel implements ActionListener {

	JPanel p1, p2;
	JButton b1;
	JTable table;
	JScrollPane pane;
	JLabel l1;
	int no;
	Ks tm;
	KsCon bean = new KsCon();
	KstmCon bean1 = new KstmCon();
	DefaultTableModel dtm;
	stu stu;
	
	
	public MyUseKsAll(stu stu) {

		this.setLayout(new BorderLayout());
		
		this.stu = stu;
		
		l1=new JLabel("������Ϣ");
		p1=new JPanel();
		p2=new JPanel();
		b1=new JButton("ѡ��");
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
		
		LinkedList<Ks> list = bean.findAll();
		Object[][] content=new Object[list.size()][4];
		Object head[]={"���", "����", "������", "����"};
		for(int i = 0;i < list.size(); i++)
		{
			tm = list.get(i);
			content[i][0] = tm.getId() + "";
			content[i][1] = tm.getMan() + "";
			content[i][2] = tm.getUse();
			content[i][3] = tm.getNum() + "";
		}
		dtm=(DefaultTableModel)table.getModel();
		dtm.setDataVector(content, head); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		Object obj = e.getSource();
		if(obj == b1) {
			int row=table.getSelectedRow();
			if(row < 0) 
				JOptionPane.showMessageDialog(this, "�㻹δѡ���κ���Ϣ");
			else {
				Object value = table.getValueAt(row, 0);
				int sid = Integer.parseInt(value + "");
				new MyUseKsFace(stu, sid);
				return;
			}
		}
	}
}
