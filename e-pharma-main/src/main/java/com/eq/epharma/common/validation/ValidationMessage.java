package com.eq.epharma.common.validation;


import java.util.Map;

public class ValidationMessage {

    private Map<String,String> message;
    private boolean hasErrors;


  
    public boolean hasErrors() {
        return hasErrors;
    }
    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }
    public Map<String, String> getMessage() {
        return message;
    }
    public void setMessage(Map<String, String> message) {
        this.message = message;
    }
    public boolean isHasErrors() {
        return hasErrors;
    }


    
}
