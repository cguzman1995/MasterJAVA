package es.uned.master.java.logactaesque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uned.master.java.logactaesque.model.Dice;
import es.uned.master.java.logactaesque.model.Rollable;

@SpringBootApplication
public class DiceConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(DiceConfiguration.class, args);
    }

    @Bean(name = "dice")
    public Rollable configDice() {
        return new Dice(new Integer[]{1, 2, 3, 4, 5, 6});
    }
}
