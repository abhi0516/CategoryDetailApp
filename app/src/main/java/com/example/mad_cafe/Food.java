package com.example.mad_cafe;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String name;
    private double price;
    private String desc;
    private int imageResourceID;


    public static final Food[] myIceCream = {
            new Food("Strawberry Ice Cream", 7.99, "Ripe, juicy strawberries " +
                    "are pureed then woven throughout our classic strawberry ice cream",
                    R.drawable.strawberry_ice_cream),
            new Food("Vanilla Ice Cream", 7.99, "Our customers’ top choice, " +
                    "producing small batches using fresh cream, sugar, and " +
                    "pure Madagascar bourbon vanilla", R.drawable.vanilla_ice_cream),
            new Food("Cookies N' Cream", 7.99, "Copious chocolatey cookie crumbles" +
                    " combined with farm fresh cream, produced in small batches. " +
                    "Simply satisfying in every way.", R.drawable.cookies_and_cream_ice_cream),
    };

    public static final Food[] mySmoothies = {
            new Food("Mango Smoothie", 6.99, " Enjoy refreshing, tropical mango" +
                    " in this all-natural fruit smoothie blended with ice. It’s an indulgence" +
                    " you can feel good about.", R.drawable.mango_smoothie),
            new Food("Raspberry Smoothie", 6.99, "Healthy and extremely flavorful," +
                    " this raspberry smoothie is the perfect blend of sweet tart flavor and has " +
                    "the most vibrant color!", R.drawable.raspberry_smoothie),
            new Food("Blueberry Smoothie", 6.99, "This creamy and refreshing" +
                    " blueberry smoothie is made with juice, yogurt, frozen blueberries and banana," +
                    " all blended together into a frosty drink.", R.drawable.blueberry_smoothie),
    };

    public static final Food[] myShakes = {
            new Food("Banana Shake", 7.99, " Made with our super premium ice " +
                    "cream, our farm fresh milk and a fresh banana. Garnished with whipped " +
                    "cream and a Pirouline cookie.", R.drawable.banana_milkshake),
            new Food("Chocolate Shake", 7.99, "Made with our super premium ice" +
                    " cream, our farm fresh milk and chocolate syrup. Garnished with whipped cream" +
                    " and a Pirouline cookie.", R.drawable.chocolate_shake),
            new Food("Strawberry Shortcake Shake", 7.99, "Generous slices of " +
                    "shortcake are blended with ice cream, strawberries and farm fresh milk--then " +
                    "topped with our signature whipped cream and Pirouline " +
                    "cookie.", R.drawable.shakes_cakestrawberry),
    };

    //used code -> generate -> constructor

    public Food(String name, double price, String desc, int imageResourceID) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imageResourceID = imageResourceID;
    }

    // A default constructor is REQUIRED for the Parceable interface to work
    public Food() {
        name = "";
        price = 0;
        desc = "";
        imageResourceID = 0;
    }



    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
     *
     * It's important that all VARS listed here are in the same order in all constructors
     * @param parcel    the parcel that is received from the intent
     */

    public Food(Parcel parcel) {
        name = parcel.readString();
        price = parcel.readDouble();
        desc = parcel.readString();
        imageResourceID = parcel.readInt();
    }

    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(desc);
        dest.writeInt(imageResourceID);
    }



    // this code is needed for the Food class to work with Parcelable
    // This code will most likely stay the same for all classes you use Parcelable with
    // the only thing you need to change is the class name
    public static final Parcelable.Creator<Food> CREATOR = new
            Parcelable.Creator<Food>() {

                @Override
                public Food createFromParcel(Parcel parcel) {
                    return new Food(parcel);
                }

                @Override
                public Food[] newArray(int size) {
                    return new Food[0];
                }
            };

    /**
     * This method is required for the Parceable interface.  As of now, this method * is in the default state and doesn't really do anything.
     *
     * If your Parcelable class will have child classes, you'll need to
     * take some extra care with the describeContents() method. This would
     * let you identify the specific child class that should be created by
     * the Parcelable.Creator. You can read more about how this works on
     *  Stack Overflow with this link.
     *           https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
     * @return
     */

    @Override
    public int describeContents() {
        return 0;
    }



    // the toString method tells java what should be returned when we try to print a food object
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }


}
