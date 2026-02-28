package in.sp.students.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.students.entites.Student;
import in.sp.students.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository stdRepo;
	@Override
	public List<Student> getAllStudents() {
			return stdRepo.findAll();
	}
	@Override
	public Student saveStudent(Student student) {
			return stdRepo.save(student); 
	}
	@Override
	public Student getById(int id) {
		   return stdRepo.findById(id).get();
	}
	@Override
	public void deletByid(int id) {
		stdRepo.deleteById(id);;
	}

}
