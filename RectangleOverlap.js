/**
 * @param {number[]} rec1
 * @param {number[]} rec2
 * @return {boolean}
 */
var isRectangleOverlap = function(rec1, rec2) {
    const [x1, y1, x2, y2] = rec1;
    const [a1, b1, a2, b2] = rec2;

    if(x1 < a2 && x2 > a1 && y1 < b2 && y2 > b1){
        return true;
    }
    return false;
};
