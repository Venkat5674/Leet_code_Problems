/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    let count = 0;
    let result = 0;

    for(let ch of s){
        if(ch === ')'){
            count--;
            continue;
        }
        if(ch !== '('){
            continue;
        }
        count++;
        if(count > result){
            result = count;
        }
    }
    return result;
};
