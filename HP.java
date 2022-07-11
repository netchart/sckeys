package com.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HP {

    private static int timeToInput(String code, String keypad) {
        int time = 0;

        Map<String, List<Integer>> keypadAdj = new HashMap<>();
        keypadAdj.put(String.valueOf(keypad.charAt(0)), Arrays.asList(0, 1, 2, 1, 1, 2, 2, 2, 2));
        keypadAdj.put(String.valueOf(keypad.charAt(1)), Arrays.asList(1, 0, 1, 1, 1, 2, 2, 2, 2));
        keypadAdj.put(String.valueOf(keypad.charAt(2)), Arrays.asList(2, 1, 0, 2, 1, 1, 2, 2, 2));
        keypadAdj.put(String.valueOf(keypad.charAt(3)), Arrays.asList(1, 1, 2, 0, 1, 1, 1, 1, 1));
        keypadAdj.put(String.valueOf(keypad.charAt(4)), Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1, 1));
        keypadAdj.put(String.valueOf(keypad.charAt(5)), Arrays.asList(2, 1, 1, 2, 1, 0, 2, 1, 1));
        keypadAdj.put(String.valueOf(keypad.charAt(6)), Arrays.asList(2, 2, 2, 1, 1, 2, 0, 1, 2));
        keypadAdj.put(String.valueOf(keypad.charAt(7)), Arrays.asList(2, 2, 2, 1, 1, 1, 1, 0, 1));
        keypadAdj.put(String.valueOf(keypad.charAt(8)), Arrays.asList(2, 2, 2, 2, 1, 1, 2, 1, 0));

        List<Integer> adjListForDigit;
        String digitPrev = "";

        for (char digit : code.toCharArray()) {
            // initial digit is skipped and do not add time
            if (digitPrev != "") {

                adjListForDigit = keypadAdj.get(String.valueOf(digit));
                time += adjListForDigit.get(keypad.indexOf(digitPrev));

                System.out.println("digit: " + digit + " adjacentes: " + adjListForDigit + " index: "
                        + keypad.indexOf(digitPrev) + " time to add:" + adjListForDigit.get(keypad.indexOf(digitPrev))
                        + " acum.time=" + time);
            }
            digitPrev = String.valueOf(digit);
        }

        return time;
    }

    public static void main(String[] args) {
        String code = "423692";
        String keypad = "923857614";
        System.out.println(
                "For code=" + code + " and keypad=" + keypad + " time is " + timeToInput(code, keypad) + " sec.");

    }
}
