var minInsertions = function(s) {
    let openBrackets = 0;
    let insertions = 0;

    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            openBrackets++;
        } else {
            // Ensure every '(' is followed by two ')'
            if (i + 1 < s.length && s[i + 1] === ')') {
                i++;
            } else {
                insertions++;
            }

            // Match the closing brackets with an opening bracket
            if (openBrackets > 0) {
                openBrackets--;
            } else {
                insertions++;
            }
        }
    }

    return insertions + openBrackets * 2;
};
