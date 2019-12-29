import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class WeightedObservedPointsTest {
    static WeightedObservedPoints obs;
    static int power = 3;
    static int count = 0;

    static void WeightedObservedPoint(){
        obs = new WeightedObservedPoints();
    }

    //add a new point to the curve
    public static void addNewPoint(double x, double y) {
        obs.add(x, y);
        count++;
    }

    public static void printPolyPara(){
        // Instantiate a two-degree polynomial fitter.
        final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(power);

        // Retrieve fitted parameters (coefficients of the polynomial function).
        final double[] coeff = fitter.fit(obs.toList());
        for (double c : coeff) {
            System.out.println(c);
        }
    }

    //calculate the bolt latency by the cpu usage x
    public static double calcLatency(double x){
        double latency = 0;
        int pow = power;
        final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3);

        // Retrieve fitted parameters (coefficients of the polynomial function).
        final double[] coeff = fitter.fit(obs.toList());
        for (double c : coeff) {
            latency += c * Math.pow(x, pow--);
        }
        return latency;
    }

    public static void main(String[] args) {
        WeightedObservedPoint();
        addNewPoint(0.2,  0.7 * 2 + 20 + 0.4);
        printPolyPara();
        System.out.println(calcLatency(0.3));
        System.out.println();

        addNewPoint(0.2,  0.7 * 2 + 20 + 0.4);
        printPolyPara();
        System.out.println(calcLatency(0.3));
        System.out.println();

        addNewPoint(0.12,  0.7 * 12 + 20 + 0.3);
        printPolyPara();
        System.out.println(calcLatency(0.3));
        System.out.println();

        addNewPoint(0.32,  0.7 * 32 + 20 + 3.4);
        printPolyPara();
        System.out.println(calcLatency(0.3));
        System.out.println();

        addNewPoint(0.34 ,  0.7 * 34 + 20 + 5.8);
        printPolyPara();
        System.out.println(calcLatency(0.3));
        System.out.println();

        addNewPoint(0.58 , 0.7 * 58 + 20 + 8.4);
        printPolyPara();
        System.out.println(calcLatency(0.3));
        System.out.println();

        addNewPoint(0.43 , 0.7 * 43 + 20 + 0.28);
        printPolyPara();
        System.out.println(calcLatency(0.3));
        System.out.println();

        addNewPoint(0.27 , 0.7 * 27 + 20 + 0.4);
        printPolyPara();
        System.out.println(calcLatency(0.3));
        System.out.println();
    }
}