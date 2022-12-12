import java.util.Scanner;

class Student {
	private int rollNo;
	private String name;
	private int age;

	public void setData(int rollNo, String name, int age) {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}

	public int getrollNo() {
		return rollNo;
	}

	public String getname() {
		return name;
	}

	public int getage() {
		return age;
	}
}

class ArrayList {
	private Student studentList[] = new Student[3];
	int count = 0;

	public void add(Student student) {
		studentList[count++] = student;
	}

	public void update(Student student, int number) {
		studentList[number - 1] = student;
	}

	public void delete(int rollNo) {
		studentList[rollNo - 1] = null;
	}

	public void viewAll() {
		for (int i = 0; i < count; i++) {
			if (studentList[i] != null) {
				System.out.print(studentList[i].getrollNo() + " ");
				System.out.print(studentList[i].getname() + " ");
				System.out.print(studentList[i].getage() + " ");
				System.out.println();
			}
		}
	}

	public void viewByRollNo(int rollNo) {
		System.out.print(studentList[rollNo - 1].getrollNo() + " ");
		System.out.print(studentList[rollNo - 1].getname() + " ");
		System.out.print(studentList[rollNo - 1].getage() + " ");
		System.out.println();
	}
}

public class Program1 {
	public static int strength;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList list = new ArrayList();
		System.out.println("Enter the Students Strength");
		strength = scanner.nextInt();
		Student student = new Student();
		for (int i = 0; i < strength; i++) {
			student = new Student();
			System.out.println("Enter the Student Roll number,Name and Age");
			student.setData(scanner.nextInt(), scanner.next(),
					scanner.nextInt());
			list.add(student);
		}
		list.viewAll();
		System.out
				.println("Enter the student roll number for that student details ");
		list.viewByRollNo(scanner.nextInt());
		System.out
				.println("Enter the student roll number for update that student details");
		int number = scanner.nextInt();
		System.out.println("Enter that Student Name and Age");
		Student studentUpdate = new Student();
		studentUpdate.setData(number, scanner.next(), scanner.nextInt());
		list.update(studentUpdate, number);
		System.out.println("Enter which student's details to be delete");
		list.delete(scanner.nextInt());
		list.viewAll();
	}
}