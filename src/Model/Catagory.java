package Model;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;
public class Catagory {

    public static String detectCatagory(String title) {

        title = title.toLowerCase();

        if (title.contains("pizza") || title.contains("burger") || title.contains("restaurant"))
            return "Food";

        else if (title.contains("uber") || title.contains("bus") || title.contains("train"))
            return "Travel";

        else if (title.contains("shirt") || title.contains("shoes") || title.contains("clothes"))
            return "Shopping";

        else if (title.contains("medicine") || title.contains("doctor"))
            return "Health";

        else
            return "Other";
    }
}
