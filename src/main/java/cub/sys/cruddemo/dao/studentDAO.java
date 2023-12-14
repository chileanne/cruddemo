package cub.sys.cruddemo.dao;

import cub.sys.cruddemo.entity.Student;

import java.util.List;

public interface studentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();


    List<Student> findByLastName(String lastNmae);


    void update(Student student);


    void deleteById(Integer Id);
}
