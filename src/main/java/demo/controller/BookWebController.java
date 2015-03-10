package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.repository.BookRepository;

@Controller
public class BookWebController {

	@Autowired
	private BookRepository bookr;
	
	
	@RequestMapping("/bookStore")
	public String store(Model model) {
		model.addAttribute("books", bookr.findAll());
		return "bookStore";
		
	}
}
