package com.example.project1;

import java.io.*;
import java.util.Arrays;
public class EquipmentStock {
    private int[][] bootSnowboardStock ;
    private int[][] bootSkiStock ;
    private int[][] snowboardStock ;
    public int[][] skiStock ;
    public EquipmentStock(int[] bootSnowboardStock, int[] bootSkiStock,int[] snowboardStock,int[] skiStock, int[] sizesBoots,   int[] sizesSnowboard,int[] sizesSki)
    {

        this.bootSkiStock =new int[2][sizesBoots.length];
        this.bootSkiStock[0]= Arrays.copyOf(sizesBoots,sizesBoots.length);
        this.bootSkiStock[1]=Arrays.copyOf(bootSkiStock,sizesBoots.length);
        this.bootSnowboardStock =new int[2][sizesBoots.length];
        this.bootSnowboardStock[0]= Arrays.copyOf(sizesBoots,sizesBoots.length);
        this.bootSnowboardStock[1]=Arrays.copyOf(bootSnowboardStock,sizesBoots.length);
        this.snowboardStock =new int[2][sizesSnowboard.length];
        this.snowboardStock[0]=Arrays.copyOf(sizesSnowboard,sizesSnowboard.length);
        this.snowboardStock[1]=Arrays.copyOf(snowboardStock,sizesSnowboard.length);
        this.skiStock= new int[2][skiStock.length];
        this.skiStock[0]=Arrays.copyOf(sizesSki,sizesSki.length);
        this.skiStock[1]=Arrays.copyOf(skiStock,sizesSki.length);
    }

    private static String intArrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public void printIntLine(String file,int[] line)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true)))
        {
           writer.write(intArrayToString(line));
            writer.newLine(); // Add a new line after the appended content
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void clearFile(String file)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
          //  writer.write());
            //writer.newLine(); // Add a new line after the appended content
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void  printStock()
    {
        clearFile("stock.txt");
        printIntLine("stock.txt",this.bootSkiStock[0]);
        printIntLine("stock.txt",this.bootSkiStock[1]);
        printIntLine("stock.txt",this.bootSnowboardStock[0]);
        printIntLine("stock.txt",this.bootSnowboardStock[1]);
        printIntLine("stock.txt",this.skiStock[0]);
        printIntLine("stock.txt",this.skiStock[1]);
        printIntLine("stock.txt",this.snowboardStock[0]);
        printIntLine("stock.txt",this.snowboardStock[1]);
    }
    public boolean borrowSkiBoots(int x)
    {
        for(int i=0;i<this.bootSkiStock[0].length;i++)
        {
            if(this.bootSkiStock[0][i]==x)
            {
                if(this.bootSkiStock[1][i]>0)
                {
                    this.bootSkiStock[1][i]--;
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
        return false;
    }
    public boolean borrowSnowboardBoots(int x)
    {
        for(int i=0;i<this.bootSnowboardStock[0].length;i++)
        {
            if(this.bootSnowboardStock[0][i]==x)
            {
                if(this.bootSnowboardStock[1][i]>0)
                {
                    this.bootSnowboardStock[1][i]--;
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
        return false;
    }
    public boolean borrowSki(int x)
    {
        for(int i=0;i<this.skiStock[0].length;i++)
        {
            if(this.skiStock[0][i]==x)
            {
                if(this.skiStock[1][i]>0)
                {
                    this.skiStock[1][i]--;
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
        return false;
    }
    public boolean borrowSnowboard(int x)
    {
        for(int i=0;i<this.snowboardStock[0].length;i++)
        {
            if(this.snowboardStock[0][i]==x)
            {
                if(this.snowboardStock[1][i]>0)
                {
                    this.snowboardStock[1][i]--;
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
        return false;
    }
    public boolean returnSkiBoots(int x)
    {
        for(int i=0;i<this.bootSkiStock[0].length;i++)
        {
            if(this.bootSkiStock[0][i]==x)
            {
                this.bootSkiStock[1][i]++;
                return true;
            }
        }
        return false;
    }
    public boolean returnSnowboardBoots(int x)
    {
        for(int i=0;i<this.bootSnowboardStock[0].length;i++)
        {
            if(this.bootSnowboardStock[0][i]==x)
            {
                this.bootSnowboardStock[1][i]++;
                return true;
            }
        }
        return false;
    }
    public boolean returnSki(int x)
    {
        for(int i=0;i<this.skiStock[0].length;i++)
        {
            if(this.skiStock[0][i]==x)
            {
                this.skiStock[1][i]++;
                return true;
            }
        }
        return false;
    }
    public boolean returnSnowboard(int x)
    {
        for(int i=0;i<this.snowboardStock[0].length;i++)
        {
            if(this.snowboardStock[0][i]==x)
            {
                this.snowboardStock[1][i]++;
                return true;

            }
        }
        return false;
    }
}
