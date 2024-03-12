package com.example.project1;

import java.io.*;

import java.time.LocalDate;
import java.util.Scanner;

public class PointPass extends SkiPass{
    private int points;
    Utility ut= new Utility();
    public PointPass()
    {}
    public PointPass(String name, String phone, LocalDate date, int points,int bootSnowboard,int bootSki, int snowboard,int ski )
    {
        this.name=name;
        this.phoneNumber=phone;
        this.date=date;
        this.price=ut.getPricePoints(points)+ut.getPriceEquipment(bootSnowboard,bootSki,ski,snowboard);
        this.points=points;
        this.bootSki=bootSki;
        this.bootSnowboard=bootSnowboard;
        this.Ski=ski;
        this.Snowboard=snowboard;
    }
    public PointPass(String name, String phone, LocalDate date, int points,int bootSki,int bootSnowboard,int ski, int snowboard,int price )
    {
        this.name=name;
        this.phoneNumber=phone;
        this.date=date;
        this.points=points;
        this.bootSki=bootSki;
        this.bootSnowboard=bootSnowboard;
        this.Ski=ski;
        this.Snowboard=snowboard;
        this.price=price;
    }
    public int getPoints()
    {
        return this.points;
    }
    public int getPrice()
    {
        return this.price;
    }
    public void usePoints(int x)
    {
        if(this.points<x)
        {
            this.points=0;
        }
        else {
            this.points = this.points - x;
        }
    }
    public int buyPoints(int x)
    {
        this.points=this.points+x;
        this.price=this.price+ut.getPricePoints(x);
        return ut.getPricePoints(x);

    }
    public void printPass()
    {
        System.out.println("Name:"+this.name+"  Emission date:"+this.date+"  Pass Type: on points");
        System.out.println(this.points+" points left");
    }
    public  void printInFille(String fileName)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)))
        {
        writer.write("PointPass"+" "+this.name+" "+this.phoneNumber+" "+this.date+" "+this.points+" "+this.bootSki+" "+this.bootSnowboard+" "+this.Ski+" "+this.Snowboard+" "+this.price);
        writer.newLine(); // Add a new line after the appended content
    } catch (IOException e) {
        System.err.println("Error appending to the file: " + e.getMessage());
        e.printStackTrace();
    }

    }
    public boolean isActive()
    {
        if(this.points>0)
            return true;
        else
            return false;
    }
}
