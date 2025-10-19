package com.nba.nba_zone.service;

import com.nba.nba_zone.player.Player;
import com.nba.nba_zone.repository.PlayerRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
  
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getPlayer(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayerfromTeam(String teamName){
        return playerRepository.findByTeam(teamName);
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findByNameContainingIgnoreCase(searchText);
    }

    public List<Player> getPlayersByCountry(String searchText){
        return playerRepository.findByCountryContainingIgnoreCase(searchText);
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updPlayer(Player updatedPlayer){
        Optional<Player> existPlayer = playerRepository.findByName(updatedPlayer.getName());

        if(existPlayer.isPresent()){
            Player playerToUpdate = existPlayer.get();

            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setAge(updatedPlayer.getAge());
            playerToUpdate.setHeight(updatedPlayer.getHeight());
            playerToUpdate.setWeight(updatedPlayer.getWeight());
            playerToUpdate.setCollege(updatedPlayer.getCollege());
            playerToUpdate.setCountry(updatedPlayer.getCountry());
            playerToUpdate.setDraft_year(updatedPlayer.getDraft_year());
            playerToUpdate.setDraft_number(updatedPlayer.getDraft_number());
            playerToUpdate.setGp(updatedPlayer.getGp());
            playerToUpdate.setPts(updatedPlayer.getPts());
            playerToUpdate.setReb(updatedPlayer.getReb());
            playerToUpdate.setAst(updatedPlayer.getAst());
            playerToUpdate.setSeason(updatedPlayer.getSeason());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        } 
        return null;
    }

    public void deletePlayer(String name){
        playerRepository.deleteByName(name);
    }
}
