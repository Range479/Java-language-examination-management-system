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
 
public class MyAdminKsOneExc {
	private static final int ID_INDEX = 0;
	private static final int NAME_INDEX = 1;
	private static final int PAS_INDEX = 2;
	private static final int USE_INDEX = 3;
	private static final int FOU_INDEX = 4;
	
	private WritableCellFormat format;
	LinkedList<Kstm> list;
	KstmCon bean = new KstmCon();
	int no;
	
	public MyAdminKsOneExc(int no) {
		this.no = no;
		list = bean.findTm(no);
		format = new WritableCellFormat(WritableWorkbook.ARIAL_10_PT);
		try {
			format.setWrap(true);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new MyAdminKsOneExc(1001).generateReport();
	}
	
	public void generateReport() throws Exception {
		// 打开 workbook
		WritableWorkbook workbook = Workbook.createWorkbook(new File("xls/" + "KS" + no +".xls"));
		
		// 创建 Sheet
		WritableSheet reportSheet = workbook.createSheet("report", 0);
		
		// 设置列宽
		setColumnWidth(reportSheet);
		
		// 设置标题
		int row = 0;
		setTitle(reportSheet, row++);
		
		// 设置每行
		List<Employee> employees = getDataFromDB();
		for (Employee employee : employees) {
			setRow(reportSheet, row++, employee);
		}
		
		// 关闭 workbook
		workbook.write();
		workbook.close();
	}
	
	private void setColumnWidth(WritableSheet sheet) {
		sheet.setColumnView(ID_INDEX, 20);
		sheet.setColumnView(NAME_INDEX, 20);
		sheet.setColumnView(PAS_INDEX, 20);
		sheet.setColumnView(USE_INDEX, 20);
		sheet.setColumnView(FOU_INDEX, 20);
	}
 
	private void setTitle(WritableSheet sheet, int row) throws Exception {
		sheet.addCell(new Label(ID_INDEX, row, "题号", format));
		sheet.addCell(new Label(NAME_INDEX, row, "原题号", format));
		sheet.addCell(new Label(PAS_INDEX, row, "分值", format));
		sheet.addCell(new Label(USE_INDEX, row, "正确数", format));
		sheet.addCell(new Label(FOU_INDEX, row, "错误数", format));
	}
	
	private void setRow(WritableSheet sheet, int row, Employee employee) throws Exception {
		sheet.addCell(new jxl.write.Number(ID_INDEX, row, employee.getID(), format));
		sheet.addCell(new jxl.write.Number(NAME_INDEX, row, employee.getName(), format));
		sheet.addCell(new jxl.write.Number(PAS_INDEX, row, employee.getPas(), format));
		sheet.addCell(new jxl.write.Number(USE_INDEX, row, employee.getUse(), format));
		sheet.addCell(new jxl.write.Number(FOU_INDEX, row, employee.getFou(), format));
	}
 
	private List<Employee> getDataFromDB () {
		List<Employee> r = new ArrayList<Employee>();
		Kstm ks;
		String ss;
		for(int i = 0;i < list.size(); i++)
		{
			ks = list.get(i);
			r.add(new Employee(ks.getNo(), ks.getId(), ks.getFen(), ks.getT(), ks.getF()));
		}
		
		return r;
	}
}
 
// Javabean
class Employee implements Serializable {
	private static final long serialVersionUID = 7445838103191670245L;
 
	private Integer ID;
	private Integer name;
	private Double pas;
	private Integer use;
	private Integer fou;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getName() {
		return name;
	}
	public void setName(Integer name) {
		this.name = name;
	}
	public Double getPas() {
		return pas;
	}
	public void setPas(Double pas) {
		this.pas = pas;
	}
	public Integer getUse() {
		return use;
	}
	public void setUse(Integer use) {
		this.use = use;
	}
	public Integer getFou() {
		return fou;
	}
	public void setFou(Integer fou) {
		this.fou = fou;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Employee(Integer iD, Integer name, Double pas, Integer use, Integer fou) {
		super();
		ID = iD;
		this.name = name;
		this.pas = pas;
		this.use = use;
		this.fou = fou;
	}
	
}