/**
 * @param {number} n
 * @return {number}
 */
var countCommas = function(n) {
   let answer = 0;
   for(let p = 1000; p <=n; p *= 1000){
    answer += n - p + 1;
   }
   return answer;
}
