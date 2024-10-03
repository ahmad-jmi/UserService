package com.user.service.UserService;

import com.user.service.UserService.entities.Rating;
import com.user.service.UserService.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.sound.midi.Soundbank;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){
		Rating rating = Rating.builder()
				.rating(10)
				.userId("")
				.hotelId("")
				.feedback("This is created using feign client")
				.build();
		ResponseEntity<Rating> savedRating = ratingService.createRating(rating);
		System.out.println("new Rating created");
	}
}
