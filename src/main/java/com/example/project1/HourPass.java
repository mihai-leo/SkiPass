package com.example.project1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class HourPass extends  SkiPass{
    private int hours;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    Utility ut= new Utility();
    public HourPass(){}
    public HourPass(String name,String number, LocalDate date,LocalTime time, int hours, int bootSnowboard, int bootSki, int snowboard, int ski )
    {
        this.name=name;
        this.phoneNumber=number;
        this.date=date;
        this.timeStart=time;
        this.timeEnd=time.plusHours(hours);
        this.price=ut.getPriceHours(hours)+ut.getPriceEquipment(bootSnowboard,bootSki,ski,snowboard);
        this.hours=hours;
        this.bootSki=bootSki;
        this.bootSnowboard=bootSnowboard;
        this.Ski=ski;
        this.Snowboard=snowboard;
    }
    public HourPass(String name, String phone, LocalDate date, int hours,LocalTime timeStart,LocalTime timeEnd,int bootSki,int bootSnowboard,int ski, int snowboard,int price )
    {
        this.name=name;
        this.phoneNumber=phone;
        this.date=date;
        this.hours =hours;
        this.timeStart=timeStart;
        this.timeEnd=timeEnd;
        this.bootSki=bootSki;
        this.bootSnowboard=bootSnowboard;
        this.Ski=ski;
        this.Snowboard=snowboard;
        this.price=price;
    }
    public LocalTime getTimeEnd()
    {
        return this.timeEnd;
    }
    public void printPass()
    {
        System.out.println("Name:"+this.name+"  Emission date:"+this.date+"  Pass Type: "+this.hours+" hours");
        System.out.println("Active from "+this.timeStart.getHour()+":" +this.timeStart.getMinute()+" to "+this.timeEnd.getHour()+":"+this.timeEnd.getMinute());
    }
    public  void printInFille(String fileName)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)))
        {
            writer.write("HourPass"+" "+this.name+" "+this.phoneNumber+" "+this.date+" "+this.hours+" "+this.timeStart+" "+this.timeEnd+" "+this.bootSki+" "+this.bootSnowboard+" "+this.Ski+" "+this.Snowboard+" "+this.price);
            writer.newLine(); // Add a new line after the appended content
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public boolean isActive()
    {
        if(LocalTime.now().isAfter(this.timeEnd))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public int buyHours(int x)
    {
        this.hours=this.hours+x;
        this.timeEnd=this.timeEnd.plusHours(x);
        this.price=this.price+ut.getPriceHours(x);
        return ut.getPriceHours(x);
    }
}
