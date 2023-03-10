
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import dao.StudentDao;
import domain.Student;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

		StudentDao studentDao = context.getBean(StudentDao.class);
		
		studentDao.create(new Student(1, "Alex", 22));
		studentDao.create(new Student(2, "Den", 18));
		studentDao.readAll().stream().forEach(System.out::println);
		System.out.println();
		
		studentDao.update(new Student(2, "Alex", 20));
		System.out.println(studentDao.readById(2));
		System.out.println();
				
		studentDao.delete(1);
		studentDao.readAll().stream().forEach(System.out::println);			
	}

}
