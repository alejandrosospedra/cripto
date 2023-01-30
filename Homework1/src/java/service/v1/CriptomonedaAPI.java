/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.v1;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import model.entities.Criptomoneda;
import model.entities.Transaccion;
import service.AbstractFacade;

/**
 *
 * @author Alejandro Sospedra 
 * @author Younes Kabir
 */
@Stateless
@Path("v1/cryptocurrency")
public class CriptomonedaAPI extends AbstractFacade<Criptomoneda>{
    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public CriptomonedaAPI() {
        super(Criptomoneda.class);
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCryptocurrencyWithLastTransaction(@PathParam("id") Long id) {
        Query query = em.createNamedQuery("Criptomoneda.findByIdWithLastTransaction");
        query.setParameter("criptoId", id);
        query.setMaxResults(1);
        List resultList = query.getResultList();
        return Response.ok(resultList).build();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSortedCryptocurrencies(@QueryParam("order") @DefaultValue("desc") String order) {
        if (order.equalsIgnoreCase("asc")) {
            return Response.ok().entity(em.createNamedQuery("Criptomoneda.findAllOrderByPriceASC", Criptomoneda.class)
                    .getResultList()).build();
        } else if(order.equalsIgnoreCase("desc")) {
            return Response.ok().entity(em.createNamedQuery("Criptomoneda.findAllOrderByPriceDESC", Criptomoneda.class)
                    .getResultList()).build();      
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid value for parameter 'order'. Value must be 'asc' or 'desc'.").build();
        }
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
        
}
