import java.util.*;

public class CourseManagement {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

        Admin admin = new Admin("AdminUser");  // one admin
        List<Course> sharedCourses = admin.getCourseList(); // shared with students

        Map<String, Student> studentMap = new HashMap<>(); // username -> Student object

        boolean runApp = true;
        while (runApp) {
            System.out.println("\n==== Course Management System ====");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("🔐 Logged in as Admin");
                    admin.showMenu();
                    break;

                case "2":
                    System.out.print("Enter student username: ");
                    String uname = sc.nextLine();

                    // If new student, create one
                    if (!studentMap.containsKey(uname)) {
                        studentMap.put(uname, new Student(uname, sharedCourses));
                        System.out.println("👤 New student profile created.");
                    } else {
                        System.out.println("👤 Welcome back, " + uname + "!");
                    }

                    studentMap.get(uname).showMenu();
                    break;

                case "3":
                    runApp = false;
                    System.out.println("👋 Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
	}
}
