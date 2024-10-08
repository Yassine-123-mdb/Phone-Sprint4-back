package com.yassine.phone;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.yassine.phone.entities.Phone;
import com.yassine.phone.entities.Type;

@SpringBootApplication
public class PhoneProject1Application implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(PhoneProject1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Phone.class,Type.class);
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}


}
