var reverseDegree = function(s) {
    let arr = ['z', 'y', 'x', 'w', 'v', 'u', 't','s', 'r', 'q', 'p', 'o', 'n', 'm','l', 'k', 'j', 'i', 'h', 'g', 'f','e', 'd', 'c', 'b', 'a'];


    let product = 0;

    for(let ch = 0; ch < s.length; ch++){
        let curr_ch = s.charAt(ch);
        for(let i = 0; i < arr.length; i++){
            if(curr_ch === arr[i]){
                product += (i+1) * (ch +1);
            }
        }
    }
    return product;
};
