package interview.tree;

public class TreeCreator {
public TreeNode createTree(String preOrder,String inOrder){
	if(preOrder.isEmpty()){
		return null;
	}
	char rootValue = preOrder.charAt(0);
	TreeNode root=new TreeNode();
	root.setValue(rootValue);
	int indexOf = inOrder.indexOf(rootValue);
	root.setLeft(createTree(preOrder.substring(1,1+indexOf), inOrder.substring(0, indexOf)));
	root.setRight(createTree(preOrder.substring(1+indexOf), inOrder.substring(indexOf+1)));
	return root;
}
}
