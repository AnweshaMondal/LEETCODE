// class Solution {
//     public int hammingWeight(int n) {
//         //Inbuilt fn to convert in binary
//         String binary = Integer.toBinaryString(n);
//         int cout = 0;

//         for(int i = 0; i<binary.length(); i++){
//           if(binary.charAt(i) =='1'){
//              cout++;
//           }
//         }
//      return cout;
//     }
   
// }

//Bit manipulation
class Solution {
    public int hammingWeight(int n) {

    //it manipulates the binary representation of the number directly using bitwise operations,
    // as all integers are inherently stored in binary form in memory.
        int res = 0;

        while(n != 0){
            res+=n&1;//n & 1 extracts the least significant bit (LSB) of the binary representation.
            //11 & 1:
            //11 in binary: 1011
            //1 in binary: 0001
            //Result: 0001 → 1 (the LSB is 1).
            
            n = n>>>1 ;//shift digits in ryt side by 1 position
        }

        return res;
    }
}