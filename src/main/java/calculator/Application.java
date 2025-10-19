package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        
        int[] number_arr = parseString(input);
        int sum = 0;
        for (int i = 0; i < number_arr.length; i++) {
            sum += number_arr[i];
        }

        System.out.println("결과 : " + sum);
    }

    public static int[] parseString(String input) {
        // 1. 빈 문자열
        if (input.isEmpty()) {
            return new int[]{0};
        }
        
        // 2. 기본 구분자
        String[] str = input.split(",|:");
        
        // 3. string to int
        int[] numbers = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.parseInt(str[i]);
        }
        
        return numbers;
    }
}
