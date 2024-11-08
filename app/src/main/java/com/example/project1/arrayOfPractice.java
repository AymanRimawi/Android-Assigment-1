package com.example.project1;

import java.util.ArrayList;
import java.util.List;

public class arrayOfPractice {
    private List<practice> practices;

    public arrayOfPractice() {
        practices = new ArrayList<>();;
    }

    public List<practice> getPractices() {
        return practices;
    }

    public void setPractices(List<practice> practices) {
        this.practices = practices;
    }

}
