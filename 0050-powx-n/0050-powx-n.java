class Solution {
    public double myPow(double x, int n) {

        //  if (n < 0) {
        //     x = 1 / x;
        //     n = -n;
        // }

        //  if(n>0){
            // if(n==0){
            //     return 1.0;
            // }
            // if(n%2 ==0){
            //   return myPow(x * x, n / 4);
            // }else{
            //      return x*myPow(x * x, n / 4);
            // }
        //  }

        //  if(n<0){
        //     if(n==0){
        //         return 1.0;
        //     }
        //    return  x/myPow(x,n+1);
        //  }
        return Math.pow(x,n);
        
    }
}