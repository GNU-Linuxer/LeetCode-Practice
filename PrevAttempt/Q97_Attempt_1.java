public class Q97_Attempt_1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }

        int[] stringIndices = new int[3];
        while(stringIndices[0] < s1.length() && stringIndices[1] < s2.length() && stringIndices[2] < s3.length()) {
            if(s3.charAt(stringIndices[2]) == s1.charAt(stringIndices[0])) {
                stringIndices[2] = stringIndices[2] + 1;
                stringIndices[0] = stringIndices[0] + 1;
            } else if(s3.charAt(stringIndices[2]) == s2.charAt(stringIndices[1])) {
                stringIndices[2] = stringIndices[2] + 1;
                stringIndices[1] = stringIndices[1] + 1;
            }
        }

        return stringIndices[0] == s1.length() && stringIndices[1] == s2.length() && stringIndices[2] == s3.length();
    }

    public static void main(String[] args) {
        Q97_Attempt_1 test1 = new Q97_Attempt_1();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(test1.isInterleave(s1, s2, s3));
    }
}
