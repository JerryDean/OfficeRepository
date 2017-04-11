package com.stee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import com.stee.gui.Gui;

@SpringBootApplication
public class NisApplication {	  
	public static void main(String[] args) {	 
		 Gui gui =new Gui();
		SpringApplication.run(NisApplication.class, args);
	}
}
