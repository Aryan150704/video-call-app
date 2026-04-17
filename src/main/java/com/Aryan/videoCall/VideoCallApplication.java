package com.Aryan.videoCall;

import com.Aryan.videoCall.user.User;
import com.Aryan.videoCall.user.UserService;
import com.Aryan.videoCall.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	){
		return args->{
			service.register(User.builder()
					.username("Aryan")
					.email("aryan@mail.com")
					.password("aaaa")
					.build());
			service.register(User.builder()
					.username("John")
					.email("john@mail.com")
					.password("jjjj")
					.build());
			service.register(User.builder()
					.username("Riva")
					.email("riva@mail.com")
					.password("rrrr")
					.build());
		};
	}
}
