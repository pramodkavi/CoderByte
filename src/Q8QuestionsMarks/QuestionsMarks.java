package Q8QuestionsMarks;
//Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit numbers,
// letters, and question marks, and check if there are exactly 3 question marks between every pair of two numbers that
// add up to 10. If so, then your program should return the string true, otherwise it should return the string false.
// If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.
// For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are exactly
// 3 question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.
public class QuestionsMarks {
    public static boolean questionsMarks(String str) {
        int lastNum = -1;
        int questionMarkCount = 0;
        boolean foundPair = false;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                if (lastNum != -1 && lastNum + num == 10) {
                    if (questionMarkCount == 3) {
                        foundPair = true;
                    } else {
                        return false;
                    }
                }
                lastNum = num;
                questionMarkCount = 0;
            } else if (ch == '?') {
                questionMarkCount++;
            }
        }

        return foundPair;
    }

    public static void main(String[] args) {
        System.out.println(questionsMarks("arrb6???4xxbl5???eee5")); // true
        System.out.println(questionsMarks("aa6?9")); // false
        System.out.println(questionsMarks("acc?7??sss?3rr1??????5")); // true
    }
}
