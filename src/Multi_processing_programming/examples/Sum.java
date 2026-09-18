package Multi_processing_programming.examples;

public class Sum {

    public static void main(String[] args) {
        long pid = ProcessHandle.current().pid();
        System.out.println("Nire PID da: " + pid + " - Sarrerak: " + args[0] + ", " + args[1]);
        System.out.println("Nire PID da: " + pid + " - Emaitza: " +  batura(args));
    }
    public static long batura(String[] args) {
        long emaitza=0;
        for (int i = Integer.parseInt(args[0]); i<=Integer.parseInt(args[1]); i++){
            emaitza+=i;
        }
        return emaitza;
    }

}
