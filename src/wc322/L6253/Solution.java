package wc322.L6253;

class Solution {
    public boolean isCircularSentence(String sentence) {
        //先檢查頭尾
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }

        String[] sentences = sentence.split("\\s+");

        //每個字頭尾要相同
        for (int i = 0; i < sentences.length - 1; i++) {
            if (sentences[i].charAt(sentences[i].length() - 1) != sentences[i + 1].charAt(0)) {
                return false;
            }
        }

        return true;
    }
}