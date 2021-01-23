package io.recruitment.assessment.dto;

import io.recruitment.assessment.config.AccessRole;

public class UserDto extends BaseDto {
    private AccessRole accessRole;
    private OrderDto orders;

    public UserDto(Integer id, String name, AccessRole accessRole) {
        this.id = id;
        this.name = name;
        this.accessRole = accessRole;
    }
    
    public String getAccess() {
        switch(accessRole) {
            case Admin: 
                return "R,W";
            case Customer:
                return "R";
            default:
                return "";
        }
    }

    public void setAccess(AccessRole accessRole) {
         this.accessRole = accessRole;
    }

    public void setOrders(OrderDto orders) {
        this.orders = orders;
    }

    public OrderDto getOrders() {
        return this.orders;
    }
}


  