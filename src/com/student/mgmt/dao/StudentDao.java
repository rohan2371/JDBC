package com.student.mgmt.dao;

import com.student.mgmt.entity.Student;

public interface StudentDao {
    public void display();
    public void insert(Student student);
    public void delete(int id);
    public void update(int id,String city);
    public void searchStudent(int id);
    public void jdbcDriverInfo();
}
