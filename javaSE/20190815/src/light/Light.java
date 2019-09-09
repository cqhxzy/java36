package light;

public class Light {
    private int state = 1;// 1:红灯   2：黄灯   3：绿灯

    public synchronized void red(){
            try {
                //假设当前状态不为红灯，则红灯的线程就要一直等待。
                while (state != 1) {
                    wait();
                }

                //红灯亮5下
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ":红灯亮" + (i + 1 ) + "下");
                    Thread.sleep(500);
                }

                //黄灯亮
                state = 2;
                notifyAll(); //唤醒所有的线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    //黄灯
    public synchronized void yellow(){
        try {
            while (state != 2) {
                wait();
            }

            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":黄灯亮" + (i + 1) + "下") ;
                Thread.sleep(500);
            }

            //绿灯亮
            state = 3;

            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void green(){
        try {
            while (state != 3) {
                wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":绿灯亮" + (i + 1) + "下") ;
                Thread.sleep(500);
            }

            //红灯亮
            state = 1;

            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
