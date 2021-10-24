package com.ghulam.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ghulam.sms.model.Course;
import com.ghulam.sms.model.Student;
import com.ghulam.sms.service.CourseService;
import com.ghulam.sms.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;
	private CourseService courseService;

	@Autowired
	public StudentController(StudentService studentService, CourseService courseService) {
		this.studentService = studentService;
		this.courseService = courseService;
	}

	@GetMapping("addStudentForm")
	public String showStudentForm(Model model) {
		// create model attribute to bind form data
		Student student = new Student();
		// fetch all course data to bind form data
		List<Course> courses = courseService.findByAll();
		// set an attribute in model
		model.addAttribute("student", student);
		model.addAttribute("courses", courses);
		return "new_student";
	}

	@RequestMapping("/")
	public String home(Model model) {
		/*
		 * call the listByPage
		 *
		 * 1 -> start page
		 */

		return listByPage(1, model);
	}

	@GetMapping("/page/{pageNumber}")
	public String listByPage(@PathVariable("pageNumber") int pageNumber, Model model) {
		// fetch all page in service
		Page<Student> pages = studentService.findAll(pageNumber);

		int currentPage = pageNumber;
		// get total page
		int totalPages = pages.getTotalPages();
		// get student list in pages object
		List<Student> students = pages.getContent();
		// set an attribute in model
		model.addAttribute("students", students);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		return "index";
	}

	@RequestMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable(value = "id") int id, Model model) {
		// get student from the service
		Student student = studentService.findById(id);
		List<Course> courses = courseService.findByAll();
		// set student as a model attribute to pre-populate the form
		model.addAttribute("student", student);
		model.addAttribute("courses", courses);
		return "new_student";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(Model model, @Valid @ModelAttribute("student") Student student,
			BindingResult bindingResult) {
		// check error is occurs or not
		if (bindingResult.hasErrors()) {
			List<Course> courses = courseService.findByAll();
			model.addAttribute("student", student);
			model.addAttribute("courses", courses);
			return "new_student";
		}

		studentService.save(student);
		return "redirect:/";
	}

	@RequestMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id") int id) {
		studentService.delete(id);
		return "redirect:/";
	}

}
