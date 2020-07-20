package tech.enjaz.rose.sahga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SahgaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SahgaApplication.class, args);
    }
//
//    @Bean
//    public ApplicationRunner init(TestRepo repo){
//        return args -> {
//            TestEntity s = new TestEntity();
//            s.setName("Potato");
//            repo.save(s);
//        };
//    }

}
