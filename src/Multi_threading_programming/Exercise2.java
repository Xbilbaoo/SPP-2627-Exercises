package Multi_threading_programming;

public class Exercise2 {

    static void main() throws InterruptedException {

        final Object blocker = new Object();

        Thread thread = new Thread(() -> {
            System.out.println("The thread " + Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(1000);

                synchronized (blocker) { blocker.wait(); }
                synchronized (blocker) { System.out.println("the thread "  +  Thread.currentThread().getName() + " exited from the block."); }

            } catch (InterruptedException e) {

                throw new RuntimeException(e);

            }
        });

        thread.setName("PAKO");


        showState(thread);

        thread.start();
        showState(thread);

        Thread.sleep(200);
        showState(thread);

        Thread.sleep(1000);
        showState(thread);

        synchronized (blocker) {

            blocker.notify();
            Thread.sleep(200);
            showState(thread);

        }

        thread.join();
        showState(thread);



    }


    static void showState(Thread thread){ System.out.format("%s: %s%n", thread.getName(), thread.getState()); }

}
