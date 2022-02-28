package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
    
    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};

    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    float[] a1 = new float[100];
    float[] a2;

    int minIndex = 0;
    int maxIndex = 0;
    float total_rf = 0;

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        for(int i = 0; i < rainfall.length; i++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        /* for(float r:rainfall)
        {
            println(r);
        } */

       /* int j  = 0;
        for(float r:rainfall)
        {
            println(r + "\t" + months[j]);
            j ++;
        } */

        /* for(int i = rainfall.length - 1; i >=0; i --)
        {
            println(rainfall[i] + "\t" + months[i]);
        } */

        /*
        float min_rf = rainfall[0];
        String min_mon = months[0];
        float max_rf = rainfall[0];
        String max_mon = months[0];
        float avg_rf = 0;
        for(int i = 0; i < rainfall.length; i++)
        {
            
            if(rainfall[i] < min_rf)
            {
                min_rf = rainfall[i];
                min_mon = months[i];
            }
            if(rainfall[i] > max_rf)
            {
                max_rf = rainfall[i];
                max_mon = months[i];
            }
            avg_rf += rainfall[i];
        }
        println("Minimum rainfall is " + min_rf + " mm in month " + min_mon);
        println("Maximum rainfall is " + max_rf + " mm in month " + max_mon);
        println("Average rainfall is " + avg_rf / 12 + " mm");
        */

        
        for(int i = 1; i < rainfall.length; i ++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            else if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            }
            total_rf += rainfall[i];
        }
        
        println("Max rainfall: " + rainfall[maxIndex] + " mm in month" + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " mm in month" + months[minIndex]);
        println("Total rainfall: " + total_rf + " mm");
        println("Average rainfall: " + total_rf / 12 + " mm");

    }

    public void draw()
    {
        background(0);
        colorMode(HSB);
        float w = width / (float)rainfall.length;
        noStroke();
        for(int i = 0; i < rainfall.length; i ++)
        {
            // float x = i * w;
            float x = map(i, 0, rainfall.length, 0, width);
            int c = (int)map(i, 0, rainfall.length, 0, 255);
            fill(c, 255, 255);
            float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
            rect(x, height, w, h);
            fill(255);
            textAlign(CENTER, CENTER);
            text(months[i], x + (w / 2), height - 50);
        }
    }
}
