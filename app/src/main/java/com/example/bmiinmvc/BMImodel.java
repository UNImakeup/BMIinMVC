package com.example.bmiinmvc;

public class BMImodel {
    private static String Height;
    private static String Weight;
    private static float bmi;

    private static BMImodel instance;

    private BMImodel(String height, String weight) {
        this.Height = height;
        this.Weight = weight;
        this.bmi = calculateBMI();
    }

    public static BMImodel getInstance(String height, String weight) {
        if(instance == null){
            instance = new BMImodel(height, weight);
        }
        return instance;
    }


    public static float calculateBMI(){
        String heightStr = Height;
        String weightStr = Weight;

        float bmi = 0;

        if(heightStr!=null && !"".equals(heightStr) && weightStr!=null &&!"".equals(weightStr)){
            float heightvalue=Float.parseFloat(heightStr)/100;
            float weightValue=Float.parseFloat(weightStr);

            bmi =weightValue/(heightvalue * heightvalue);
        }
        return bmi;
    }

    public static String displayBMI(){
        String bmiLabel="";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "Very severely underweight";
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "very underweight";
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "Underweight";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "Normal";
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "Overweight";
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "Very Overweight";
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "Obese";
        } else {
            bmiLabel = "Fat fuck";
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        //answer.setText(bmiLabel);
        return bmiLabel;
    }
}
