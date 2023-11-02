/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.accesdatos;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mx.itson.accesdatos.exceptions.IllegalOrphanException;
import mx.itson.accesdatos.exceptions.NonexistentEntityException;
import mx.itson.accesdatos.exceptions.PreexistingEntityException;

/**
 *
 * @author leyv4a
 */
public class PersonaController implements Serializable {

    public PersonaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) throws PreexistingEntityException, Exception {
        if (persona.getLicenciaCollection() == null) {
            persona.setLicenciaCollection(new ArrayList<Licencia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Licencia> attachedLicenciaCollection = new ArrayList<Licencia>();
            for (Licencia licenciaCollectionLicenciaToAttach : persona.getLicenciaCollection()) {
                licenciaCollectionLicenciaToAttach = em.getReference(licenciaCollectionLicenciaToAttach.getClass(), licenciaCollectionLicenciaToAttach.getIdLicencia());
                attachedLicenciaCollection.add(licenciaCollectionLicenciaToAttach);
            }
            persona.setLicenciaCollection(attachedLicenciaCollection);
            em.persist(persona);
            for (Licencia licenciaCollectionLicencia : persona.getLicenciaCollection()) {
                Persona oldRfcOfLicenciaCollectionLicencia = licenciaCollectionLicencia.getRfc();
                licenciaCollectionLicencia.setRfc(persona);
                licenciaCollectionLicencia = em.merge(licenciaCollectionLicencia);
                if (oldRfcOfLicenciaCollectionLicencia != null) {
                    oldRfcOfLicenciaCollectionLicencia.getLicenciaCollection().remove(licenciaCollectionLicencia);
                    oldRfcOfLicenciaCollectionLicencia = em.merge(oldRfcOfLicenciaCollectionLicencia);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersona(persona.getRfc()) != null) {
                throw new PreexistingEntityException("Persona " + persona + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getRfc());
            Collection<Licencia> licenciaCollectionOld = persistentPersona.getLicenciaCollection();
            Collection<Licencia> licenciaCollectionNew = persona.getLicenciaCollection();
            List<String> illegalOrphanMessages = null;
            for (Licencia licenciaCollectionOldLicencia : licenciaCollectionOld) {
                if (!licenciaCollectionNew.contains(licenciaCollectionOldLicencia)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Licencia " + licenciaCollectionOldLicencia + " since its rfc field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Licencia> attachedLicenciaCollectionNew = new ArrayList<Licencia>();
            for (Licencia licenciaCollectionNewLicenciaToAttach : licenciaCollectionNew) {
                licenciaCollectionNewLicenciaToAttach = em.getReference(licenciaCollectionNewLicenciaToAttach.getClass(), licenciaCollectionNewLicenciaToAttach.getIdLicencia());
                attachedLicenciaCollectionNew.add(licenciaCollectionNewLicenciaToAttach);
            }
            licenciaCollectionNew = attachedLicenciaCollectionNew;
            persona.setLicenciaCollection(licenciaCollectionNew);
            persona = em.merge(persona);
            for (Licencia licenciaCollectionNewLicencia : licenciaCollectionNew) {
                if (!licenciaCollectionOld.contains(licenciaCollectionNewLicencia)) {
                    Persona oldRfcOfLicenciaCollectionNewLicencia = licenciaCollectionNewLicencia.getRfc();
                    licenciaCollectionNewLicencia.setRfc(persona);
                    licenciaCollectionNewLicencia = em.merge(licenciaCollectionNewLicencia);
                    if (oldRfcOfLicenciaCollectionNewLicencia != null && !oldRfcOfLicenciaCollectionNewLicencia.equals(persona)) {
                        oldRfcOfLicenciaCollectionNewLicencia.getLicenciaCollection().remove(licenciaCollectionNewLicencia);
                        oldRfcOfLicenciaCollectionNewLicencia = em.merge(oldRfcOfLicenciaCollectionNewLicencia);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = persona.getRfc();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getRfc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Licencia> licenciaCollectionOrphanCheck = persona.getLicenciaCollection();
            for (Licencia licenciaCollectionOrphanCheckLicencia : licenciaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Licencia " + licenciaCollectionOrphanCheckLicencia + " in its licenciaCollection field has a non-nullable rfc field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
