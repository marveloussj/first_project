package interview.tree;

public class TreeTraversal {

	public void inOrder(TreeNode root){
		if(root==null){
			return;
		}
		inOrder(root.getLeft());
		System.out.println(root.getValue());
		inOrder(root.getRight());
	}
	public void postOrder(TreeNode root){
		if(root==null){
			return;
		}
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getValue());
	}
	public static void main(String[] args) {
		TreeCreator creator =new TreeCreator();
		TreeTraversal traversal=new TreeTraversal();
		TreeNode tree = creator.createTree("ABDEGCF", "DBGEACF");
		traversal.postOrder(tree);
	}
}
