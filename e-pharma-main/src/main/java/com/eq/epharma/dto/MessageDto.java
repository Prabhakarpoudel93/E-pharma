package com.eq.epharma.dto;

import com.eq.epharma.common.validation.ValidationMessage;

public class MessageDto {

    public String message;
    public Object common;
    private boolean status;

    public ValidationMessage vm;

    public MessageDto(ValidationMessage vm) {
        this.vm = vm;
    }

    public MessageDto() {
    }

    public MessageDto(String message, boolean status) {
        this.message = message;
        this.status = status;
    }


    public Object getCommon() {
        return common;
    }

    public void setCommon(Object common) {
        this.common = common;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ValidationMessage getVm() {
        return vm;
    }

    public void setVm(ValidationMessage vm) {
        this.vm = vm;
    }

}
