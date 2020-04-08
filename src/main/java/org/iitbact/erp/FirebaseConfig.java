package org.iitbact.erp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

	@PostConstruct
	public void initFirebase() {
		try {

			File file = ResourceUtils.getFile("classpath:firebase.json");
			FileInputStream serviceAccount = new FileInputStream(file);

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://hospital-erp-prod.firebaseio.com").build();
			FirebaseApp.initializeApp(options);
			System.out.println(FirebaseApp.DEFAULT_APP_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
