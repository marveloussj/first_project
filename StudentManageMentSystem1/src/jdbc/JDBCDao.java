package jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * 
 * @author sj
 *
 */
public class JDBCDao {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	//显示指定学生信息
	public static void Query(String index) {
		con = JDBCUtil.getmysqlcon();
		try {
			ps = con.prepareStatement("select *from students where xuehao=?");
			ps.setObject(1, index);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("id:" +rs.getObject("id") + "--学号:" + rs.getObject("xuehao") + "--姓名:" + rs.getObject("name")
						+ "--语文:" + rs.getObject("chinese") + "--数学:" + rs.getObject("math") + "--总分:"
						+ rs.getObject("totals"));
			} else {
				System.out.println("未找到该学生！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.Close(rs, ps, con);
	}
	//显示所有学生信息
	public static void Queryall() {
		con = JDBCUtil.getmysqlcon();
		try {
			ps = con.prepareStatement("select *from students ");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getObject("id") + "--" + rs.getObject("xuehao") + "--" + rs.getObject("name")
						+ "--" + rs.getObject("chinese") + "--" + rs.getObject("math") + "--"
						+ rs.getObject("totals"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.Close(rs, ps, con);
	}
	//输入学生成绩
	public static int updatescore(int chinese, int math, int totals, String index) {
		int execute = 0;
		con = JDBCUtil.getmysqlcon();
		try {
			ps = con.prepareStatement("update students set chinese=?,math=?,totals=? where xuehao=?");
			ps.setObject(1, chinese);
			ps.setObject(2, math);
			ps.setObject(3, totals);
			ps.setObject(4, index);
			execute = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.Close(ps, con);
		return execute;
	}
	//更新学生信息
	public static int update(String xh, String xm,  String index) {
		int execute = 0;
		con = JDBCUtil.getmysqlcon();
		try {
			ps = con.prepareStatement("update students set xuehao=?,name=? where xuehao=?");
			ps.setObject(1, xh);
			ps.setObject(2, xm);
			ps.setObject(3, index);
			execute = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.Close(ps, con);
		return execute;
	}
	//删除一个学生
	public static int delete(String index) {
		con = JDBCUtil.getmysqlcon();
		int execute = 0;
		try {
			ps = con.prepareStatement("delete from students  where xuehao=?");
			ps.setObject(1, index);
			execute = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.Close(ps, con);
		return execute;
	}
	//增加一个学生
	public static int insert(String xh, String xm) {
		con = JDBCUtil.getmysqlcon();
		int execute = 0;
		try {
			ps = con.prepareStatement("insert into students (xuehao,name) values(?,?)");
			ps.setObject(1, xh);
			ps.setObject(2, xm);
			execute = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.Close(ps, con);
		return execute;
	}
	//从Excel文件中批量导入个学生
	public static void ExcelInsert() {
		con=JDBCUtil.getmysqlcon();
		Workbook book=null;
			try {
				book = Workbook.getWorkbook(new  File( JDBCUtil.ExcelUrl() ));
			} catch (BiffException e1) {
				System.out.println("未找到该文件");
			} catch (IOException e1) {
				System.out.println("未找到该文件");
			}
		try {
			 Sheet sheet  =  book.getSheet( 0 );
			for(int i=0; i<=56;i++){ 
			ps=con.prepareStatement("insert into students (xuehao,name) values(?,?)");
			Cell cell3 = sheet.getCell(1,i); 
			String xh = cell3.getContents();
			ps.setObject(1,xh);
			Cell cell2 = sheet.getCell(2,i);
			String xm = cell2.getContents();
			ps.setObject(2,xm);
			ps.execute();
			}
			JDBCUtil.Close(ps,con);
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		JDBCUtil.Close(ps,con);
	}

}