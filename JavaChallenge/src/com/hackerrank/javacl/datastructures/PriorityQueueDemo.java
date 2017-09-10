package com.hackerrank.javacl.datastructures;

import java.util.*;

/**
 * Created by raistlin on 9/10/2017.
 */
class PriorityQueueDemo {
    void run() {
        Scanner in = new Scanner(System.in);

        int eventCount = in.nextInt();
        in.nextLine();

        List<String> events = new ArrayList<>();
        for (int i = 0; i < eventCount; ++i) {
            events.add(in.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Priorities {
    private final PriorityQueue<Student> students;
    private final Comparator<Student> studentComparator;

    Priorities() {
        studentComparator = Comparator.comparing(Student::getCGPA).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getID);
        students = new PriorityQueue<>(
                studentComparator);
    }

    private Student parseStudent(String[] eventData) {
        return new Student(Integer.parseInt(eventData[3]), eventData[1], Double.parseDouble(eventData[2]));
    }

    List<Student> getStudents(List<String> events) {
        for (String event : events) {
            String[] eventData = event.split(" ");
            if ("ENTER".equals(eventData[0])) {
                students.offer(parseStudent(eventData));
            } else if ("SERVED".equals(eventData[0])) {
                if (!students.isEmpty()) {
                    students.poll();
                }
            }
        }

        List<Student> results = new ArrayList<>(students);
        results.sort(studentComparator);
        return results;
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }
}