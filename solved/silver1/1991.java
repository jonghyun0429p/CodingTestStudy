import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Character, Node> nodeMap;

    static class Node{;
        char rightChild;
        char leftChild;

        Node(char rightChild,char leftChild){
            this.rightChild = rightChild;
            this.leftChild = leftChild;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeMap = new HashMap<>();

        int treeCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < treeCount; i++) {
            String[] tree = br.readLine().split(" ");

            char now = tree[0].charAt(0);
            char leftChild = tree[1].charAt(0);
            char rightChild = tree[2].charAt(0);

            nodeMap.put(now, new Node(rightChild, leftChild));
        }

        char start = 'A';

        for(int i = 0; i < 3; i++){
            StringBuilder sb = new StringBuilder();
            getOrder(start, sb, i);
            System.out.println(sb);
        }


    }

    public static void getOrder(char c, StringBuilder sb, int i) {
        Node cur = nodeMap.get(c);
        if(i == 0){
            sb.append(c);
        }


        if(cur.leftChild != '.'){
            getOrder(cur.leftChild, sb, i);
        }

        if(i == 1){
            sb.append(c);
        }

        if(cur.rightChild != '.'){

            getOrder(cur.rightChild, sb, i);
        }

        if(i == 2){
            sb.append(c);
        }
    }
}
