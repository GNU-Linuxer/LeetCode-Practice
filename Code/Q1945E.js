// 1945. Sum of Digits of String After Convert (Easy)
// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/

var getLucky = function(s, k) {
    let sum = 0;
    let sChar = s.split('');
    let charAlp = sChar.map(c => c.charCodeAt(0) - 96); // 'a' -> 1; 'b'-> 2
    sum = charAlp.join("");

    while(k > 0) {
        const num = Array.from(String(sum), Number);// 9999 -> [9,9,9,9]
        sum = num.reduce((a, b) => a + b, 0); // Sum the array
        k = k - 1;
    }

    return sum;
};

console.log(getLucky("dbvmfhnttvr", 5));