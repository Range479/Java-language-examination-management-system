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
 
public class MyAdminUseAllExc {
	private static final int ID_INDEX = 0;
	private static final int NAME_INDEX = 1;
	private static final int PAS_INDEX = 2;
	private static final int USE_INDEX = 3;
	
	private WritableCellFormat format;
	LinkedList<stu> list;
	StuCon bean = new StuCon();
	
	public MyAdminUseAllExc() {
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
		new MyAdminUseAllExc().generateReport();
	}
	
	public void generateReport() throws Exception {
		// 打开 workbook
		WritableWorkbook workbook = Workbook.createWorkbook(new File("xls/stu.xls"));
		
		// 创建 Sheet
		WritableSheet reportSheet = workbook.createSheet("report", 0);
		
		// 设置列宽
		setColumnWidth(reportSheet);
		
		// 设置标题
		int row = 0;
		setTitle(reportSheet, row++);
		
		// 设置每行
		List<Emplo> employees = getDataFromDB();
		for (Emplo employee : employees) {
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
	}
 
	private void setTitle(WritableSheet sheet, int row) throws Exception {
		sheet.addCell(new Label(ID_INDEX, row, "学号", format));
		sheet.addCell(new Label(NAME_INDEX, row, "姓名", format));
		sheet.addCell(new Label(PAS_INDEX, row, "密码", format));
		sheet.addCell(new Label(USE_INDEX, row, "身份", format));
	}
	
	private void setRow(WritableSheet sheet, int row, Emplo employee) throws Exception {
		sheet.addCell(new jxl.write.Number(ID_INDEX, row, employee.getID(), format));
		sheet.addCell(new Label(NAME_INDEX, row, employee.getName(), format));
		sheet.addCell(new Label(PAS_INDEX, row, employee.getPas(), format));
		sheet.addCell(new Label(USE_INDEX, row, employee.getUse(), format));
	}
 
	private List<Emplo> getDataFromDB () {
		List<Emplo> r = new ArrayList<Emplo>();
		stu stu;
		String ss;
		for(int i = 0;i < list.size(); i++)
		{
			stu = list.get(i);
			if(stu.getUse() == 1)
				ss = "学生";
			else ss = "老师";
			r.add(new Emplo(stu.getId(), stu.getName(), stu.getPassword(), ss));
		}
		
		return r;
	}
}
 
// Javabean
class Emplo implements Serializable {
	private static final long serialVersionUID = 7445838103191670245L;
 
	private Integer ID;
	private String name;
	private String pas;
	private String use;
 
	
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPas() {
		return pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public Emplo() {
	}
	
	public Emplo(Integer ID, String name, String salary, String address) {
		this.ID = ID;
		this.name = name;
		this.pas = salary;
		this.use = address;
	}
}