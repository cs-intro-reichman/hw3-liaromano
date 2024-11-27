/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		String str1m= preProcess(str1);
		String str2m= preProcess(str2);
		String str1n="";
		String str2n="";
		for(int i=0;i<str1m.length();i++)
		{
			if((str1m.charAt(i)>='a'&& str1m.charAt(i)<='z'))
			{
				str1n=str1n+str1m.charAt(i);
			}
		}
		for(int i=0;i<str2m.length();i++)
		{
			if((str2m.charAt(i)>='a'&& str2m.charAt(i)<='z'))
			{
				str2n=str2n+str2m.charAt(i);
			}
		}
		if(str1n.length()!=str2n.length())
		{
			return false;
		}
		else
		{
			int i=0;
			while(str2n.length()>0 && i<str2.length())
		{
			if(str2n.indexOf(str1n.charAt(i))==-1)
			{
				return false;
			}
			else{
				str2= str2.substring(0,i)+str2n.substring(i+1);
			}
			i++;
		}
	}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str= str.toLowerCase();
		String n="";
		for(int i=0;i<str.length();i++)
		{
			if((str.charAt(i)>='a'&& str.charAt(i)<='z')|| (str.charAt(i)==' '))
			{
				n=n+ str.charAt(i);
			}
		}
		return n;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		str= preProcess(str);
		String n="";
		int random=0;
		while(str.length()>0)
		{
			random=(int)(str.length()*Math.random());
			n=n+str.charAt(random);
			str= str.substring(0,random)+str.substring(random+1);
		}
		return n;
	}
}
