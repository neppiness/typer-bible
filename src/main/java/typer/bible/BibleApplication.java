package typer.bible;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BibleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibleApplication.class, args);
	}
}
