

import java.util.*;
import java.lang.*;
import java.io.*;

class JobScheduling
{
	public static void main (String[] args) throws java.lang.Exception
	{
		job jobs[] =new job[4];
		jobs[0] = new job(3,10,20);
		jobs[1] = new job(1,2,50);
        jobs[2] = new job(6,19,100);
        jobs[3] = new job(2,100,200);
   
        Comparator<job> comp = new Comparator<job>(){
            public int compare(job a,job b){
                if(a.end>b.end)return 1;
                return -1;
            }
        };
        Arrays.sort(jobs,comp);
        int dp[] = new int[jobs.length];
        dp[0] = jobs[0].data;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<jobs.length;i++){
            dp[i] = jobs[i].data;
            for(int j =0;j<i;j++){
                if(jobs[j].end <= jobs[i].start){
                    dp[i] = Math.max(dp[i],dp[j]+jobs[i].data);
                }
            }
            if(max<dp[i])max = dp[i];
        }
        System.out.println(max);
        
	}
}
class job{
    int start ;
    int end;
    int data;
    public job(int s,int e,int d){
        start = s;
        end = e;
        data =d;
    }
}
