package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entity.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
//		User user = new User();
//		user.setName("Shubham Choudhary");
//		user.setCity("Burhanpur");
//		user.setStatus("I am Software Engineer");
//		
		//saving single user
//		User user1 = userRepository.save(user);
//        System.out.println(user1);
	
//	  // create object of new user
//		User user2= new User();
//		user2.setName("Nitin");
//		user2.setCity("Pune");
//		user2.setStatus("I am banker");
//		User user3= new User();
//		user3.setName("Chirag");
//		user3.setCity("Chennai");
//		user3.setStatus("I am IIB");
//		
//		//saving single user
//		List<User> users = List.of(user2,user3);
//		// save multiple objects
//		Iterable<User> result = userRepository.saveAll(users);
//		
//		result.forEach(user->{
//			System.out.println(user);
//		});

//		//Update
//		Optional<User> optional = userRepository.findById(2);
//		User user = optional.get(); //search using Id
//		user.setName("Prajwal"); // then update
//		User result = userRepository.save(user);
//		System.out.println(result);
//	
		// hpw tp get the data
		//findById(id) return Optional Containing
	 
		//search	
//		Iterable<User> itr = userRepository.findAll();
    //old method
//        Iterator<User> iterator = itr.iterator();
//        
//        while(iterator.hasNext())
//        {
//        	User user=iterator.next();
//        	System.out.println(user);
//        }
//		 itr.forEach(user->System.out.println(user));
//	}

	  //delete the user element
//	userRepository.deleteById(2);
//	System.out.println("deleted");
//		
		
		//delete all
//		Iterable<User> allusers = userRepository.findAll();
//		
//		allusers.forEach(user-> System.out.println(user));
//		
//		userRepository.deleteAll(allusers);
		
//		List<User> users = userRepository.findByName("Chirag");
	//	List<User> users = userRepository.findByNameAndCity("chirag","chennai");
//		users.forEach(e->System.out.println(e));
		
		
		List<User> users = userRepository.getAllUser();
		users.forEach(e->System.out.println(e));
		
		System.out.println("__________________________________________");
		
		List<User> userByName = userRepository.getUserByName("shubham choudhary");
		userByName.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("__________________________________________");
		
		List<User> userByNameAndCity = userRepository.getUserByNameAndCity("chirag","chennai");
		userByName.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("__________________________________________");

        List<User> usersall = userRepository.getUsers();	
        usersall.forEach(e->{System.out.println(e);});
	}
}
