import java.lang.management.ManagementFactory;
/*
  * VM options -Xmx512m -Xms512m -XX:-UseCompressedOops
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
    public static void main(String[] args){

        System.out.println("pid:" + ManagementFactory.getRuntimeMXBean().getName());
        Benchmark benchmark = new Benchmark();
        benchmark.prepare();
        benchmark.memorySizing(Object::new,"object");
        benchmark.memorySizing(String::new,"String_pool");
        benchmark.memorySizing(() -> new String(new char[0]),"String_without_pool");
    }
}
