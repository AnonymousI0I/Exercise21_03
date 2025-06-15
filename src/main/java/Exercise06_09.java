public class Exercise06_09 {
    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        System.out.println("Feet    Meters     |     Meters    Feet");
        System.out.println("-----------------------------------------");

        double foot = 1.0;
        double meter = 20.0;

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-8.1f%-11.3f|     %-9.1f%.3f\n",
                    foot, footToMeter(foot), meter, meterToFoot(meter));
            foot++;
            meter += 5;
        }
    }
}
