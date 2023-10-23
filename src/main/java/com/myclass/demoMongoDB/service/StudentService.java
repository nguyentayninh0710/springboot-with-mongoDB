package com.myclass.demoMongoDB.service;

import com.myclass.demoMongoDB.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(String id);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    String deleteStudent(String id);

    List<Student> getStudentsByName(String name);

    Student studentsByNameAndMail(String name, String email);

    Student studentsByNameOrMail(String name, String email);

    List<Student> getAllWithPagination(int pageNo, int pageSize);

    List<Student> getAllWithSorting();

    List<Student> byDepartmentName (String deptName);

    List<Student> bySubjectName (String subName);

    List<Student> emailLike (String email);

    List<Student> nameStartsWith (String name);

    List<Student> byDepartmentId(String depId);
}
