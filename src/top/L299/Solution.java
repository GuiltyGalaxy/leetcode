package top.L299;

class Solution {
    public String getHint(String secret, String guess) {

        int A = 0;
        int B = 0;

        int[] sDigits = new int[10];
        int[] gDigits = new int[10];

        //統計出現次數
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            }
            sDigits[secret.charAt(i) - '0']++;
            gDigits[guess.charAt(i) - '0']++;
        }

        //secret與guess都有出現擇取數字小的則可當作B
        for (int i = 0; i <= 9; i++) {
            B += Math.min(sDigits[i], gDigits[i]);
        }

        B -= A;

        return A + "A" + B + "B";
    }
}