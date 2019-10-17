package project1.com.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import project1.com.messenger.entities.Customer;
import project1.com.messenger.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = {"/", "/login"})
	public String login(Model model) {
		model.addAttribute("customer", new Customer());
		return "Login";
	}
	@RequestMapping(value = {"/register"})
	public String register(Model model) {
		model.addAttribute("customer", new Customer());
		return "Register";
	}
	@RequestMapping("/processLogin")
	public String doLogin(@ModelAttribute("Customer") Customer customer, Model model) {
		Customer tcustomer = customerService.login(customer);
		if( tcustomer == null)
			return "Error";
		else {
			model.addAttribute("customer", tcustomer);
			return "Profile";
		}		
	}
	@RequestMapping("/processRegister")
	public String doRegister(@ModelAttribute("Customer") Customer customer, Model model) {
		Customer tcustomer = customerService.register(customer);
		if( tcustomer == null)
			return "Error";
		else {
			model.addAttribute("customer", customer);
			return "Profile";
		}		
	}
}
