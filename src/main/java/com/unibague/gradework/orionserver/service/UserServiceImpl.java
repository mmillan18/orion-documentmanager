package com.unibague.gradework.orionserver.service;
import com.unibague.gradework.orionserver.model.Actors;
import com.unibague.gradework.orionserver.model.Role;
import com.unibague.gradework.orionserver.model.Student;
import com.unibague.gradework.orionserver.model.User;
import com.unibague.gradework.orionserver.repository.ActorsRepository;
import com.unibague.gradework.orionserver.repository.RoleRepository;
import com.unibague.gradework.orionserver.repository.StudentRepository;
import com.unibague.gradework.orionserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ActorsRepository actorsRepository;

    @Override
    public Student createStudent(Student student, String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role " + roleName + " not found"));
        student.setRole(role); // Asigna el rol encontrado al estudiante
        return studentRepository.save(student); // Guarda el estudiante en la base de datos
    }

    @Override
    public Actors createActor(Actors actor, String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role " + roleName + " not found"));
        actor.setRole(role); // Asigna el rol encontrado al actor
        return actorsRepository.save(actor); // Guarda el actor en la base de datos
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Actors> getAllActors() {
        return actorsRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) { // Cambiado a String
        return userRepository.findById(Long.valueOf(id));
    }

    @Override
    public Student updateStudent(String id, Student studentDetails) {
        Student existingStudent = studentRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));

        existingStudent.setFirstName(studentDetails.getFirstName());
        existingStudent.setLastName(studentDetails.getLastName());
        existingStudent.setPhone(studentDetails.getPhone());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setImage(studentDetails.getImage());
        existingStudent.setSex(studentDetails.getSex());
        existingStudent.setStudentID(studentDetails.getStudentID());
        existingStudent.setStatus(studentDetails.isStatus());
        existingStudent.setSemester(studentDetails.getSemester());
        existingStudent.setCategory(studentDetails.getCategory());

        return studentRepository.save(existingStudent);
    }

    @Override
    public Actors updateActor(String id, Actors actorDetails) {
        Actors existingActor = actorsRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Actor with ID " + id + " not found"));

        existingActor.setFirstName(actorDetails.getFirstName());
        existingActor.setLastName(actorDetails.getLastName());
        existingActor.setPhone(actorDetails.getPhone());
        existingActor.setEmail(actorDetails.getEmail());
        existingActor.setImage(actorDetails.getImage());
        existingActor.setSex(actorDetails.getSex());
        existingActor.setEmployeeId(actorDetails.getEmployeeId());
        existingActor.setPosition(actorDetails.getPosition());

        return actorsRepository.save(existingActor);
    }

    @Override
    public void deleteStudent(String id) {
        Student existingStudent = studentRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));
        studentRepository.delete(existingStudent);
    }

    @Override
    public void deleteActor(String id) {
        Actors existingActor = actorsRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Actor with ID " + id + " not found"));
        actorsRepository.delete(existingActor);
    }
}
