package lecture17.Queues;

/*
 *

The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers `0` and `1` respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a **stack**. At each step:

- If the student at the front of the queue **prefers** the sandwich on the top of the stack, they will **take it** and leave the queue.
- Otherwise, they will **leave it** and go to the queue's end.

This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

You are given two integer arrays `students` and `sandwiches` where `sandwiches[i]` is the type of the `ith` sandwich in the stack (`i = 0` is the top of the stack) and `students[j]` is the preference of the `jth` student in the initial queue (`j = 0` is the front of the queue). Return *the number of students that are unable to eat*

Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0
*/

import java.util.*;

public class Question3 {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();

        // Add all students to the queue
        for (int student : students) {
            queue.offer(student);
        }

        int notEaten = 0; // Count of students who are unable to eat

        for (int sandwich : sandwiches) {
            if (queue.isEmpty()) {
                break;
            }

            if (queue.peek() == sandwich) {
                queue.poll(); // The student takes the sandwich
                notEaten = 0; // Reset the count
            } else {
                queue.offer(queue.poll()); // The student goes to the queue's end
                notEaten++; // Increment the count of students unable to eat

                // If all students have been considered but no one can eat, break the loop
                if (notEaten == queue.size()) {
                    break;
                }
            }
        }

        return queue.size(); // Remaining students in the queue are unable to eat
    }

    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        int notEaten = countStudents(students, sandwiches);
        System.out.println("Number of students unable to eat: " + notEaten);
    }
}
