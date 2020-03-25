package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Student;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "insert";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Student st = new Student(id, name);
		String result = studentService.insert(st);
		System.out.println(st);
		if(result.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Inserted");
		}else {
			request.setAttribute("msg", "Record Not Inserted");
		}
		return "insert";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update() {
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Student st = new Student(id, name);
		String result = studentService.update(st);
		System.out.println(st);
		if(result.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Updated");
		}else {
			request.setAttribute("msg", "Record Updation Fail");
		}
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete() {
		return "delete";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		Student st = new Student();
		st.setId(id);
		String result = studentService.delete(st);
		System.out.println(st);
		if(result.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Deleted");
		}else {
			request.setAttribute("msg", "Record Deletion Fail");
		}
		return "delete";
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public String getAll(HttpServletRequest request) {
		List<Student> list = studentService.getAll();
		request.setAttribute("list", list);
		return "display";
	}

}
