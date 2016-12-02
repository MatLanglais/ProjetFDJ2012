package org.formation.jsf.validator;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class EmailValidator implements Validator {

	public EmailValidator() {
	}

	@Override
	public void validate(FacesContext facesContext, UIComponent arg1, Object arg2) throws ValidatorException {
		String mustcontain = "@";
		String email = (String) arg2;
		if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
			ResourceBundle bundleMsg = facesContext.getApplication().getResourceBundle(facesContext, "messages");
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					bundleMsg.getString("error.notanemail"), bundleMsg.getString("error.notanemail")));
		} 
	}

}
