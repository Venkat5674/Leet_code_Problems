/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var averageOfSubtree = function(root) {
    let result = 0;
    solve(root)
    return result;
    function solve(root){
        if(root === null){
            return [0,0]
        }
        let left = []
        left = solve(root.left);
        let right = []
        right = solve(root.right);

        let sum = left[0] + right[0] + root.val;
        let count = left[1] + right[1] + 1;
        let avg = Math.floor(sum / count);
        if(avg === root.val){
            result++;
        }
        return [sum, count];
    }
};
