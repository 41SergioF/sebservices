package com.carlossergio.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carlossergio.webservices.entities.Category;
import com.carlossergio.webservices.entities.Order;
import com.carlossergio.webservices.entities.User;
import com.carlossergio.webservices.entities.enums.OrderStatus;
import com.carlossergio.webservices.repositories.CategoryRepository;
import com.carlossergio.webservices.repositories.OrderRepository;
import com.carlossergio.webservices.repositories.UserRepository;

/*Primeira mente essa classe irá servir para popular o DB
 * 
 * Como faz isso ser executado quando o programa for rodado?
 * Para isso fazemos a classe implementar a interface para isso */

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	/*
	 * Vamos agora fazer uma injeção de dependência. O framework SpringBoot já tem
	 * uma uma injeção padrão, precisamos usar a anotação @Autowired para isso
	 */
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WATTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WATTING_PAYMENT, u1);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
