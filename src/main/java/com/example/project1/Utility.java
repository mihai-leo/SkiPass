package com.example.project1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.*;

public class Utility {
    Prices price=new Prices(40,40,50,50,20,30,10,20,130);
    public int getPriceEquipment(int bootSnowboard,int bootSki, int ski,int snowboard)
    {
        int x=0;
        if( bootSki!=0)
        {
            x=x+price.getBootSkiPrice();
        }
        if( ski !=0 )
        {
            x=x+price.getSkiPrice();
        }
        if(  snowboard!=0)
        {
            x=x+price.getSnowboardPrice();
        }
        if(bootSnowboard!=0 )
        {
            x=x+price.getBootSnowboardPrice();
        }
        if(bootSnowboard!=0 && bootSki!=0 &&ski !=0 && snowboard!=0)
        {
            x=x-price.getFourPromotion();
        }
        if( bootSki!=0 &&ski !=0 )
        {
            x=x-price.getTwoPromotion();
        }
        if(bootSnowboard!=0 &&  snowboard!=0)
        {
            x=x-price.getTwoPromotion();
        }
        return x;

    }
    public int getPricePoints(int points)
    {
        int x=0;
        x=points*price.getPointPrice();
        x=x-(points/5)*price.getPointPrice();;
        x=x-(points/10)*price.getPointPrice();;
        x=x-(points/20)*price.getPointPrice();;
        return x;
    }
    public int getPriceHours(int hours)
    {
        int x=0;
        x=hours*price.getHourPrice();
        return x;
    }
    public int getPriceDays(int days)
    {
        int x=0;
        x=days*price.getDayPrice();
        return x;
    }
    public boolean isInFille(String name, String file)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                if (wordInString(name,line)) {
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error when searching phone from the file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


   public boolean wordInString(String word,String line)
   {
       String[] words = line.split("\\s+");
       for (String aux:words)
       {
           if (aux.equals(word))
           {
               return true;
           }

       }
       return false;
   }

    public String removeFromFile(String name,String file)
   {
       String string=null;
       try {
           BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
           StringBuilder content = new StringBuilder();
           String line;
           while ((line = bufferedReader.readLine()) != null) {
               if (!wordInString(name,line)) {
                   content.append(line).append("\n");
               }
               else {
                   string=line;
               }
           }
           bufferedReader.close();

           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
           bufferedWriter.write(content.toString());
           bufferedWriter.close();

           System.out.println("Line with \"" + name + "\" deleted successfully.");

       } catch (IOException e) {
           e.printStackTrace();
       }
       return string;
   }
    public String getStringFromFile(String name,String file)
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (isInFille(name,line)) {
                    return line;
                }
            }
            bufferedReader.close();

            System.out.println("Line with \"" + name + "\" deleted successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static int[] convertArrayStringToInt(String[] str )
    {
        int ar[]=new int[str.length];
        for (int i=0;i<str.length;i++)
        {
            ar[i]=Integer.parseInt(str[i]);
        }
        return ar;
    }
    public PointPass stringToPointPass(String line)
    {
        String[] words=line.split("\\s+");
        PointPass pass=new PointPass(words[1],words[2],LocalDate.parse(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]));

        return pass;
    }
    public HourPass stringToHourPass(String line)
    {
        String[] words=line.split("\\s+");
        HourPass pass=new HourPass(words[1],words[2],LocalDate.parse(words[3]),Integer.parseInt(words[4]),LocalTime.parse(words[5]),LocalTime.parse(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]),Integer.parseInt(words[10]),Integer.parseInt(words[11]));

        return pass;
    }
    public DayPass stringToDayPass(String line)
    {
        String[] words=line.split("\\s+");
        DayPass pass=new DayPass(words[1],words[2],LocalDate.parse(words[3]),Integer.parseInt(words[4]),LocalDate.parse(words[5]),LocalDate.parse(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]),Integer.parseInt(words[10]),Integer.parseInt(words[11]));
        return pass;
    }

    public int[][] readStock(String file)
    {
        int[][] matrix =new int[8][];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String[] aux;

            for(int i=0;i<8;i++) {
                try {
                    line = reader.readLine();
                    aux = line.split(" ");
                    matrix[i] = convertArrayStringToInt(aux);
                }
                catch (Exception e)
                {
                    System.out.println("la "+i);
                }
            }
            reader.close();
            return matrix;
        } catch (IOException e) {
            System.err.println("Error deleting line from the file: " + e.getMessage());
            e.printStackTrace();
        }
        return matrix;
    }
}
