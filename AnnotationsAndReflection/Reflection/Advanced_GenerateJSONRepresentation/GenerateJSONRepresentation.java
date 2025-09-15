import java.lang.reflect.*;

class Book {
    public String title = "Unknown";
    public int pages = 100;
}

public class GenerateJSONRepresentation {
    public static String toJSON(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder("{");
        Field[] fields = cls.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sb.append("\"" + fields[i].getName() + "\": \"" + fields[i].get(obj) + "\"");
            if (i < fields.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Book book = new Book();
        System.out.println(toJSON(book));
    }
}