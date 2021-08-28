package com.carlossergio.webservices.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlossergio.webservices.entities.User;
import com.carlossergio.webservices.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	/*
	 * Injeção de dependência
	 */
	@Autowired
	private UserService userService;

	/*
	 * Funcionamento do método: A classe UserResource pede a UserService todas a
	 * entidades contidas no BD
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();

		return ResponseEntity.ok().body(list);
	}

	/*
	 * Esse trexo "(value = "/{id}")", diz que o resource
	 * receberá uma valor de Id
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = userService.insert(obj);
		///Forma padrão de criação de endereços
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		///Para respostas vazias
		return ResponseEntity.noContent().build();
	}
	
}
