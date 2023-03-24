package com.example.notion_ex;

import com.example.notion_ex.model.*;
import com.example.notion_ex.repository.*;
import com.example.notion_ex.service.FinancialActivityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.example.notion_ex"})
public class NotionExApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotionExApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepo userRepo, AdminRepo adminRepo, ClientRepo clientRepo, ToDoActivityRepo toDoActivityRepo,
						   ReadActivityRepo readBooksActivityRepo, FinancialActivityRepo financialActivityRepo, ProjectActivityRepo projectTasksActivityRepo) {
		return args -> {
			User user = new User();
			user.setName("Gigel");
			userRepo.save(user);

			User user1 = new Client();
			user1.setName("Costel");
			userRepo.save(user1);

			Admin admin = new Admin();
			admin.setName("Costel");
			adminRepo.save(admin);

			Client client = new Client();
			client.setName("Petrica");
			clientRepo.save(client);

			ToDoActivity activity = new ToDoActivity();
			activity.setTaskName("Must implement Java functions");
			toDoActivityRepo.save(activity);

			FinancialActivity act = new FinancialActivity();
			act.setExpense("Groceries");
			act.setCategory("Must");
			financialActivityRepo.save(act);

			System.out.println(financialActivityRepo.findFirstByExpense(("Groceries")).getExpense());

			ProjectActivity prAct = new ProjectActivity();
			prAct.setProjectName("Dealing with Java bugs");
			projectTasksActivityRepo.save(prAct);

			ReadActivity readAct = new ReadActivity();
			readAct.setType("Book");
			readBooksActivityRepo.save(readAct);


		};
	}
}
