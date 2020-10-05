package com.api.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RespostaModelo;
import com.api.produto.repositorio.ProdutoRepositorio;

@RestController // Responsável por criar a estrutura MVC para trabalhar com API's
@RequestMapping("/api") // Define a url que quando for requisitada chamara o metodo
public class ProdutoControle {
	//Ações
	@Autowired // diz ao Spring que ações é um repositório e que ele tem que ter acesso às funcionalidades como findByAll, findByCodigo ou save.
	private ProdutoRepositorio acoes; //acoes -> é responsável por executar ações previamente disponíveis no repositorio.
	
	// Listar produtos
		@RequestMapping(value="/produtos", method=RequestMethod.GET) // valor vazio, porque essa será a API principal. 
		public @ResponseBody List<ProdutoModelo> listar() { // Essa Annotation faz com que o return seja exibido no navegador.
			return acoes.findAll();
		}

	// Cadastrar produtos
		@RequestMapping(value="/produtos", method=RequestMethod.POST)
		public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
			return acoes.save(produto);
		}
		
		//Filtrar Produtos
		@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.GET) // <- definindo a rota. As chaves uma variável, nesse caso, o código que digitarei para que o produto seja encontrado. 
		public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo) { // Definindo o caminho que será feita a filtragem, nesse caso, pelo codigo.
			return acoes.findByCodigo(codigo);
		}
		
		// Alterar produtos
		@RequestMapping(value="/produtos", method=RequestMethod.PUT)
		public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
			return acoes.save(produto);
		}
		
		//Remover produtos
		@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.DELETE)
		public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {
			
			RespostaModelo resposta = new RespostaModelo();
			
			//para que apareça uma mensagem no console do postman se deletou ou não o produto:
			try{
				ProdutoModelo produto = filtrar(codigo);
				this.acoes.delete(produto);
				resposta.setMensagem("Produto removido com sucesso!"); 
			}catch(Exception erro) {
				resposta.setMensagem("Falha ao remover: "+erro.getMessage());
			}
			
			return resposta;
			
		}
	
	//Resoluções iniciais pra explicação dos métodos.	
	/*// Início
	@RequestMapping(value="", method=RequestMethod.GET) // valor vazio, porque essa será a API principal. 
	public @ResponseBody String inicio() { // Essa Annotation faz com que o return seja exibido no navegador.
		return "Bem vindo a API de produtos!";
	}
	
	// Sobre
	@RequestMapping(value="/sobre", method=RequestMethod.GET)
	public @ResponseBody String sobre() {
		return "Sobre API...";
	}
	
	// Contato
	@RequestMapping(value="/contato", method=RequestMethod.GET)
	public @ResponseBody String contato() {
		return "Fale conosco. =)";
	}*/
	
}
