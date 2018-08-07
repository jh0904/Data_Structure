package day06_SetAndHash;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * leetcode804. 唯一摩尔斯密码词
 * */
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<> ();
        for (String s : words) {
            StringBuilder res = new StringBuilder ();
            for (int i = 0; i < s.length (); i++) {
                res.append (code[s.charAt (i)-'a']);
            }
            set.add (res.toString ());
        }
        return set.size ();
    }
}