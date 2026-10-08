import java.util.Scanner;
class Student {
    String studentName;
    int rollNumber;
    int marks;
    String courseName;
    int courseCredits;
    boolean eligibility;
    int Scholarship;

    public Student(String studentName, int rollNumber, int marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public int calculateFee() {
        return courseCredits * 1500;
    }

    public boolean checkEligibility() {
        if (marks >= 50) {
            System.out.println("Student is eligible for the course");
            eligibility = true;
        } else {
            System.out.println("Sorry, the student is not eligible for the course");
            eligibility = false;
        }
        return eligibility;
    }

    public int calculateScholarship() {
        if (marks >= 85) {
            System.out.println("You are eligible for 20% Scholarship");
            Scholarship = 20;
            return 20;
        } else if (marks >= 70) {
            System.out.println("You are eligible for 10% Scholarship");
            Scholarship = 10;
            return 10;
        } else {
            System.out.println("Not eligible for scholarship");
            Scholarship = 0;
            return 0;
        }
    }

    public double calculateFinalFee() {
        int courseFee = calculateFee();
        int SPpercent = calculateScholarship();
        double discount = courseFee * SPpercent / 100;
        double finalfee = courseFee - discount;
        return finalfee;
    }

    public void displaydeets() {
        System.out.println("\n--------Student Details----------");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks Scored: " + marks);
        System.out.println("Chosen Course: " + courseName);
        System.out.println("Course credits: " + courseCredits);
        System.out.println("Course Fee: " + calculateFee() + "$");
        System.out.println("Scholarship percentage: " + Scholarship + "%");
        System.out.println("Final Fee: " + calculateFinalFee() + "$");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String ScannerName = sc.nextLine();
        System.out.println("Enter Student Roll Number: ");
        int ScannerRno = sc.nextInt();
        System.out.println("Enter Student Marks: ");
        int ScannerMarks = sc.nextInt();
        System.out.println("\n----------------------");
        System.out.println("Select a course" + "\n1)java" + "\n2)maths" + "\n3)ddca");
        System.out.println("\n----------------------");
        System.out.println("Enter Course Name: ");
        String ScannerCoursename = sc.nextLine();
        ScannerCoursename = sc.nextLine().trim().toLowerCase();
        
        int TempCredits = 0;
        switch (ScannerCoursename) {
            case "java": 
            TempCredits = 4;
            break;
            case "maths":
                TempCredits = 3;
                break;
            case "ddca":
                TempCredits = 5;
                break;
            default:
                System.out.println("Please enter the listed course");
                return;
        }

        Student s1 = new Student(ScannerName, ScannerRno, ScannerMarks, ScannerCoursename, TempCredits);
        if (s1.checkEligibility() == false) {
            System.out.println("You are not eligible for Course registration");
            return;
        }
        s1.calculateFee();
        s1.calculateScholarship();
        s1.calculateFinalFee();
        s1.displaydeets();
    }
}