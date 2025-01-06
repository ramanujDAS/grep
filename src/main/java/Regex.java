public class Regex {
    private final Character WILDCARD;
    private final Character ZERO_OR_MORE;

    public Regex(Character wildcard, Character zeroOrMore) {
        this.WILDCARD = wildcard;
        this.ZERO_OR_MORE = zeroOrMore;
    }
    public boolean isMatch(String inputString, String pattern) {
        boolean[][] matchCheck = new boolean[inputString.length() + 1][pattern.length() + 1];
        matchCheck[inputString.length()][pattern.length()] = true;
        for (int patternIndex = pattern.length() - 1; patternIndex >= 0; patternIndex--) {
            if (pattern.charAt(patternIndex) != '*')
                break;
            else
                matchCheck[inputString.length()][patternIndex] = true;
        }

        for (int charIndex = inputString.length() - 1; charIndex >= 0; charIndex--) {
            for (int patternIndex = pattern.length() - 1; patternIndex >= 0; patternIndex--) {
                if (inputString.charAt(charIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == WILDCARD)
                    matchCheck[charIndex][patternIndex] = matchCheck[charIndex + 1][patternIndex + 1];
                else if (pattern.charAt(patternIndex) == ZERO_OR_MORE)
                    matchCheck[charIndex][patternIndex] = matchCheck[charIndex + 1][patternIndex] || matchCheck[charIndex][patternIndex + 1];
                else
                    matchCheck[charIndex][patternIndex] = false;
            }
        }
        return matchCheck[0][0];
    }

    public static void main(String[] args) {
        Regex regex = new Regex('?' , '*');
        System.out.println(regex.isMatch("aab", "a*?"));
    }
}
