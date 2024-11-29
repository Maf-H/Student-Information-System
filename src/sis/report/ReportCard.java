package sis.report;

import java.util.*;
import sis.studentinfo.*;
public class ReportCard {
    static String A_MESSAGE = "Excellent";
    static String B_MESSAGE = "Very good";
    static String C_MESSAGE = "Hmmm";
    static String D_MESSAGE = "You are not trying";
    static String F_MESSAGE = "Loser";

    private Map<Student.Grade, String> messages = null;

    public String getMessage(Student.Grade grade) {
        return getMessage().get(grade);
    }
    private Map<Student.Grade, String> getMessage(){
        if (messages == null)
            loadMessages();
        return messages;
    }
    private void loadMessages() {
        // casting to enumerator type hashmap.
        messages = new EnumMap<>(Student.Grade.class);
        messages.put(Student.Grade.A, A_MESSAGE);
        messages.put(Student.Grade.B, B_MESSAGE);
        messages.put(Student.Grade.C, C_MESSAGE);
        messages.put(Student.Grade.D, D_MESSAGE);
        messages.put(Student.Grade.F, F_MESSAGE);
    }
}
