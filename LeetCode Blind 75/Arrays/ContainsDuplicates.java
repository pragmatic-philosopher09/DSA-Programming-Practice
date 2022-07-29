class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        
        /*
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()>=2)
                return true;
        }
        
        return false;
        */
        
        
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        
        if(set.size() == nums.length)
            return false;
        return true;
    }
}