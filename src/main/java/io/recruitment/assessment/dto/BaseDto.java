package io.recruitment.assessment.dto;

public class BaseDto {
    protected Integer id;
    protected String name;

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
         this.name = newName;
    }

    public int getId() {
        return this.id;
    }
}
