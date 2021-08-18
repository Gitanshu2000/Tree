import javax.xml.bind.SchemaOutputResolver;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Math.max;

class Node1
{
    int data;
    Node1 right;
    Node1 left;

    Node1(int data)
    {
        this.data = data;
    }
}
public class tree

{
      static Scanner sc=new Scanner(System.in);
    public static void main(String[] args)
    {
        Node1 hello=createnode();
        preorder(hello);
        System.out.println();
        inorder(hello);
        System.out.println();
        postorder(hello);
        System.out.println();
        levelorder(hello);
        System.out.println();
        System.out.println(height(hello));
        System.out.println();
        printLeftView(hello);
    }



       static Node1 createnode()
    {
        System.out.println("Enter data: ");
        int data=sc.nextInt();
        if(data==-1) return null;
         Node1 root = new Node1(data);
        System.out.println("Enter left for "+data);
        root.left= createnode();
        System.out.println("Enter Right for "+data);
        root.right=createnode();
        return root;
    }
    static int  height(Node1 root)   //maximum depth or height of tree

    {
        if(root==null) return 0;
        int x=height(root.left);
        int y=height(root.right);
        return (max(x,y)+1) ;

    }
    static void printLeftView(Node1 root)
    {
        if (root == null)
            return;

        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 1; i <= n; i++) {
                Node1 temp = queue.poll();

                if (i == 1)
                    System.out.print(temp.data + " ");

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    static void inorder( Node1 root)
    {
        if(root==null)return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    static void postorder(Node1 root)
    {
        if(root==null)return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    static void preorder(Node1 root)
    {
        if(root==null)return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }
    static void levelorder(Node1 root)
    {
        if(root==null)return;
        Queue<Node1>queue=new LinkedList<Node1>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node1 current=queue.poll();
            System.out.print(current.data+" ");
            if(current.left!=null)queue.add(current.left);
            if(current.right!=null)queue.add(current.right);

        }

    }

}
