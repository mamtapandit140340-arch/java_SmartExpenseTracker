// ============================================================
// Category.java
// Package: model
// ============================================================

package Model;

public class Catagory {

    public static String detectCategory(String title) {

        title = title.toLowerCase();
        if (title.contains("pizza")
                || title.contains("burger")
                || title.contains("food")
                || title.contains("restaurant")
                || title.contains("coffee")
                || title.contains("lunch")
                || title.contains("dinner")) {

            return "Food";
        }


        else if (title.contains("bus")
                || title.contains("train")
                || title.contains("uber")
                || title.contains("ola")
                || title.contains("rickshaw")
                || title.contains("rikshaw")
                || title.contains("fuel")
                || title.contains("petrol")) {

            return "Travel";
        }


        else if (title.contains("shirt")
                || title.contains("shoes")
                || title.contains("clothes")
                || title.contains("shopping")
                || title.contains("amazon")
                || title.contains("flipkart")) {

            return "Shopping";
        }


        else if (title.contains("medicine")
                || title.contains("doctor")
                || title.contains("hospital")
                || title.contains("medical")) {

            return "Health";
        }


        else if (title.contains("book")
                || title.contains("course")
                || title.contains("college")
                || title.contains("exam")
                || title.contains("education")) {

            return "Education";
        }


        else if (title.contains("movie")
                || title.contains("netflix")
                || title.contains("game")
                || title.contains("concert")) {

            return "Entertainment";
        }


        else if (title.contains("electricity")
                || title.contains("bill")
                || title.contains("recharge")
                || title.contains("internet")) {

            return "Bills";
        }


        else {
            return "Other";
        }
    }
}