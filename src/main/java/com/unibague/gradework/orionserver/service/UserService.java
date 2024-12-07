package com.unibague.gradework.orionserver.service;

import com.unibague.gradework.orionserver.model.Actors;
import com.unibague.gradework.orionserver.model.Student;
import com.unibague.gradework.orionserver.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Student createStudent(Student student, String roleName);
    Actors createActor(Actors actor, String roleName);
    List<Student> getAllStudents();
    List<Actors> getAllActors();
    Optional<User> getUserById(String  id);
    Student updateStudent(String id, Student studentDetails);
    Actors updateActor(String id, Actors actorDetails);
    void deleteStudent(String id);
    void deleteActor(String id);
}
