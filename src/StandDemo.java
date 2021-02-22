import java.lang.management.ManagementFactory;
/*
  * VM options -Xmx512m -Xms512m
  *<p>
  * Runtime runtime = Runtime.getRuntime();
  * long mem = runtime.totalMemory() - runtime.freeMemory();
  * <p>
  * System.gc();
  * <p>
  * use jconsole
  *
* */
public class StandDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("pid:" + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;
        System.out.println("Starting the loop");

        while (true){
            System.gc();
            Thread.sleep(10);
            Runtime runtime = Runtime.getRuntime();
            long mem = runtime.totalMemory() - runtime.freeMemory();
            System.out.println(mem);

            Object[] array = new Object[size];
            System.out.println("Array created! size:" + array.length);
            
            long mem2 = runtime.totalMemory() - runtime.freeMemory();
            System.out.println((mem2-mem)/size);

            for(int i = 0;i < array.length;i++){
                array[i] = new Object();

               // array[i] = new String("");//String pool
               // array[i] = new String(new char[0]);// without string pool
            }
            System.out.println("Created " + size + " objects.");
            Thread.sleep(1000);
        }
    }
}
