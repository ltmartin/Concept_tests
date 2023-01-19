package be.ltmartin.tictactoerest.controller;

import be.ltmartin.tictactoerest.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping("/newgame")
    public ResponseEntity<Boolean> newGame(){
        if (gameService.newGame())
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.SEE_OTHER);
    }
    @GetMapping("/getboard")
    public ResponseEntity<Character[][]> getBoard(){
        return new ResponseEntity<>(gameService.getBoard(), HttpStatus.OK);
    }

    @GetMapping("/play/{row}/{column}/{character}")
    public ResponseEntity<String> play(@PathVariable Integer row, @PathVariable Integer column, @PathVariable Character character){
        return new ResponseEntity<>(gameService.play(row, column, character), HttpStatus.OK);
    }
}
