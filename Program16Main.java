public class Program16Main {
        public static void main(String... s) {
        Program15Thread comp=new Program15Thread();
        Producer p= new Producer(comp);
        Consumer c= new Consumer(comp);
        p.start();
        c.start();
    }
}