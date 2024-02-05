
class bst{
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root,int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    public static void inorder(Node root) {
        // TODO Auto-generated method stub;
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right = delete(root.right, val);
        }
        else if(root.data>val){
            root.left = delete(root.left, val);
        }
        else{
            // case 1 - no child
            if(root.left==null && root.right == null){
                return null;
            }
            //case2 - one child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            // case 3: 2 child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1,int k2){
        if(root == null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void main(String[] args){
        int val[] = {8,5,3,1,4,6,7,10,11,14};
        Node root=null;
        for(int i=0;i<val.length;i++){
            root=insert(root, val[i]);
        }
        // delete(root, 4);
        inorder(root);
        System.out.println();
        printInRange(root, 5, 12);

    }

    
}
