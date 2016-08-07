/**
 * Created by vlad on 07.08.2016.
 */
public class CalculationProcessor {
    public static LocalThread [] localThreads = new LocalThread[3];
    public static double result = 0;

    public static void calculation(double a, double b) throws InterruptedException {
        double tolerance = 0.001;
        double second = (b + a)/2;
        double first = (a + second)/2;
        double third = (b + second)/2;
        double [] localPoints = {first,second,third};
        boolean [] flags = new boolean[3];
        for(int i = 0;i < 3;i++){
            localThreads[i] = new LocalThread(localPoints[i]);
            Thread.sleep(15);
            if(Math.abs(localThreads[i].result) < tolerance){
                result = localThreads[i].result;
                break;
            }else{
                flags[i] = localThreads[i].flag;
                //flag == true, functionValue > 0
                //flag == false, functionValue < 0
            }
            if(flags[0]) {
                calculation(a, first);
            }
            if(!flags[0] && flags[1]){
                calculation(first,second);
            }
            if(!flags[1] && flags[2]){
                calculation(second,third);
            }
            if(!flags[2]){
                calculation(third,b);
            }
        }
    }
}
