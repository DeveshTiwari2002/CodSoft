import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private ArrayList<String> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseId) {
        registeredCourses.add(courseId);
    }

    public void unregisterCourse(String courseId) {
        registeredCourses.remove(courseId);
    }
}

class Course {
    private String courseId;
    private String courseName;
    private int maxCapacity;
    private int currentCapacity;

    public Course(String courseId, String courseName, int maxCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public boolean isFull() {
        return currentCapacity >= maxCapacity;
    }

    public void incrementCurrentCapacity() {
        currentCapacity++;
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        // Sample courses
        courses.add(new Course("CSE101", "Introduction to Computer Science", 30));
        courses.add(new Course("MATH201", "Calculus I", 25));
        courses.add(new Course("PHY301", "Physics Mechanics", 20));

        boolean exit = false;

        while (!exit) {
            System.out.println("\nCOURSE REGISTRATION SYSTEM");
            System.out.println("1. Register Student");
            System.out.println("2. Display Available Courses");
            System.out.println("3. Register Student to Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.next();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    students.add(new Student(studentId, name));
                    System.out.println("Student registered successfully!");
                    break;
                case 2:
                    System.out.println("\nAVAILABLE COURSES");
                    System.out.println("Course ID\tCourse Name\tMax Capacity\tCurrent Capacity");
                    for (Course course : courses) {
                        System.out.printf("%-10s\t%-20s\t%-12d\t%-16d%n",
                                course.getCourseId(), course.getCourseName(), course.getMaxCapacity(),
                                course.getCurrentCapacity());
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    String stuId = scanner.next();
                    System.out.print("Enter course ID: ");
                    String courseId = scanner.next();

                    Student student = null;
                    Course course = null;

                    // Find the student and course objects
                    for (Student s : students) {
                        if (s.getStudentId().equals(stuId)) {
                            student = s;
                            break;
                        }
                    }

                    for (Course c : courses) {
                        if (c.getCourseId().equals(courseId)) {
                            course = c;
                            break;
                        }
                    }

                    if (student == null || course == null) {
                        System.out.println("Invalid student ID or course ID.");
                    } else if (course.isFull()) {
                        System.out.println("Course is already full. Cannot register.");
                    } else {
                        student.registerCourse(courseId);
                        course.incrementCurrentCapacity();
                        System.out.println("Course registration successful!");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Course Registration System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
