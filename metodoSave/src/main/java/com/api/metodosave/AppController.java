package com.api.metodosave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

@Controller
public class AppController { 
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		return "redirect:/new/";
	}
	
	@RequestMapping("/new")
	public String showNewProdutoPage(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		
		return "new_produto";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduto(@ModelAttribute("produto") Produto produto) {
		service.save(produto);
		
		return "redirect:/";
	}
}