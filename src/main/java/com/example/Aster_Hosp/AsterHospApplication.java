package com.example.Aster_Hosp;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AsterHospApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsterHospApplication.class, args);
	}

//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}
}
