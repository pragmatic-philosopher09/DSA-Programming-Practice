class FindAndReplacePattern {
    
    static boolean isPatternMatching(String word, String pattern)
    {
        if(word.length() != pattern.length())
            return false;
        
        Map<Character,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i<pattern.length();i++)
        {
            char pchar = pattern.charAt(i);
            char wchar = word.charAt(i);
            
            if(map.containsKey(pchar))
            {
                //Pattern's character is already mapped with word character
                if(map.get(pchar) != wchar)
                    return false;
                    
            }
            
            else
            {
                if(set.contains(wchar))
                    return false;
                map.put(pchar,wchar);
                set.add(wchar);
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> res = new ArrayList<>();
        for(String word: words)
        {
           if(isPatternMatching(word,pattern))
               res.add(word);
        }
        
        return res;
        
    }
}
