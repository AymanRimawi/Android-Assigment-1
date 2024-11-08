package com.example.project1;

public class practice {

    private  String name ;
    private String Rounds ="";
    private int CountperRound =0;
    private int ImadeID;

    public practice(String name, int ImadeID) {
        this.name = name;

        this.ImadeID=ImadeID;
    }

    public practice(String name, String rounds, int countperRound , int ImadeID) {
        this.name = name;
        Rounds = rounds;
        CountperRound = countperRound;
        this.ImadeID=ImadeID;
    }

    public String getName() {
        return name;
    }

    public int getImadeID() {
        return ImadeID;
    }

    public void setImadeID(int imadeID) {
        ImadeID = imadeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRounds() {
        return Rounds;
    }

    public void setRounds(String countForRounds) {
        this.Rounds = countForRounds;
    }

    public int getCountperRound() {
        return CountperRound;
    }

    public void setCountperRound(int CountperRound) {
        this.CountperRound = CountperRound;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toString2() {
        return  Rounds+"\n"+CountperRound;
    }
}
