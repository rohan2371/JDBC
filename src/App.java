import com.student.mgmt.connection.ConnectionProvider;
import com.student.mgmt.entity.Student;
import com.student.mgmt.dao.StudentDaoImpl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StudentDaoImpl studentDao = new StudentDaoImpl();

        while (true) {
            System.out.println("PRESS 1 to ADD student : ");
            System.out.println("PRESS 2 to Delete student : ");
            System.out.println("PRESS 3 to Display student : ");
            System.out.println("PRESS 4 TO Update student : ");
            System.out.println("PRESS 5 TO Search Student id : ");
            System.out.println("PRESS 6 to Know about jdbc driver  :");
            System.out.println("PRESS 7 to Exit system :");

            int choice = Integer.parseInt(br.readLine());
            switch (choice){
                case 1 : {
                    // add student
                    System.out.println("Enter user id : ");
                    int id = Integer.parseInt(br.readLine());

                    System.out.println("Enter user name : ");
                    String name = br.readLine();

                    System.out.println("Enter user PhoneNO : ");
                    String phone = br.readLine();

                    System.out.println("Enter user city : ");
                    String city = br.readLine();

                    // create student object to store student
                    Student st = new Student(id,name,phone,city);
                    studentDao.insert(st);
                }
                break;

                case 2 :{
                    // delete student
                    System.out.println("Enter student id to delete : ");
                    int id = Integer.parseInt(br.readLine());
                    studentDao.delete(id);
                }
                break;

                case 3:{
                    // display student
                    studentDao.display();
                }
                break;

                case 4:{
                    System.out.println("Enter id to update student : ");
                    int id = Integer.parseInt(br.readLine());
                    System.out.println("Enter to city to update");
                    String city = br.readLine();
                    studentDao.update(id,city);
                }
                break;

                case 5:{
                    System.out.println("Enter Student id : ");
                    int id = Integer.parseInt(br.readLine());
                    studentDao.searchStudent(id);
                }
                break;

                case 6 :{
                    studentDao.jdbcDriverInfo();
                }

                default:
                    System.out.println("Application exit....");
            }



        }



    }
}
