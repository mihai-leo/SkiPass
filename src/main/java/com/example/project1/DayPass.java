package com.example.project1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class DayPass extends SkiPass{
    private int days;
    private LocalDate dataStart;
    private  LocalDate dataEnd;
    Utility ut= new Utility();
    public DayPass()
    {}
    public DayPass(String name,String numbber, LocalDate date,LocalDate dateStart, int days, int bootSnowboard, int bootSki, int snowboard, int ski )
    {

        this.name=name;
        this.phoneNumber=numbber;
        this.date=date;
        this.dataStart=dateStart;
        this.dataEnd=dataStart.plusDays(days);
        this.price=ut.getPriceDays(days)+days*ut.getPriceEquipment(bootSnowboard,bootSki,ski,snowboard);
        this.days=days;
        this.bootSki=bootSki;
        this.bootSnowboard=bootSnowboard;
        this.Ski=ski;
        this.Snowboard=snowboard;
    }
    public DayPass(String name,String number, LocalDate date,int days,LocalDate dateStart, LocalDate dateEnd, int bootSki, int bootSnowboard , int ski ,int snowboard,int price)
    {

        this.name=name;
        this.phoneNumber=number;
        this.date=date;
        this.dataStart=dateStart;
        this.dataEnd=dateEnd;
        this.price=price;
        this.days=days;
        this.bootSki=bootSki;
        this.bootSnowboard=bootSnowboard;
        this.Ski=ski;
        this.Snowboard=snowboard;
    }
    public LocalDate getDataEnd()
    {
        return this.dataEnd;
    }
    public void printPass()
    {
        System.out.println("Name:"+this.name+"  Emission date:"+this.date+"  Pass Type: "+this.days+" days");
        System.out.println("Active from "+this.dataStart+" to "+this.dataEnd);
    }
    public  void printInFille(String fileName)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)))
        {
            writer.write("DayPass"+" "+this.name+" "+this.phoneNumber+" "+this.date+" "+this.days+" "+this.dataStart+" "+this.dataEnd+" "+this.bootSki+" "+this.bootSnowboard+" "+this.Ski+" "+this.Snowboard+" "+this.price);
            writer.newLine(); // Add a new line after the appended content
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public boolean isActive()
    {
        if(LocalDate.now().isAfter(this.dataEnd)||this.dataStart.isAfter(LocalDate.now()))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
