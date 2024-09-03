import java.util.Arrays;

class ArrayList {
    Integer[] arr;

    int index;

    ArrayList() {
        arr = new Integer[10];
    }

    @Override
    public String toString() {
        String op = "[";
        for (int i = 0; i < index - 1; i++) {
            op += arr[i] + ", ";
        }
        op += arr[index - 1] + "]";
        return op;
    }

    public int size() {
        return arr.length;
    }

    public void add(Integer e) {
        if (arr.length == index) {
            int newSize = ((arr.length * 3) / 2) + 1;
            Integer[] narr = Arrays.copyOf(arr, newSize);
            arr = narr;
        }
        arr[index++] = e;
    }

    public int indexOf(Integer e) {
        for (int i = 0; i < index; i++)
            if (arr[i] == e)
                return i;
        return -1;
    }

    public int lastIndexOf(Integer e) {
        for (int i = index - 1; i >= 0; i--)
            if (arr[i] == e)
                return i;
        return -1;
    }

    public int get(int indx) {

        if (indx < 0 || indx >= size()) {
            throw new ArrayIndexOutOfBoundsException("Wrong index entered");
        }
        return arr[indx];
    }

    public int set(int indx, Integer newEle) {
        if (indx < 0 || indx >= size()) {
            throw new ArrayIndexOutOfBoundsException("Wrong index entered");
        }
        int prevEle = arr[indx];
        arr[indx] = newEle;
        return prevEle;
    }

    public void trimToSize() {
        Integer[] narr = Arrays.copyOf(arr, index);
        arr = narr;
    }

    public ArrayList subList(int sIndex, int eIndex) {
        ArrayList obj = new ArrayList();
        for (int i = sIndex; i < eIndex; i++) {
            obj.add(get(i));
        }
        return obj;
    }
}

public class MyArrayListDriver {
    public static void main(String[] args) {
        ArrayList obj = new ArrayList();

        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);
        obj.add(6);
        obj.add(7);
        obj.add(8);
        obj.add(9);
        obj.add(10);
        obj.add(11);

        System.out.println(obj);
        System.out.println(obj.subList(1, 5));

    }
}
