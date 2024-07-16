import java.util.*;

public class LCA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        String[] persons = sc.nextLine().split(" ");
        List<Integer> v = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            v.add(Integer.parseInt(arr[i]));
        }
        Node root = new Node(v.get(0));
        Node P1 = new Node(Integer.parseInt(persons[0]));
        Node P2 = new Node(Integer.parseInt(persons[1]));
        Queue<Node> q = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q.add(root);
        int j = 1;
        while (j < n && !q.isEmpty()) {
            Node temp = q.poll();
            if (v.get(j) != -1) {
                temp.left = new Node(v.get(j));
                q.add(temp.left);
            }
            j++;
            if (j < n && v.get(j) != -1) {
                temp.right = new Node(v.get(j));
                q.add(temp.right);
            }
            j++;
        }
        Node res = new Solution().lowestCommonAscendant(root, P1, P2);
        System.out.println(res.data);
    }
}

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class Solution {
    Node lowestCommonAscendant(Node root, Node P1, Node P2) {
        if (root == null) {
            return null;
        }
        if (P1.data == root.data || P2.data == root.data) {
            return root;
        }
        Node left = lowestCommonAscendant(root.left, P1, P2);
        Node right = lowestCommonAscendant(root.right, P1, P2);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}