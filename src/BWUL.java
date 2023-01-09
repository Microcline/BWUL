import java.util.Scanner;

public class BWUL {

    private double kbps_;
    private double days_;

    public BWUL( ) {
       kbps_ = 30.0;
       days_ = 30.0; 
    }
    
    /**
     * @param kbps
     * @param days
     */
    public BWUL(double kbps, double days) {
        kbps_ = kbps;
        days_ = days;
    }
    
    public BWUL(BWUL BWULCopy) {
        kbps_ = BWULCopy.getKbps();
        days_ = BWULCopy.getDays();
    }

    public void promptForData() {
        Scanner console = new Scanner(System.in);
        System.out.println("How many KB/s?");
        kbps_ = console.nextDouble();
        System.out.println("Over how many days?");
        days_ = console.nextDouble();
        console.close();
    }
    
    public double getKbps() {
        return kbps_;
    }
    
    public double getDays() {
        return days_;
    }
    
    public double computeMegabytes() {
    	//Formula: kbps * bits in a kB * days * hours in a day * minutes in an
    	//hour * seconds in a minute
        double totalBytes = kbps_ * 1024.0 * days_ * 24.0 * 60.0 * 60.0;
        double megabytes = totalBytes / 1048576;
        return megabytes;
    }
    
    public double computeGigabytes() {
    	//Formula: kbps * bits in a kB * days * hours in a day * minutes in an
    	//hour * seconds in a minute
        double totalBytes = kbps_ * 1024.0 * days_ * 24.0 * 60.0 * 60.0;
        double gigabytes = totalBytes / 1073843200.0;
        return gigabytes;
    }

    public String toString() {
    	String gigaByteStr = String.format("That is %.4f gigabytes, ",
    			this.computeGigabytes());
    	String megaByteStr = String.format("or %.4f megabytes",
    			this.computeMegabytes());
    	
    	return gigaByteStr + megaByteStr;
    }   
}