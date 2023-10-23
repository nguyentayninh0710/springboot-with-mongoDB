package com.myclass.demoMongoDB.repository;

import com.myclass.demoMongoDB.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);
    Student findByEmailAndName (String email, String name);

    Student findByNameOrEmail (String name, String email);

    List<Student> findByDepartmentDepartmentName(String deptname);

    List<Student> findBySubjectsSubjectName (String subName);

    List<Student> findByEmailIsLike (String email);

    List<Student> findByNameStartsWith (String name);

    List<Student> findByDepartmentId(String deptId);

    @Query("{ \"name\" : \"?0\" }")
    List<Student> getByName(String name);

}
