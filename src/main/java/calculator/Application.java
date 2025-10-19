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
        
        // 2. 구분자 인식
        String delimiter = ",|:";
        String numbers = input;
            
        if (input.startsWith("//")) {
            int endIdx = input.indexOf("\\n");
            if (endIdx == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            delimiter = input.substring(2, endIdx);
            numbers = input.substring(endIdx + 2);
        }

        // 3. 구분자 분리
        String[] str = numbers.split(delimiter);

        // 4. string to int
        int[] result = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            try {
                int num = Integer.parseInt(str[i].trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수 값이 있습니다.");
                }
                    result[i] = num;
            } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 있습니다.");
            }
        }
        
        return result;
    }
}
