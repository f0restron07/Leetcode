public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        
        // Search in the ascending part
        int idx = binarySearch(mountainArr, 0, peak, target, true);
        if(idx != -1) return idx;
        
        // Search in the descending part
        return binarySearch(mountainArr, peak, mountainArr.length() - 1, target, false);
    }
    
    private int findPeak(MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    private int binarySearch(MountainArray mountainArr, int start, int end, int target, boolean isAscending) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mountainArr.get(mid) == target) return mid;
            
            if(isAscending) {
                if(mountainArr.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(mountainArr.get(mid) < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
