class Solution {
    public String intToRoman(int num) {
        
        //Instead of using a map, use 2 arrays
        int index[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String symbol[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";
        int len  = index.length;

        for(int i = 0; num!=0  ; i++)
        {
           while(num >= index[i] )
           {
             num -= index[i];
              res+=symbol[i];
           }
        //    else
        //    {
        //      continue ;
        //    }
        } 
        return res; 
    }
}