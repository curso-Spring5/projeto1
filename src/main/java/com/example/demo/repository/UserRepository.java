package com.example.demo.repository;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.User;

// MySQL
//public interface UserRepository extends JpaRepository<User, Long>{
// MongoDB
public interface UserRepository extends MongoRepository<User, Long>{

	// #### Métodos Mágicos ####
	// ## Ver "Table 3. Supported keywords inside method names" em 
	// ## "https://docs.spring.io/spring-data/jpa/docs/current/reference/html/"
	
	User findByName(String name);
	
	// Este "select" é escrito na linguaga JPQL
	//@Query("select u from User u where u.name = ?1")
	@Query("{ 'name' : ?0 }")
	User findByNameQualquerCoisa(String name);
	
	// Este "select" é escrito na linguaga JPQL
	//@Query("select u from User u where u.name like %?1%")
	//User findByNameComLike(String name);
	
	User findByNameIgnoreCase(String name);
}
