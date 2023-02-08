class Solution {
    
    public class Pair{
		Node node;
		int state;
		Pair(Node root,int state){
			this.node = root;
			this.state = state;
		}
	}
	public Node getNextFromNormal(Stack<Pair> st){

		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				top.state++;
				if(top.node.left!=null) st.push(new Pair(top.node.left,1));
			}
			else if(top.state == 2){
				top.state++;
				if(top.node.right!=null) st.push(new Pair(top.node.right,1));
				return top.node;
			}
			else st.pop();
		}
		return null;
	}
	public Node getNextFromReverse(Stack<Pair> st){

		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				top.state++;
				if(top.node.right!=null) st.push(new Pair(top.node.right,1));
				
			}
			else if(top.state == 2){
				top.state++;
				if(top.node.left!=null) st.push(new Pair(top.node.left,1));
				return top.node;
			}
			else st.pop();
		}
		return null;
	}
    public void targetSum(Node root, int tar){

		Stack<Pair> normal = new Stack<>();
		Stack<Pair> reverse = new Stack<>();

		normal.push(new Pair(root,1));
		reverse.push(new Pair(root,1));
		
        boolean flag = false;
		int left = getNextFromNormal(normal).data;
		int right = getNextFromReverse(reverse).data;

		while(left<right){

			if(left+right == tar){
				System.out.println(left+" "+right);
				flag = true;
				 left = getNextFromNormal(normal).data;
		         right = getNextFromReverse(reverse).data;
			}
			else if(left+right > tar){
		         right = getNextFromReverse(reverse).data;
			}
			else left = getNextFromNormal(normal).data;
		}
		if(!flag) System.out.println("-1");
	}
}
