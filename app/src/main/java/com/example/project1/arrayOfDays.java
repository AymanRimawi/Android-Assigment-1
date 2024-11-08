package com.example.project1;

public class arrayOfDays {
    private  arrayOfPractice [] arrayOfDays;

    public arrayOfDays() {
        arrayOfDays= new arrayOfPractice[7];

        for (int i = 0; i < arrayOfDays.length; i++) {
            arrayOfDays[i] = new arrayOfPractice();
        }
    }


    public arrayOfPractice[] getarrayOfDays() {
        return arrayOfDays;
    }

    public void setarrayOfDays(arrayOfPractice[] arrayOfPratices) {
        this.arrayOfDays = arrayOfPratices;
    }
}
