public class CharPrinter implements Runnable {
    private char c;
    private long l;

    public CharPrinter(char c, long l) {
        this.c = c;
        this.l = l;
    }

    @Override
    public void run() {
        try {
            int counter = 0;
            while (true) {
                counter++;
                System.out.print(c);
                if (counter == 5) {
                    System.out.println();
                    counter = 0;
                }
                Thread.sleep(l);
            }
        } catch (InterruptedException e) {
            System.out.println();
            System.out.println("The char is: " + c);
        }
    }
}
