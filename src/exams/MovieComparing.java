package exams;
//Doplnte atributy pro Film
//
//Jsou jimi:
//Název filmu,
//Rok vydani,
//rating (4.5, 7.8... vyssi = lepsi)
//doba trvani ve vterinach
//
//Vypis do konzole:
//Vypsano serazene dle data vydani od nejstarsich
//Vypsano serazeno dle jmena
//TOP 10 filmu dle ratingu

//Link na odevzdani GIST:
//https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=f_BDFfkwekCetYp67EGP_1pSNPXTVBFPg7PGychWGEdUM040WFhKVFpJQ1RBUVZYVUU2MUYxS0hETCQlQCNjPTEu


import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;

public class MovieComparing {

    static ArrayList<Movie> loadData(String path){
        DataImport di = new DataImport(path);
        ArrayList<Movie> movies = new ArrayList<>();
        String line;
        String[] tokens;

        while (di.hasNext()){
            line = di.readLine();
            tokens = line.split(";");
            movies.add(new Movie(
                    tokens[0],
                    Integer.parseInt(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Integer.parseInt(tokens[3])
            ));
        }

        di.finishImport();
        return movies;
    }

    static void printList(ArrayList<Movie> movies){
        for (Movie m : movies){
            System.out.println(m);
        }
        System.out.println();
        System.out.println("---");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Movie> movies = loadData("data/Movies.txt");
/*
        movies.sort(Movie.BY_YEAR);
        printList(movies);

        movies.sort(Movie.BY_NAME);
        printList(movies);
*/
        movies.sort(Movie.BY_RATING.reversed());
        int filmyTOP10 = 0;
        for (Movie m : movies){
            System.out.println(m);
            filmyTOP10++;
            if (filmyTOP10 > 10){
                return;
            }
        }

    }

}

class Movie {
    String name;
    int year;
    double rating;
    int lengthInSeconds;

    public Movie(String name, int year, double rating, int lengthInSeconds) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.lengthInSeconds = lengthInSeconds;
    }

    public static final Comparator<Movie> BY_YEAR = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Integer.compare(o1.year, o2.year);
        }
    };

    public static final Comparator<Movie> BY_NAME = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public static final Comparator<Movie> BY_RATING = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o1.rating, o2.rating);
        }
    };

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", lengthInSeconds=" + lengthInSeconds +
                '}';
    }
}