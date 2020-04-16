package repo;

import entity.Album;
import entity.Artist;
import javax.persistence.EntityManager;
import util.PersistanceUtil;

public class AlbumRepository {

    private final EntityManager EM;

    public AlbumRepository() {
        EM = PersistanceUtil.getInstance().getEMF().createEntityManager();
    }

    public void Create(Album album) {
        EM.getTransaction().begin();
        EM.persist(album);
        EM.getTransaction().commit();
    }

    public Album findById(int id) {
        EM.getTransaction().begin();
        Album album = EM.find(Album.class, id);
        EM.getTransaction().commit();
        return album;
    }

    public Album findbyName(String name) {
        EM.getTransaction().begin();
        Album album = (Album) EM.createNamedQuery("Album.findByName")
                .setParameter("name", name)
                .getSingleResult();
        EM.getTransaction().commit();
        return album;
    }

    public Album findByArtist(Artist artist) {
        EM.getTransaction().begin();
        Album album = (Album) EM.createNamedQuery("Album.findByName")
                .setParameter("arist_id", artist.getId())
                .getSingleResult();
        EM.getTransaction().commit();
        return album;
    }
}
