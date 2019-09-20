package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Entrou em DataInitializr");
		
		List<User> listaUser = userRepository.findAll();
		if (listaUser.isEmpty() || listaUser == null) {
			createUser("Givaldo Braz", "givaldo.braz@gmail.com");
			createUser("João", "joao@gmail.com");
			createUser("Maria", "maria@gmail.com");
		}
		
		User user0 = userRepository.findByName("Maria");
		System.out.println("Email do usuario de nome Maria: "+ user0.getEmail());
		
		User user1 = userRepository.findByNameQualquerCoisa("João");
		System.out.println("Email do usuario de nome João: "+ user1.getEmail());
		
		User user2 = userRepository.findByNameIgnoreCase("maria");
		System.out.println("Email do usuario de nome Maria: "+ user2.getEmail());
		
//		User user3 = userRepository.getOne(6L);
//		System.out.println("Nome usuario id=6: "+ user3.getName());
		
//		userRepository.deleteById(5L);
		
//		User user4 = userRepository.getOne(6L);
//		user4.setName("Nome Alterado");
//		userRepository.save(user4);
//		System.out.println("Nome usuario id=6: "+ user4.getName());
		
	}

	public void createUser(String name, String email) {
		User user = new User(name, email);
		
		userRepository.save(user);
	}
}
