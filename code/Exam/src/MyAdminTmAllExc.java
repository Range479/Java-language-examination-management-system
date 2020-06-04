import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
 
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
 
public class MyAdminTmAllExc {
	private static final int ID_INDEX = 0;
	private static final int NAME_INDEX = 1;
	private static final int MS_INDEX = 2;
	private static final int TR_INDEX = 3;
	private static final int FL_INDEX = 4;
	private static final int A_INDEX = 5;
	private static final int B_INDEX = 6;
	private static final int C_INDEX = 7;
	private static final int D_INDEX = 8;
	private static final int DA_INDEX = 9;
	
	private WritableCellFormat format;
	LinkedList<Tm> list;
	TmCon bean = new TmCon();
	
	public MyAdminTmAllExc() {
		list = bean.findAll();
		format = new WritableCellFormat(WritableWorkbook.ARIAL_10_PT);
		try {
			format.setWrap(true);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new MyAdminTmAllExc().generateReport();
	}
	
	public void generateReport() throws Exception {
		// 打开 workbook
		WritableWorkbook workbook = Workbook.createWorkbook(new File("xls/tm.xls"));
		
		// 创建 Sheet
		WritableSheet reportSheet = workbook.createSheet("report", 0);
		
		// 设置列宽
		setColumnWidth(reportSheet);
		
		// 设置标题
		int row = 0;
		setTitle(reportSheet, row++);
		
		// 设置每行
		List<Employe> employees = getDataFromDB();
		for (Employe employee : employees) {
			setRow(reportSheet, row++, employee);
		}
		
		// 关闭 workbook
		workbook.write();
		workbook.close();
	}
	
	private void setColumnWidth(WritableSheet sheet) {
		sheet.setColumnView(ID_INDEX, 7);
		sheet.setColumnView(NAME_INDEX, 20);
		sheet.setColumnView(MS_INDEX, 45);
		sheet.setColumnView(TR_INDEX, 10);
		sheet.setColumnView(FL_INDEX, 10);
		sheet.setColumnView(A_INDEX, 15);
		sheet.setColumnView(B_INDEX, 15);
		sheet.setColumnView(C_INDEX, 15);
		sheet.setColumnView(D_INDEX, 15);
		sheet.setColumnView(DA_INDEX, 10);
	}
 
	private void setTitle(WritableSheet sheet, int row) throws Exception {
		sheet.addCell(new Label(ID_INDEX, row, "题号", format));
		sheet.addCell(new Label(NAME_INDEX, row, "题目", format));
		sheet.addCell(new Label(MS_INDEX, row, "描述", format));
		sheet.addCell(new Label(TR_INDEX, row, "正确次数", format));
		sheet.addCell(new Label(FL_INDEX, row, "错误次数", format));
		sheet.addCell(new Label(A_INDEX, row, "A", format));
		sheet.addCell(new Label(B_INDEX, row, "B", format));
		sheet.addCell(new Label(C_INDEX, row, "C", format));
		sheet.addCell(new Label(D_INDEX, row, "D", format));
		sheet.addCell(new Label(DA_INDEX, row, "正确选项", format));
	}
	
	private void setRow(WritableSheet sheet, int row, Employe employee) throws Exception {
		sheet.addCell(new jxl.write.Number(ID_INDEX, row, employee.getId(), format));
		sheet.addCell(new Label(NAME_INDEX, row, employee.getName(), format));
		sheet.addCell(new Label(MS_INDEX, row, employee.getMs(), format));
		sheet.addCell(new jxl.write.Number(TR_INDEX, row, employee.getTr(), format));
		sheet.addCell(new jxl.write.Number(FL_INDEX, row, employee.getFl(), format));
		sheet.addCell(new Label(A_INDEX, row, employee.getA(), format));
		sheet.addCell(new Label(B_INDEX, row, employee.getB(), format));
		sheet.addCell(new Label(C_INDEX, row, employee.getC(), format));
		sheet.addCell(new Label(D_INDEX, row, employee.getD(), format));
		sheet.addCell(new Label(DA_INDEX, row, employee.getDa(), format));
	}
 
	private List<Employe> getDataFromDB () {
		List<Employe> r = new ArrayList<Employe>();
		Tm tm;
		String ss = null;
		for(int i = 0;i < list.size(); i++)
		{
			tm = list.get(i);
			if(tm.getDa() == 1) ss = "A";
			else if(tm.getDa() == 2) ss = "B";
			else if(tm.getDa() == 3) ss = "C";
			else if(tm.getDa() == 4) ss = "D";
			r.add(new Employe(tm.getId(), tm.getName(), tm.getMs(), tm.getTr(), tm.getFl(), tm.getA(), tm.getB(), tm.getC(), tm.getD(), ss));
		}
		
		return r;
	}
}
 
// Javabean
class Employe implements Serializable {
	private static final long serialVersionUID = 7445838103191670245L;
 
	private int id;  //题号
	private String name; //题目
	private String ms; //描述
	private int tr; //正确次数
	private int fl; //错误次数
	private String a; //a选项
	private String b; //b选项
	private String c; //c选项
	private String d; //d选项
	private String da; //正确答案
	
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
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}

	public Employe() {
	}
	
	public Employe(int id, String name, String ms, int tr, int fl, String a, String b, String c, String d, String da) {
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
}