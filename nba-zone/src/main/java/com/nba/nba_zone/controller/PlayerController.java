package com.nba.nba_zone.controller;

import com.nba.nba_zone.player.*;
import com.nba.nba_zone.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="nba/player")
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String team,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String country){
            if (team!=null) {
                return playerService.getPlayerfromTeam(team);
            } else if (name!=null){
                return playerService.getPlayersByName(name);
            } else if (country!=null){
                return playerService.getPlayersByCountry(country);
            }
            return playerService.getPlayer();
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
        // will return 201
    }

    @PutMapping
    public ResponseEntity<Player> updPlayer(@RequestBody Player player){
        Player resultPlayer = playerService.updPlayer(player);
        if(resultPlayer!=null){
            return new ResponseEntity<>(resultPlayer,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<Player> delPlayer(@PathVariable String playerName){
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
