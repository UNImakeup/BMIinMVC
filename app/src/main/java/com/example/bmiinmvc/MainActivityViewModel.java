package com.example.bmiinmvc;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    String bmi;

    public void setBmi(String height, String weight) {
        BMImodel bmImodel = BMImodel.getInstance(height, weight); //Singleton bruges så for at kunne hente det i den næste aktivitet. Så kan man lave en anden viewmodel, for at tilgå det der.
        bmi = bmImodel.displayBMI(); //Kunne bruge displayBMI og have bmi som en String i stedet, der er tom til at starte med.
    }

    public String getBmi() {
        return bmi;
    }
}
