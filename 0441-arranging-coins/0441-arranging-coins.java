// class Solution {
//     public int arrangeCoins(int n) {
//         long count = 0; 
//         int i = 1;

//         while(count <= n){
//             count = i*(i+1)/2;
//             i++;
//         }
//         return i-2;
//     }
// }

class Solution {
    public int arrangeCoins(int n) {
        int i = 1;
        while(n>=i){
          n-=i;
          i++;
        }
        return i-1;
    }
}