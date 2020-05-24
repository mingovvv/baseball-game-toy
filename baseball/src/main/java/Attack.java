import java.util.Arrays;
import java.util.Scanner;

public class Attack {
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("머릿속으로 서로 중복되지 않는 1~9까지의 세자리 숫자를 생각해주세요.");
        Util.delayMs(1000);
        System.out.println("제가 당신의 정답을 마춰보겠습니다.");
        Util.delayMs(1000);
        System.out.println("생각은 다 끝나셨나요?");
        Util.delayMs(1000);
        System.out.println("그럼 바로 시작합니다.");
        Util.delayMs(1000);

        // 시도 횟수
        int cnt = 1;

        // 경우의 수 생성
        Algorithm.createValues();

        int value = Algorithm.getRandomValue();

        while (true) {

            System.out.println(cnt + "번째 AI의 정답 숫자는 : " + value + "입니다. 정답인가요?");
            System.out.println("스트라이크는 s, 볼은 b, 아웃은 o로 표현해주세요.");
            System.out.println();
            System.out.println("example 1. : 2s1b (2스트라이크, 1볼)");
            System.out.println("example 2. : 3b (3볼)");
            System.out.println("example 3. : o (아웃, 일치값 없음)");

            String reply = sc.next();

            if (reply.length() == 4 && reply.matches("^[1-2][sSbB][1-2][sSbB]$")) {
                // 후보군 제외
                Algorithm.removeValues(value, reply);
                cnt++;
                value = Algorithm.getRandomValue();
            } else if ("O".equalsIgnoreCase(reply)) {
                // 후보군 제외
                Algorithm.removeValues(value, reply);
                cnt++;
                value = Algorithm.getRandomValue();
            } else if (reply.length() == 2 && reply.matches("^[3][sS]$")) {
                System.out.println(cnt + "번만에 맞췄네요. :) ");
                break;
            } else if (reply.length() == 2 && reply.matches("^[1-3][sSbB]$")) {
                // 후보군 제외
                Algorithm.removeValues(value, reply);
                cnt++;
                value = Algorithm.getRandomValue();
            } else {
                System.out.println("잘못 입력 하셨습니다. 다시 정확하게 입력해주세요.");
            }
        }

    }
}
