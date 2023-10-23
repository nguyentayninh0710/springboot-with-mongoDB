package com.myclass.demoMongoDB.service.impl;

import com.myclass.demoMongoDB.entity.Student;
import com.myclass.demoMongoDB.repository.DepartmentRepository;
import com.myclass.demoMongoDB.repository.StudentRepository;
import com.myclass.demoMongoDB.repository.SubjectRepository;
import com.myclass.demoMongoDB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Student createStudent(Student student) {
        if(student.getDepartment() != null){
            departmentRepository.save(student.getDepartment());
        }
        if(student.getSubjects() != null && student.getSubjects().size() > 0){
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }

    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted";
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student studentsByNameAndMail(String name, String email) {
        return studentRepository.findByEmailAndName(email, name);
    }

    @Override
    public Student studentsByNameOrMail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    @Override
    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name", "email");
        return studentRepository.findAll(sort);
    }

    @Override
    public List<Student> byDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    @Override
    public List<Student> bySubjectName(String subName) {
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    @Override
    public List<Student> emailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    @Override
    public List<Student> nameStartsWith (String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    @Override
    public List<Student> byDepartmentId(String depId) {
        return studentRepository.findByDepartmentId(depId);
    }


}

