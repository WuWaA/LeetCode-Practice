public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int arr[] = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 97] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 97;
            arr[index] -= 1;
            if (arr[index] < 0)
                return false;
        }
        return true;
    }
}
