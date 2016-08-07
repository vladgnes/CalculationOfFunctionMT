import java.util.function.DoubleFunction;

public class Main {
    public static LocalThread [] localThreads = new LocalThread[3];
    public static double result = 0;

    public static void main(String [] args){
        double a = -0.8;
        double b = 0.5;
        calculation(a,b);


        System.out.println(result);
    }

    public static void calculation(double a, double b){
        double second = (b + a)/2;
        double first = (a + second)/2;
        double third = (b + second)/2;
        double [] localPoints = {first,second,third};
        boolean [] flags = new boolean[3];
        for(int i = 0;i < 3;i++){
            localThreads[i] = new LocalThread(a,b,localPoints[i]);
            //tyt
            if(localThreads[i].result != 0.0){
                result = localThreads[i].result;
                break;
            }else{
                flags[i] = localThreads[i].flag;
                //flag == true, functionValue > 0
                //flag == false, functionValue < 0
            }
        }
        if(flags[0]){
            calculation(a,first);
        }else if(!flags[0] && flags[1]){
            calculation(first,second);
        }else if(!flags[1] && flags[2]){
            calculation(second,third);
        }else if(!flags[2]){
            calculation(third,b);
        }

    }




}