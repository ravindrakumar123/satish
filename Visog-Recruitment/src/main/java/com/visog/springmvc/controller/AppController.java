package com.visog.springmvc.controller;

import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.visog.springmvc.dao.EmployeeDaoImpl;
import com.visog.springmvc.model.Student;
import com.visog.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/app")
public class AppController {
	
	@Autowired
	 EmployeeDaoImpl employeeDaoImpl;
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	MessageSource messageSource;
	 
	 //This method will list all existing employees.
	 
	@RequestMapping(value = {  "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Student> students = service.findAllStudents();
		model.addAttribute("students", students);
		return "allemployees";
	}
	
	
	

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public ModelAndView newStudent(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("edit", false);
		return new ModelAndView("registration");
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveStudent(@Valid Student student, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!service.isStudentStunoUnique(student.getId(), student.getStuno())){
			FieldError stunoError =new FieldError("employee","stuno",messageSource.getMessage("non.unique.stuno", new String[]{student.getStuno()}, Locale.getDefault()));
		    result.addError(stunoError);
			return "registration";
		}
		
		service.saveStudent(student);

		model.addAttribute("success", "Student " + student.getName() + " registered successfully");
		return "success";
	}


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{stuno}-student" }, method = RequestMethod.GET)
	public String editStudent(@PathVariable String stuno, ModelMap model) {
		Student student = service.findStudentByStuno(stuno);
		model.addAttribute("student", student);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{stuno}-student" }, method = RequestMethod.POST)
	public String updateStudent(@Valid Student student, BindingResult result,
			ModelMap model, @PathVariable String stuno) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isStudentStunoUnique(student.getId(), student.getStuno())){
			FieldError stunoError =new FieldError("student","stuno",messageSource.getMessage("non.unique.stuno", new String[]{student.getStuno()}, Locale.getDefault()));
		    result.addError(stunoError);
			return "registration";
		}

		service.updateStudent(student);

		model.addAttribute("success", "Student " + student.getName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{stuno}-student" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String stuno) {
		service.deleteStudentByStuno(stuno);
		return "redirect:/app/list"; 
	} 

	@RequestMapping(value = { "/home"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = { "/products"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "products";
	}

	@RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}
	
	/*@Autowired
    private EmployeeDao employeeDao;
 
   @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadForm(HttpServletRequest request) {
        return "registration";
    }
     
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
          
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
                  
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                 
                Student student = new Student();
                student.setFileName(aFile.getOriginalFilename());
                student.setData(aFile.getBytes());
                employeeDao.saveStudent(student);               
            }
}
  
        return "Success1";*/
    }  
	
/*}*/