package in.sp.students.services;

import java.util.List;

import in.sp.students.entites.Student;

public interface StudentService 
{
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student getById(int id);
	public void deletByid(int id);
}
