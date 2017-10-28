package com.msj_01_smis_dao;

import java.util.List;

import com.msj_01_smis_domain.Student;

public interface IStudentDao {
     void save(Student stu);
     
     void delete(Long id);
     
     void updata(Student stu);
     
     Student get(Long id);
     
     List<Student> list();
}
