package will.zhang.heap.BShiftUp;

import will.zhang.util.SortTestHelper;

/**
 * 这只是一个最大堆
 * @param <T>
 */
public class MaxHeap<T extends Comparable> {

    /**
     * 使用数组来实现一个最大堆
     */
    protected T[] data;
    /**
     * 堆里面元素的个数
     */
    protected int count;
    /**
     * 堆的容量
     */
    protected int capacity;

    /**
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        //下标0的位置是弃用的,所以capacity+1
        data = (T[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 返回堆中元素个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 往最大堆插入一个元素
     * @param t
     */
    public void insert(T t){
        assert count + 1 <= capacity;
        //下标0位置是启用的，所以+1
        data[count + 1] = t;
        count++;
        //把元素调整到合适的位置（符合最大堆的要求）
        shiftUp(count);
    }

    /**
     * 最大堆核心辅助函数
     * 把元素调整到合适的位置
     * @param k
     */
    private void shiftUp(int k){
        //和父节点比较，如果小于父节点，则交换
        while (k > 1 && data[k/2].compareTo(data[k]) < 0){
            SortTestHelper.swap(data, k/2, k);
            k /= 2;
        }
    }


    public static void main(String[] args) {
        int capacity = 10;

        int M = 100;
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(capacity);

        for (int i = 0; i < capacity; i++) {
            maxHeap.insert(new Integer((int)(Math.random() * M)));
        }
    }
}

