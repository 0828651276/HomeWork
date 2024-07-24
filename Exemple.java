import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    String Id;
    String Name;
    String Classname;
    double Point;

    Student(String Id, String Name, String Classname, double Point) {
        this.Id = Id;
        this.Name = Name;
        this.Classname = Classname;
        this.Point = Point;
    }

    @Override
    public String toString() {
        return "HocVien [maSo=" + Id + ", ten=" + Name + ", lop=" + Classname + ", diem=" + Point + "]";
    }
}

class Tutor {
    String Id;
    String Name;

    Tutor(String Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "GiangVien [maSo=" + Id + ", ten=" + Name + "]";
    }
}

public class Exemple {
    static ArrayList<Student> ListStudent = new ArrayList<>();
    static ArrayList<Tutor> ListTutor = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Thêm học viên");
            System.out.println("2. Sửa học viên");
            System.out.println("3. Xóa học viên");
            System.out.println("4. Sắp xếp học viên theo điểm");
            System.out.println("5. Thêm giảng viên");
            System.out.println("6. Sửa giảng viên");
            System.out.println("7. Xóa giảng viên");
            System.out.println("8. Sắp xếp giảng viên theo tên");
            System.out.println("9. Hiển thị danh sách học viên");
            System.out.println("10. Hiển thị danh sách giảng viên");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deletStudent();
                    break;
                case 4:
                    sortStudent();
                    break;
                case 5:
                    addTutor();
                    break;
                case 6:
                    editTutor();
                    break;
                case 7:
                    deletTutor();
                    break;
                case 8:
                    sortTutor();
                    break;
                case 9:
                    alertList();
                    break;
                case 10:
                    alertListTutor();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void addStudent() {
        System.out.print("Nhập mã số: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập lớp: ");
        String lop = scanner.nextLine();
        System.out.print("Nhập điểm: ");
        double diem = scanner.nextDouble();
        scanner.nextLine();
        ListStudent.add(new Student(maSo, ten, lop, diem));
    }

    public static void editStudent() {
        System.out.print("Nhập mã số học viên cần sửa: ");
        String maSo = scanner.nextLine();
        for (Student hv : ListStudent) {
            if (hv.Id.equals(maSo)) {
                System.out.print("Nhập tên mới: ");
                hv.Name = scanner.nextLine();
                System.out.print("Nhập lớp mới: ");
                hv.Classname = scanner.nextLine();
                System.out.print("Nhập điểm mới: ");
                hv.Point = scanner.nextDouble();
                scanner.nextLine();
                return;
            }
        }
        System.out.println("Không tìm thấy học viên với mã số " + maSo);
    }

    public static void deletStudent() {
        System.out.print("Nhập mã số học viên cần xóa: ");
        String maSo = scanner.nextLine();
        ListStudent.removeIf(hv -> hv.Id.equals(maSo));
    }

    public static void sortStudent() {
        Collections.sort(ListStudent, Comparator.comparingDouble(hv -> hv.Point));
    }

    public static void addTutor() {
        System.out.print("Nhập mã số: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine();
        ListTutor.add(new Tutor(maSo, ten));
    }

    public static void editTutor() {
        System.out.print("Nhập mã số giảng viên cần sửa: ");
        String maSo = scanner.nextLine();
        for (Tutor gv : ListTutor) {
            if (gv.Id.equals(maSo)) {
                System.out.print("Nhập tên mới: ");
                gv.Name = scanner.nextLine();
                return;
            }
        }
        System.out.println("Không tìm thấy giảng viên với mã số " + maSo);
    }

    public static void deletTutor() {
        System.out.print("Nhập mã số giảng viên cần xóa: ");
        String maSo = scanner.nextLine();
        ListTutor.removeIf(gv -> gv.Id.equals(maSo));
    }

    public static void sortTutor() {
        Collections.sort(ListTutor, Comparator.comparing(gv -> gv.Name));
    }

    public static void alertList() {
        for (Student hv : ListStudent) {
            System.out.println(hv);
        }
    }

    public static void alertListTutor() {
        for (Tutor gv : ListTutor) {
            System.out.println(gv);
        }
    }
}

