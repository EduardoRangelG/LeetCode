class Solution:
    def getMinPatches(self, nums: list[int], n: int) -> int:
        min_patches = 0
        miss = 1
        i = 0

        while (miss <= n):
            if(i < len(nums) and nums[i] <= miss):
                miss += nums[i]
                i += 1
            else:
                miss += miss
                min_patches += 1

        return min_patches

solution = Solution()

nums1 = [1,3]
n1 = 6
result1 = solution.getMinPatches(nums1, n1)
print(result1)

nums2 = [1,5,10]
n2 = 20
result2 = solution.getMinPatches(nums2, n2)
print(result2)

nums3 = [1,2,2]
n3 = 5
result3 = solution.getMinPatches(nums3, n3)
print(result3)