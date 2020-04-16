package app;

import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {

    public static void main(String[] args) {
        Database database = Database.getInstance();
        AlbumController AbC = new AlbumController(database);
        ArtistController AtC = new ArtistController(database);
        AlbumRepository AbrP = new AlbumRepository();
        ArtistRepository AtrP = new ArtistRepository();
        database.closeConnection();
    }

}
