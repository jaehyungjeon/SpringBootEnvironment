package com.example.personal;

import com.example.personal.Dto.Member;
import com.example.personal.Repository.MainRepository;
import com.example.personal.RepositoryImpl.MainRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PersonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalApplication.class, args);
	}

	/* run 하면서 jpa를 이용한 insert 구현 */
//	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(PersonalApplication.class, args);
//
//		MainRepository repository = context.getBean(MainRepository.class);
//		repository.save(new Member("tot","1", "QQ"));
//	}

}
