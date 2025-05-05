//By Recursion
class Solution {
    public char findKthBit(int n, int k) {
        
        if(n == 1) return '0';

        String res = findSn(n);
        return res.charAt(k-1);//as it is 0 based indexing
    }

    String findSn(int n){
        
        if(n == 1) return "0";

        String sPrev = findSn(n-1);
        StringBuilder sb = new StringBuilder(sPrev);
        StringBuilder rev = new StringBuilder();//empty sb

        for(int i = 0; i<sb.length(); i++)
        {
            if(sPrev.charAt(i) == '0') rev.append('1');
            else {rev.append('0');}
        }
        rev.reverse();//reverse the rev Sb

        return sPrev + "1" + rev.toString();
    }
}

//By Loop