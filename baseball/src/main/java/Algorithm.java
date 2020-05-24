import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    static List<Integer> list = new ArrayList<>();

    // 완전탐색 알고리즘
    public static void createValues() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i != j && j != k && k != i) {
                        list.add(100 * i + 10 * j + k);
                    }
                }
            }
        }
    }

    public static int getRandomValue() {
        return list.size() != 0 ? list.get((int)(Math.random()*list.size())) : getError("당신이 준 단서( s, b, o) 카운팅이 올바르지 않습니다. 모든 경우의 수를 따져봐도 정답이 없거든요...");
    }

    public static void removeValues(int value, String reply) {

        List<Integer> editList = new ArrayList<>();

        int matchedStrike = 0;
        int matchedBall = 0;

        int strike = 0;
        int ball = 0;

        if (reply.length() == 4) {
            // 스트라이크 && 볼
            strike = reply.charAt(reply.toUpperCase().indexOf("S")-1) - '0';
            ball = reply.charAt(reply.toUpperCase().indexOf("B")-1) - '0';

             int[] comValue = gerArray(value);

            for (int i=0; i<list.size(); i++) {
                int[] listValue = gerArray(list.get(i));

                for (int j = 0; j < listValue.length; j++) {
                    // strike 확인
                    if(listValue[j] == comValue[j]) {
                    matchedStrike++;
                    // ball 확인
                    } else if(String.valueOf(value).contains(String.valueOf(listValue[j]))){
                        matchedBall++;
                    }
                }

                if(strike == matchedStrike && ball == matchedBall) {
                    editList.add(list.get(i));
                }
                matchedStrike = 0;
                matchedBall = 0;
            }

            list.clear();
            list.addAll(editList);

        } else if (reply.length() == 2){
            // 스트라이크 || 볼
            if (reply.toUpperCase().contains("S")) {
                strike = reply.charAt(reply.toUpperCase().indexOf("S") - 1) - '0';
            } else if (reply.toUpperCase().contains("B")) {
                ball = reply.charAt(reply.toUpperCase().indexOf("B") - 1) - '0';
            }

            int[] comValue = gerArray(value);

            for (int i=0; i<list.size(); i++) {
                int[] listValue = gerArray(list.get(i));

                for (int j = 0; j < listValue.length; j++) {
                    // strike 확인
                    if(listValue[j] == comValue[j]) {
                        matchedStrike++;
                        // ball 확인
                    } else if(String.valueOf(value).contains(String.valueOf(listValue[j]))){
                        matchedBall++;
                    }
                }

                if(strike == matchedStrike && ball == matchedBall) {
                    editList.add(list.get(i));
                }
                matchedStrike = 0;
                matchedBall = 0;
            }

            list.clear();
            list.addAll(editList);

        } else if (reply.length() == 1){
            List<Integer> deleteList = new ArrayList<>();
            // 아웃
            int[] comValue = gerArray(value);

            for (int i=0; i<list.size(); i++) {
                int[] listValue = gerArray(list.get(i));

                for (int j = 0; j < listValue.length; j++) {
                    if(String.valueOf(value).contains(String.valueOf(listValue[j]))){
                        deleteList.add(list.get(i));
                        break;
                    }
                }
            }
            for (Integer deleteNum : deleteList) {
                list.remove(deleteNum);
            }
        }
    }

    private static int[] gerArray(Integer value) {
        int[] num = new int[3];

        num[0] = value/100;
        value = value%100;
        num[1] = value/10;
        value = value%10;
        num[2] = value/1;

        return num;
    }

    private static int getError(String msg) {
        System.out.println(msg);
        System.exit(0);
        return 9999;
    }
}
