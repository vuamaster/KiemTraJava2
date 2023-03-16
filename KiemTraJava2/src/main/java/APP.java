import dao.StudentDAO;
import model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class APP {
    private static StudentDAO studentDAO= new StudentDAO();
    private static void mainMenu() {
        System.out.println("------ QUẢN LÝ THÔNG TIN SINH VIÊN --------");
        System.out.println("1. Danh sách SINH viên theo bảng");
        System.out.println("2. Nhập một sinh viên mới ");
        System.out.println("3. Xóa một sinh viên mã");
        System.out.println("4. Câp nhật thông tin sinh viên");
        System.out.println("5. Tìm kiếm một sinh viên theo mã hoặc họ tên");
        System.out.println("6. Sắp xếp sinh viên theo điểm GPA tăng dần");
        System.out.println("7. in ra tất cả sinh viên nữ ở hà nội và có GPA > 2.5");
        System.out.println("8. sắp xếp sinh viên theo họ tên");
        System.out.println("9. thoát");
    }
    private static void option1() {
        List<Student> studentList = studentDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.printf("%-20s %-20s %-20d %-20s\n", s.getId(), s.getFullName(), s.getGender(), s.getAddress());
        };
    }
    public static void option2(Scanner in){
        Student tmp = new Student();
        System.out.print("nhập mã: ");
        tmp.setId(in.nextLine());
        System.out.print("nhập tên: ");
        tmp.setFullName(in.nextLine());
        System.out.print("nhập địa chỉ: ");
        tmp.setAddress(in.nextLine());
        System.out.print("nhập ngày sinh: ");
        tmp.setBirthDay(in.nextLine());
        System.out.print("nhập email: ");
        tmp.setEmail(in.nextLine());
        System.out.print("nhập phone: ");
        tmp.setPhone(in.nextLine());
        System.out.print("Nhập gới tính: nữ nhập 0, Nam nhập 1 : ");
        tmp.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập điểm GPA: ");
        tmp.setDiemGPA(Double.parseDouble(in.nextLine()));
        studentDAO.insert(tmp);
    }
    public static void option4(Scanner in){
        System.out.print("nhập id sinh viên muốn cập nhật : ");
        String id = in.nextLine();
        Student tmp = new Student();
        System.out.print("nhập tên: ");
        tmp.setFullName(in.nextLine());
        System.out.print("nhập địa chỉ: ");
        tmp.setAddress(in.nextLine());
        System.out.print("nhập ngày sinh: ");
        tmp.setBirthDay(in.nextLine());
        System.out.print("nhập email: ");
        tmp.setEmail(in.nextLine());
        System.out.print("nhập phone: ");
        tmp.setPhone(in.nextLine());
        System.out.print("Nhập gới tính: nữ nhập 0, Nam nhập 1 : ");
        tmp.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập điểm GPA: ");
        tmp.setDiemGPA(Double.parseDouble(in.nextLine()));
        studentDAO.update(tmp,id);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            try {
                option = Integer.parseInt(in.nextLine());
            }
            catch (Exception ex){
                System.out.println("Nhập sai định dạng!");
                continue;
            }
            if (option < 1 || option > 9) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    System.out.print("Nhập id sinh viên cần xóa : ");
                    String id = in.nextLine();
                    studentDAO.delete(id);
                    break;
                case 4:
                    option4(in);
                    break;
                case 5:
                    System.out.print("Nhập id sinh viên muôn tìm : ");
                    String id1 = in.nextLine();
                    Student student= studentDAO.getBuyId(id1);
                    System.out.println(student);
                    break;
                case 6:
                    List<Student> studentList = studentDAO.getAll();
                    studentList.stream()
                            .sorted()
                            .forEach(student1 -> System.out.println(student1));
                    break;
                case 7:
                    List<Student> studentList1 =studentDAO.getAll();
                    studentList1.stream()
                            .filter(student1 -> student1.getGender()==0 && student1.getDiemGPA()>2.5 && student1.getAddress().contains("HN") )
                            .forEach(student1 -> System.out.println(student1));
                    break;
                case 8:
                    List<Student> studentList2 = studentDAO.getAll();
                    studentList2.stream()
                            .sorted(((o1, o2) -> o1.getFullName().compareTo(o2.getFullName())))
                            .forEach(student1 -> System.out.println(student1));
                    break;
                case 9:
                    break;
            }

        }
        while (option != 9);
        in.close();

    }
}
