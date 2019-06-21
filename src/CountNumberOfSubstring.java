import java.util.Arrays;

public class CountNumberOfSubstring {
    int countkDist(String str, int k) {
        if (str == null || str.length() < k)
            return 0;

        int res = 0;

        int[] cha = new int[26];

        int l, r;
        for (int i = 0; i < str.length(); i++) {
            Arrays.fill(cha, 0);
            int cnt = 0;

            for (int j = i; j < str.length(); j++) {
                if (cha[str.charAt(j) - 'a']++ == 0)
                    cnt++;

                if (cnt == k)
                    res++;
            }
        }

        return res;
    }
/*
    public static void main(String[] args)
    {
        CountNumberOfSubstring ob = new CountNumberOfSubstring();
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k +    " distinct characters : "
                + ob.countkDist(ch, k));
    }
*/
}
