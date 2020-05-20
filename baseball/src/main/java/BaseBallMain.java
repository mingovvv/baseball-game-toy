import java.util.Scanner;

public class BaseBallMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("우리 야구 숫자 게임을 시작해봐요.");

        loop:
        while (true){
            System.out.println("당신 공격을 할지 방어를 할지 선택해주세요.");
            System.out.println("1. 공격");
            System.out.println("2. 방어");

            String selection = sc.next();


            switch (selection) {
                case "1" :
                    System.out.println("공격을 선택 하셨네요. 그럼 제가 정답을 맞춰보도록 하겠습니다.");
                    Attack attack = new Attack();
                    attack.start();
                    

                    break loop;
                case "2" :
                    Defense d = new Defense();
                    System.out.println("방어을 선택 하셨네요. 그럼 제가 문제를 내보도록 하겠습니다.");
                    break loop;
                default:
                    System.out.println("잘못 입력하셨어요. 다시 선택해주세요.");
                    break;
            }
        }

    }
}
