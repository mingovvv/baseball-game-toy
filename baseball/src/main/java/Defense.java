import java.util.Scanner;

public class Defense {
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("제가 생각하고 있는 중복되지 않는 세 자리수를 맞춰주세요");
        Util.delayMs(1000);
        System.out.println("저는 생각이 다 끝났습니다.");
        Util.delayMs(1000);
        System.out.println("그럼 바로 시작합니다.");
        Util.delayMs(1000);

        // 세 자리수 생성
        int[] comNum = Algorithm.createRandomValue();

        // 시도 횟수
        int cnt = 1;

        while (true) {
            System.out.println("당신의 " + cnt + "번째 정답을 말해주세요.");
            String reply = sc.next();

            if(reply.length() == 3 && reply.matches("^[1-9]{3}$")) {
                String answer = Algorithm.compareValue(reply, comNum);

                if("300".equals(answer)) {
                    System.out.println(cnt + "번의 시도만에 정답을 맞추셨네요 :) ");
                    System.exit(0);
                }  else {
                    if(answer.charAt(2)-'0' != 1) {
                        System.out.println(answer.charAt(0)+"S"+answer.charAt(1)+"B"+ " 입니다.");
                        cnt++;
                    } else {
                        System.out.println("아웃입니다.");
                        cnt++;
                    }
                }
            }else {
                System.out.println("잘못 입력 하셨습니다. 다시 정확하게 입력해주세요.");
            }
        }

    }
}
