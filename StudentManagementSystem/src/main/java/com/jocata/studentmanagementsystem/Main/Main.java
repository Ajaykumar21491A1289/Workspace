package com.jocata.studentmanagementsystem.Main;

import com.jocata.studentmanagementsystem.controller.*;
import com.jocata.studentmanagementsystem.entity.StudentResponse;
import com.jocata.studentmanagementsystem.form.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentController studentController = new StudentController();
        AssignCourseController courseController = new AssignCourseController();
        AssignSubjectsController subjectController = new AssignSubjectsController();
        GradeController gradeController = new GradeController();
        AttendanceController attendanceController = new AttendanceController();

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Assign Course");
            System.out.println("5. Assign Subject");
            System.out.println("6. Mark Attendance");
            System.out.println("7. Add Grade");
            System.out.println("8. View All Students");
            System.out.println("9. Group Student By Course");
            System.out.println("10. Track Grade Subject Wise");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    StudentForm form = new StudentForm();
                    System.out.print("Enter Student ID: ");
                    form.setStudentId(sc.nextLine());
                    System.out.print("Enter Name: ");
                    form.setStudentName(sc.nextLine());
                    System.out.print("Enter Email: ");
                    form.setEmail(sc.nextLine());
                    System.out.print("Enter Phone: ");
                    form.setPhone(sc.nextLine());
                    System.out.print("Enter Address: ");
                    form.setAddress(sc.nextLine());
                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                    form.setDob(sc.nextLine());
                    System.out.println(studentController.addStudent(form));
                    break;

                case 2:
                    StudentForm updateForm = new StudentForm();
                    System.out.print("Enter Student ID to update: ");
                    updateForm.setStudentId(sc.nextLine());
                    System.out.print("Enter New Name: ");
                    updateForm.setStudentName(sc.nextLine());
                    System.out.print("Enter New Email: ");
                    updateForm.setEmail(sc.nextLine());
                    System.out.print("Enter New Phone: ");
                    updateForm.setPhone(sc.nextLine());
                    System.out.print("Enter New Address: ");
                    updateForm.setAddress(sc.nextLine());
                    System.out.print("Enter New DOB (yyyy-mm-dd): ");
                    updateForm.setDob(sc.nextLine());
                    System.out.println(studentController.updateStudent(updateForm));
                    break;

                case 3:
                    System.out.print("Enter Student ID to remove: ");
                    String removeId = sc.nextLine();
                    System.out.println(studentController.removeStudent(removeId));
                    break;

                case 4:
                    System.out.print("Enter Course ID: ");
                    String courseId = sc.nextLine();
                    System.out.print("Enter Student ID: ");
                    String studentId = sc.nextLine();
                    System.out.println(courseController.assignCourseToStudent(courseId, studentId));
                    break;

                case 5:
                    System.out.print("Enter Subject ID: ");
                    String subjectId = sc.nextLine();
                    System.out.print("Enter Student ID: ");
                    String studId = sc.nextLine();
                    System.out.println(subjectController.assignSubjectsToStudent(studId, subjectId));
                    break;

                case 6:
                    AttendanceForm attForm = new AttendanceForm();
                    System.out.print("Enter Attendance ID: ");
                    attForm.setAttendanceId(sc.nextLine());
                    System.out.print("Enter Student ID: ");
                    attForm.setStudentId(sc.nextLine());
                    System.out.print("Enter Subject ID: ");
                    attForm.setSubjectId(sc.nextLine());
                    System.out.print("Enter Status (Present/Absent): ");
                    attForm.setStatus(sc.nextLine());
                    System.out.println(attendanceController.markAttendance(attForm));
                    break;

                case 7:
                    GradeForm gradeForm = new GradeForm();
                    System.out.print("Enter Grade ID: ");
                    gradeForm.setGradeId(sc.nextLine());
                    System.out.print("Enter Student ID: ");
                    gradeForm.setStudentId(sc.nextLine());
                    System.out.print("Enter Subject ID: ");
                    gradeForm.setSubjectId(sc.nextLine());
                    System.out.print("Enter Grade: ");
                    gradeForm.setGrade(sc.nextLine());
                    System.out.println(gradeController.addGrade(gradeForm));
                    break;

                case 8:
                    List<StudentResponse> list = studentController.getStudents();
                    for (StudentResponse response : list) {
                        System.out.println(response);
                    }
                    break;

                case 9:
                    Map<String, List<GroupStudentForm>> groupedByCourse=studentController.groupStudents();
                    for (Map.Entry<String, List<GroupStudentForm>> entry : groupedByCourse.entrySet()) {
                        System.out.println("Course: " + entry.getKey());
                        for (GroupStudentForm student : entry.getValue()) {
                            System.out.println("  Student ID: " + student.getStudentId() + ", Name: " + student.getStudentName());
                        }
                    }
                    break;

                case 10:
                    Map<String, List<GradeTrackForm>> gradeMap = studentController.trackGradeSubjectWise();

                    for (Map.Entry<String, List<GradeTrackForm>> entry : gradeMap.entrySet()) {
                        String subject = entry.getKey();
                        List<GradeTrackForm> students = entry.getValue();

                        System.out.println("Subject: " + subject);
                        for (GradeTrackForm student : students) {
                            System.out.println("  Student ID: " + student.getStudentId());
                            System.out.println("  Name     : " + student.getStudentName());
                            System.out.println("  Grade    : " + student.getGrade());
                            System.out.println();
                        }
                        System.out.println("-----------------------------");
                    }
                    break;



                case 11:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
