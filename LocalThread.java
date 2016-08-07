import java.util.function.DoubleFunction;

/**
 * Created by vlad on 06.08.2016.
 */
public class LocalThread extends Thread {
    double point;
    double result;
    double tolerance = 0.01;
    boolean flag = true;
    DoubleFunction<Double> doubleFunction = new DoubleFunction<Double>() {
        @Override
        public Double apply(double value) {
            return Math.sin(value);
        }
    };

    public LocalThread(double point) {
        this.point = point;
        start();
    }

    public void run() {
        double functionValue = doubleFunction.apply(point);

        if (Math.abs(functionValue) < tolerance) {
            result = point;
        } else if (Math.abs(functionValue) < tolerance) {
            result = point;
        } else if (Math.abs(functionValue) < tolerance) {
            result = point;
        } else if (functionValue > 0) {
            flag = true;
        } else if (functionValue < 0) {
            flag = false;
        }
    }
}
