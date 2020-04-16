package repo;

import entity.Artist;
import javax.persistence.EntityManager;
import util.PersistanceUtil;

public class ArtistRepository {

    private final EntityManager EM;

    public ArtistRepository() {
        EM = PersistanceUtil.getInstance().getEMF().createEntityManager();
    }

    public void Create(Artist artist) {
        EM.getTransaction().begin();
        EM.persist(artist);
        EM.getTransaction().commit();
    }

    public Artist findById(int id) {
        EM.getTransaction().begin();
        Artist artist = EM.find(Artist.class, id);
        EM.getTransaction().commit();
        return artist;
    }

    public Artist findbyName(String name) {
        EM.getTransaction().begin();
        Artist artist = (Artist) EM.createNamedQuery("Artist.findByName")
                        .setParameter("name", name)
                        .getSingleResult();
        EM.getTransaction().commit();
        return artist;
    }
}
