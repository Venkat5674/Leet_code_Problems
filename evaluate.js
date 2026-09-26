var evaluate = function(s, knowledge) {
    const map = new Map();

    for(let pair of knowledge){
        map.set(pair[0], pair[1]);
    }

    let result="";

    for(let i = 0; i < s.length; i++){
        if(s[i] === '('){
            let j = s.indexOf(')', i+1);
            let key = s.substring(i+1, j);

            let value = map.get(key);

            if(value === undefined){
                result += "?"
            }else{
                result += value;
            }
            i = j;
        }else{
            result += s[i];
        }
    }
    return result;
};
