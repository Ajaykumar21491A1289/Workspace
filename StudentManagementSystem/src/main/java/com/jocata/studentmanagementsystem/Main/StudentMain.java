package com.jocata.studentmanagementsystem.Main;

import com.jocata.studentmanagementsystem.controller.AssignCourseController;
import com.jocata.studentmanagementsystem.controller.AssignSubjectsController;
import com.jocata.studentmanagementsystem.controller.StudentController;
import com.jocata.studentmanagementsystem.entity.StudentResponse;
import com.jocata.studentmanagementsystem.form.StudentForm;

import java.util.List;

public class StudentMain {

    public static void main(String[] args){
        StudentController controller = new StudentController();
        AssignSubjectsController subjectsController = new AssignSubjectsController();
        AssignCourseController courseController = new AssignCourseController();
        StudentForm form = new StudentForm();
        form.setStudentId("302");
        form.setStudentName("prasad");
        form.setEmail("prasad@123");
        form.setPhone("123456");
        form.setAddress("vinukonda");
        form.setDob("2023-06-23");

        //System.out.println(controller.updateStudent(form));
        //System.out.println(controller.removeStudent("301"));


        //System.out.println(controller.addStudent(form));
       /* System.out.println(courseController.assignCourseToStudent("102","302"));
        System.out.println(subjectsController.assignSubjectsToStudent("302","206"));
        System.out.println(subjectsController.assignSubjectsToStudent("302","207"));
        System.out.println(subjectsController.assignSubjectsToStudent("302","208"));
        System.out.println(subjectsController.assignSubjectsToStudent("302","209"));
        System.out.println(subjectsController.assignSubjectsToStudent("302","210"));*/
        //System.out.println(subjectsController.deleteSubjectsToStudent("302"));
       // System.out.println(courseController.deleteCourseToStudent("302"));

        List<StudentResponse> list = controller.getStudents();
        for(StudentResponse response:list){
            System.out.println(response);
        }



    }
}
