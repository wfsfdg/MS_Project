package com.example.msproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

public class SharedPreference {

    public static SharedPreferences getMealNamePf(Context context) {
        return context.getSharedPreferences("Meal_Name", Context.MODE_PRIVATE);
    }
    public static String getMealName(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getMealNamePf(context);
        return sharedPreferences.getString(key, defaultValue);
    }
    public static void putMealName(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getMealNamePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealYearPf(Context context) {
        return context.getSharedPreferences("Meal_Year", Context.MODE_PRIVATE);
    }
    public static int getMealYear(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getMealYearPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putMealYear(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getMealYearPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealMonthPf(Context context) {
        return context.getSharedPreferences("Meal_Month", Context.MODE_PRIVATE);
    }
    public static int getMealMonth(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getMealMonthPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putMealMonth(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getMealMonthPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealDayPf(Context context) {
        return context.getSharedPreferences("Meal_Day", Context.MODE_PRIVATE);
    }
    public static int getMealDay(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getMealDayPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putMealDay(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getMealDayPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealHourPf(Context context) {
        return context.getSharedPreferences("Meal_Hour", Context.MODE_PRIVATE);
    }
    public static int getMealHour(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getMealHourPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putMealHour(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getMealHourPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealMinutePf(Context context) {
        return context.getSharedPreferences("Meal_Minute", Context.MODE_PRIVATE);
    }
    public static int getMealMinute(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getMealMinutePf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putMealMinute(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getMealMinutePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealPricePf(Context context) {
        return context.getSharedPreferences("Meal_Price", Context.MODE_PRIVATE);
    }
    public static int getMealPrice(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getMealPricePf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putMealPrice(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getMealPricePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealKcalPf(Context context) {
        return context.getSharedPreferences("Meal_Kcal", Context.MODE_PRIVATE);
    }
    public static int getMealKcal(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getMealKcalPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putMealKcal(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getMealKcalPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealImagePf(Context context) {
        return context.getSharedPreferences("Meal_Image", Context.MODE_PRIVATE);
    }
    public static void putMealImage(Context context, String key, byte[] value) {
        SharedPreferences sharedPreferences = getMealImagePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String encodedImage = Base64.encodeToString(value, Base64.DEFAULT);
        editor.putString(key, encodedImage);
        editor.apply();
    }

    public static byte[] getMealImage(Context context, String key, byte[] defaultValue) {
        SharedPreferences sharedPreferences = getMealImagePf(context);
        String encodedImage = sharedPreferences.getString(key, null);
        if (encodedImage != null) {
            return Base64.decode(encodedImage, Base64.DEFAULT);
        } else {
            return defaultValue;
        }
    }/////////////////////////////////
    public static SharedPreferences getMealLocPf(Context context) {
        return context.getSharedPreferences("Meal_Loc", Context.MODE_PRIVATE);
    }
    public static String getMealLoc(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getMealLocPf(context);
        return sharedPreferences.getString(key, defaultValue);
    }
    public static void putMealLoc(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getMealLocPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealTypePf(Context context) {
        return context.getSharedPreferences("Meal_Type", Context.MODE_PRIVATE);
    }
    public static String getMealType(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getMealTypePf(context);
        return sharedPreferences.getString(key, defaultValue);
    }
    public static void putMealType(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getMealTypePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getMealReviewPf(Context context) {
        return context.getSharedPreferences("Meal_Review", Context.MODE_PRIVATE);
    }
    public static String getMealReview(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getMealReviewPf(context);
        return sharedPreferences.getString(key, defaultValue);
    }
    public static void putMealReview(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getMealReviewPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }/////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    public static SharedPreferences getDrinkNamePf(Context context) {
        return context.getSharedPreferences("Drink_Name", Context.MODE_PRIVATE);
    }
    public static String getDrinkName(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getDrinkNamePf(context);
        return sharedPreferences.getString(key, defaultValue);
    }
    public static void putDrinkName(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getDrinkNamePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkYearPf(Context context) {
        return context.getSharedPreferences("Drink_Year", Context.MODE_PRIVATE);
    }
    public static int getDrinkYear(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getDrinkYearPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putDrinkYear(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getDrinkYearPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkMonthPf(Context context) {
        return context.getSharedPreferences("Drink_Month", Context.MODE_PRIVATE);
    }
    public static int getDrinkMonth(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getDrinkMonthPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putDrinkMonth(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getDrinkMonthPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkDayPf(Context context) {
        return context.getSharedPreferences("Drink_Day", Context.MODE_PRIVATE);
    }
    public static int getDrinkDay(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getDrinkDayPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putDrinkDay(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getDrinkDayPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkHourPf(Context context) {
        return context.getSharedPreferences("Drink_Hour", Context.MODE_PRIVATE);
    }
    public static int getDrinkHour(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getDrinkHourPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putDrinkHour(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getDrinkHourPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkMinutePf(Context context) {
        return context.getSharedPreferences("Drink_Minute", Context.MODE_PRIVATE);
    }
    public static int getDrinkMinute(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getDrinkMinutePf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putDrinkMinute(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getDrinkMinutePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkPricePf(Context context) {
        return context.getSharedPreferences("Drink_Price", Context.MODE_PRIVATE);
    }
    public static int getDrinkPrice(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getDrinkPricePf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putDrinkPrice(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getDrinkPricePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkKcalPf(Context context) {
        return context.getSharedPreferences("Drink_Kcal", Context.MODE_PRIVATE);
    }
    public static int getDrinkKcal(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getDrinkKcalPf(context);
        return sharedPreferences.getInt(key, defaultValue);
    }
    public static void putDrinkKcal(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getDrinkKcalPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkImagePf(Context context) {
        return context.getSharedPreferences("Drink_Image", Context.MODE_PRIVATE);
    }
    public static void putDrinkImage(Context context, String key, byte[] value) {
        SharedPreferences sharedPreferences = getDrinkImagePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String encodedImage = Base64.encodeToString(value, Base64.DEFAULT);
        editor.putString(key, encodedImage);
        editor.apply();
    }

    public static byte[] getDrinkImage(Context context, String key, byte[] defaultValue) {
        SharedPreferences sharedPreferences = getDrinkImagePf(context);
        String encodedImage = sharedPreferences.getString(key, null);
        if (encodedImage != null) {
            return Base64.decode(encodedImage, Base64.DEFAULT);
        } else {
            return defaultValue;
        }
    }/////////////////////////////////
    public static SharedPreferences getDrinkLocPf(Context context) {
        return context.getSharedPreferences("Drink_Loc", Context.MODE_PRIVATE);
    }
    public static String getDrinkLoc(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getDrinkLocPf(context);
        return sharedPreferences.getString(key, defaultValue);
    }
    public static void putDrinkLoc(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getDrinkLocPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkTypePf(Context context) {
        return context.getSharedPreferences("Drink_Type", Context.MODE_PRIVATE);
    }
    public static String getDrinkType(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getDrinkTypePf(context);
        return sharedPreferences.getString(key, defaultValue);
    }
    public static void putDrinkType(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getDrinkTypePf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }/////////////////////////////////
    public static SharedPreferences getDrinkReviewPf(Context context) {
        return context.getSharedPreferences("Drink_Review", Context.MODE_PRIVATE);
    }
    public static String getDrinkReview(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getDrinkReviewPf(context);
        return sharedPreferences.getString(key, defaultValue);
    }
    public static void putDrinkReview(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getDrinkReviewPf(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }/////////////////////////////////

}
