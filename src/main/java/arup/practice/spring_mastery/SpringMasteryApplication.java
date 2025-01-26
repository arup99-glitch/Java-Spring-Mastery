package arup.practice.spring_mastery;

import arup.practice.spring_mastery.oop.simpleTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMasteryApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringMasteryApplication.class, args);
		int a = 9;

		simpleTask obj = new simpleTask();

		obj.a=1;
		obj.b=2;

		obj.sum();
		obj.sub();

	}

}
