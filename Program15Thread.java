public class Program15Thread {

    int n;
    boolean f=false;
    synchronized public void  produce_item(int n){
        if(f){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n=n;
      System.out.println("Produce: "+this.n);
      f=true;
      notify();
    }
    synchronized public int consume_item(){
        if(!f){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
        System.out.println("comsume: "+this.n);
        f=false;
        notify();
        return this.n;
    }
}
/////////////////////////////////////////////////////////////////////
class Producer extends Thread{
    Program15Thread c;

    Producer(Program15Thread c){
        this.c=c;
    }
    public void run(){
        int i=1;
        while(true){
            this.c.produce_item(i);
            try{
            Thread.sleep(1000);}catch(Exception e){}
            i++;
        }

    }
}
////////////////////////////////////////////////////////////////////////
class Consumer extends  Thread{
    Program15Thread c;
Consumer(Program15Thread c){
    this.c=c;
}
    public void run(){
         while(true){
            this.c.consume_item();
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
            

         }
    }
}
//////////////////////////////////////////////////////////////
