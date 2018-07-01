package other;

public class TreePostOrder {
	
public static  String postOrder(String preOrder,String inOrder){
	if(preOrder.isEmpty()){
		return "";
	}
	char charAt = preOrder.charAt(0);
	int rootValue = inOrder.indexOf(charAt);
	return postOrder(preOrder.substring(1,rootValue+1),inOrder.substring(0, rootValue))+
			postOrder(preOrder.substring(rootValue+1),inOrder.substring( rootValue+1))+charAt;
	
}
public static void main(String[] args) {
	String order = postOrder("abdegcf","dbgeacf");
	System.out.println(order);
}
}
