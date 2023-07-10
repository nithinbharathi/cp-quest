#include <stdio.h>

int main(void) {
	int n,result =0,a;
	scanf("%d",&n);
	for(int i =0;i<n;i++){
	  scanf("%d",&a);
	  result = result^a;
	  }
	  printf("%d",result);
	return 0;
}
