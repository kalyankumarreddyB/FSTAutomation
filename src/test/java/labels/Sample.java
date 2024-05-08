package labels;

import java.text.DecimalFormat;

public class Sample {

	public static void main(String[] args) {

		double lat1=8.96;
	     double lat2=8.95;
	     double dif=lat1-lat2;

	     DecimalFormat df = new DecimalFormat("###.##");
	     System.out.println("Diff Val  : "+df.format(dif));

	}

}
