package tk.mybatis.thread.test;

import java.util.concurrent.CountDownLatch;
import org.junit.Test;

public class ThreadTest {


    private static int value;




    @Test
    public void threadTest() {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {


            new Thread(() -> {

                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println(System.currentTimeMillis() + " : " + Thread.currentThread().getName() + " value: " + getNext());
            }, "thread" + i).start();

        }



        countDownLatch.countDown();
    }



    private  static int getNext() {
        return value++;
    }
}
