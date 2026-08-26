import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class task1 {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      StudentEvaluation[] students = new StudentEvaluation[5];
      
      students[0] = new UGCourseEvaluation("Ramanujan", 1729, 95.0f);
      students[1] = new PGCourseEvaluation("Aryabhata", 476, 88.0f);
      students[2] = new CertificateCourseEvaluation("Bhaskara", 1114, true);
      students[3] = new UGCourseEvaluation("C.V. Raman", 1930, 75.0f);
      students[4] = new DiplomaCourseEvaluation("Visvesvaraya", 1861, 45);

      for (int i = 0; i < students.length; i++) {
          students[i].GetGrades(scan);
          System.out.println();
          students[i].DisplayStudentDetails();
          students[i].DisplayGrades();
          System.out.println("====================================");
      }
    }
}
// ==============================================================================================

abstract class StudentEvaluation {
  String name;
  int rollNo;
  static float maxMark = 100.0f;
  int numSubjects;
  HashMap<String, Float> marks = new HashMap<>();


  StudentEvaluation(String name, int rollNo) {
    this.name = name;
    this.rollNo = rollNo;
  }  

  void DisplayStudentDetails() {
    System.out.println("Name: " + name);
    System.out.println("Roll Number " + rollNo);
  }

  abstract float CalculateGrades();
  abstract void DisplayGrades(); 

  void GetGrades(Scanner scan) {
    System.out.println("Enter mark details for " + name);
    System.out.print("Enter number of subjects to add: ");
    numSubjects = scan.nextInt();
    scan.nextLine();

    for (int i = 0; i < numSubjects; i++) {
      System.out.print((i+1) + ". Subject Name: ");
      String subject = scan.nextLine();
      System.out.print("Mark: ");
      float mark = scan.nextFloat();
      scan.nextLine();

      marks.put(subject, mark);
    }
  }
}
// ==============================================================================================

class UGCourseEvaluation extends StudentEvaluation {
  float attendance;

  UGCourseEvaluation(String name, int rollNo, float attendance) {
    super(name, rollNo);
    if (!(attendance > 0 && attendance <= 100)) {
        return;
    } 
    this.attendance = attendance;
  }

  float calculate(float attendance) {
    float score;
    if (attendance > 90) {score = 5.0f;}
    else if (attendance > 80) {score = 4.0f;}
    else if (attendance > 70) {score = 3.0f;}
    else {score = 0f;}
    return score;
  }

  float CalculateGrades() {
    float total = 0f;
    for (float mark: marks.values()) {
      total += mark;
    }
    total /= numSubjects;
    total += calculate(this.attendance);
    return total;
  }

  void DisplayGrades(){
    float grade = CalculateGrades();
    System.out.println("Grade: " + grade);
  }
}
// ==============================================================================================

class PGCourseEvaluation extends StudentEvaluation {
  float researchScore;

  PGCourseEvaluation(String name, int rollNo, float researchScore) {
    super(name, rollNo);
    this.researchScore = researchScore;
  }

  float CalculateGrades() {
    float total = 0f;
    for (float mark : marks.values()) {
      total += mark;
    }
    total /= numSubjects;
    return (total * 0.8f) + (researchScore * 0.2f);
  }

  void DisplayGrades() {
    float grade = CalculateGrades();
    System.out.println("PG Final Score: " + grade);
  }
}
// ==============================================================================================

class CertificateCourseEvaluation extends StudentEvaluation {
  boolean projectCompleted;

  CertificateCourseEvaluation(String name, int rollNo, boolean projectCompleted) {
    super(name, rollNo);
    this.projectCompleted = projectCompleted;
  }

  float CalculateGrades() {
    float total = 0f;
    for (float mark : marks.values()) {
      total += mark;
    }
    return total / numSubjects;
  }

  void DisplayGrades() {
    float avg = CalculateGrades();
    if (avg >= 60.0f && projectCompleted) {
        System.out.println("Status: Certified");
    } else {
        System.out.println("Status: Not Certified");
    }
  }
}
// ==============================================================================================

class DiplomaCourseEvaluation extends StudentEvaluation {
  int practicalHours;

  DiplomaCourseEvaluation(String name, int rollNo, int practicalHours) {
    super(name, rollNo);
    this.practicalHours = practicalHours;
  }

  float CalculateGrades() {
    float total = 0f;
    for (float mark : marks.values()) {
      total += mark;
    }
    total /= numSubjects;
    if (practicalHours > 40) {
        total += 5.0f;
    }
    return total;
  }

  void DisplayGrades() {
    float grade = CalculateGrades();
    System.out.println("Diploma Score: " + grade);
  }
}

