import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
public class WikiGame {
    public static void main(String[] args) {
        int linkCounter = 0;
        Scanner Scan = new Scanner(System.in);

        System.out.println("Enter the starting point, is it's multiple words, put an underscore");

        String StartingPage = Scan.nextLine();

        System.out.println(StartingPage);

        System.out.println("Enter the ending point, is it's multiple words, put an underscore");

        String EndingPage = Scan.nextLine();

        System.out.println(EndingPage);

        String StartingURL = ("https://en.wikipedia.org/wiki/" + StartingPage);

        String PageText = URLFetcher.getUrlContents(StartingURL);

//        System.out.println(PageText);

        String[] SpacedText = PageText.split("<");
        System.out.println(SpacedText[3]);
        ArrayList<String> URLSFound;
        URLSFound = new ArrayList<String>();

        for (int i = 0; i<SpacedText.length; i = i+1){
            Pattern pattern = Pattern.compile("a href=");
            Matcher matcher = pattern.matcher(SpacedText[i]);
            if(matcher.find()) {
                URLSFound.add(SpacedText[i].substring(8));
                System.out.println(SpacedText[i].substring(8));
            }
        }

    }

}
