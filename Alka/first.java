import java.util.Arrays;
public class first{  //public is used for make the code accesible to everyone 
    private static double  divide(double var1, double var2){
	if (var2==0){
		System.out.println("Denominator can't be zero!");
		return Double.NaN;
	}
    	return var1/var2;
    }
    public static void main(String[] args){
	//System.out.println(args.length);
	System.out.println(Arrays.toString(args));
	double num1 = Double.parseDouble(args[0]);
	double num2 = Double.parseDouble(args[1]);
	double result = divide(num1,num2);
	System.out.println(result);
	if(Double.compare(result, Double.NaN) == 0) {
		System.out.println("This division is not possible!") ;
	}
	else{
		System.out.println(result) ;
	}
	//System.out.println(args[1]);

       // System.out.println(divide(5,0)) ; //we can use back slash for this then output will be My name is "alka noor".
    }
}


 
//this is single line comment 
/*this is multiple line 
.....
comment*/






