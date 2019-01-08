package com.ccff.mybatis.model;

public class BasketballPlayer {
    private int id;
    private String name;
    private int age;
    private Double weight;
    private int height;
    private int number;
    private String team;
    private String position;

    public BasketballPlayer() {
    }

    public BasketballPlayer(String name, int age, Double weight, int height, int number, String team, String position) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.number = number;
        this.team = team;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int num) {
        this.number = num;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "BasketballPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", number=" + number +
                ", team='" + team + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
