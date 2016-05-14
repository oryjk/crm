package other;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlwang on 5/14/16.
 */
public class Container {
    public static final ThreadLocal<List> holder = new ThreadLocal<>();
    private static List<String> list = new ArrayList<>();

    private Container() {
        holder.set(list);
    }

    public static void add() {
        if (ObjectUtils.isEmpty(holder.get())) {
            holder.set(new ArrayList<String>());
        }
        holder.get().add("1");
    }

    public static Integer getSize() {
        return holder.get().size();
    }
}
