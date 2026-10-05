public class Test
{

	public static String explodeTime(double t) {
		int year = (int)(t/60/60/24/365.2425);
		t = t - year*(60*60*24*365.2425);
		int days = (int)( t / 60/60/24 );
		t = t - days*60*60*24;
		int hours =  (int)( t/60/60 );
		t = t - hours*60*60;
		int min =  (int)( t / 60);
		t = t - min*60;
		double sec= t;
		return year+" years; "+ days +" days; "+ hours +" hours; "+ min+" min.; "+sec+" s";		
	}

    public static void main(String[] args)
	{
		System.out.println("Calibrating...");
		long start = System.currentTimeMillis();
        	long res = AnalyseFibonacci.fibo_r(45);
        	long stop = System.currentTimeMillis();
        	double timePerRecCall = (stop-start)/1000.0/AnalyseFibonacci.nar(45);
        System.out.println("Time per recursive call : "+ timePerRecCall +" s");
        	
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a number for n : ");
        int n= sc.nextInt();
        
	   start = System.currentTimeMillis();
        res = AnalyseFibonacci.fibo_i(n);
        stop = System.currentTimeMillis();
        System.out.println("fibo_i("+n+") = "+res);
        System.out.println("Time = "+(stop-start)/1000.0+"s");
        
     double timeToWait = (timePerRecCall*AnalyseFibonacci.nar(n));
     System.out.println("Number of recursive calls : "+AnalyseFibonacci.nar(n));
     System.out.println("Time to wait: " + timeToWait +" s");
     System.out.println("Time to wait: " + explodeTime(timeToWait));    

     
	start = System.currentTimeMillis();
        res = AnalyseFibonacci.fibo_r(n);
        stop = System.currentTimeMillis();
        System.out.println("fibo_r("+n+") = "+res);
        System.out.println("Time = "+(stop-start)/1000.0+"s");
    	}
}