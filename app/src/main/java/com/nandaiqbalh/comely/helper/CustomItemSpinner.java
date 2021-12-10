package com.nandaiqbalh.comely.helper;

public class CustomItemSpinner {
    private String spinnerGenderName;
    private int spinnerGenderImage;

    public CustomItemSpinner(String spinnerGenderName, int spinnerGenderImage) {
        this.spinnerGenderName = spinnerGenderName;
        this.spinnerGenderImage = spinnerGenderImage;
    }

    public String getSpinnerGenderName() {
        return spinnerGenderName;
    }

    public void setSpinnerGenderName(String spinnerGenderName) {
        this.spinnerGenderName = spinnerGenderName;
    }

    public int getSpinnerGenderImage() {
        return spinnerGenderImage;
    }

    public void setSpinnerGenderImage(int spinnerGenderImage) {
        this.spinnerGenderImage = spinnerGenderImage;
    }
}
