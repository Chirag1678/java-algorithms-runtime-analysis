// Class to check performance of concatenation using String, StringBuffer and StringBuilder
public class StringConcatenation {
    public static void main(String[] args) {
        // Define a sample string to concatenate
        String s = "hello";

        // Concat strings for 1_000, 10_000 and 1_000_000 number of times and compare result
        compareConcatenation(s, 1_000);
        compareConcatenation(s, 10_000);
        compareConcatenation(s, 1_000_000);
    }

    static void compareConcatenation(String s, int length) {
        System.out.println("Current String length: " + length);
        // Define startTime and endTime variables
        long startTime, endTime;

        // String time
        if(length == 1_000_000) {
            System.out.println("Concatenation using String is not feasible");
        } else {
            startTime = System.nanoTime();
            String res = "";
            for(int i=0;i<length;i++) {
                res += s;
            }
            endTime = System.nanoTime();
            System.out.println("Time taken by String: " + (endTime - startTime) / 1e6 + "ms");
        }

        // StringBuilder Time
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++) {
            sb.append(s);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) / 1e6 + "ms");

        // StrigBuffer Time
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<length;i++) {
            sbf.append(s);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) / 1e6 + "ms");

        System.out.println();
    }
}
// System Output ->
// Current String length: 1000
// Time taken by String: 1.91ms
// Time taken by StringBuilder: 0.064791ms
// Time taken by StringBuffer: 0.096041ms

// Current String length: 10000
// Time taken by String: 31.532958ms
// Time taken by StringBuilder: 0.33425ms
// Time taken by StringBuffer: 0.340917ms

// Current String length: 1000000
// Concatenation using String is not feasible
// Time taken by StringBuilder: 14.961083ms
// Time taken by StringBuffer: 21.569792ms