import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int j = i;
            int lineLength = 0;
            while (j < n && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int numberOfWords = j - i;
            int numberOfGaps = numberOfWords - 1;
            if (j == n || numberOfGaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
             
                int totalSpaces = maxWidth - lineLength;
                int spacesPerGap = totalSpaces / numberOfGaps;
                int extraSpaces = totalSpaces % numberOfGaps;

                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    int spacesToApply = spacesPerGap + (k - i < extraSpaces ? 1 : 0);
                    for (int s = 0; s < spacesToApply; s++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[j - 1]);
            }

            // Fixed line: used .add() instead of .append()
            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}