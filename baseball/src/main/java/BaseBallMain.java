import java.util.Scanner;

public class BaseBallMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("★★★★★★★★★★★★★★★★★★★★");
        System.out.println("★★★★★★ 야구 숫자 게임 ★★★★★★");
        System.out.println("★★★★★★★★★★★★★★★★★★★★");
        Util.delayMs(3000);

        loop:
        while (true){
            System.out.println("당신이 공격을 할지 방어를 할지 선택해주세요.");
            Util.delayMs(1000);
            System.out.println("1. 공격");
            Util.delayMs(500);
            System.out.println("2. 방어");
            Util.delayMs(500);

            String selection = sc.next();

            switch (selection) {
                case "1" :
                    System.out.println("공격을 선택 하셨습니다. 그럼 제가 정답을 맞춰보도록 하겠습니다.");
                    Util.delayMs(1000);
                    Attack attack = new Attack();
                    attack.start();
                    break loop;
                case "2" :
                    Defense d = new Defense();
                    System.out.println("방어을 선택 하셨습니다. 그럼 제가 문제를 내보도록 하겠습니다.");
                    Util.delayMs(1000);
                    Defense defense = new Defense();
                    defense.start();
                    break loop;
                default:
                    System.out.println("잘못 입력 하셨습니다. 다시 선택해주세요.");
                    Util.delayMs(1000);
                    break;
            }
        }
    }
}
