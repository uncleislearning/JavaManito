package main.daan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by unclexiao on 27/03/2018.
 */
public class One {
    public static void main(String[] args) {

        Map<String, Map<String, String>> flags = new HashMap<>();
        Map<String, String> nmaps = new HashMap<>();
        nmaps.put("L", "W");
        nmaps.put("R", "E");

        flags.put("N", nmaps);

        Map<String, String> wmaps = new HashMap<>();
        wmaps.put("L", "S");
        wmaps.put("R", "N");

        flags.put("W", wmaps);

        Map<String, String> smaps = new HashMap<>();
        smaps.put("L", "E");
        smaps.put("R", "W");

        flags.put("S", smaps);

        Map<String, String> emaps = new HashMap<>();
        emaps.put("L", "N");
        emaps.put("R", "S");

        flags.put("E", emaps);

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            char[] line = in.next().toCharArray();
            String face = "N";
            for (int i = 0; i < n; i++) {
                String f = String.valueOf(line[i]);
                face = flags.get(face).get(f);
            }

            System.out.println(face);

        }
    }
}
