import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.net.*;

/**
 * 人事管理系统主界面
 */
public class MyAdminUse extends JFrame implements ActionListener,TreeSelectionListener{
	
	//菜单条
	JPanel p1;
	JMenuBar menuber;
	JMenu menu0, menu1, menu2, menu3;
	JMenuItem item11, item12, item13, item14, item21, item22 ,item23 ,item24 ,item25 ,item31 ,item32 ,item33 ,item34 ,item35;
	ImageIcon icon1, icon2, icon3;
	JLabel l1, l2, l3;
	JButton b1, b2, b3;
	
	//框架的大小
	Dimension faceSize = new Dimension(1500,1000);
	//程序图标
	ImageIcon icon;

	//建立Jtree菜单
	JTree tree;
	DefaultMutableTreeNode root;  //人事管理系统
	DefaultMutableTreeNode node1; //人员基本信息维护
	DefaultMutableTreeNode node2; //部门信息管理
	DefaultMutableTreeNode node3; //人员调动管理
	DefaultMutableTreeNode leafnode;
	TreePath treePath;

	//主界面面板
	public static JSplitPane splitPane;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JLabel welcome = new JLabel();
	JScrollPane scrollPane;

	/**
	 * 程序初始化函数
	 */
	 public MyAdminUse() {
		 
		this.setBounds(150,20,1500,1000);
		 
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);

		//添加框架的关闭事件处理
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.pack();
		//设置框架的大小
		this.setSize(faceSize);
		//设置标题
		this.setTitle("admin");
		//程序图标
		icon = new ImageIcon("img/log/logo.png");
		this.setIconImage(icon.getImage());//设置程序图标*/
		//设置自定义大小
		this.setResizable(false);

		try {	
			Init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 程序初始化函数
	 */
	private void Init() throws Exception {

		//添加Jtree菜单
		root = new DefaultMutableTreeNode("考试系统");
		node1 = new DefaultMutableTreeNode("用户管理");
		node2 = new DefaultMutableTreeNode("考试管理");
		node3 = new DefaultMutableTreeNode("题库管理");
		//用户管理
		root.add(node1);
		leafnode = new DefaultMutableTreeNode("查看用户信息");
		node1.add(leafnode);
		leafnode = new DefaultMutableTreeNode("修改用户信息");
		node1.add(leafnode);
		leafnode = new DefaultMutableTreeNode("删除用户信息");
		node1.add(leafnode);
		//考试管理
		root.add(node2);
		leafnode = new DefaultMutableTreeNode("查看考试");
		node2.add(leafnode);
		leafnode = new DefaultMutableTreeNode("修改考试");
		node2.add(leafnode);
		leafnode = new DefaultMutableTreeNode("删除考试");
		node2.add(leafnode);
		leafnode = new DefaultMutableTreeNode("添加考试");
		node2.add(leafnode);
		//题库管理
		root.add(node3);
		leafnode = new DefaultMutableTreeNode("查看题目");
		node3.add(leafnode);
		leafnode = new DefaultMutableTreeNode("修改题目");
		node3.add(leafnode);
		leafnode = new DefaultMutableTreeNode("删除题目");
		node3.add(leafnode);
		leafnode = new DefaultMutableTreeNode("添加题目");
		node3.add(leafnode);
		//生成左侧的JTree
		tree = new JTree(root);
		scrollPane = new JScrollPane(tree);
		scrollPane.setPreferredSize(new Dimension(200,940));
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		//生成JPanel
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel1.add(scrollPane);
		welcome.setText("欢迎使用xx考试系统");
		welcome.setFont(new Font("",1,20));
		panel3.add(welcome);
		
		//生成JSplitPane并设置参数
		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(false);
		splitPane.setContinuousLayout(true);
		splitPane.setPreferredSize(new Dimension(150, 380));
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(panel1);
		splitPane.setRightComponent(panel3);
		splitPane.setDividerSize(2);
		splitPane.setDividerLocation(161);
		//生成主界面
		this.setContentPane(splitPane);
		this.setVisible(true);

		//添加事件侦听
		tree.addTreeSelectionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {

	}
	
	/**
	 * JTree事件处理
	 */
	public void valueChanged(TreeSelectionEvent tse) {
		DefaultMutableTreeNode dnode = 
			(DefaultMutableTreeNode)tse.getPath().getLastPathComponent();
		String node_str = dnode.toString();
		if (node_str == "考试管理系统") { 
			splitPane.setRightComponent(panel3);
		}
		//人员基本信息管理树
		else if (node_str == "用户管理") { 
			//当选中后展开或关闭叶子节点
			treePath = new TreePath(node1.getPath());
			if(tree.isExpanded(treePath))
				tree.collapsePath(treePath);
			else
				tree.expandPath(treePath);
		}
		else if (node_str == "查看用户信息") { 
			MyAdminUseAll node11Panel = new MyAdminUseAll();
			splitPane.setRightComponent(node11Panel);
		}
		else if (node_str == "修改用户信息") { 
			MyAdminUseRe node12Panel = new MyAdminUseRe();
			splitPane.setRightComponent(node12Panel);
		}
		else if (node_str == "删除用户信息") { 
			MyAdminUseDle node13Panel = new MyAdminUseDle();
			splitPane.setRightComponent(node13Panel);
		}
		//人员调动管理树
		else if (node_str == "考试管理") { 
			//当选中后展开或关闭叶子节点
			treePath = new TreePath(node2.getPath());
			if(tree.isExpanded(treePath))
				tree.collapsePath(treePath);
			else
				tree.expandPath(treePath);
		}
		else if (node_str == "查看考试") { 
			MyAdminKsAll node21Panel = new MyAdminKsAll();
			splitPane.setRightComponent(node21Panel);
		}
		else if (node_str == "修改考试") { 
			MyAdminKsRe node22Panel = new MyAdminKsRe();
			splitPane.setRightComponent(node22Panel);
		}
		else if (node_str == "删除考试") { 
			MyAdminKsDle node22Panel = new MyAdminKsDle();
			splitPane.setRightComponent(node22Panel);
		}
		else if (node_str == "添加考试") { 
			MyAdminKsAdd node22Panel = new MyAdminKsAdd();
			splitPane.setRightComponent(node22Panel);
		}
		//人员考核管理树
		else if (node_str == "题库管理") {
			//当选中后展开或关闭叶子节点
			treePath = new TreePath(node3.getPath());
			if(tree.isExpanded(treePath))
				tree.collapsePath(treePath);
			else
				tree.expandPath(treePath);
		}
		else if (node_str == "查看题目") { 
			MyAdminTmAll node31Panel = new MyAdminTmAll();
			splitPane.setRightComponent(node31Panel);
		}
		else if (node_str == "修改题目") { 
			MyAdminTmRe node32Panel = new MyAdminTmRe();
			splitPane.setRightComponent(node32Panel);
		}
		else if (node_str == "删除题目") { 
			MyAdminTmDle node32Panel = new MyAdminTmDle();
			splitPane.setRightComponent(node32Panel);
		}
		else if (node_str == "添加题目") { 
			MyAdminTmAdd node32Panel = new MyAdminTmAdd();
			splitPane.setRightComponent(node32Panel);
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
		new MyAdminUse();
	}
}

