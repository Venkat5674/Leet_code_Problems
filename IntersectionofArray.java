class Solution {
    public int[] intersection(int[] nums1, int[] nums2)
    {
        List<Integer> arr=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            if(map.containsKey(nums1[i]))
            {
                map.put(nums1[i],map.get(nums1[i])+1);
            }
            else
            {
                map.put(nums1[i],1);
            }
        }

        for(int i=0;i<nums2.length;i++)
        {
            if(map.containsKey(nums2[i]))
            {
               if(!arr.contains(nums2[i]))
               {
                    arr.add(nums2[i]);
               }
            }
        }

        int ans[]=new int[arr.size()];
        
        for(int i=0;i<arr.size();i++)
        {
            ans[i]=arr.get(i);
        }

        return ans;
    }
}
