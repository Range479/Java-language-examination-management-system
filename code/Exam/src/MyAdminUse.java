import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.net.*;

/**
 * ���¹���ϵͳ������
 */
public class MyAdminUse extends JFrame implements ActionListener,TreeSelectionListener{
	
	//�˵���
	JPanel p1;
	JMenuBar menuber;
	JMenu menu0, menu1, menu2, menu3;
	JMenuItem item11, item12, item13, item14, item21, item22 ,item23 ,item24 ,item25 ,item31 ,item32 ,item33 ,item34 ,item35;
	ImageIcon icon1, icon2, icon3;
	JLabel l1, l2, l3;
	JButton b1, b2, b3;
	
	//��ܵĴ�С
	Dimension faceSize = new Dimension(1500,1000);
	//����ͼ��
	ImageIcon icon;

	//����Jtree�˵�
	JTree tree;
	DefaultMutableTreeNode root;  //���¹���ϵͳ
	DefaultMutableTreeNode node1; //��Ա������Ϣά��
	DefaultMutableTreeNode node2; //������Ϣ����
	DefaultMutableTreeNode node3; //��Ա��������
	DefaultMutableTreeNode leafnode;
	TreePath treePath;

	//���������
	public static JSplitPane splitPane;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JLabel welcome = new JLabel();
	JScrollPane scrollPane;

	/**
	 * �����ʼ������
	 */
	 public MyAdminUse() {
		 
		this.setBounds(150,20,1500,1000);
		 
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);

		//��ӿ�ܵĹر��¼�����
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.pack();
		//���ÿ�ܵĴ�С
		this.setSize(faceSize);
		//���ñ���
		this.setTitle("admin");
		//����ͼ��
		icon = new ImageIcon("img/log/logo.png");
		this.setIconImage(icon.getImage());//���ó���ͼ��*/
		//�����Զ����С
		this.setResizable(false);

