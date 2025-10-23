import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	//���� ��, ������ ������ ����� ���̴� ���� ������ �Ǵ°žƴѰ� 100000���ε� 50000�̸� �����ϱ� �ȵ�
	//�������ͷ� ������ �������� ��. �׷��� 100000.

	static int N, left, right, bestL, bestR, min, value;
	static int[] solutions;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        left = 0;
        right = N-1;
        min = Integer.MAX_VALUE;
        solutions = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	solutions[i] = Integer.parseInt(st.nextToken());
        }
        
        while(left != right) {
        	value = solutions[left] + solutions[right];
        	if(value == 0) {
        		min = value;
        		bestL = left;
        		bestR = right;
        		break;
        	}else if(0-Math.abs(value) > 0-Math.abs(min)) {
        		min = value;
        		bestL = left;
        		bestR = right;
        	}
        	
        	if(value > 0) {
        		right--;
        	}else {
        		left++;
        	}
        }
        
        System.out.printf("%d %d\n", solutions[bestL], solutions[bestR]);
    }
}
