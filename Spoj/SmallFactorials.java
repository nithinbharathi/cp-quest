public class spoj {

	public static void main(String[] args) {
		FastReader input = new FastReader();
		// TODO Auto-generated method stub
		int test = input.nextInt();
		while(test-->0){
			int num = input.nextInt();
		    String result = fact(num);
		    System.out.println(result);
			
		}
		
	}
	public static String fact(int num){
		int result[] = new int[1000];
		String str = "";
		result[0] =1;
		int size =1;
		for(int i =2;i<=num;i++){
			size = helper(i,result,size);
		}
		for(int i =size-1;i>=0;i--){
			str+=result[i];
		}
		
		return str;
		
	}
	
	public static int helper(int n,int arr[],int size){
		int carry =0;
		for(int i =0;i<size;i++){
			int prod = (arr[i]*n)+carry;
			arr[i] = prod%10;
			carry = prod/10;
		}
		while(carry != 0){
			arr[size] = carry%10;
			carry/=10;
			size++;
		}
		
		return size;
	}
		
	
}	
	   
class FastReader{
	StringTokenizer str;
	BufferedReader br;
	public FastReader(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	public String next(){
		while(str == null || !str.hasMoreTokens()){
			try{
				str = new StringTokenizer(br.readLine());

			}
			catch (Exception e){
				throw new RuntimeException(e);
			}
		}
		return str.nextToken();
	}
	public int nextInt(){
		return Integer.parseInt(next());
	}
}
