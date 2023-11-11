import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> arr;

    public Stack() {
        arr = new ArrayList<>();
    }

    public void push(int num) {
        arr.add(num);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int last = arr.size() - 1;
            int popNum = arr.get(last);
            arr.remove(last);
            return popNum;
        }
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(4);
        s.push(5);
        s.push(6);

        if (!s.isEmpty()) {
            int poppedElement = s.pop();
            System.out.println("Popped element: " + poppedElement);
        } else {
            System.out.println("Stack is empty.");
        }
    }
}



