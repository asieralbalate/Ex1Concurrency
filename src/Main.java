import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Runnable> list = new ArrayList<>(24);
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            long time = (long) ((Math.random() * 3001) + 3000);
            list.add(new CharPrinter(ch, time));
        }
        launchThread(list);
    }

    public static void launchThread(List<Runnable> list) {
        for (Runnable runnable : list) {
            Thread t = new Thread(runnable);
            t.start();
            long timer = 10000 + (long) (Math.random() * 20000);
            Interruptor interruptor = new Interruptor(t, timer);
            Thread thread = new Thread(interruptor);
            thread.start();
        }
    }
}
