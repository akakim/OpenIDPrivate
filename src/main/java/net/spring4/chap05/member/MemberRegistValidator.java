package net.spring4.chap05.member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberRegistValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberRegistRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberRegistRequest regReq = (MemberRegistRequest) target;
		
		if( regReq.getEmail() == null || regReq.getEmail().trim().isEmpty() ) {
			errors.rejectValue("email","required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		
		
		// util을 이용하면 좀 더 간결하게 표현할 수 있다. 
		if( regReq.hasPassword()) {
			if( regReq.getPassword().length()<5) {
				errors.reject("password","shortPassword");
			} else if ( !regReq.isSamePasswordConfirmPassword()) {
				errors.rejectValue("confirmPassword","notSame");
			}
			
		}
		
		// 중첩 
		Address address = regReq.getAddress();
		
		if( address == null ) { 
			errors.rejectValue("address","required");
		} else {
			errors.pushNestedPath("address");
			try {
				
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address2", "required");
			} finally {
				errors.popNestedPath();
			}
		}
		
	}

}
