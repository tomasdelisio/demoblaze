package utils;

public enum MessagesRegister {
	/*** MESSAGES ***/
	// OK
	REGISTER_TEST_START("INICIANDO PRUEBA DE REGISTRO"),
	REGISTER("REGISTRANDO"),
	REGISTER_COMPLETED("REGISTRO COMPLETADO"),
	VALIDATE_REGISTER("VALIDANDO REGISTRO"),
	REGISTER_TEST_OK("PRUEBA DE REGISTRO EXITOSA"),
	REGISTER_TEST_FINISH("FINALIZANDO PRUEBA DE REGISTRO"),
	REGISTER_OK("Sign up successful."),
	
	// Error
	REGISTER_TEST_ERROR("PRUEBA DE REGISTRO FALLIDA");
	
	/*** VARIABLES ***/
	private final String message;
	
	/*** METHODS ***/
	// Setter
	MessagesRegister(String message){
		this.message = message;
		
	}
	
	// Getter
	public String getMessage() {
		return message;
		
	}
}
