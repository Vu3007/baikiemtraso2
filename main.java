import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import  java.io.Writer;


public class main {
    public static void main(String[] args) {
        user Users=new user("vu@","11111111");
        convertObjectToJsonFile("user.json",Users);

        List<user>User=new ArrayList<>();

        User.add(new user("vu@gmail","123"));
        User.add(new user("a@gmail","123"));
        User.add(new user("b@gmail","123"));
        convertObjectToJsonFile("list-user.json",User);

    }
    public static void convertObjectToJsonFile(String fileName, Object obj) {
        try {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));

            gson.toJson(obj, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Scanner sc=new Scanner(System.in);
        int option=0;
        boolean test=false;
        while (!test){
            showMenu();
            System.out.println("Nhập lựa chọn: ");
            option=sc.nextInt();
            switch (option){
                case 1: {
                    doFunctionOne();
                    break;
                }
                case 2: {
                    doFunctionTwo();
                    break;
                }
                case 3: {
                    doFunctionThree();
                    break;
                }

                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
            int option1 = 0;
            boolean isQuit = false;

            while (!isQuit) {
                showMenu();

                System.out.print("Nhập lựa chọn : ");
                option = sc.nextInt();

                switch (option) {
                    case 1: {
                        doFunctionOne();
                        break;
                    }
                    case 2: {
                        doFunctionTwo();
                        break;
                    }
                    case 3: {
                        doFunctionThree();
                        break;
                    }
                    case 4: {
                        isQuit = true;
                        break;
                    }
                    default: {
                        System.out.println("Lựa chọn không hợp lệ");
                        break;
                    }
                }
            }
        }

        public static void doFunctionOne() {
        Scanner scanner=new Scanner(System.in);
            System.out.println("Thực hiện chức năng 1");
            System.out.println("Nhập email: ");
            String email=scanner.nextLine();

            System.out.println("Nhập mật khẩu ");
            String password=scanner.nextLine();


        }

        public static void doFunctionTwo() {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Thực hiện chức năng 2");
            System.out.println("Nhập email: ");
            String email=scanner.nextLine();
            System.out.println("Nhập mật khẩu ");
            String password=scanner.nextLine();
        }

        public static void doFunctionThree() {
            System.out.println("Thực hiện chức năng 3");
        }

        public static void showMenu() {
            System.out.println("\n********* MENU *********");
            System.out.println("1 - Đăng nhập");
            System.out.println("2 - Đăng ký");
            System.out.println("3 - Quên mật khẩu");

        }
    // 1. Lấy Object đơn từ file json
    public user getObjectFromJsonFile(String fileName) {
        try {
            // Khởi tạo đối tượng gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin từ file và binding và class
            user student = gson.fromJson(reader, user.class);

            // Đọc file xong thì đóng lại
            // Và trả về kết quả
            reader.close();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public static void main(String[] args) throws IOException {
        // Lấy thông tin đối tượng student từ file "student.json"
        user student = getObjectFromJsonFile("student.json");
        System.out.println("Đọc thông tin từ file student.json");
        System.out.println(student);
        System.out.println();

        // ************************************************

        // Lấy List đối tượng student từ file "list-student.json"
        List<user> students = getListObjectFromJsonFile("list-student.json");

        // Vì có thể list là null, nên xử lý bằng Optional
        Optional<List<user>> studentsOptional = Optional.ofNullable(students);

        // In ra thông tin từng Object trong List
        System.out.println("Đọc thông tin từ file list-student.json");
        if(studentsOptional.isPresent()) {
            students.forEach(System.out::println);
        }
    }







}









