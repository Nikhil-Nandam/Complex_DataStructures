import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Integer> heap;
    
    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public int compare(int a, int b) {
        return Integer.compare(this.heap.get(a), this.heap.get(b));
    }

    public int size() {
        return this.heap.size();
    }

    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    public int peek() {
        return this.heap.get(0);
    }

    public int push(int element) {
        this.heap.add(this.size(), element);
        this.siftUp();
        return this.size();
    }

    public int pop() {
        // int returnValue = this.heap.remove(0);
        // this.siftDown();
        // return returnValue;
        if (this.size() > 1) {
            this.swap(0, this.size() - 1);
        }
        int returnValue = this.heap.remove(this.size() - 1);
        this.siftDown();
        return returnValue;
    }

    private int getParentIndex(int index) {
        return (int)Math.floor((index - 1) / 2);
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private void swap(int i, int j) {
        int temp = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, temp);
    }

    private void siftUp() {
        int nodeIndex = this.size() - 1;
        // System.out.println(nodeIndex);
        // System.out.println(this.compare(nodeIndex, this.getParentIndex(nodeIndex)) > 1);
        while (nodeIndex > 0 && this.compare(nodeIndex, this.getParentIndex(nodeIndex)) > 0) {
            // System.out.println("YES");
            this.swap(nodeIndex, this.getParentIndex(nodeIndex));
            nodeIndex = this.getParentIndex(nodeIndex);
        }
    }

    public void siftDown() {
        int nodeIndex = 0;
        while ((this.getLeftChildIndex(nodeIndex) < this.size() && this.compare(this.getLeftChildIndex(nodeIndex), nodeIndex) > 0) 
                || (this.getRightChildIndex(nodeIndex) < this.size() && this.compare(this.getRightChildIndex(nodeIndex), nodeIndex) > 0)) {
            int greaterChildIndex = 
            this.getRightChildIndex(nodeIndex) < this.size() && 
            this.compare(this.getRightChildIndex(nodeIndex), this.getLeftChildIndex(nodeIndex)) > 0
            ? this.getRightChildIndex(nodeIndex) : this.getLeftChildIndex(nodeIndex);

            this.swap(greaterChildIndex, nodeIndex);
            nodeIndex = greaterChildIndex;
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.push(15);
        heap.push(12);
        heap.push(50);
        heap.push(7);
        heap.push(40);
        heap.push(22);

        for (int i = 0; i < 6; i++) {
            // System.out.println(heap.pop());
            System.out.println(heap.heap.get(i));
        }
        // heap.pop();
        // heap.pop();
        // heap.pop();

        for (int i = 0; i < 6; i++) {
            System.out.println(heap.pop());
            // System.out.println(heap.heap.get(i));
        }
    }
}