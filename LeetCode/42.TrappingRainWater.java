//Time Complexity: O(n)
??Space Complexity: O(1)

class Solution {
    public int trap(int[] height) {
        if(height.length<=2)return 0;               //no way water can be accumulated
        int count = 0;
       
        for(int bar =0;bar<height.length;bar++){    //for every bar we compute the water that it can store by finding out
                                                    // min(left_max_bar,right_max_bar) - height of the current bar
                                                    //where left_max_bar & right_max_bar are the bars that enclose the current bar
                                                    //in other words two bars which are taller than the current bar
             int m_left = 0,m_right =0;
            for(int left =bar-1;left>=0;left--){   // finding the left_max_bar
                if(height[left]>m_left){
                    m_left = height[left];
                }
            }
            for(int right = bar+1;right<height.length;right++){   // finding the right_max_bar
                 if(height[right]>m_right){
                     m_right = height[right];
                 }
            }
       
         if(m_left > height[bar] && m_right > height[bar]){      // in case if we found out the two bars greater than the current bar
                                                                 // we calculate the volume as said before.
             count = count + Math.min(m_left,m_right)-height[bar];
         }
            
            
        }
        return count;
    }
}
