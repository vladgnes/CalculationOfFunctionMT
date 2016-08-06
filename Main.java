import java.util.function.DoubleFunction;

/**
 * Created by vlad on 06.08.2016.
 */
public class Main {
    public static void main(String [] args){
        search(-0.8,0.5);

    }
    public static void search(double a, double b){
        DoubleFunction<Double> doubleFunction = new DoubleFunction<Double>() {
            @Override
            public Double apply(double value) {
                return Math.sin(value);
            }
        };
        double middle = (b+a)/2;
        double functionValue = doubleFunction.apply(middle);
        if( functionValue > 0){
            search(a,middle);
        }else if(functionValue < 0){
            search(middle,b);
        }else if(functionValue > - 0.009 || functionValue < 0.001){
            System.out.println(middle);
        }

    }



}
