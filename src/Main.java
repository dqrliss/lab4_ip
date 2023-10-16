import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.Collections;
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println();
        Scanner in = new Scanner(Paths.get("input.txt"));
        st_recordbook st_recordbook1 = new st_recordbook();
        st_recordbook1.input(in);
        //System.out.println("first student:");
        //st_recordbook1.average_mark();
        st_recordbook st_recordbook2 = new st_recordbook();
        st_recordbook2.input(in);
        //System.out.println("second student:");
        //st_recordbook2.average_mark();
        st_recordbook st_recordbook3 = new st_recordbook();
        st_recordbook3.input(in);
        //System.out.println("third student:");
        //st_recordbook3.average_mark();
        in.close();

        ArrayList <st_recordbook> recordbooks = new ArrayList<>();
        recordbooks.add(st_recordbook1);
        recordbooks.add(st_recordbook2);
        recordbooks.add(st_recordbook3);

        Collections.sort(recordbooks);
        for (st_recordbook stRecordbook : recordbooks) {
            System.out.println(stRecordbook.get_zachetka());
        }
        int index = Collections.binarySearch(recordbooks, new st_recordbook(1458685));
        if (index > -1) System.out.println(recordbooks.get(index).get_name() + "\n");
        else System.out.println("there is no such zachetka\n");

        recordbooks.sort(new my_comp()); // <- list.sort // aka Collections.sort(recordbooks, new my_comp());
        for (st_recordbook recordbook: recordbooks) {
            System.out.println(recordbook.get_name());
        }
        int index_ = Collections.binarySearch(recordbooks, new st_recordbook("listov glist anufrievich"), new my_comp());
        if (index_ > -1) System.out.println(recordbooks.get(index_).get_zachetka());
        else System.out.println("there is no such student");

//        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
//        st_recordbook1.output(out);
//        st_recordbook2.output(out);
//        out.close();
        //for (st_recordbook i: recordbooks) System.out.println(i.get_name() + " " + i.get_zachetka());
        //for (int i: recordbooks) System.out.println(i);
    }
}