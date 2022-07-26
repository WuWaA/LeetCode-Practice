/**
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000


    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

 */

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        char last = ' ';
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch (current) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    if (last == 'I')
                        result += 3; // 3 -> 4-1, because result plus 1 in last turn
                    else
                        result += 5;
                    break;
                case 'X':
                    if (last == 'I')
                        result += 8; // 3 -> 9-1, because result plus 1 in last turn
                    else
                        result += 10;
                    break;
                case 'L':
                    if (last == 'X')
                        result += 30; // 30 -> 40-10, because result plus 10 in last turn
                    else
                        result += 50;
                    break;
                case 'C':
                    if (last == 'X')
                        result += 80; // 80 -> 90-10, because result plus 10 in last turn
                    else
                        result += 100;
                    break;
                case 'D':
                    if (last == 'C')
                        result += 300; // 300 -> 400-100, because result plus 100 in last turn
                    else
                        result += 500;
                    break;
                case 'M':
                    if (last == 'C')
                        result += 800; // 800 -> 900-100, because result plus 100 in last turn
                    else
                        result += 1000;
            }
            last = current;
        }
        return result;
    }

    /**
     * compare two roman char
     * @param a
     * @param b
     * @return 1 if a > b, 0 if a = b, -1 if a < b, 2 if error
     */
    /*
    int compareTo(char a, char b) {
        if (a == b)
            return 0;
        else if (a == 'I')
            return -1;
        else if (a == 'V')
            return 1 ? b == 'I' : -1;
        else if (a == 'X')
            return 1 ? b == 'I' || b == 'V' : -1;
        else if (a == 'L')
            return 1 ? b == 'I' || b == 'V' || b == 'X' : -1;
        else if (a == 'C')
            return -1 ? b == 'M' || b == 'D' : 1;
        else if (a == 'D')
            return -1 ? b == 'M' : 1;
        else if (a == 'M')
            return 1;
        else // error
            return 2;
    }
    */
}
