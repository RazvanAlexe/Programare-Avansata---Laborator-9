package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistanceUtil {

    private static PersistanceUtil pu;
    private final EntityManagerFactory EMF;

    private PersistanceUtil() {
        EMF = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    public static PersistanceUtil getInstance() {
        if (pu == null) {
            pu = new PersistanceUtil();
        }
        return pu;
    }

    public EntityManagerFactory getEMF() {
        return EMF;
    }

}
