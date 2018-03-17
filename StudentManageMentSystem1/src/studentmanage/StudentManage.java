package studentmanage;

import java.util.Scanner;
import jdbc.JDBCDao;
/**
 * 
 * @author sj
 *
 */
public class StudentManage {
	public static void main(String[] args) {
		int f = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n请选择：");
			System.out.println("1.从Excel文件中批量导入个学生");
			System.out.println("2.增加一个学生");
			System.out.println("3.删除一个学生");
			System.out.println("4.输入学生成绩");
			System.out.println("5.更新学生信息");
			System.out.println("6.显示指定学生信息");
			System.out.println("7.显示所有学生信息");
			System.out.println("9.退出");
			String xz = sc.nextLine();
			if (xz.equals("1")) {
				 JDBCDao.ExcelInsert();
				System.out.println("批量导入学生成功");
			}
			if (xz.equals("2")) {
				System.out.println("输入要插入学生学号：");
				String xh = sc.nextLine();
				System.out.println("输入要插入学生姓名：");
				String xm = sc.nextLine();
				f = JDBCDao.insert(xh, xm);
				if (f > 0)
					System.out.println("新增" + xh + "成功！");
				else
					System.out.println("新增学生失败！");
			}
			if (xz.equals("3")) {
				System.out.println("输入要删除的学生学号：");
				String index = sc.nextLine();
				f = JDBCDao.delete(index);
				if (f > 0)
					System.out.println("删除" + index + "成功！");
				else
					System.out.println("未找到该学生！");

			}
			if (xz.equals("4")) {
				System.out.println("输入要添加成绩的学生学号：");
				String index = sc.nextLine();
				System.out.println("依次输入学生数学，语文成绩：");
				int math = sc.nextInt();
				int chinese = sc.nextInt();
				int totalscore = chinese + math;
				f = JDBCDao.updatescore(chinese, math, totalscore, index);
				if (f > 0)
					System.out.println("插入成绩成功");
				else
					System.out.println("未找到该学生！");
			}
			if (xz.equals("5")) {
				System.out.println("输入要修改信息的学生学号：");
				String index = sc.nextLine();
				System.out.println("依次输入学生学号，姓名：");
				String xh = sc.nextLine();
				String xm = sc.nextLine();
				f = JDBCDao.update(xh, xm,index);
				if (f > 0)
					System.out.println("修改该学生信息成功");
				else
					System.out.println("未找到该学生！");
			}
			if (xz.equals("6")) {
				System.out.println("输入要查成绩的学生学号：");
				String index = sc.nextLine();
				JDBCDao.Query(index);
			}
			if (xz.equals("7")) {
				JDBCDao.Queryall();
			}
			if (xz.equals("9")) {
				break;
			}
		}

	}
}
