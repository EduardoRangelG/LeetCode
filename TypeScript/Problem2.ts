function getMinPatches(nums: number[], n: number): number {
    let minPatches = 0;
    let miss = 1
    let i = 0;

    while (miss <= n) {
        if (i < nums.length && nums[i] <= miss) {
            miss += nums[i];
            i++;
        } else {
            miss += miss;
            minPatches++;
        }
    }

    return minPatches;
};

const nums1 = [1,3];
const n1 = 6;
const result1 = getMinPatches(nums1, n1);
console.log(result1);

const nums2 = [1,5,10];
const n2 = 20;
const result2 = getMinPatches(nums2, n2);
console.log(result2);

const nums3 = [1,2,2];
const n3 = 5;
const result3 = getMinPatches(nums3, n3);
console.log(result3);