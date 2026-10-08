/**
 * @param {string} s
 * @return {string}
 */
var removeOuterParentheses = function(s) {
    let sb = [];
    let count = 0;

    for(let ch of s){
        if( ch === '('){
            count++;
            if(count > 1){
                sb.push(ch);
            }
        }else{
            count--;
            if(count > 0){
               sb.push(ch);
            }
        }
    }
    return sb.join("");
};
