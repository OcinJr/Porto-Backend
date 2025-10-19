package com.nba.nba_zone.repository;

import com.nba.nba_zone.player.Player;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
    void deleteByName(String playerName);

    List<Player> findByNameContainingIgnoreCase(String name);
    List<Player> findByTeam(String teamName);
    List<Player> findByCountryContainingIgnoreCase(String country);
    Optional<Player> findByName(String name);
}
