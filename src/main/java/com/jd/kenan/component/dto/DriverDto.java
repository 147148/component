package com.jd.kenan.component.dto;

import com.jd.kenan.component.annotation.ColumnName;
import com.jd.kenan.component.annotation.HeaderName;
import com.jd.kenan.component.annotation.TableName;

import java.time.LocalDateTime;

@TableName(name = "driver")
public class DriverDto extends AbstractDto {
    private static final long serialVersionUID = 1879313902192034069L;

    @HeaderName(name = "driver_code", index = 1)
    @ColumnName(name = "driver_code")
    private String driver_code;

    @HeaderName(name = "jd_pin", index = 2)
    @ColumnName(name = "jd_pin")
    private String jd_pin;

    @HeaderName(name = "driver_name", index = 3)
    @ColumnName(name = "driver_name")
    private String driver_name;

    @HeaderName(name = "driver_mobile", index = 4)
    @ColumnName(name = "driver_mobile")
    private String driver_mobile;

    @HeaderName(name = "driver_email", index = 5)
    @ColumnName(name = "driver_email")
    private String driver_email;

    @HeaderName(name = "driver_id_card", index = 6)
    @ColumnName(name = "driver_id_card")
    private String driver_id_card;

    @HeaderName(name = "driver_card_num", index = 7)
    @ColumnName(name = "driver_card_num")
    private String driver_card_num;

    @HeaderName(name = "vehicle_number", index = 8)
    @ColumnName(name = "vehicle_number")
    private String vehicle_number;

    @HeaderName(name = "create_user_code", index = 9)
    @ColumnName(name = "create_user")
    private String create_user;

    @HeaderName(name = "update_user_code", index = 10)
    @ColumnName(name = "update_user")
    private String update_user;

    @HeaderName(name = "yn", index = 11)
    @ColumnName(name = "yn")
    private String yn;

    @ColumnName(name = "create_time")
    private String create_time;

    @ColumnName(name = "update_time")
    private String update_time;

    public String getDriver_code() {
        return driver_code;
    }

    public DriverDto setDriver_code(String driver_code) {
        this.driver_code = driver_code;
        return this;
    }

    public String getJd_pin() {
        return jd_pin;
    }

    public DriverDto setJd_pin(String jd_pin) {
        this.jd_pin = jd_pin;
        return this;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public DriverDto setDriver_name(String driver_name) {
        this.driver_name = driver_name;
        return this;
    }

    public String getDriver_mobile() {
        return driver_mobile;
    }

    public DriverDto setDriver_mobile(String driver_mobile) {
        this.driver_mobile = driver_mobile;
        return this;
    }

    public String getDriver_email() {
        return driver_email;
    }

    public DriverDto setDriver_email(String driver_email) {
        this.driver_email = driver_email;
        return this;
    }

    public String getDriver_id_card() {
        return driver_id_card;
    }

    public DriverDto setDriver_id_card(String driver_id_card) {
        this.driver_id_card = driver_id_card;
        return this;
    }

    public String getDriver_card_num() {
        return driver_card_num;
    }

    public DriverDto setDriver_card_num(String driver_card_num) {
        this.driver_card_num = driver_card_num;
        return this;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public DriverDto setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
        return this;
    }

    public String getCreate_time() {
        return FORMATTER.format(LocalDateTime.now());
    }

    public DriverDto setCreate_time(String create_time) {
        this.create_time = create_time;
        return this;
    }

    public String getCreate_user() {
        return create_user;
    }

    public DriverDto setCreate_user(String create_user) {
        this.create_user = create_user;
        return this;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public DriverDto setUpdate_user(String update_user) {
        this.update_user = update_user;
        return this;
    }

    public String getUpdate_time() {
        return FORMATTER.format(LocalDateTime.now());
    }

    public DriverDto setUpdate_time(String update_time) {
        this.update_time = update_time;
        return this;
    }

    public String getYn() {
        return yn;
    }

    public DriverDto setYn(String yn) {
        this.yn = yn;
        return this;
    }
}
