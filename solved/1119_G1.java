import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	//유니온 파인드인데, 두 쌍을 택해서 새로운 노드를 생성하는 문제.
	//한 집합에 사이클이 존재하면, 다른 집합에 엮여서 연결할 수 있게된다.
	//사이클 집합을 사이클 집합과 연결하면 하나의 큰 사이클이 된다.
	//즉, 유니온 파인드에 사이클을 관리해야함.
	//유니온 파인드를 적용하고, cycled를 배열을 관리하기? dfs를 활용하면 사이클을 구할 수 있음. 이를 통해서 cycled에 순환 여부 저장하고, 이를 통해서 다른 집합을 연결 할 수 있는지 파악할 수 있음.
	//dfs를 활용하면 1-2-3-1, 4-5로 순환 연결되어있다면, 모두 3으로 연결되어있고, 1부터 dfs를 돌리면 1-3-2-1이 될거고, 1,2의 부모인 3의 위치에 cycled가 true가 될거임.
	//그리고 4-5로 연결 되어있는 것을 확인하면 4-5로 사이클이 안됨. 고로 부모 배열은 3, 3, 3, 5, 5이고, 사이클은 f, f, t, f, f가 될거임. 3과 5가 연결이 가능한지 파악하면 됨.
	//둘 중 하나라도 cycled면 연결하고 되어있던거 f처리. 둘 다 순환이면 연결하고 큰 값으로 유니온 파인드 걸고, 거기만 t. 이렇게 조합하면 됨.
	public static int find(int a) {
		if(a == parents[a]) return parents[a];
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) {
		int Pa = find(a);
		int Pb = find(b);
		
		if(Pa == Pb) return;
		
		if(a < b) parents[b] = parents[a];
		else parents[a] = parents[b];
	}
	
	public static boolean isUnion(int a, int b) {
		if(find(a) == find(b)) return true;
		return false;
	}
	
	static int[] parents;
	static boolean[] cycled, visited;
	static String line;
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		size = Integer.parseInt(br.readLine());
		
		parents = new int[size];
		cycled = new boolean[size];
		visited = new boolean[size];
		
		//부모 지정.본인 포함 가장 큰 걸 자동으로 부모로 지정하게 하면 유니온 파인드가 필요한가?
		for(int i = 0; i < size; i++) {
			parents[i] = i;
			line = br.readLine();
			for(int j = i; j < line.length(); j++) {
				if(line.charAt(j) == 'Y') {
					parents[i] = j;
				}
			}
		}
		
		for(int i = 1; i < size; i++) {
			if(!isUnion(i, i-1)) {
				union(i, i-1);
			}
			
			
		}
		
	}
}