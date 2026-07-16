const prefixGcd = [];
    let mx = 0;

    for (let num of nums) {
        mx = Math.max(mx, num);
        prefixGcd.push(gcd(num, mx));
    }

    prefixGcd.sort((a, b) => a - b);

    let left = 0;
    let right = prefixGcd.length - 1;
    let ans = 0;

    while (left < right) {
        ans += gcd(prefixGcd[left], prefixGcd[right]);
        left++;
        right--;
    }

    return ans;
};

function gcd(a, b) {
    while (b !== 0) {
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
