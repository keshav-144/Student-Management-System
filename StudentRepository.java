package in.sp.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.students.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{

}
