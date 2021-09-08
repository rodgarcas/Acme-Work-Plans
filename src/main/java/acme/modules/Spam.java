package acme.modules;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spam {
	
	private Spam() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static Boolean isSpam(String text, String spamwords, Double  threshold) {
		spamwords = spamwords.replace(" ", "");
		List<String> spamLs = Arrays.asList( spamwords.split(","));
		
		String txt1 = text.replace(",", "");
		String txt2 = txt1.replace(".", "");
		String txt3 = txt2.replace(" ", "");
		String txt4 = txt3.toLowerCase();
		
		Integer acum = 0;
		Integer nTxt4 = txt4.length();
		Integer nSpam = 0;
		
		for(String s : spamLs) {
			Integer nS = s.length();

			Pattern regex = Pattern.compile(s);
			Matcher m = regex.matcher(txt4);
			
			while(m.find()) {
				nSpam = nSpam + nS;
				acum = acum + 1 ;
			}
		}
		
		Double cSpam = (double) nSpam/nTxt4 * 100.0;
		return cSpam > threshold;
		
	}


}
