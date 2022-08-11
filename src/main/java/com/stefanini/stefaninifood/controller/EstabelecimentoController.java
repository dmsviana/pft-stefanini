package com.stefanini.stefaninifood.controller;

import com.stefanini.stefaninifood.entity.Estabelecimento;
import com.stefanini.stefaninifood.controller.util.JsfUtil;
import com.stefanini.stefaninifood.controller.util.JsfUtil.PersistAction;
import com.stefanini.stefaninifood.bean.EstabelecimentoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("estabelecimentoController")
@SessionScoped
public class EstabelecimentoController implements Serializable {

    @EJB
    private com.stefanini.stefaninifood.bean.EstabelecimentoFacade ejbFacade;
    private List<Estabelecimento> items = null;
    private Estabelecimento selected;

    public EstabelecimentoController() {
    }

    public Estabelecimento getSelected() {
        return selected;
    }

    public void setSelected(Estabelecimento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EstabelecimentoFacade getFacade() {
        return ejbFacade;
    }

    public Estabelecimento prepareCreate() {
        selected = new Estabelecimento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        if(estabelecimentoJaExiste(this.selected)){
            JsfUtil.addErrorMessage("Estabelecimento já existe!");
        }else{
            persist(PersistAction.CREATE, "Estabelecimento criado com sucesso!");
        }
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EstabelecimentoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EstabelecimentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Estabelecimento> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Estabelecimento getEstabelecimento(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Estabelecimento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Estabelecimento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
    public boolean estabelecimentoJaExiste(Estabelecimento estabelecimento){
        String cnpj = estabelecimento.getCNPJ();
        List<Estabelecimento> list = getItems();
        return list.stream().anyMatch((item) -> (item.getCNPJ().equals(cnpj)));
    }

    @FacesConverter(forClass = Estabelecimento.class)
    public static class EstabelecimentoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstabelecimentoController controller = (EstabelecimentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estabelecimentoController");
            return controller.getEstabelecimento(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Estabelecimento) {
                Estabelecimento o = (Estabelecimento) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Estabelecimento.class.getName()});
                return null;
            }
        }

    }

}
