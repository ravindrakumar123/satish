package com.visog.springmvc.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.visog.springmvc.model.Employee;
import com.visog.springmvc.service.EmployeeService;


@Controller
@RequestMapping("/home")
public class AppController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	MessageSource messageSource;
	
	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = {  "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Employee> employees = service.findAllEmployees();
		model.addAttribute("employees", employees);
		return "allemployees";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "registration2";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration2";
		}

		
		if(!service.isEmployeePasswordUnique(employee.getId(), employee.getPassword())){
			FieldError ssnError =new FieldError("employee","password",messageSource.getMessage("non.unique.ssn", new String[]{employee.getPassword()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration2";
		}
		
		service.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
		return "success";
	}


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String password, ModelMap model) {
		Employee employee = service.findEmployeeByPassword(password);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration2";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginMethod(ModelMap model){
		Employee employee= new Employee();
	    model.addAttribute("employee", employee);
		return "login";
		
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@PathVariable String name, String password, ModelMap model,BindingResult result){
		
		if(result.hasErrors()){
			return "login";
		}
		
		Employee employee = new Employee();
	    //model.addAttribute("employee", employee);
		//model.addAttribute("name", employee.getName());
		//model.addAttribute("password", password);
	    return "success";
	}

	//@RequestMapping(value={"/login"},method = RequestMethod.POST)

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	

	@RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}
	
}