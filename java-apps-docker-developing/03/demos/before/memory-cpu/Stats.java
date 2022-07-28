public class Stats {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        System.out.printf("Heap size: %dMB%n", 
                          rt.totalMemory()/1024/1024);
        
        // The heap cannot grow beyond this size or an OutOfMemoryException will be thrown
        System.out.printf("Maximum size of heap: %dMB%n", 
                          rt.maxMemory()/1024/1024); 
        
        System.out.printf("Available processors: %d%n", 
                          rt.availableProcessors());

    }
}
