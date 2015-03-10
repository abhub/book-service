package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.props.LoginSetting;

@RestController
public class BookServiceRestController {
	
	@Value("${name}")
	private String name;
	
	@Autowired
	LoginSetting login;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping("/name")
	public String getName() {
		return login.toString();
	}
}
