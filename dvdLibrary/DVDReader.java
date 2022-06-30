package dvdLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class DVD{

    private String title;
    private String releaseDate;
    private int mpaaRating;
    private String directorName;
    private String studio;
    private int userRating;
    private String userReview;

    public DVD(String title, String releaseDate, int mpaaRating, String directorName, String studio, int userRating, String userReview) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.directorName = directorName;
        this.studio = studio;
        this.userRating = userRating;
        this.userReview = userReview;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", mpaaRating=" + mpaaRating +
                ", directorName='" + directorName + '\'' +
                ", studio='" + studio + '\'' +
                ", userRating=" + userRating +
                ", userReview=" + userReview +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return mpaaRating == dvd.mpaaRating && userRating == dvd.userRating && userReview == dvd.userReview && Objects.equals(title, dvd.title) && Objects.equals(releaseDate, dvd.releaseDate) && Objects.equals(directorName, dvd.directorName) && Objects.equals(studio, dvd.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, mpaaRating, directorName, studio, userRating, userReview);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(int mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

}

class Service{

    Service(){}

    public static void add(ArrayList<DVD> dvdList, String properties){
        String[] splitProp = properties.split("::");
        DVD dvd = new DVD(splitProp[0],splitProp[1],Integer.valueOf(splitProp[2]),splitProp[3],
                splitProp[4],Integer.valueOf(splitProp[5]),splitProp[6]);
        dvdList.add(dvd);
    }

    public static void remove(ArrayList<DVD> dvdList, String movieName){
        for (DVD dvd: dvdList){
            if (dvd.getTitle().equals(movieName)){
                dvdList.remove(dvd);
            }
        }
    }

    public static void edit(ArrayList<DVD> dvdList, String properties){
        String[] splitProp = properties.split("::");
        String movieName = splitProp[0];
        for (DVD dvd: dvdList){
            if (dvd.getTitle().equals(movieName)){
                dvd.setReleaseDate(splitProp[1]);
                dvd.setMpaaRating(Integer.valueOf(splitProp[2]));
                dvd.setDirectorName(splitProp[3]);
                dvd.setStudio(splitProp[4]);
                dvd.setUserRating(Integer.valueOf(splitProp[5]));
                dvd.setUserReview(splitProp[6]);
            }
        }
    }

    public static void listAll(ArrayList<DVD> dvdList){
        for (DVD dvd:dvdList){
            System.out.println(dvd);
        }
    }

    public static void listOne(ArrayList<DVD> dvdList, String movieName){
        for (DVD dvd: dvdList){
            if (dvd.getTitle().equals(movieName)){
                System.out.println(dvd);
            }
        }
    }
}

public class DVDReader {
    public static void main(String[] args) throws IOException {
        // Load the DVD library
        File file = new File("src/dvdLibrary/dvdInformation.txt");
        Scanner sc = new Scanner(file);
        ArrayList<DVD> dvdList = new ArrayList<DVD>();
        while (sc.hasNextLine()) {
            String properties = sc.nextLine();
            Service.add(dvdList, properties);
        }
        Scanner sc1 = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            System.out.println("-----Welcome to interactive DVD Collection Application-----");
            System.out.println(" ");
            System.out.println("Please choose an operation to be performed (Enter the task number)");
            System.out.println(" ");
            System.out.println("1) Add a DVD to the collection");
            System.out.println("2) Remove a DVD from the collection");
            System.out.println("3) Edit the information for an existing DVD in the collection");
            System.out.println("4) List the DVDs in the collection");
            System.out.println("5) Search for a DVD by title and display DVD information");
            System.out.println("6) Save the DVD library back to the file");
            int choice = sc1.nextInt();
            if (choice == 1){ // Allow the user to add a DVD to the collection
                System.out.println("Enter movie title");
                String movieName = sc1.next();
                System.out.println("Enter release date");
                String releaseDate = sc1.next();
                System.out.println("Enter movie's MPAA rating (Enter an integer)");
                String mpaaRating = sc1.next();
                System.out.println("Enter director's name");
                String directorName = sc1.next();
                System.out.println("Enter the production studio");
                String studio = sc1.next();
                System.out.println("Enter user's rating (Enter an integer)");
                String userRating = sc1.next();
                System.out.println("Enter user review (if any)");
                String userReview = sc1.next();

                String newProp = movieName + "::" +
                        releaseDate + "::"+
                        mpaaRating + "::" +
                        directorName + "::" +
                        studio + "::" +
                        userRating + "::" +
                        userReview + "::";

                Service.add(dvdList, newProp);
            } else if (choice == 2){ // Allow the user to remove a DVD to the collection
                System.out.println("Enter movie title");
                String movieName = sc1.next();
                Service.remove(dvdList,movieName);
            } else if (choice == 3){ // Allow the user to edit the information for an existing DVD in the collection
                System.out.println("Enter movie title");
                String movieName = sc1.next();
                System.out.println("Enter release date");
                String releaseDate = sc1.next();
                System.out.println("Enter movie's MPAA rating (Enter an integer)");
                String mpaaRating = sc1.next();
                System.out.println("Enter director's name");
                String directorName = sc1.next();
                System.out.println("Enter the production studio");
                String studio = sc1.next();
                System.out.println("Enter user's rating (Enter an integer)");
                String userRating = sc1.next();
                System.out.println("Enter user review (if any)");
                String userReview = sc1.next();

                String newProp = movieName + "::" +
                        releaseDate + "::"+
                        mpaaRating + "::" +
                        directorName + "::" +
                        studio + "::" +
                        userRating + "::" +
                        userReview + "::";

                Service.edit(dvdList,newProp);
            } else if (choice == 4){ // Allow the user to list the DVDs in the collection
                Service.listAll(dvdList);
            } else if (choice == 5){ // Allow the user to search for a DVD by title and display DVD information
                System.out.println("Enter movie title");
                String movieName = sc1.next();
                Service.listOne(dvdList,movieName);
            } else if (choice == 6){// Save the DVD library back to the file when the program completes
                FileWriter fileStream = new FileWriter ("src/dvdLibrary/outputDVDInformation.txt");
                BufferedWriter info = new BufferedWriter(fileStream);
                for (DVD dvd:dvdList){
                    String output = dvd.getTitle() + "::" +
                            dvd.getReleaseDate() + "::" +
                            dvd.getMpaaRating() + "::" +
                            dvd.getDirectorName() + "::" +
                            dvd.getStudio() + "::" +
                            dvd.getUserRating() + "::" +
                            dvd.getUserReview();
                    info.write(output);
                    info.newLine();
                }
                info.close();
                break;
            }
        }
    }
}
