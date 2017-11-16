
import Model.*;

import java.util.ArrayList;

public class main {

        public static DatabaseConnection database;


        public static void main(String[] args) {

            database = new DatabaseConnection("src/CourseworkDatabase.db");
            ArrayList<Catch> testList = new ArrayList<>();

            CatchService.selectAll(testList, database);

                for (Catch c: testList) {
                    System.out.println(c);
                }

            ArrayList<Album> AlbumList = new ArrayList<>();

            AlbumService.selectAll(AlbumList, database);

                for (Album d: AlbumList) {
                    System.out.println(d);
            }

            ArrayList<Species> SpeciesList = new ArrayList<>();

            SpeciesService.selectAll(SpeciesList, database);

            for (Species a: SpeciesList) {
                System.out.println(a);
            }
        }
    }

