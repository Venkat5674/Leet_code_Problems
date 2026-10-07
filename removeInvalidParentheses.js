const removeInvalidParentheses = (input) => {
    const validResults = [];

    const removeExtraClosingParentheses = (str, startIndex, removeStart) => {
        let balance = 0;

        for (let currentIndex = startIndex; currentIndex < str.length; currentIndex++) {

            balance += (str[currentIndex] === '(') - (str[currentIndex] === ')');

            if (balance >= 0) continue;
            for (
                let removeIndex = removeStart;
                removeIndex <= currentIndex;
                removeIndex++
            ) {
                if (str[removeIndex] === ')' &&(removeIndex === removeStart || str[removeIndex - 1] !== ')')
                ) {
                    const newString =
                        str.slice(0, removeIndex) +
                        str.slice(removeIndex + 1);

                    removeExtraClosingParentheses(
                        newString,
                        currentIndex,
                        removeIndex
                    );
                }
            }

            return;
        }

        removeExtraOpeningParentheses(
            str,
            str.length - 1,
            str.length - 1
        );
    };

    const removeExtraOpeningParentheses = (str, startIndex, removeStart) => {
        let balance = 0;

        for (let currentIndex = startIndex; currentIndex >= 0; currentIndex--) {

            balance +=
                (str[currentIndex] === ')') -
                (str[currentIndex] === '(');

            if (balance >= 0) continue;

            for (
                let removeIndex = removeStart;
                removeIndex >= currentIndex;
                removeIndex--
            ) {
                if (
                    str[removeIndex] === '(' &&
                    (removeIndex === removeStart ||
                     str[removeIndex + 1] !== '(')
                ) {
                    const newString =
                        str.slice(0, removeIndex) +
                        str.slice(removeIndex + 1);

                    removeExtraOpeningParentheses(
                        newString,
                        currentIndex - 1,
                        removeIndex - 1
                    );
                }
            }

            return;
        }

        validResults.push(str);
    };

    removeExtraClosingParentheses(input, 0, 0);

    return validResults;
};
