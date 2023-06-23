package lecture17.Queues;


/*
You have a `RecentCounter` class which counts the number of recent requests within a certain time frame.

Implement the `RecentCounter` class:

- `RecentCounter()` Initializes the counter with zero recent requests.
- `int ping(int t)` Adds a new request at time `t`, where `t` represents some time in milliseconds, and returns the number of requests that has happened in the past `3000` milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range `[t - 3000, t]`.

It is **guaranteed** that every call to `ping` uses a strictly larger value of `t` than the previous call.

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]
*/



import java.util.LinkedList;
import java.util.Queue;

public class Question4 {
    private Queue<Integer> requests;

    public Question4() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        // Add the current request time to the queue
        requests.offer(t);

        // Remove outdated requests from the queue
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        // Return the number of requests within the time frame
        return requests.size();
    }

    public static void main(String[] args) {
        Question4 counter = new Question4();
        System.out.println(counter.ping(1));     // Output: 1
        System.out.println(counter.ping(100));   // Output: 2
        System.out.println(counter.ping(3001));  // Output: 3
        System.out.println(counter.ping(3002));  // Output: 3
    }
}
