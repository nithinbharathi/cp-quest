#include <stdio.h>

int main(void) {
    long long int test,c=1;
    scanf("%lld",&test);
    long long int dp[100001];
    dp[0] = 0;
    dp[1] = 0;
    for(int i =2;i<100001;i++){
        long long int num = i;
        long long int r = i;
        for(int j =2;j*j<=i;j++){
            if(num%j ==0){
                r= r-(r/j);
                while(num%j ==0){
                    num/=j;
                }
            }
           
        }
         if(num >1){
                r = r-(r/num);
            }
         dp[i] = dp[i-1]+i-r;
    }
    while(test-->0){
        long long int n;
        scanf("%lld",&n);
        printf("Case %lld: %lld\n",c,dp[n]);
        c++;
    }
    return 0;
    
}