		try {	
			Init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����ʼ������
	 */
	private void Init() throws Exception {

		//���Jtree�˵�
		root = new DefaultMutableTreeNode("����ϵͳ");
		node1 = new DefaultMutableTreeNode("�û�����");
		node2 = new DefaultMutableTreeNode("���Թ���");
		node3 = new DefaultMutableTreeNode("������");
		//�û�����
		root.add(node1);
		leafnode = new DefaultMutableTreeNode("�鿴�û���Ϣ");
		node1.add(leafnode);
		leafnode = new DefaultMutableTreeNode("�޸��û���Ϣ");
		node1.add(leafnode);
		leafnode = new DefaultMutableTreeNode("ɾ���û���Ϣ");
		node1.add(leafnode);
		//���Թ���
		root.add(node2);
		leafnode = new DefaultMutableTreeNode("�鿴����");
		node2.add(leafnode);
		leafnode = new DefaultMutableTreeNode("�޸Ŀ���");
		node2.add(leafnode);
		leafnode = new DefaultMutableTreeNode("ɾ������");
		node2.add(leafnode);
		leafnode = new DefaultMutableTreeNode("��ӿ���");
		node2.add(leafnode);
		//������
		root.add(node3);
		leafnode = new DefaultMutableTreeNode("�鿴��Ŀ");
		node3.add(leafnode);
		leafnode = new DefaultMutableTreeNode("�޸���Ŀ");
		node3.add(leafnode);
		leafnode = new DefaultMutableTreeNode("ɾ����Ŀ");
		node3.add(leafnode);
		leafnode = new DefaultMutableTreeNode("�����Ŀ");
		node3.add(leafnode);
		//��������JTree
		tree = new JTree(root);
		scrollPane = new JScrollPane(tree);
		scrollPane.setPreferredSize(new Dimension(200,940));
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		//����JPanel
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel1.add(scrollPane);
		welcome.setText("��ӭʹ��xx����ϵͳ");
		welcome.setFont(new Font("",1,20));
		panel3.add(welcome);
		
		//����JSplitPane�����ò���
		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(false);
		splitPane.setContinuousLayout(true);
		splitPane.setPreferredSize(new Dimension(150, 380));
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(panel1);
		splitPane.setRightComponent(panel3);
		splitPane.setDividerSize(2);
		splitPane.setDividerLocation(161);
		//����������
		this.setContentPane(splitPane);
		this.setVisible(true);

		//����¼�����
		tree.addTreeSelectionListener(this);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {

	}
	
	/**
	 * JTree�¼�����
	 */
	public void valueChanged(TreeSelectionEvent tse) {
		DefaultMutableTreeNode dnode = 
			(DefaultMutableTreeNode)tse.getPath().getLastPathComponent();
		String node_str = dnode.toString();
		if (node_str == "���Թ���ϵͳ") { 
			splitPane.setRightComponent(panel3);
		}
		//��Ա������Ϣ������
		else if (node_str == "�û�����") { 
			//��ѡ�к�չ����ر�Ҷ�ӽڵ�
			treePath = new TreePath(node1.getPath());
			if(tree.isExpanded(treePath))
				tree.collapsePath(treePath);
			else
				tree.expandPath(treePath);
		}
		else if (node_str == "�鿴�û���Ϣ") { 
			MyAdminUseAll node11Panel = new MyAdminUseAll();
			splitPane.setRightComponent(node11Panel);
		}
		else if (node_str == "�޸��û���Ϣ") { 
			MyAdminUseRe node12Panel = new MyAdminUseRe();
			splitPane.setRightComponent(node12Panel);
		}
		else if (node_str == "ɾ���û���Ϣ") { 
			MyAdminUseDle node13Panel = new MyAdminUseDle();
			splitPane.setRightComponent(node13Panel);
		}
		//��Ա����������
		else if (node_str == "���Թ���") { 
			//��ѡ�к�չ����ر�Ҷ�ӽڵ�
			treePath = new TreePath(node2.getPath());
			if(tree.isExpanded(treePath))
				tree.collapsePath(treePath);
			else
				tree.expandPath(treePath);
		}
		else if (node_str == "�鿴����") { 
			MyAdminKsAll node21Panel = new MyAdminKsAll();
			splitPane.setRightComponent(node21Panel);
		}
		else if (node_str == "�޸Ŀ���") { 
			MyAdminKsRe node22Panel = new MyAdminKsRe();
			splitPane.setRightComponent(node22Panel);
		}
		else if (node_str == "ɾ������") { 
			MyAdminKsDle node22Panel = new MyAdminKsDle();
			splitPane.setRightComponent(node22Panel);
		}
		else if (node_str == "��ӿ���") { 
			MyAdminKsAdd node22Panel = new MyAdminKsAdd();
			splitPane.setRightComponent(node22Panel);
		}
		//��Ա���˹�����
		else if (node_str == "������") {
			//��ѡ�к�չ����ر�Ҷ�ӽڵ�
			treePath = new TreePath(node3.getPath());
			if(tree.isExpanded(treePath))
				tree.collapsePath(treePath);
			else
				tree.expandPath(treePath);
		}
		else if (node_str == "�鿴��Ŀ") { 
			MyAdminTmAll node31Panel = new MyAdminTmAll();
			splitPane.setRightComponent(node31Panel);
		}
		else if (node_str == "�޸���Ŀ") { 
			MyAdminTmRe node32Panel = new MyAdminTmRe();
			splitPane.setRightComponent(node32Panel);
		}
		else if (node_str == "ɾ����Ŀ") { 
			MyAdminTmDle node32Panel = new MyAdminTmDle();
			splitPane.setRightComponent(node32Panel);
		}
		else if (node_str == "�����Ŀ") { 
			MyAdminTmAdd node32Panel = new MyAdminTmAdd();
			splitPane.setRightComponent(node32Panel);
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
		new MyAdminUse();
	}
}

