import java.io.*;
import java.util.*;

class LeakyBucket {
    public static void main(String[] args) {
        int no_of_queries = 4;
        int bucket_size = 10;
        int input_pkt_size = 4;
        int output_pkt_size = 1;

        int storage = 0;
        for (int i = 0; i < no_of_queries; i++) {
            int size_left = bucket_size - storage;

            if (input_pkt_size <= size_left) {
                storage += input_pkt_size;
                System.out.println("Packets added: " + input_pkt_size);
                System.out.println("Buffer size: " + storage + " out of bucket size: " + bucket_size);
            } else {
                int lost_packets = input_pkt_size - size_left;
                storage = bucket_size;
                System.out.println("Packet loss: " + lost_packets);
                System.out.println("Buffer size: " + storage + " out of bucket size: " + bucket_size);
            }

            storage -= output_pkt_size;
            if (storage < 0) {
                storage = 0;
            }
            System.out.println("Buffer size after output: " + storage + " out of bucket size: " + bucket_size);
            System.out.println();
        }
    }
}
