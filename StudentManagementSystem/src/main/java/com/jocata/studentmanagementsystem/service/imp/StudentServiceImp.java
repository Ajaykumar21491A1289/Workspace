package com.jocata.studentmanagementsystem.service.imp;

import com.jocata.studentmanagementsystem.dao.*;
import com.jocata.studentmanagementsystem.dao.imp.*;
import com.jocata.studentmanagementsystem.entity.StudentEntity;
import com.jocata.studentmanagementsystem.entity.StudentResponse;
import com.jocata.studentmanagementsystem.form.GradeTrackForm;
import com.jocata.studentmanagementsystem.form.GroupStudentForm;
import com.jocata.studentmanagementsystem.form.StudentForm;
import com.jocata.studentmanagementsystem.service.StudentService;

import java.util.*;

public class StudentServiceImp implements StudentService {


    StudentDao dao = new StudentDaoImp();

    public String addStudent(StudentForm form) {

        StudentEntity entity = new StudentEntity();
        entity.setStudentId(form.getStudentId());
        entity.setStudentName(form.getStudentName());
        entity.setEmail(form.getEmail());
        entity.setPhone(form.getPhone());
        entity.setAddress(form.getAddress());
        entity.setDob(form.getDob());
        return dao.addStudent(entity);
    }

    public String updateStudent(StudentForm form) {

        StudentEntity entity = new StudentEntity();
        entity.setStudentId(form.getStudentId());
        entity.setStudentName(form.getStudentName());
        entity.setEmail(form.getEmail());
        entity.setPhone(form.getPhone());
        entity.setAddress(form.getAddress());
        entity.setDob(form.getDob());
        return dao.updateStudent(entity);
    }

    public String removeStudent(String id) {

        AssignSubjectsDao subjectDao = new AssignSubjectsDaoImp();
        AssignCourseDao courseDao = new AssignCourseDaoImp();
        AttendanceDao attendanceDao = new AttendanceDaoImp();
        GradeDao gradeDao = new GradeDaoImp();
        //deleting assigned subjects to the students
        subjectDao.deleteSubjectsToStudent(id);
        //deleting assigned course to the student
        courseDao.deleteCourseToStudent(id);
        //deleting attendance assigned to the student
        attendanceDao.deleteAttendance(id);
        //deleting grade assigned to the students
        gradeDao.deleteGrade(id);
        return dao.removeStudent(id);

    }

    public List<StudentResponse> getStudents() {
        List<StudentResponse> list = dao.getStudents();
        Collections.sort(list, Comparator
                .comparing(StudentResponse::getStudentId)
                .thenComparing(StudentResponse::getName));
        return list;

    }
    public Map<String, List<GroupStudentForm>> groupStudents() {
        List<StudentResponse> list = dao.getStudents();
        Map<String, List<GroupStudentForm>> groupedByCourse = new HashMap<>();

        for (StudentResponse response : list) {
            GroupStudentForm form = new GroupStudentForm();
            form.setStudentId(response.getStudentId());
            form.setStudentName(response.getName());
            form.setCourse(response.getCourseName());

            groupedByCourse
                    .computeIfAbsent(response.getCourseName(), k -> new ArrayList<>())
                    .add(form);
        }
        for (List<GroupStudentForm> group : groupedByCourse.values()) {
            group.sort(Comparator
                    .comparing(GroupStudentForm::getStudentId)
                    .thenComparing(GroupStudentForm::getStudentName));
        }

        return groupedByCourse;
    }

    public Map<String, List<GradeTrackForm>> trackGradeSubjectWise() {
        List<StudentResponse> list = dao.getStudents();  // Get all student data
        Map<String, List<GradeTrackForm>> gradeMap = new HashMap<>();

        for (StudentResponse response : list) {
            GradeTrackForm form = new GradeTrackForm();
            form.setStudentId(response.getStudentId());
            form.setStudentName(response.getName());
            form.setSubjectName(response.getSubjectName());
            form.setGrade(response.getGrade());

            gradeMap
                    .computeIfAbsent(response.getSubjectName(), k -> new ArrayList<>())
                    .add(form);
        }

        return gradeMap;
    }



}
