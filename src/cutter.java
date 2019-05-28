import jsone.JsoneParse;

import java.io.IOException;

public class cutter {
    public static void main(String[] args) {
        try {
            new JsoneParse().parseJsone();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
