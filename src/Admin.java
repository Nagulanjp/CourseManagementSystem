import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Account {

    private List<Course> courseList;

    public Admin(String username) {
        super(username);
        this.courseList = new ArrayList<>();
    }

    // Add a new course
    public void addCourse(Course course) {
        courseList.add(course);
        System.out.println("✅ Course added successfully.");
    }

    // Remove a course by ID
    public void removeCourse(int courseId) {
        boolean removed = courseList.removeIf(c -> c.getCourseId() == courseId);
        if (removed) {
            System.out.println("✅ Course removed.");
        } else {
            System.out.println("⚠️ Course ID not found.");
        }
    }

    // View all courses
    public void viewCourses() {
        if (courseList.isEmpty()) {
            System.out.println("⚠️ No courses available.");
        } else {
            System.out.println("📚 Available Courses:");
            for (Course c : courseList) {
                System.out.println(c);
            }
        }
    }

    // Admin menu logic
    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View All Courses");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Course Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Instructor Name: ");
                    String instructor = sc.nextLine();
                    addCourse(new Course(id, name, instructor));
                    break;

                case 2:
                    System.out.print("Enter Course ID to remove: ");
                    int removeId = Integer.parseInt(sc.nextLine());
                    removeCourse(removeId);
                    break;

                case 3:
                    viewCourses();
                    break;

                case 4:
                    loop = false;
                    System.out.println("🔒 Admin logged out.");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }

    // Getter for course list (used by Student class later)
    public List<Course> getCourseList() {
        return courseList;
    }
}