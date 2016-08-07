import java.util.function.DoubleFunction;

/**
 * Created by vlad on 06.08.2016.
 */
public class LocalThread extends Thread {
    double point;
    double result = 5;
    double tolerance = 0.01;
    boolean flag = true;
    double functionValue;
    DoubleFunction<Double> doubleFunction = new DoubleFunction<Double>() {
        @Override
        public Double apply(double value) {
            return (value*value*value) - 1;
        }
    };

    public LocalThread(double point) {
        this.point = point;
        this.functionValue = doubleFunction.apply(point);
        start();
    }

    public void run() {

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
