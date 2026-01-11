import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static class Node{
        HashMap<Character, Node> child = new HashMap<Character, Node>();
        boolean endOfword;

        Node(){

        }

        public void insert(String word){
            Node node = this;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);

                node.child.putIfAbsent(c, new Node());
                node = node.child.get(c);

                if(i == word.length()-1){
                    endOfword = true;
                    return;
                }
            }
        }

//        public boolean contains(String word){
//            Node node = this;
//            for(int i = 0; i < word.length(); i++){
//
//                char c = word.charAt(i);
//                Node curNode = node.child.get(c);
//
//                if(curNode == null){
//                    return false;
//                }
//                node = curNode;
//            }
//            return node.endOfword;
//        }

        public String getNickname(String word){
            StringBuilder sb = new StringBuilder();
            Node node = this;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                sb.append(c);
                Node curNode = node.child.get(c);

                if(curNode == null){
                    break;
                }

                node = curNode;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> name = new HashMap<>();
        Node node = new Node();

        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++){
            String line = br.readLine();

            if(!name.containsKey(line)){
                sb.append(node.getNickname(line)).append("\n");
                node.insert(line);
                name.put(line, 1);
            }else{
                int count = name.get(line)+1;
                name.replace(line, count);
                line = line.concat(Integer.toString(count));
                sb.append(line).append("\n");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }
}
