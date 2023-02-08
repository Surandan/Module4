// Size 
public static int size(Node node) {
    // write your code here
	  if(node == null) return 0;
	  return 1 + size(node.left) + size(node.right);
  }

// Sum of all nodes
  public static int sum(Node node) {
    // write your code here
	  if(node == null) return 0;
	  int ls = sum(node.left);
	  int rs = sum(node.right);

	  return ls + rs + node.data;
  }

// Max of all Nodes
  public static int max(Node node) {
    // write your code here
	  if(node.right == null) return node.data;
	  return max(node.right);
  }

// Min of all nodes
  public static int min(Node node) {
    // write your code here
	  if(node.left == null) return node.data;
	  return min(node.left);
  }

//Find a node in BST
  public static boolean find(Node node, int data){
    // write your code here
	  if(node == null) return false;
	  if(node.data == data) return true;
	  if(node.data > data) return find(node.left,data);
	  else return find(node.right,data);
  }  
  
// Search Node 
class Solution{
    public boolean searchNode(Node root,int k){

		if(root == null) return false;
		if(root.val == k) return true;
		if(root.val > k) return searchNode(root.left,k);
		else return searchNode(root.right,k);
       
    }
}
