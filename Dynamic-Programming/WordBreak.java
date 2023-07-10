
import java.util.*;
import java.lang.*;
import java.io.*;

class WordBreak
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    Set<String> set = new HashSet<String>();
        set.add("I");
        set.add("like");
        set.add("had");
        set.add("play");
        set.add("to");
        String s = "Ihadliketoplay";
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j =0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        System.out.println(dp[s.length()]);
        
	}
}
