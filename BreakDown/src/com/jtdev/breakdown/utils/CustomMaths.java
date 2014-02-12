package com.jtdev.breakdown.utils;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 10/14/13
 * Time: 8:22 PM
 */
public class CustomMaths
{
    public static float distance(float x, float y) { return (float) Math.sqrt(Math.pow(x,2) + Math.pow(y,2)); }
    public static float distance(float x1, float y1, float x2, float y2) { return (float) Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2)); }
    public static double distance(double x1, double y1, double x2, double y2) { return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2)); }

    public static float angle(float x, float y) { return (float) Math.toDegrees(Math.atan2(y,x)); }
    public static float angle(float x1, float y1, float x2, float y2) { return (float) Math.toDegrees(Math.atan2(y2-y1,x2-x1));  }
    public static double angle(double x1, double y1, double x2, double y2) { return Math.toDegrees(Math.atan2(y2-y1, x2-x1)); }

    //Just use MathUtils
    //public static float randomRange(float low, float high) { return (float) ((Math.random() * (high - low)) + low); }
    //public static double randomRange(double low, double high) { return (Math.random() * (high - low)) + low; }
}
