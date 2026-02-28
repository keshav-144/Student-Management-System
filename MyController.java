package in.sp.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.students.entites.Student;
import in.sp.students.services.StudentService;

@Controller
public class MyController 
{
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public String getAllStudents(Model model)
	{
		model.addAttribute("students",service.getAllStudents());
		return "students";
	}
	
	@GetMapping("students/new")
	public String studentForm(Model model)
	{
		Student student = new Student();
		model.addAttribute("student",student);
		return "register";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute ("student") Student student)
	{
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model)
	{
		model.addAttribute("student",service.getById(id));
		
		return "edit";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute ("student") Student student)
	{
		Student existStd= service.getById(id);
		existStd.setFirstName(student.getFirstName());
		existStd.setLastName(student.getLastName());
		existStd.setEmail(student.getEmail());
		
		service.saveStudent(existStd);
		return "redirect:/students";	
	}
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id)
	{
		service.deletByid(id);
		return "redirect:/students";
	}
}
