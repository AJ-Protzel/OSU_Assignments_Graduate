
public class IntList {
    private ConsCell start;

    public IntList(ConsCell s) {
        start = s;
    }

    public IntList cons(int h) {
        return new IntList(new ConsCell(h, start));
    }

    public int length() {
        int len = 0;
        ConsCell cell = start;
        while (cell != null) {
            len++;
            cell = cell.getTail();
        }
        return len;
    }


public IntList reverse() {
    IntList rList = new IntList(null); // new empty list
    ConsCell i = start; // grab first index of list

    while (i != null) { // iterate list to push on new list
        rList = rList.cons(i.getHead()); // prepend old list onto new list
        i = i.getTail(); // get next
    }
    return rList;
}

    // Print
    public void print() {
        System.out.print("[");
        ConsCell a = start;
        while (a != null) {
            System.out.print(a.getHead());
            a = a.getTail();
            if (a != null)
                System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        IntList a = new IntList(null);
        IntList b = a.cons(2);
        IntList c = b.cons(1);
        IntList d = c.reverse();

        a.print(); // Output: []
        b.print(); // Output: [2]
        c.print(); // Output: [1,2]
        d.print(); // Output: [2,1]
    }
}
