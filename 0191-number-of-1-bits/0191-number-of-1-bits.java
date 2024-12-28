class Solution {
    public int hammingWeight(int n) {
        //Inbuilt fn to convert in binary
        String binary = Integer.toBinaryString(n);
        int cout = 0;

        for(int i = 0; i<binary.length(); i++){
          if(binary.charAt(i) =='1'){
             cout++;
          }
        }
     return cout;
    }
   
}