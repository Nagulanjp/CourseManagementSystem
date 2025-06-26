import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 

public class Student extends Account {

    private Set<Integer> enrolledCourseIds; // Store enrolled course IDs
    private List<Course> sharedCourseList;  // From Admin

    public Student(String username, List<Course> sharedCourseList) {
        super(username);
        this.sharedCourseList = sharedCourseList;
        this.enrolledCourseIds = new HashSet<>();
    }

    // Enroll in a course
    public void enrollInCourse(int courseId) {
        boolean found = false;
        for (Course c : sharedCourseList) {
            if (c.getCourseId() == courseId) {
                if (enrolledCourseIds.contains(courseId)) {
                    System.out.println("⚠️ Already enrolled in this course.");
                } else {
                    enrolledCourseIds.add(courseId);
                    System.out.println("✅ Successfully enrolled in " + c.getCourseName());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Course ID not found.");
        }
    }

    // View available courses
    public void viewAvailableCourses() {
        if (sharedCourseList.isEmpty()) {
            System.out.println("⚠️ No courses available to enroll.");
        } else {
            System.out.println("📘 Available Courses:");
            for (Course c : sharedCourseList) {
                System.out.println(c);
            }
        }
    }

    // View enrolled courses
    public void viewEnrolledCourses() {
        if (enrolledCourseIds.isEmpty()) {
            System.out.println("📭 Not enrolled in any courses yet.");
        } else {
            System.out.println("🎓 Your Enrolled Courses:");
            for (Course c : sharedCourseList) {
                if (enrolledCourseIds.contains(c.getCourseId())) {
                    System.out.println(c);
                }
            }
        }
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View Available Courses");
            System.out.println("2. Enroll in a Course");
            System.out.println("3. View Enrolled Courses");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    viewAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter Course ID to enroll: ");
                    int id = Integer.parseInt(sc.nextLine());
                    enrollInCourse(id);
                    break;
                case 3:
                    viewEnrolledCourses();
                    break;
                case 4:
                    loop = false;
                    System.out.println("🔒 Student logged out.");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}