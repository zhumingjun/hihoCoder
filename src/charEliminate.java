import java.util.Scanner;

//1039字符消除
public class charEliminate {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        String [] strs= new String [n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        int[] sum = new int[n];
        for (int i = 0; i < strs.length; i++) {
            StringBuffer sb = new StringBuffer(strs[i]);
            int size = sb.length();
            sum[i] = 0;
            for (int j = 0; j < size; j++) {
                for (char k = 'A'; k < 'D' ; k++) {
                    StringBuffer temp = new StringBuffer(sb);
                    temp.insert(j,k);
                    int count = handle(temp);
                    sum[i] = size>count?count:size;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(strs[i].length()+1-sum[i]);
        }
    }

    private static int handle (StringBuffer buffer) {
        int count = 0;
        while (true) {
            StringBuffer temp = new StringBuffer();
            int i = 0, j = 1;
            for (; j < buffer.length(); j++) {
                if (buffer.charAt(i) != buffer.charAt(j)) {
                    temp.append(buffer.charAt(i));
                } else {
                    while (j < buffer.length()
                            && buffer.charAt(i) == buffer.charAt(j))
                        j++;
                }
                i = j;
            }
            if (j == buffer.length()) {
                temp.append(buffer.charAt(i));
            }
            if (temp.length() == buffer.length()) {
                count = temp.length();
                break;
            }
            buffer = temp;
        }
        return count;
    }
}
