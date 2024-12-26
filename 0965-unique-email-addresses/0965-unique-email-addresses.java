class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        //for each loop
        for(String item:emails){
            StringBuilder copy = new StringBuilder();//empty string
            int i = 0;
            while(item.charAt(i) != '@'){
                if(item.charAt(i)=='.'){
                    i++;
                    continue;
                }
                if(item.charAt(i) =='+'){
                    break;
                }

                else{
                    copy.append(item.charAt(i));
                    i++;
                }
            }

            //append domain
            while(item.charAt(i)!='@') i++; //// Skip to '@'
            String domain = item.substring(i);
            //add
            set.add(copy.toString()+ domain);
        }
        return set.size();     
     } 
}
