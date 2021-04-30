import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public final class BaseballGame {
    private static final int MAX_BALL_COUNT = 3;

    private int[] answer = null;
    private int[] sortedAnswer = null;

    private int strikeCount = 0;
    private int ballCount = 0;

    BaseballGame() {
        init();
    }

    private void init() {
        answer = getNewAnswer();
        sortedAnswer = sort(answer);
        resetCount();
    }

    private void resetCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    private int[] sort(int[] src) {
        int[] dest = Arrays.copyOf(src, src.length);
        Arrays.sort(dest);
        return dest;
    }

    void start() {
        System.out.print("숫자를 입력해주세요 : ");
        int[] inputValue = sort(toIntArray(getInputValue()));
        if (strikeCount < 3) {
            printHint(ballCount);
            resetCount();
            start();
            return;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int continueValue = getInputValue();
        if (continueValue == 1) {
            init();
            start();
        }
    }

    private void setScore(int[] sortedInput) {
        for (int i = 0; i < MAX_BALL_COUNT; ++i) {
            strikes[i] = 
        }
    }

    private boolean printHint() {
        if (strikeCount == 0 && ballCount == 0) {
            
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + " 스트라이크 ");
        }
        if (ballCount != 0) {
            System.out.print(strikeCount + " 볼 ");
        }
    }

    private int[] getNewAnswer() {
        int[] newAnswer = new int[MAX_BALL_COUNT];
        for (int i = 0; i < MAX_BALL_COUNT; ++i) {
            newAnswer[i] = (int)(Math.random() * 9) + 1;
        }

        return newAnswer;
    }

    private int getInputValue() {
        int input = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("오류가 발생했습니다. 다시 입력해 주세요.");
            getInputValue();
        }

        return input;
    }

    private int[] toIntArray(int src) {
        int[] dest = new int[MAX_BALL_COUNT];
        for (int i = 2; i >= 0; --i) {
            dest[i] = src % 10;
        }
        
        return dest;
    }
}
