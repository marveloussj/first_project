package com.msj_02_smis_dao;

import java.util.List;



public interface IStudentDao {
     void save(Student stu);
     
     void delete(Long id);
     
     void updata(Student stu);
     
     Student get(Long id);
     
     List<Student> list();
}
