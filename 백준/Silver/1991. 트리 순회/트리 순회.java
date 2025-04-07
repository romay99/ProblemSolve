import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Node[] arr;
    static StringBuilder sb ;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new Node[n];
        sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            arr[i] = new Node((char)(i + 'A'));
        }

        for (int i=0; i< arr.length; i++) {
            char c, l, r;
            String s = br.readLine();
            c = s.charAt(0);
            l = s.charAt(2);
            r = s.charAt(4);
            if (l != '.') {
                arr[c-'A'].left = arr[l-'A'];
            }
            if (r != '.'){
                arr[c-'A'].right = arr[r-'A'];
            }
        }
        preOrder(arr[0]);
        sb.append("\n");
        inOrder(arr[0]);
        sb.append("\n");
        postOrder(arr[0]);
        sb.append("\n");

        System.out.println(sb);

    }
    static class Node {
        char ch;
        Node left;
        Node right;

        public Node(char ch) {
            this.ch = ch;
        }
    }
    static void preOrder(Node node) {
        sb.append(node.ch);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        sb.append(node.ch);
        if (node.right != null) {
            inOrder(node.right);
        }
    }
    static void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        sb.append(node.ch);
    }
}
