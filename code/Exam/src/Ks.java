
public class Ks {
	private int id;  //���Ա��
	private double man; //���ֶ���
	private String ause; //������
	private int num; //��Ŀ����
	private int per; //�ο�����
	
	public Ks(int id, double man, String ause, int num, int per) {
		super();
		this.id = id;
		this.man = man;
		this.ause = ause;
		this.num = num;
		this.per = per;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMan() {
		return man;
	}

	public void setMan(double man) {
		this.man = man;
	}

	public String getUse() {
		return ause;
	}

	public void setUse(String ause) {
		this.ause = ause;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPer() {
		return per;
	}

	public void setPer(int per) {
		this.per = per;
	}
}
