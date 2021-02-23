import java.util.function.Supplier;

public class Benchmark {
    private final int DEF_CAPACITY_SIZE = 10_000_000;
    private final int size;
    private Object[] array;
    public Benchmark(){
        size = DEF_CAPACITY_SIZE;
    }
    public Benchmark(int size){
        this.size = size;
    }
    public void prepare(){
       long mem = getMemoryChanges(() ->{array = new Object[size];});
        System.out.println("Pointer size:" + mem/size);
    }
    public void memorySizing(Supplier<Object> supplier, String typeObject){
        long changes = getMemoryChanges(() ->{
            for(int i = 0; i < size;i++){
                array[i] = supplier.get();
            }
        });
        System.out.println(typeObject + " use size:"+ Math.round((double)changes/size));
    }
    public static long getMemoryChanges(Runnable create) {
        tryLaunchGC();
        Runtime runtime = Runtime.getRuntime();
        long before = runtime.totalMemory() - runtime.freeMemory();
        create.run();
        tryLaunchGC();
        long after = runtime.totalMemory() - runtime.freeMemory();
        return after - before;
    }
    private static void tryLaunchGC(){
        try {
            System.gc();
            Thread.sleep(50);
        }
        catch (InterruptedException ignored){}
    }
}
