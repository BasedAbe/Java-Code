public class CalculateAverage {

    public static void main(String[] args) {
        double[] numArray = {4025, 5487, 7590, 4223};
        double sum = 0.0;

        for (double num: numArray) {
           sum += num;
        }

        double average = sum / numArray.length;
        System.out.format("The average is: %.2f", average);
    }
}