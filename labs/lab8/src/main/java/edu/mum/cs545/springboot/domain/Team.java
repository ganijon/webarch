package edu.mum.cs545.springboot.domain;


import java.util.List;

public class Team {

    private int teamKey;
    private String name;
    private String city;
    private String mascot;
    private List<Player> players;
    private Uniform homeUniform;
    private Uniform visitUniform;
    private List<Match> matchesAsHome;
    private List<Match> matchesAsVisitor;

}
