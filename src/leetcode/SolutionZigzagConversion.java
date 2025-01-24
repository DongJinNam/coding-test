class Solution {
    public String convert(String s, int numRows) {
        
        String result = "";
        char[][] charArr = new char[numRows+1][s.length()+1];
        int count = 0;
        int row = 0, col = 0;
        boolean isCross = false;
        // numRows == 1 인 경우, return s
        if (numRows == 1) return s;
        // 대각선인 경우, 그렇지 않은 경우로 구분
        while (count < s.length()) {
            if (isCross) {
                charArr[row--][col++] = s.charAt(count++);
                if (row == 0) isCross = false;
            } else {
                charArr[row++][col] =  s.charAt(count++);
                if (row == numRows-1) isCross = true;
            }
        }
        // 순서대로 result 에 추가
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= col; j++) {
                if ((charArr[i][j] >= 'A' && charArr[i][j] <= 'z') || charArr[i][j] == ',' || charArr[i][j] == '.') result += charArr[i][j];
            }
        }
        return result;
    }
}
