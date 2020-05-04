public class RansomNote {

    /*
     Given an arbitrary ransom note string and another string containing letters from all the magazines,
     write a function that will return true if the ransom note can be constructed from the magazines ;
     otherwise, it will return false.

     Each letter in the magazine string can only be used once in your ransom note.

     Note:
     You may assume that both strings contain only lowercase letters.

     canConstruct("a", "b") -> false
     canConstruct("aa", "ab") -> false
     canConstruct("aa", "aab") -> true
     */

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println("jewelsAndStones " + ransomNote.canConstruct("aa", "aab"));
    }

    private boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int index = ransomNote.indexOf(c);
            if (index != -1) {
                ransomNote = ransomNote.substring(0, index) + ransomNote.substring(index + 1);
            }
        }
        return ransomNote.isEmpty();
    }
}
