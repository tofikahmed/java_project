/*
This java code performs simple registration form of a student.
Also displays the information one by one of the student registered.
*/


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
abstract class Student
{
    protected String firstName;
    protected String lastName;
    protected String Id;
    protected String college;
    protected String department;
    protected String email;
    protected double attendancePercentage;
    protected double previousGrade;
    protected int year;
    protected int semester;
    //CONSTRUCTOR OF AN ABSTRACT CLASS STUDENT
    public Student(String fn, String Id, String clg, String dept, String ln, String email, double atp, double pg, int year, int sem)
    {
        this.firstName = fn;
        this.lastName = ln;
        this.Id = Id;
        this.college = clg;
        this.department = dept;
        this.year = year;
        this.semester = sem;
        this.email = email;
        this.attendancePercentage = atp;
        this.previousGrade = pg;
    }
    //ABSTRACT METHOD OF ABSTRACT CLASS STUDENT
    public abstract void displayRegistrationDetails();
    public void checkAttendance()
    {
        System.out.println("your previous Attendance Percentage: " + attendancePercentage);
    }
    public void checkPreviousGrade()
    {
        System.out.println("your previous Grade: " + previousGrade);
    }
}
// ABSTRACT CLASS STUDENT EXTENDED BY UNDERGRADUATE STUDENT
class UndergraduateStudent extends Student
{
    //CONSTRUCTOR OF undergraduateStudent class
    public UndergraduateStudent(String fn, String ln, String Id, String clg, String dept, String email, double atp, double pg, int year, int sem)
    {
        super(fn, ln, Id, clg, dept, email, atp, pg, year, sem);
    }
    @Override
    // method of undergraduateStudent class extended from student class
    public void displayRegistrationDetails()
    {
        System.out.println("\t\t\t UNDERGRADUATE STUDENT  ");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
        System.out.println("|Year: " + year + "                                                                 | semester: " + semester + "    |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
        System.out.println("|College: " + college + "    " + "| Department: " + department + "                                                    |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
        System.out.println("| FirstName: " + firstName + " " + lastName + "                                     " + "| ID Number: " + Id + "         |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
        System.out.println("|Email: " + email + "                                                                                          |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
    }
}
class GraduateStudent extends Student
{
    public GraduateStudent(String fn, String ln, String Id, String clg, String dept, String email, double atp, double pg, int year, int sem)
    {
        super(fn, ln, Id, clg, dept, email, atp, pg, year, sem);
    }
    @Override
    // method of graduateStudent class extended from student class
    public void displayRegistrationDetails()
    {
        System.out.println("\t\t\t GRADUATE STUDENT ");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
        System.out.println("|Year: " + year + "                                                                 | semester: " + semester + "    |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
        System.out.println("|College: " + college + "    " + "| Department: " + department + "                                                    |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
        System.out.println("| FirstName: " + firstName + " " + lastName + "                                     " + "| ID Number: " + Id + "         |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
        System.out.println("|Email: " + email + "                                                                                          |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------|");
    }
}
// MAIN CLASS
class StudentRegistrationForm
{
    //MAIN METHOD
    public static void main(String[] args)
    {
        List<Student> students;
        int numberOfStudentsRegistered;
        try {
            Scanner scanner = new Scanner(System.in);
            int numStudents;
            System.out.println("Student Registration Form inputs");
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");

            System.out.print("Enter number of students to register: ");
            numStudents = scanner.nextInt();

            students = new ArrayList<>();
            numberOfStudentsRegistered = 0;

            for (int i = 0; i < numStudents; i++){
                try {
                    System.out.println("\nStudent #" + (i + 1));

                    System.out.print("Enter your first name : ");
                    String firstName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter your last name : ");
                    String lastName = scanner.nextLine();

                    System.out.print("your ID : ");
                    String Id = scanner.nextLine();

                    System.out.print("college : ");
                    String college = scanner.nextLine();

                    System.out.print("department : ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Academic Year : ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    if (year < 1 || year > 5){
                        System.out.println("re enter year");
                        year = scanner.nextInt();
                    }
                    System.out.print("Enter Academic semester ");
                    int sem = scanner.nextInt();
                    if (sem < 1 || sem > 2) {
                        System.out.println("re enter semester");
                    }
                    scanner.nextLine();
                    System.out.print("Enter your email address(optional) : ");
                    String email = scanner.nextLine();

                    System.out.print("Enter your attendance percentage: ");
                    double attendancePercentage = scanner.nextDouble();
                    if (attendancePercentage < 70) {
                        System.out.println("student " + firstName + " you are failed for registration of this year");
                        continue;
                    }
                    scanner.nextLine();

                    System.out.print("Enter your previous grade: ");
                    double previousGrade = scanner.nextDouble();
                    if (previousGrade < 1.75 || previousGrade > 4.0) {
                        System.out.println("student " + firstName + " you are failed for registration of this year!");
                        continue;
                    }
                    scanner.nextLine();
                    System.out.print("Enter your level (undergraduate/graduate): ");
                    String studentLevel = scanner.nextLine();
                    switch (studentLevel.toLowerCase())
                    {

                        case "undergraduate":
                            System.out.println("Student " + firstName + " : you are successfully registered for semester : " + sem);
                            students.add(new UndergraduateStudent(firstName, lastName, Id, college, department, email, attendancePercentage, previousGrade, year, sem));
                            break;
                        case "graduate":
                            System.out.println("Student " + firstName + "you are successfully registered for semester : " + sem);
                            students.add(new GraduateStudent(firstName, lastName, Id, college, department, email, attendancePercentage, previousGrade, year, sem));
                            break;
                        default:
                            System.out.println("Invalid student level.");
                            break;
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (IllegalArgumentException e){
                    System.out.println("Illegal Argument Exception occurred");
                }
                numberOfStudentsRegistered++;
            }
            System.out.println("\nRegistration Details");
            System.out.println("----------------------");

            for (int i = 0; i < students.size(); i++)
            {
                System.out.println("\nStudent #" + (i + 1));
                students.get(i).displayRegistrationDetails();
                students.get(i).checkAttendance();
                students.get(i).checkPreviousGrade();
            }
            System.out.println("Total number of students registered is : " + numberOfStudentsRegistered);

        }
        catch (InputMismatchException e)
        {
            System.out.println("some input misunderstood");
        }
        catch (Exception e)
        {
            System.out.println("Exception occured ");

        }
    }
}
