function shortestPalindrome(s: string): string {
    let max_coincidence: string[] = [];
    let prefix: string = "";

    const s_reversed = s.split('').reverse().join('');

    for (let i = 0; i < s.length; i++) {
        const word: string[] = [];

        for (let j = 0; j < s.length - i; j++) {
            if (s[j] === s_reversed[i + j]) {
                word.push(s[j]);
            } else {
                break;
            }
        }

        if (word.length > max_coincidence.length) {
            max_coincidence = [...word];
            prefix = s.slice(max_coincidence.length);
        }
    }

    const prefix_reversed = prefix.split('').reverse().join('');
    const palindrome = prefix_reversed + max_coincidence.join('') + prefix;

    return palindrome;
}

console.log(shortestPalindrome("aacecaaa"));
console.log(shortestPalindrome("abcd"));
