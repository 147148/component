package com.jd.kenan.component.dto;

import com.jd.kenan.component.annotation.ColumnName;
import com.jd.kenan.component.annotation.HeaderName;
import com.jd.kenan.component.annotation.TableName;

import java.time.LocalDateTime;

@TableName(name = "carrier_driver_relation")
public class CarrierDto extends AbstractDto {
    private static final long serialVersionUID = -3876238727272674360L;

    @HeaderName(name = "carrier_code", index = 1)
    @ColumnName(name = "carrier_code")
    private String carrier_code;

    @HeaderName(name = "carrier_name", index = 2)
    @ColumnName(name = "carrier_name")
    private String carrier_name;

    @HeaderName(name = "carrier_type", index = 3)
    @ColumnName(name = "carrier_type")
    private String carrier_type;

    @HeaderName(name = "carrier_class", index = 4)
    @ColumnName(name = "carrier_class")
    private String carrier_class;

    @HeaderName(name = "carrier_team_code", index = 5)
    @ColumnName(name = "carrier_team_code")
    private String carrier_team_code;

    @HeaderName(name = "carrier_team_name", index = 6)
    @ColumnName(name = "carrier_team_name")
    private String carrier_team_name;

    @HeaderName(name = "jd_pin", index = 7)
    @ColumnName(name = "driver_jd_pin")
    private String driver_jd_pin;

    @HeaderName(name = "status", index = 8)
    @ColumnName(name = "serve_status")
    private String serve_status;

    @HeaderName(name = "create_user_code", index = 9)
    @ColumnName(name = "create_user")
    private String create_user;

    @HeaderName(name = "create_time", index = 10)
    @ColumnName(name = "create_time")
    private String create_time;

    @HeaderName(name = "update_user_code", index = 11)
    @ColumnName(name = "update_user")
    private String update_user;

    @HeaderName(name = "update_time", index = 12)
    @ColumnName(name = "update_time")
    private String update_time;

    @HeaderName(name = "yn", index = 13)
    @ColumnName(name = "yn")
    private String yn;

    @ColumnName(name = "bind_status")
    private String bind_status;

    @ColumnName(name = "roles")
    private String roles;


    public String getCarrier_code() {
        return carrier_code;
    }

    public CarrierDto setCarrier_code(String carrier_code) {
        this.carrier_code = carrier_code;
        return this;
    }

    public String getCarrier_name() {
        return carrier_name;
    }

    public CarrierDto setCarrier_name(String carrier_name) {
        this.carrier_name = carrier_name;
        return this;
    }

    public String getCarrier_type() {
        return carrier_type;
    }

    public CarrierDto setCarrier_type(String carrier_type) {
        this.carrier_type = carrier_type;
        return this;
    }

    public String getCarrier_class() {
        return carrier_class;
    }

    public CarrierDto setCarrier_class(String carrier_class) {
        this.carrier_class = carrier_class;
        return this;
    }

    public String getCarrier_team_code() {
        return carrier_team_code;
    }

    public CarrierDto setCarrier_team_code(String carrier_team_code) {
        this.carrier_team_code = carrier_team_code;
        return this;
    }

    public String getCarrier_team_name() {
        return carrier_team_name;
    }

    public CarrierDto setCarrier_team_name(String carrier_team_name) {
        this.carrier_team_name = carrier_team_name;
        return this;
    }

    public String getRoles() {
        return "";
    }

    public CarrierDto setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public String getDriver_jd_pin() {
        return driver_jd_pin;
    }

    public CarrierDto setDriver_jd_pin(String driver_jd_pin) {
        this.driver_jd_pin = driver_jd_pin;
        return this;
    }

    public String getBind_status() {
        return "1";
    }

    public CarrierDto setBind_status(String bind_status) {
        this.bind_status = bind_status;
        return this;
    }

    public String getServe_status() {
        return serve_status;
    }

    public CarrierDto setServe_status(String serve_status) {
        this.serve_status = serve_status;
        return this;
    }

    public String getCreate_user() {
        return create_user;
    }

    public CarrierDto setCreate_user(String create_user) {
        this.create_user = create_user;
        return this;
    }

    public String getCreate_time() {
        return create_time;
    }

    public CarrierDto setCreate_time(String create_time) {
        this.create_time = create_time;
        return this;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public CarrierDto setUpdate_user(String update_user) {
        this.update_user = update_user;
        return this;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public CarrierDto setUpdate_time(String update_time) {
        this.update_time = update_time;
        return this;
    }

    public String getYn() {
        return yn;
    }

    public CarrierDto setYn(String yn) {
        this.yn = yn;
        return this;
    }
}
