import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        int queries = 4;
        int bucket = 10;
        int input = 4;
        int output = 1;

        int storage = 0;
        for (int i = 0; i < queries; i++) {
            int space = bucket - storage;

            if (input <= space) {
                storage += input;
                System.out.println("Packets added: " + input);
                System.out.println("Buffer size: " + storage + " out of bucket size: " + bucket);
            } else {
                int lost = input - space;
                storage = bucket;
                System.out.println("Packet loss: " + lost);
                System.out.println("Buffer size: " + storage + " out of bucket size: " + bucket);
            }

            storage -= output;
            if (storage < 0) {
                storage = 0;
            }
            System.out.println("Buffer size after output: " + storage + " out of bucket size: " + bucket);
            System.out.println();
        }
    }
}
