/**
 Created by Saego on 11.04.2017.
 */
public class LThread implements Runnable{

    private boolean isActive = true;

    private void disable(){
        isActive = false;
    }
    public void run() {
        System.out.printf("Stream %s started work \n", Thread.currentThread().getName());
        int counter = 1;
        while (isActive){
            System.out.println("Cycle " + counter++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String []args){
        System.out.println("Main stream started");
        LThread lThread = new LThread();
        new Thread(lThread, "Inner").start();
        try {
            Thread.sleep(1500);
            lThread.disable();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main stream finished");
    }
}
