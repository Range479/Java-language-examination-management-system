public class stu {
	
	private int id; //�˺�
	private String name; //���� 
	private String password; //����
	private int use;// 1��ѧ�� 2����ʦ
	
	public stu(int id, String name, String password, int use) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.use = use;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUse() {
		return use;
	}
	
	public void setUse(int use) {
		this.use = use;
	}
}
