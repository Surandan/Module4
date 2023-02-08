class Solution{
	public int min(Node root){
		if(root.left == null) return root.val;
		
		return min(root.left);
	}
    public Node deleteNode(Node root, int val){

		if(root == null) return null;
		if(root.val == val){

			if(root.left == null && root.right == null) return null;
			if(root.left == null && root.right != null) return root.right;
			if(root.left != null && root.right == null) return root.left;
			else {
				int rmin = min(root.right);
				root.val = rmin;
				root.right = deleteNode(root.right,root.val);
			}
			
		}

		if( root.val > val ) root.left = deleteNode(root.left,val);
		else root.right = deleteNode(root.right,val);

		return root;
    }
}
