/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.accesdatos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mx.itson.accesdatos.exceptions.NonexistentEntityException;
import mx.itson.accesdatos.exceptions.PreexistingEntityException;

/**
 *
 * @author leyv4a
 */
public class LicenciaController implements Serializable {

    public LicenciaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Licencia licencia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona rfc = licencia.getRfc();
            if (rfc != null) {
                rfc = em.getReference(rfc.getClass(), rfc.getRfc());
                licencia.setRfc(rfc);
            }
            em.persist(licencia);
            if (rfc != null) {
                rfc.getLicenciaCollection().add(licencia);
                rfc = em.merge(rfc);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLicencia(licencia.getIdLicencia()) != null) {
                throw new PreexistingEntityException("Licencia " + licencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Licencia licencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Licencia persistentLicencia = em.find(Licencia.class, licencia.getIdLicencia());
            Persona rfcOld = persistentLicencia.getRfc();
            Persona rfcNew = licencia.getRfc();
            if (rfcNew != null) {
                rfcNew = em.getReference(rfcNew.getClass(), rfcNew.getRfc());
                licencia.setRfc(rfcNew);
            }
            licencia = em.merge(licencia);
            if (rfcOld != null && !rfcOld.equals(rfcNew)) {
                rfcOld.getLicenciaCollection().remove(licencia);
                rfcOld = em.merge(rfcOld);
            }
            if (rfcNew != null && !rfcNew.equals(rfcOld)) {
                rfcNew.getLicenciaCollection().add(licencia);
                rfcNew = em.merge(rfcNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = licencia.getIdLicencia();
                if (findLicencia(id) == null) {
                    throw new NonexistentEntityException("The licencia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Licencia licencia;
            try {
                licencia = em.getReference(Licencia.class, id);
                licencia.getIdLicencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The licencia with id " + id + " no longer exists.", enfe);
            }
            Persona rfc = licencia.getRfc();
            if (rfc != null) {
                rfc.getLicenciaCollection().remove(licencia);
                rfc = em.merge(rfc);
            }
            em.remove(licencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Licencia> findLicenciaEntities() {
        return findLicenciaEntities(true, -1, -1);
    }

    public List<Licencia> findLicenciaEntities(int maxResults, int firstResult) {
        return findLicenciaEntities(false, maxResults, firstResult);
    }

    private List<Licencia> findLicenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Licencia.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Licencia findLicencia(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Licencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getLicenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Licencia> rt = cq.from(Licencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
