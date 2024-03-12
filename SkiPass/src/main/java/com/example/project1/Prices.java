package com.example.project1;

public class Prices {
    private int bootSnowboardPrice ;
    private int bootSkiPrice ;
    private int snowboardPrice ;
    private int skiPrice ;
    private int twoPromotion;
    private int fourPromotion;
    private int pointPrice;
    private int hourPrice;
    private int dayPrice;
    public Prices(int bootSnowboardPrice, int bootSkiPrice, int snowboardPrice, int skiPrice, int twoPromotion, int fourPromotion,int pointPrice,int hourPrice,int dayPrice){
        this.bootSkiPrice=bootSkiPrice;
        this.bootSnowboardPrice=bootSnowboardPrice;
        this.skiPrice=skiPrice;
        this.snowboardPrice=snowboardPrice;
        this.twoPromotion=twoPromotion;
        this.fourPromotion=fourPromotion;
        this.pointPrice=pointPrice;
        this.dayPrice=dayPrice;
        this.hourPrice=hourPrice;
    }
    public int getBootSnowboardPrice()
    {
        return this.bootSnowboardPrice;
    }
    public int getBootSkiPrice()
    {
        return  this.bootSkiPrice;
    }
    public int getSnowboardPrice()
    {
        return this.snowboardPrice;
    }

    public int getDayPrice() {
        return this.dayPrice;
    }

    public int getHourPrice() {
        return this.hourPrice;
    }

    public int getPointPrice() {
        return this.pointPrice;
    }

    public int getSkiPrice() {
        return this.skiPrice;
    }

    public int getFourPromotion() {
        return this.fourPromotion;
    }
    public int getTwoPromotion()
    {
        return this.twoPromotion;
    }
}
