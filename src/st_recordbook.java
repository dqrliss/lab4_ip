import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class st_recordbook implements Comparable<st_recordbook>{
    st_recordbook() {
        number_of_recordbook = 0;
        name_of_student = "";
        number_of_sessions = 0;
    }
    st_recordbook(int number_of_recordbook) {
        this.number_of_recordbook = number_of_recordbook;
        name_of_student = "";
        number_of_sessions = 0;
    }
    st_recordbook(String name_of_student) {
        number_of_recordbook = 0;
        this.name_of_student = name_of_student;
        number_of_sessions = 0;
    }
    private int number_of_recordbook;
    private String name_of_student;
    private int number_of_sessions;
    ArrayList <session> sessions = new ArrayList<>();
    int get_zachetka() {
        return number_of_recordbook;
    }
    String get_name() {
        return name_of_student;
    }
    public int compareTo(st_recordbook other) {
        return Integer.compare(this.number_of_recordbook, other.number_of_recordbook);
        //return (this.number_of_recordbook < other.number_of_recordbook) ? -1 : ((this.number_of_recordbook == other.number_of_recordbook) ? 0 : 1);
    }
    public boolean checking_for_excellent_student() {
        for (session i: sessions) if (!i.checking_for_excellent_student()) return false;
        return true;
    }
    public void average_mark() {
        for (session i: sessions) System.out.print(i.average_mark() + " ");
        System.out.println("\n");
    }
    public String toString() {
        StringBuilder str = new StringBuilder("number of recordbook: " + number_of_recordbook + "\n" + "student's full name: " + name_of_student + "\n" + "number of sessions: " + number_of_sessions + "\n\n");
        for (session i: sessions) str.append(i.toString());
        return str.toString();
    }
//    public String toString() {
//        String str = "number of recordbook: " + number_of_recordbook + "\n" + "student's full name: " + name_of_student + "\n" + "number of sessions: " + number_of_sessions + "\n\n";
//        for (session i: sessions) str += i.toString();
//        return str;
//    }
    public void output(PrintWriter out) {
        out.print(this);
    }
    public void input(Scanner in) throws IOException {
        number_of_recordbook = Integer.parseInt(in.nextLine());
        name_of_student = in.nextLine();
        number_of_sessions = Integer.parseInt(in.nextLine());
        for (int i = 0; i < number_of_sessions; i++) {
            session session = new session();
            session.input(in);
            sessions.add(session);
        }
    }
    public static class session {
        private int number_of_exams;
        private int number_of_session;
        private int number_of_zachets;
        ArrayList <exam> exams = new ArrayList<>();
        ArrayList <zachet> zachets = new ArrayList<>();
        public boolean checking_for_excellent_student() {
            for (exam i: exams) if (!i.checking_for_excellent_student()) return false;
            for (zachet i: zachets) if (!i.checking_for_excellent_student()) return false;
            return true;
        }
        public double average_mark() {
            double av_mark = 0;
            for (exam i: exams) {
                av_mark += i.average_mark();
            }
            return av_mark / number_of_exams;
        }
        public String toString() {
            StringBuilder str = new StringBuilder("number of session: " + number_of_session + "\n" + "number of exams: " + number_of_exams + "\n");
            for (exam i: exams) str.append(i.toString()).append("\n");
            str.append("number of zachets: ").append(number_of_zachets).append("\n");
            for (zachet i: zachets) str.append(i.toString()).append("\n");
            str.append("\n");
            return str.toString();
        }
        public void input(Scanner in) throws IOException {
            number_of_session = Integer.parseInt(in.nextLine());
            number_of_exams = Integer.parseInt(in.nextLine());
            for (int i = 0; i < number_of_exams; i++) {
                exam exam = new exam();
                exam.input(in);
                exams.add(exam);
            }
            number_of_zachets = Integer.parseInt(in.nextLine());
            for (int i = 0; i < number_of_zachets; i++) {
                zachet zachet = new zachet();
                zachet.input(in);
                zachets.add(zachet);
            }
        }
        private static class exam {
            private String subject;
            private int mark;
            public boolean checking_for_excellent_student() {
                return mark == 9 || mark == 10;
            }
            public double average_mark() {
                return mark;
            }
            public String toString() {
                return "subject: " + subject + ", " + "mark: " + mark;
            }
            private void input(Scanner in) throws IOException {
                String str = in.nextLine();
                int index = str.lastIndexOf(" ");
                subject = str.substring(0, index);
                mark = Integer.parseInt(str.substring(index + 1));
            }
        }
        private static class zachet {
            private String subject;
            private boolean zachet;
            public boolean checking_for_excellent_student() {
                return zachet;
            }
            public String toString() {
                return "subject: " + subject + ", " + "zachet: " + zachet;
            }
            private void input(Scanner in) throws IOException {
                String str = in.nextLine();
                int index = str.lastIndexOf(" ");
                subject = str.substring(0, index);
                zachet = Boolean.parseBoolean(str.substring(index + 1));
            }
        }
    }
}