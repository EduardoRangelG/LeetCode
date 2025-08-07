class Solution:
    def shortestPalindrome(self, s: str) -> str:
        max_coincidence=[]
        s_reversed=s[::-1]

        for i in range(len(s)):
            word = []
            for j in range(len(s) - i):
                if s[j] == s_reversed[i + j]:
                    word.append(s[j])
                else:
                    break
            if len(word) > len(max_coincidence):
                max_coincidence = word[:]
                prefix= s[len(max_coincidence):]

        prefix_reversed=prefix[::-1]
        palindrome="".join(prefix_reversed)+"".join(max_coincidence)+"".join(prefix)
        return palindrome
        
sol = Solution()

print(sol.shortestPalindrome("aacecaaa"))
print(sol.shortestPalindrome("abcd"))
