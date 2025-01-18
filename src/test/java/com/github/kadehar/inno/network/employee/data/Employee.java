package com.github.kadehar.inno.network.employee.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Long companyId;
    private String email;
    private String url;
    private String phone;
    private String birthdate;
    private Boolean isActive;

    private Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public static Builder newBuilder() {
        return new Employee().new Builder();
    }

    @Override
    public String toString() {
        return """
                {
                  "id": %d,
                  "firstName": "%s",
                  "lastName": "%s",
                  "middleName": "%s",
                  "companyId": %d,
                  "email": "%s",
                  "url": "%s",
                  "phone": "%s",
                  "birthdate": "%s",
                  "isActive": %b
                }
                """.formatted(
                id, firstName,
                lastName, middleName,
                companyId, email, url,
                phone, birthdate, isActive
        ).trim();
    }

    /**
     * <a href="https://habr.com/ru/articles/244521/">Builder example</a>
     */
    public class Builder {
        private Builder() {

        }

        public Builder setId(Long id) {
            Employee.this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            Employee.this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            Employee.this.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            Employee.this.middleName = middleName;
            return this;
        }

        public Builder setCompanyId(Long companyId) {
            Employee.this.companyId = companyId;
            return this;
        }

        public Builder setEmail(String email) {
            Employee.this.email = email;
            return this;
        }

        public Builder setUrl(String url) {
            Employee.this.url = url;
            return this;
        }

        public Builder setPhone(String phone) {
            Employee.this.phone = phone;
            return this;
        }

        public Builder setBirthdate(String birthdate) {
            Employee.this.birthdate = birthdate;
            return this;
        }

        public Builder setActive(Boolean active) {
            Employee.this.isActive = active;
            return this;
        }

        public Employee build() {
            return Employee.this;
        }
    }
}
