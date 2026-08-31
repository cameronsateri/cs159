/**
 * This class creates a car, as well as its make, year, and current speed.
 * 
 * @author Cameron Sateri
 * @version 1/25/23
 */
public class Car {
    private String make;
    private int year;
    private double speed;

    /**
     * Creates the Car object when called.
     * 
     * @param make version of the car
     * @param year year of the car
     */
    public Car(String make, int year) {
        this.make = make;
        this.year = year;
        this.speed = 0.0;
    }

    /**
     * Returns a statement containing the values in the Car object.
     * 
     * @return ret string containing the year, make and speed of the Car.
     */
    public String toString() {
        String ret = "A " + this.year + " " + this.make + " that is going ";
        ret = ret + this.speed + " mph";
        return ret;
    }

    public String getMake() {
        return this.make;
    }

    public int getYear() {
        return this.year;
    }

    public double getSpeed() {
        return this.speed;
    }

    /**
     * Increases the speed of the car by 5 mph up to 150 mph.
     * 
     * @return ret statement containing the equation for the change in speed.
     */
    public String accelerate() {
        String ret = this.speed + " + ";
        if (this.speed + 5 >= 150) {
            ret = ret + (150 - this.speed);
            this.speed = 150.0;
        } else {
            ret = ret + "5.0";
            this.speed = this.speed + 5;
        }
        ret = ret + " = " + this.speed;
        return ret;
    }

    /**
     * Decreases the speed of the car by 5 mph down to 0 mph.
     */
    public void brake() {
        this.speed = this.speed - 5;
        if (this.speed <= 0) {
            this.speed = 0;
        }
    }
}
