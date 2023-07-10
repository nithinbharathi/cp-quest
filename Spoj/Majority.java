#include <stdio.h>

int main(void) {
	int test,n;
	scanf("%d",&test);
	while(test-->0){
	    scanf("%d",&n);
	    int arr[n];
	    for(int i =0;i<n;i++){
	        scanf("%d",&arr[i]);
	    }
	    int m = 0,count =1;
	    for(int i =1;i<n;i++){
	        if(arr[m] ==arr[i]){
	            count++;
	        }else{
	            count--;
	        }
	        if(count == 0 ){
	            m = i;
	            count =1;
	        }
	    }
	    int c = arr[m];
	    count =0;
	    for(int i =0;i<n;i++){
	        if(c == arr[i]){
	            count++;
	        }
	    }
	    if(count > n/2){
	        printf("YES %d\n",c);
	    }else{
	        printf("NO\n");
	    }
	}
	return 0;
}

