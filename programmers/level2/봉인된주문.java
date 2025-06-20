import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";

        Arrays.sort(bans, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();  // 길이 짧은 순
            }
            return a.compareTo(b);  // 사전순
        });

        for(String ban : bans){
            if(isBanOver(n, ban)){
                n += 1;
            }else{
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(n > 0){
            long remain = n % 26;
            if(remain == 0){
                remain = 26;
                n -= 1;
            }
            n = n / 26;
            sb.append((char)('a' + remain - 1));
        }

        answer = sb.reverse().toString();

        return answer;
    }

    public boolean isBanOver(long n, String ban){
        int size = ban.length();
        long value = 0;

        for(int i = 0; i < size; i++){
            char cur = ban.charAt(i);
            value += (long)(cur - 'a' + 1) * Math.pow(26, (size - i - 1));
        }

        return value <= n;
    }
}