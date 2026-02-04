import java.io.*;
import java.util.*;

public class Main {

	static class Problem{
		int no, dif;
		
		Problem(int no, int dif){
			this.no = no;
			this.dif = dif;
		}
    }
	
	static int N, P;
	static int[] arr;
	static String[] command;
	static TreeSet<Problem> ts;
	static HashMap<Integer, Problem> map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		ts = new TreeSet<Problem>((a, b) -> {
			if(a.dif == b.dif) {
				return a.no - b.no;
			}
			return a.dif - b.dif;
		});
		map = new HashMap<Integer, Problem>();
		
		for(int i = 0; i < N; i++) {
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Problem pro = new Problem(arr[0], arr[1]);
			ts.add(pro);
			map.put(arr[0], pro);
		}
		
		P = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < P; i++) {
			command = br.readLine().split(" ");
			if(command[0].equals("add")) {
				Problem pro = new Problem(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				ts.add(pro);
				map.put(Integer.parseInt(command[1]), pro);
			}else if(command[0].equals("recommend")) {
				if(command[1].equals("1")) {
					sb.append(ts.last().no).append(" ");
				}else if(command[1].equals("-1")) {
					sb.append(ts.first().no).append(" ");
				}				
			}else {
				Problem pro = map.get(Integer.parseInt(command[1]));
				map.remove(pro.no);
				ts.remove(pro);				
			}
		}
		System.out.println(sb.toString());
		
		
	}
}
