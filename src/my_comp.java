import java.util.Comparator;
public class my_comp implements Comparator<st_recordbook> {
    public int compare(st_recordbook a, st_recordbook b){
        return a.get_name().compareTo(b.get_name()); // minus for int
    }
}