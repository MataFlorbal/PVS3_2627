package Vyuka.basics;

import fileworks.DataExport;
import fileworks.DataImport;

import java.io.IOException;
import java.util.Arrays;

public class ParseFile {
    public static void main(String[] args) throws IOException {
        //imort souboru
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        //      //di.printFile(); //vypis vseho
        //      System.out.println(di.readLine()); //vypis radku

        //      //vypis informace jednoho radku
        //      String name;
        //      String continent;
        //      long population;
        //      double avgAge;

        //      //vypis vseho, bez printFile
        //      di.reinitializeRead();
        //      while (di.hasNext()){
        //          System.out.println(di.readLine());
        //      }

        //      //nacteni, rozdeleni, parsing a vypis jednoho radku
        //      String output = di.readLine();
        //      String [] tokens = output.split(";");
        //
        //      name = tokens[0];
        //      continent = tokens[1];
        //      population = Long.parseLong(tokens[2]);
        //      avgAge = Double.parseDouble(tokens[3]);

        //      System.out.println(name);
        //      System.out.println(continent);
        //      System.out.println(population);
        //      System.out.println(avgAge);

        //vypis jednoho radku jako objekt tridy country

        Country czechia = new Country("Czech Republic", "Europa", 10800000L, 85.0);
        System.out.println(czechia);

        //export souboru
        DataExport de = new DataExport("output.txt");



        while (di.hasNext()) {
            //vypis vsech radku jako objekty tridy country
            String line = di.readLine();
            String[] tokens = line.split(";");

            String name = tokens[0];
            String continent = tokens[1];
            long population = Long.parseLong(tokens[2]);
            double avgAge = Double.parseDouble(tokens[3]);

            Country oneCountry = new Country(name, continent, population, avgAge);

            if (oneCountry.continent.equals("Europe")){
                de.writeLine(oneCountry.toString());
            }

            System.out.println(oneCountry);
        }
        de.finishExport();
        di.finishImport();
    }
}
