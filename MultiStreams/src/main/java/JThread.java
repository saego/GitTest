/**
 Created by Saego on 11.04.2017.
 */
public class JThread extends Thread{
    private JThread(String name) {
        super(name);
    }
    public void run(){
        System.out.printf("Stream %s started work \n", Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getPriority());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Stream %s finished work \n", Thread.currentThread().getName());
    }

    public static void main(String []args){
        System.out.println("Main stream started work");
        for(int i=1; i<6;i++) {
            JThread jT = new JThread("Stream " + i);
            jT.start();
            try {
                jT.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main stream finished work");
    }
}
