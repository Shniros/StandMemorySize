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
    public static void main(String[] args) {

        System.out.println("pid:" + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;
        System.out.println("Starting the loop");

        while (true){

        }
    }
}
