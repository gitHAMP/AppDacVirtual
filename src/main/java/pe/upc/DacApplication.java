package pe.upc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DacApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(DacApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        String password = "equipodac";

        for (int i = 0; i < 14; i++) {
            String bcryptPassword = passwordEncoder.encode(password);
            System.out.println(bcryptPassword);
        }
    }


}
