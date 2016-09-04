public class applyHash{
        public static HashMap<String, Integer> hash = new HashMap<>();
        public static HashMap<String,List<String>>  anagramMap= new HashMap<>();
        public int uniqCount =0;
        public String fileName = "data.ulysses";
    public int count=0;
        public static void main(String[] args){
                applyHash appHash = new applyHash();
                appHash.run();
        
       }
        
       public void run()
       {
                try {
                File inFile = new File (fileName);

                Scanner sc = new Scanner (inFile);
                while (sc.hasNextLine())
                {
                        String line = sc.nextLine();
                        Pattern exp = Pattern.compile("[\\p{Punct}\\d]");
                        Matcher w = exp.matcher(line);
                        String[] words = w.replaceAll("").toLowerCase().split(" ");
                        
                        if(words.length!=1)
                        {       
                                matchAnagrams(words);
                                hashWords(words);
                                //System.out.println(Arrays.toString(words));
                        }
                                                else
                                                {
                                                        for(String word : words)
                                                        {
                                                                if(word!="")
                                                                {
                                                                        matchAnagrams(words);
                                                                        hashWords(words);
                                                                }
                                                        }
                                                }
                                                //Hashing words , counting occurrence and counting unique words
                        
               }   
                sc.close();
              displayStats();
        }

       catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
       } 
        
       
        
       public void matchAnagrams(String[] words) {
            for (String s : words) {//Matching Anagrams
                                
                                                                char[] chars = s.toCharArray();
                                                                Arrays.sort(chars);
                                                                String newWord = new String(chars);
                                                                if(!anagramMap.containsKey(newWord))
                                                                {
                                                                        anagramMap.put(newWord, new ArrayList<String>());
                                                                }
                                                                if(!anagramMap.get(newWord).contains(s))
                                                                        anagramMap.get(newWord).add(s);             
                                                }
          }
          
      public void hashWords(String[] words){
                for(int i =0; i<words.length;i++){
                        if(words[i].equals("")){
                                }                       
                else if(hash.containsKey(words[i]))
                        {
                                
                        hash.put(words[i],(Integer) (hash.get(words[i])+1));
                        if(hash.get(words[i])==2)
                                uniqCount--;
                    }
                else{
                                hash.put(words[i],1);
                        uniqCount++;
                                        
                    }
                }
                
      }
     public void topFreqWords()
     {
     
        System.out.println("Top 10 frequently used words:");
        Object values[] = hash.values().toArray();
        Arrays.sort(values);
        String[] hashKeyArray = hash.keySet().toArray(new String[hash.keySet().size()]);
        int countdown =10;
        int i =1;
        int lengthOfArr = values.length;
        while(i<11)
        {
                
                for(String w: hashKeyArray)
                {
                        
                        if(hash.get(w).equals(values[values.length -i])&& countdown>0)
                                {
                                        System.out.println(countdown+": "+w+" "+hash.get(w));
                                        countdown--;
                                        i++;
                                        break;
                                }
                }
                
        }
        
     } 
      
      
     public void noOfAnagrams()
     {
        Object[] value = null;
        int countAn=0;
        for(String key: anagramMap.keySet()){
                value = anagramMap.get(key).toArray();
                if(value.length>1){
                        count= count+ value.length;
                        countAn++;
                }
            }
            
                System.out.println("Number of Anagrams: "+ countAn);
            
        
     } 
     
     public void listOfMostAnagrams()
     {
        int max=0;
        String keyHigh="";
        Object[] value = null;
        for (String key: anagramMap.keySet()){
                                value = anagramMap.get(key).toArray();  
                                if(value.length > max)
                                {
                                        max = value.length;
                                        keyHigh = key;
                                }}
                                
                System.out.println("List with most anagrams: "+keyHigh + ":" + Arrays.toString(anagramMap.get(keyHigh).toArray()));             
     
     }
     
     public void displayStats()
     {
                
            System.out.println("Number of unique words "+ uniqCount);
            
            //Top Ten Frequent words
            topFreqWords();
            //Number of anagrams
                noOfAnagrams();
            
            //List with most anagrams
            listOfMostAnagrams();
            
                        
     } 

}

