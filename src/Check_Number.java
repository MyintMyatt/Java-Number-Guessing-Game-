package com.guessinggame;

public class Check_Number {
    public String checkNum(String randomNum, String guessNum) {
        char[] random = randomNum.toCharArray();
        char[] guess = guessNum.toCharArray();
        String result = "";
        boolean flag = true;
        for (int k = 0; k < guess.length; k++) {
            if (guess[k] == random[k]) {
                result += "*";
                random[k] = '*';
            } else {
                for (int j = 0; j < random.length; j++) {
                    System.out.println("k : " + k + " j : " + j);
                    if (k != j && guess[k] == random[j]) {
                        result += "!";
                        random[j] = '!';
                        System.out.println(random);
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    result += "X";
                }
                flag = true;

            }
        }

        return result;
    }
}
