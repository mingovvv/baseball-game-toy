import java.util.Arrays;
import java.util.Scanner;

public class Attack {
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("머릿속으로 서로 중복되지 않는 1~9까지의 세자리 숫자를 생각해주세요.");
        System.out.println("제가 사용자님의 마춰보겠습니다.");
        System.out.println("생각은 다 끝나셨나요?");
        System.out.println("그럼 바로 시작하겠습니다.");

        int index = 1;
        int[] random = new int[3];
        for (int i = 0; i < random.length; i++) {
            random[i] = (int) (Math.random() * 9 + 1);

            // 중복제거
            for (int j = 0; j < i; j++) {
                if (random[i] == random[j]) {
                    i--;
                    break;
                }
            }

        }

        System.out.println(index + "번째 저의 도전 숫자는 : " + Arrays.toString(random) + "입니다");
        System.out.println("스트라이크는 s, 볼은 b로 표현해주세요.");
        System.out.println("example 1. : 2s1b (2스트라이크 1볼)");
        System.out.println("example 2. : 3b (1볼)");

        while (true) {
            String reply = sc.next();
            if (reply.length() != 4 || reply.length() != 2) {
                if (reply.length() == 4 && reply.matches("^[1-2][sSbB][1-2][sSbB]$")) {
                    reply.charAt(1);
                } else if (reply.length() == 2 && reply.matches("^[1-2][sSbB]$")) {

                } else {
                    System.out.println("잘못 입력하셨어요. 다시 선택해주세요.");
                }

            } else {
                System.out.println("잘못 입력하셨어요. 다시 선택해주세요.");
            }

        }

    }
}
