package com.nba.nba_zone.player;

// import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="player_data")
public class Player {

    @Id
    @Column(name="id", unique = true)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="team_abb")
    private String team;

    @Column(name="age")
    private Double age;

    @Column(name="height")
    private Double height;

    @Column(name="weight")
    private Double weight;

    @Column(name="college")
    private String college;

    @Column(name="country")
    private String country;

    @Column(name="draft_year")
    private String draft_year;
    
    @Column(name="draft_number")
    private String draft_number;

    @Column(name="gp")
    private Integer gp;

    @Column(name="pts")
    private Double pts;
    
    @Column(name="reb")
    private Double reb;

    @Column(name="ast")
    private Double ast;
    
    @Column(name="season")
    private String season;

}
