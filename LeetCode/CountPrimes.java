// Brute Force Approach 
// Time Complexity O(n*n) Not Accepted

class Solution {
    public int countPrimes(int n) {
        int count =0;
        for(int i =2;i<n;i++){
            if(is_prime(i)){
                count++;
            }
        }
        return count;
    }
    public boolean is_prime(int n){
        for(int i =2;i<n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}


//........................................................................
//O(n*sqrt(n)) Accepted
class Solution {
    public int countPrimes(int n) {
        int count =0;
        for(int i =2;i<n;i++){
            if(is_prime(i)){
                count++;
            }
        }
        return count;
    }
    public boolean is_prime(int n){
        for(int i =2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}

//..........................................................................
//Seive Of Eratosthenes O(log(log(n))) Accepted
class Solution {
    public int countPrimes(int n) {
        int count =0;
        boolean seive[] = new boolean[n];
        for(int i =2;i<n;i++){
            if(seive[i] == false){
                count++;
                for(int j =2;i*j<n;j++){
                    seive[i*j] = true;
                }
            }
        }

        return count;
       
    }
}
