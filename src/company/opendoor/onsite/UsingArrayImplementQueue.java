package company.opendoor.onsite;

public class UsingArrayImplementQueue {

    static class MyQueue {
        int[] array = new int[8];
        int tail = 0;
        int head = 0;
        int size = 0;

        public void push(int e) {
            array[tail] = e;
            size++;
            if (size == array.length) {
                array = resize(array);
            }else {
                tail = (tail + 1) % array.length;
            }
        }

        private int[] resize(int[] array) {
            System.out.println("resize");
            int[] newArray = new int[array.length * 2];
            int i = 0;
            while (head != tail) {
                newArray[i++] = array[head];
                head = (head + 1) % array.length;
            }
            // Don't forget
            newArray[i++] = array[head];
            head = 0;
            tail = i;
            return newArray;
        }

        public int pop() throws Exception {
            if (head == tail) {
                throw new Exception();
            }
            int ret = array[head];
            size--;
            head = (head + 1) % array.length;
            return ret;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            if(head == tail){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        queue.push(6);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println("size:"+queue.size);
        queue.push(100);
        queue.push(99);
        queue.push(100);
        queue.push(99);
        queue.push(101);
        queue.push(102);
        queue.push(103);
        queue.push(104);
        queue.push(105);

        while(!queue.isEmpty()){
            System.out.println("pop:"+ queue.pop());
        }

    }
}
