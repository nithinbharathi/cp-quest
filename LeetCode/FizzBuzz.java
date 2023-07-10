class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        result.add("1");
        for(int i=2;i<=n;i++){
            if(i%3 ==0 && i%5 ==0){
                result.add("FizzBuzz");
            }else if(i%3 == 0){
                result.add("Fizz");
            }else if(i%5 == 0){
                result.add("Buzz");
            }else{
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
