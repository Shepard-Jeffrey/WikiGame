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

        String[] SpacedText = PageText.split("<");


        ArrayList<String> URLSFound;
        URLSFound = new ArrayList<String>();

        for (int i = 0; i<SpacedText.length; i = i+1){
            Pattern pattern = Pattern.compile("a href=\"/wiki");
            Matcher matcher = pattern.matcher(SpacedText[i]);
            int closingIndex;
            if(matcher.find()) {
                String endingURL;
                endingURL = SpacedText[i].substring(14);
                closingIndex =  endingURL.indexOf("\" ");
                //uniquePartURL.substring(0, closingIndex);

                // URLSFound.add(SpacedText[i].substring(8, closingIndex));
                if(closingIndex > 0) {
                    System.out.println(URLSFound.size());
                    System.out.println(endingURL.substring(0, closingIndex));
                    URLSFound.add(endingURL.substring(0, closingIndex));
                }

            }
        }
        int chosenIndex = 0; // initialization

        while (!((URLSFound.get(chosenIndex)).equals(EndingPage)))
        {
            System.out.println("Enter the number of the next page you'd like to visit");

            String chosenURL = Scan.nextLine();

            linkCounter = linkCounter + 1;

            chosenIndex = Integer.parseInt(chosenURL);

            if (URLSFound.get(chosenIndex).equals(EndingPage)) {
                break;
        }

            System.out.println(URLSFound.get(chosenIndex));

            String NextURL = ("https://en.wikipedia.org/wiki/" + URLSFound.get(chosenIndex));

            PageText = URLFetcher.getUrlContents(NextURL);

            SpacedText = PageText.split("<");

            System.out.println(URLSFound.get(3));

            URLSFound = new ArrayList<String>();

            for (int i = 0; i<SpacedText.length; i = i+1){
                Pattern pattern = Pattern.compile("a href=\"/wiki");
                Matcher matcher = pattern.matcher(SpacedText[i]);
                int closingIndex;
                if(matcher.find()) {
                    String endingURL;
                    endingURL = SpacedText[i].substring(14);
                    closingIndex =  endingURL.indexOf("\" ");
                    //uniquePartURL.substring(0, closingIndex);

                    // URLSFound.add(SpacedText[i].substring(8, closingIndex));
                    if(closingIndex > 0) {
                        System.out.println(URLSFound.size());
                        System.out.println(endingURL.substring(0, closingIndex));
                        URLSFound.add(endingURL.substring(0, closingIndex));
                    }

                }
            }
        }

        System.out.println("Congratulations! You've reached the goal page in " + linkCounter + " tries!");

//        Player NewPlayer = new Player();
//        NewPlayer.setName("John");
//        System.out.println(NewPlayer.getName());
    }

}