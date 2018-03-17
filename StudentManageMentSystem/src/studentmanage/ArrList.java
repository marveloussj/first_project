package studentmanage;

import java.util.ArrayList;
import java.util.Scanner;

import excel.excel;

public class ArrList {
	public static void main(String[] args) {
		String id;
		String name;
		String idd;
		boolean flag = false;
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			flag = false;
			System.out.println("\n请选择：");
			System.out.println("1.增加一个学生");
			System.out.println("2.删除一个学生");
			System.out.println("3.输入学生成绩");
			System.out.println("5.显示学生信息");
			System.out.println("9.退出");
			String xz = sc.nextLine();
			if (xz.equals("1")) {
//				System.out.println("建立一个学生对象，并加入到班级中");
//				System.out.println("请输入学号、姓名：");
//				id = sc.nextLine();
//				name = sc.nextLine();
				excel.insert();

			}
			if (xz.equals("2")) {
				System.out.println("输入要删除的学生学号：");
				String ii = sc.nextLine();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getId().equals(ii)) {
						list.remove(i);
						System.out.println("删除成功！");
						flag = true;
					}
				}
				if (!flag)
					System.out.println("未找到该学生！");

			}
			if (xz.equals("3")) {
				System.out.println("输入要添加成绩的学生学号：");
				String ii = sc.nextLine();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getId().equals(ii)) {
						System.out.println("依次输入学生数学，语文，总成绩：");
						int math = sc.nextInt();
						int Chinese = sc.nextInt();
						int totalscore = sc.nextInt();
						list.get(i).setMath(math);
						list.get(i).setChinese(Chinese);
						list.get(i).setTotalscore(totalscore);
						flag = true;
					}
				}
				if (!flag)
					System.out.println("未找到该学生！");
			}
			if (xz.equals("5")) {
				for (Student student : list) {
					System.out.println(student);

				}
			}
			if (xz.equals("9")) {
				break;
			}
		}

	}
}
