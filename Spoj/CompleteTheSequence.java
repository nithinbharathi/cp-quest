#include <stdio.h>
int main(void) {
	int test;
	scanf("%d",&test);
	    while(test-->0){
	        
	        long long int a3,al3,sum;
	        scanf("%lld%lld%lld",&a3,&al3,&sum);
	        long long int  n = (2*sum)/(a3+al3);
	        long long int d = (al3-a3)/(n-5);
	        long long int a = a3-(2*d);
	        printf("%lld\n",n);
	        for(int i =0;i<n;i++){
	            printf("%lld ",a+(i*d));
	        }
	        printf("\n");
	    }

	return 0;
}
