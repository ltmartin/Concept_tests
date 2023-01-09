package be.bnp;

import be.bnp.controller.Game;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class TicTacToe implements CommandLineRunner
{
    @Resource
    private Game gameController;
    public static void main( String[] args )
    {
        SpringApplication.run(TicTacToe.class, args);
    }

    @Override
    public void run(String... args) {
        gameController.play();
    }
}
