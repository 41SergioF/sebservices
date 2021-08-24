package com.carlossergio.webservices.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlossergio.webservices.entities.User;

/*Esse classe é um recurso web implementado pelo controlador REST
 * 
 * Esse é um nome para o recurso. Nome do recurso "/users"
 * */
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	/*Esse método é um EndPoint para acessar os usuários
	 *Isso é um controlador REST */
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Maria", "maria@gmail.com", "85 98653298", "123456");
		/*Esse método vai retornar um objeto do tipo ResponseEntity.
		 * .ok diz que deu tudo certo.
		 * .body manda o corpo do user
		 * */
		return ResponseEntity.ok().body(user);
	}
	
}
