import java.io.*;
import java.util.*;

public class Main {

	static int hour, minute, second, total;
	static int tryHour, tryMinute, trySecond;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		StringBuilder sb = new StringBuilder();
		
		hour = Integer.parseInt(st.nextToken());	
		minute = Integer.parseInt(st.nextToken());
		second = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), ":");
		
		tryHour = Integer.parseInt(st.nextToken());
		tryMinute = Integer.parseInt(st.nextToken());
		trySecond = Integer.parseInt(st.nextToken());
		
		if(tryHour - hour < 0) {
			tryHour += 24;
		}
		hour = tryHour - hour;
		
		if(tryMinute - minute < 0) {
			tryMinute += 60;
			minusHour();
		}
		minute = tryMinute - minute;
		
		if(trySecond - second < 0) {
			trySecond += 60;
			minusMinute();
		}
		second = trySecond - second;
		
		if(hour / 10 < 1) {
			sb.append("0").append(hour);
		}else {
			sb.append(hour);
		}
		
		sb.append(":");
		
		if(minute / 10 < 1) {
			sb.append("0").append(minute);
		}else {
			sb.append(minute);
		}

		sb.append(":");
		
		if(second / 10 < 1) {
			sb.append("0").append(second);
		}else {
			sb.append(second);
		}
		
		
		System.out.println(sb.toString());
	}
	
	static void minusHour() {
		if(hour == 0) {
			hour = 23;
		}else {
			hour -= 1;
		}
	}
	
	static void minusMinute() {
		if(minute == 0) {
			minute = 59;
			minusHour();
		}else {
			minute -= 1;
		}
	}
}
