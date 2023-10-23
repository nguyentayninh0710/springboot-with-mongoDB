package com.myclass.demoMongoDB.repository;

import com.myclass.demoMongoDB.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {
}
