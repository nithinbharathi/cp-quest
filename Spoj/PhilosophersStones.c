#include <stdio.h>
#define max(a,b) ((a)>(b)?a:b)
#define min(a,b) ((a)>(b)?b:a)
int main(void) {
int test;
         scanf("%d",&test);
         int m,n;
        while(test-->0){
            scanf("%d %d",&m,&n);
            int arr[m][n];
            int dp[m][n];
            for(int i =0;i<m;i++){
                for(int j =0;j<n;j++){
                    scanf("%d",&arr[i][j]);
                } 
            }
            for(int i =0;i<n;i++){
                dp[0][i] = arr[0][i];   
            }
            int max_value =-9999 ;
            for(int i =1;i<m;i++){
                for(int j =0;j<n;j++){
                    if(j-1>=0 && j+1<n){
                        dp[i][j] = max(max(dp[i-1][j-1]+arr[i][j],dp[i-1][j]+arr[i][j]),dp[i-1][j+1]+arr[i][j]);
                    }else if(j == 0){
                        dp[i][j] = max(dp[i-1][j]+arr[i][j],dp[i-1][j+1]+arr[i][j]);
                    }else{
                        dp[i][j] = max(dp[i-1][j-1]+arr[i][j],dp[i-1][j]+arr[i][j]);
                    }
                    if(i == m-1){
                        if(dp[i][j]>max_value){
                            max_value = dp[i][j];
                        }
                    }
                }
            }
            
            printf("%d\n",max_value);
        }


	return 0;
}
