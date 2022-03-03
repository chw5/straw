package Tree;

import java.util.*;

public class TreeSolution {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    /**
     * 求树的最大深度
     * 思路：递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        return root == null ?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * 前序遍历，递归实现
     */
    public static void preOrder(TreeNode root) {
        if (root == null){
            return;
        }
        System.out.println(root.val);//首先遍历父节点
        preOrder(root.left);//第二步，遍历左节点
        preOrder(root.right);//第三步，遍历右节点
    }

    /**
     * 前序遍历，非递归实现（栈）
     */
    public static void preOrder1(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);//输出父节点
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
    }

    /**
     * 中序遍历，递归实现
     */
    public static  void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        inOrder(root.left);//第一步，遍历左子树
        System.out.println(root.val);//中间遍历父节点
        inOrder(root.right);//第二步，遍历右子树
    }

    /**
     * 后续遍历，递归实现
     */
    public static void postOrder(TreeNode root){
        if (root == null) {
            return;
        }
        postOrder(root.left);//第一步，遍历左子树
        postOrder(root.right);//第二步，遍历右子树
        System.out.println(root.val);//最后遍历父节点
    }

    /**
     * 深度遍历
     * 思路：使用栈
     */
    public void DFS(TreeNode root){
        //创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    /**
     * 广度遍历
     * 思路：使用队列，将每层节点的左右子节点放到队列尾部
     */
    public void BFS(TreeNode root){
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            //每一层的个数
            int size = deque.size();
            //将一层的左右节点遍历放到队列里
            while (size-- > 0){
                TreeNode cur = deque.pop();
                if (cur.left != null){
                    deque.addLast(cur.left);
                }
                if (cur.right != null){
                    deque.addLast(cur.right);
                }
            }
        }
    }

    /**
     * 判断二叉树是否是对称树
     * url: https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        //从两个子节点开始判断
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        //如果左右子节点都为空，说明当前节点是叶子节点，返回true
        if (left == null && right == null)
            return true;
        //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if (left == null || right == null || left.val != right.val)
            return false;
        //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
