
public class Ks {
	private int id;  //考试编号
	private double man; //满分多少
	private String ause; //出题人
	private int num; //题目数量
	private int per; //参考人数
	
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
