package com.mypack.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mypack.entity.User;
@Component
public class UserValidator implements Validator{
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}
	public void validate(Object obj, Errors error) {
		ValidationUtils.rejectIfEmpty(error, "firstName", "","First name is required");
		ValidationUtils.rejectIfEmpty(error,"lastName", "msg.name", "Last name is required");
		ValidationUtils.rejectIfEmpty(error,"password", "msg.lastname", "Password is required");
		ValidationUtils.rejectIfEmpty(error,"email", "msg.email", "Email is required");
		//error.rejectValue("password", "msg.password", "Password is required");
		/* ValidationUtils.rejectIfEmpty(err, "password", "Password is required");
	      ValidationUtils.rejectIfEmpty(err, "email", "Email is required");
	      ValidationUtils.rejectIfEmpty(err, "firstName", "First Name is required");
	      ValidationUtils.rejectIfEmpty(err, "lastName", "Last Name is required");
*/
	      User user = (User) obj;

	      Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	            Pattern.CASE_INSENSITIVE);
	      if (!(pattern.matcher(user.getEmail()).matches())) {
	         error.rejectValue("email", "user.email.invalid","Not Valid Email");
	      }

	}

}
