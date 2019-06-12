package com.projectdayum.dayum.config;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Configuration
public class FirebaseConfig {

	@Bean
	public DatabaseReference firebaseDatabse() {
		final DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
		return firebase;
	}

	@PostConstruct
	public void init() {
		try {
			FirebaseApp.initializeApp(new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials
							.fromStream(new FileInputStream("src/main/resources/serviceAccountKey.json")))
					.setDatabaseUrl("https://formidable-fort-240905.firebaseio.com").build());
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

}