package com.example.cheztataangela.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Patisseries implements Parcelable {

    //Variable----------------------------------

    private String PatisserieName;
    private String PatisserieDescritpion;
    private int PatisserieImage;
    private String PatisserieIngredient;

    //Constructeur----------------------------------------

    public Patisseries(String PatisserieName, String PatisserieDescription, int PatisserieImage, String PattiserieIngredient){
        super();
        this.PatisserieName = PatisserieName;
        this.PatisserieDescritpion = PatisserieDescription;
        this.PatisserieImage = PatisserieImage;
        this.PatisserieIngredient = PattiserieIngredient;
    }

    public Patisseries(Parcel source){
        this.PatisserieName = source.readString();
        this.PatisserieDescritpion = source.readString();
        this.PatisserieImage = source.readInt();
        this.PatisserieIngredient = source.readString();
    }

    //Getter & Setter -------------------------------

    public String getPatisserieName() {
        return PatisserieName;
    }

    public String getPatisserieDescritpion() {
        return PatisserieDescritpion;
    }

    public int getPatisserieImage() {
        return PatisserieImage;
    }

    public String getPatisserieIngredient() {
        return PatisserieIngredient;
    }

    public void setPatisserieName(String patisserieName) {
        PatisserieName = patisserieName;
    }

    public void setPatisserieDescritpion(String patisserieDescritpion) {
        PatisserieDescritpion = patisserieDescritpion;
    }

    public void setPatisserieImage(int patisserieImage) {
        PatisserieImage = patisserieImage;
    }

    public void setPatisserieIngredient(String patisserieIngredient) {
        PatisserieIngredient = patisserieIngredient;
    }

    //Parceble-----------------------------------------------

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(PatisserieName);
        dest.writeString(PatisserieDescritpion);
        dest.writeInt(PatisserieImage);
        dest.writeString(PatisserieIngredient);
    }

    public static final Parcelable.Creator<Patisseries> CREATOR = new Parcelable.Creator<Patisseries>(){

        @Override
        public Patisseries createFromParcel(Parcel source) {
            return new Patisseries(source);
        }

        @Override
        public Patisseries[] newArray(int size) {
            return new Patisseries[size];
        }
    };

}
