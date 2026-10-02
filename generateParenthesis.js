/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    const res = [];

    const dfs = (o, c, s) => {
        if (o === n && c === n) {
            res.push(s);
            return;
        }

        if (o < n) dfs(o + 1, c, s + "(");
        if (c < o) dfs(o, c + 1, s + ")");
    };

    dfs(0, 0, "");

    return res;
};
