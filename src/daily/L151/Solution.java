package daily.L151;

class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        //反轉全部字串
        reverse(cs, 0, cs.length - 1);
        //反轉個別word
        reverseWord(cs);
        //將多餘的空白去掉
        return cleanSpaces(cs);
    }


    private void reverseWord(char[] cs) {
        int i = 0, j = 0, n = cs.length;

        while (i < n) {
            //找word的起始
            while (i < j || i < n && cs[i] == ' ') i++;
            //找word的結束
            while (j < i || j < n && cs[j] != ' ') j++;

            reverse(cs, i, j - 1);
        }
    }

    private String cleanSpaces(char[] a) {
        int i = 0, j = 0, n = a.length;

        while (j < n) {
            //找到word起始
            while (j < n && a[j] == ' ') j++;
            //搬移word
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            //計算下個word起始
            while (j < n && a[j] == ' ') j++;
            //補一個空白
            if (j < n) a[i++] = ' ';
        }
        //結束後多的空白會全部在字串最後面，所以要截掉
        return new String(a).substring(0, i);
    }

    private void reverse(char[] cs, int a, int b) {
        while (a < b) {
            swap(cs, a, b);
            a++;
            b--;
        }
    }

    private void swap(char[] c, int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}