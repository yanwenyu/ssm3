package com.duyi.hrb.controller;

public enum RespStatusEnum {
    SUCCESS("success"),FAIL("fail");
    private String status;

    RespStatusEnum(String status) {
        this.status = status;
    }

    public String  getStatus() {
        return status;
    }
}
