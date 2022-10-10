package db;

import entity.*;

import java.util.List;

public interface IDBServices {

    List<Subject> getAllActiveSubjects();

    void createSubject (String subject);

    Subject getSubjectById (String id);

    void modifySubject (String id, String newSubject);

    void deleteSubject (String id);

    List<Student> getAllActiveStudents();

    void createStudent (String surname, String name, String group, String date);

    Student getStudentById (String id);

    void modifyStudent (String id, String newSurname, String newName, String newGroup, String newDate);

    void deleteStudent (String id);

    List <Term> getAllActiveTerms();

    List <Subject> getSubjectsByTerm (String idTerm);

    void createTerm (String duration, String idsSubject);

    Term getTermById (String id);

    void modifyTerm (String id, String newDuration, String newIdsSubject);

    void deleteTerm (String id);

    List <Mark> getMarks(String idStud, String idTerm);

    List<Role> getAllActiveRoles();

    boolean canLogin (String login, String password, String idRole);




}
