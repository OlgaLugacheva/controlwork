import java.util.Random;

/**
 * Created by Olga on 13.02.2017.
 * Реализовать программу из 2-х потоков. Один из потоков каждую секунду генерирует
 * случайное число в интервале [0;99]. Второй поток раз в пять секунд выводит количество
 * уникальных чисел, сгенерированных первым потоком. После того, как будет сгенерировано
 * все 100 чисел, оба потока должны остановить свое выполнение.
 */
public class Main {
    public static void main(String[] args) {
        SimpleThread thread1 = new SimpleThread();
        thread1.start();
    }

}

class SimpleThread extends Thread {

    Random rnd = new Random(100);

    @Override
    public void run() {
        try {
            System.out.println("Simple Thread 1");

            for (int i = 1; i <= 100; i++) {
                JoinedThread jt = new JoinedThread(i);
                jt.start();
                Thread.sleep(1000);
                int d = rnd.nextInt(100);
                System.out.println("Generated: " + d);
//                jt.join();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


class JoinedThread extends Thread {
    int count = 0;

    public JoinedThread(int count) {
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(this.Count(count));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public int Count(int i) {
        System.out.println("Count is: " + i);
        return i;
    }
}


