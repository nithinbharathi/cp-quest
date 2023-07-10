#include <stdio.h>
#define max(a,b) ((a)>(b)?a:b)
#define min(a,b) ((a)>(b)?b:a)
int main(void) {
int test;
         scanf("%d",&test);
         int n;
        int s = 1;
        while(test-->0){
            scanf("%d",&n);
            if(n == 0){
                printf("Case %d: 0\n",s);
                s++;
                continue;
            }
            
            if(n == 1){
                long long int a;
                scanf("%lld",&a);
            	printf("Case %d: %lld\n",s,a);
                s++;
                continue;
            }
                long long int arr[n];
                long long int dp[n];
                for(int i =0;i<n;i++){
                    scanf("%lld",&arr[i]);
                }
                dp[0] = arr[0];
                dp[1] = max(dp[0],arr[1]);
                for(int i =2;i<n;i++){
                    dp[i] = max(dp[i-2]+arr[i],dp[i-1]);
                }
                printf("Case %d: %lld\n",s,dp[n-1]);
                s++;
            }
	return 0;
}
