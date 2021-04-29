import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class BaseballGame {
    private int answer = 0;

    BaseballGame() {
        init();
    }

    private void init() {
        answer = getNewAnswer();
    }

    void start() {
        System.out.println("숫자를 입력해주세요 : ");
        int input = input();
        if (answer != input) {
            printHint(input);
            start();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = input();
        if (input == 1) {
            init();
            start();
        }
    }

    private void printHint(int input) {
        
    }

    private int getNewAnswer() {
        return ((int)(Math.random() * 9) + 1) * 100 + ((int)(Math.random() * 9) + 1) * 10 + ((int)(Math.random() * 9) + 1);
    }

    private int input() {
        int input = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("오류가 발생했습니다. 다시 입력해 주세요.");
            input();
        }
        return input;
    }
}
