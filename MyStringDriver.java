import java.util.ArrayList;
import java.util.Arrays;

final class MyString {
    String str = null;

    MyString(String str) {
        this.str = str;
    }

    public int length() {
        int count = 0;
        for (int i = 0; true; i++) {
            try {
                str.charAt(i);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        if (str == null) {
            throw new NullPointerException("String is null");
        }

        if (str.length() == 0)
            return true;
        return false;

    }

    @Override
    public String toString() {
        return str;
    }

    public MyString toUpperCase(MyString str) {
        String op = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 97 || ch <= 122) {
                op += (char) (ch - 32);
            } else {
                op += ch;
            }
        }
        return new MyString(op);
    }

    public MyString toLowerCase(MyString str) {
        String op = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 65 || ch <= 90) {
                op += (char) (ch + 32);
            } else {
                op += ch;
            }
        }
        return new MyString(op);
    }

    public boolean startsWith(MyString ip) {
        for (int i = 0; i < ip.length(); i++) {
            if (str.charAt(i) != ip.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean endsWith(MyString ip) {
        if (ip.length() > str.length()) {
            return false;
        }

        for (int i = ip.length() - 1; i >= 0; i--) {
            if (str.charAt(str.length() - ip.length() + i) != ip.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public char charAt(int index) {
        if (index < 0 || index > str.length()) {
            throw new StringIndexOutOfBoundsException("Index should be less than string length");
        }
        char[] arr = str.toCharArray();
        return arr[index];
    }

    public int codePointAt(int index) {
        if (index < 0 || index >= str.length()) {
            throw new StringIndexOutOfBoundsException("Index should be less than string length");
        }

        char[] arr = str.toCharArray();

        return (int) arr[index];
    }

    public int codePointBefore(int index) {
        if (index < 0 || index >= str.length()) {
            throw new StringIndexOutOfBoundsException("Index should be less than string length");
        }

        char[] arr = str.toCharArray();

        return (int) arr[index - 1];
    }

    public int codePointCount(int start, int end) {
        int count = 0;
        if (start > end || end > str.length()) {
            throw new IndexOutOfBoundsException("Start cant be greater than end");
        }
        for (int i = start; i < end; i++) {
            count++;
        }
        return count;
    }

    public char[] toCharArray() {
        char[] arr = new char[str.length()];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            arr[index++] = str.charAt(i);
        }
        return arr;
    }

    public boolean equals(MyString str1) {
        for (int i = 0; i < str.length(); i++) {
            if (str1.str.charAt(i) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(MyString obj) {
        return (str.toUpperCase().equals(obj.str.toUpperCase()));
    }

    public int indexOf(char ch) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    public MyString trim() {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                newStr = str.substring(i + 1);
                continue;
            } else {
                break;
            }
        }
        for (int i = newStr.length() - 1; i >= 0; i--) {
            if (newStr.charAt(i) == ' ') {
                newStr = str.substring(0, i);
                continue;
            } else {
                break;
            }
        }
        return new MyString(newStr);
    }

    public MyString[] split(String regex) {
        char ch = regex.charAt(0);
        ArrayList<String> list = new ArrayList<>();
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                newStr += str.charAt(i);
            } else {
                list.add(newStr);
                newStr = "";
            }
        }
        if (!newStr.isEmpty()) {
            list.add(newStr);
        }
        MyString[] arr = new MyString[list.size()];
        int index = 0;
        for (String ele : list) {
            arr[index++] = new MyString(ele);
        }
        return arr;
    }

    public boolean contentEquals(Object obj) {
        if (obj instanceof StringBuffer) {
            StringBuffer sb = (StringBuffer) obj;
            if (str.length() != sb.length())
                return false;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != sb.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else if (obj instanceof StringBuilder) {
            StringBuilder sb = (StringBuilder) obj;
            if (str.length() != sb.length()) {
                return false;
            }
            for (int i = 0; i < str.length(); i++)
                if (str.charAt(i) != sb.charAt(i))
                    return false;
            return true;
        }
        return false;
    }

    public int compareTo(MyString regex) {
        int ch1 = str.charAt(0);
        int ch2 = regex.charAt(0);
        if (ch1 > ch2) {
            return ch1 - ch2;
        } else if (ch1 < ch2) {
            return ch1 - ch2;
        }
        return 0;
    }

    public MyString replace(char oldChar, char newChar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == oldChar) {
                sb.append(newChar);
            } else {
                sb.append(ch);
            }
        }
        String s = sb.toString();
        return new MyString(s);
    }
}

class MyStringDriver {
    public static void main(String[] args) {
        MyString str = new MyString("Hello");
        System.out.println(str.replace('l', 'o'));
    }
}
