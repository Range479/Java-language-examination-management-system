
public class Tm {
	
	private int id;  //题号
	private String name; //题目
	private String ms; //描述
	private int tr; //正确次数
	private int fl; //错误次数
	private String a; //a选项
	private String b; //b选项
	private String c; //c选项
	private String d; //d选项
	private int da; //正确答案 0-A 1-B 2-C 3-D
	
	public Tm(int id, String name, String ms, int tr, int fl, String a, String b, String c, String d, int da) {
		super();
		this.id = id;
		this.name = name;
		this.ms = ms;
		this.tr = tr;
		this.fl = fl;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.da = da;
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
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getFl() {
		return fl;
	}
	public void setFl(int fl) {
		this.fl = fl;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public int getDa() {
		return da;
	}
	public void setDa(int da) {
		this.da = da;
	}
	
	
	
}
