package demo.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookServiceCMD implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring boot command line runner");
	}

}
