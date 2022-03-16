package com.mypractice.spring.data.ldap.sbdataldap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;

import javax.naming.Name;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entry(
        base = "dc=abs,dc=com",
        objectClasses = {"inetOrgPerson"})
public class User implements Serializable {
        @Id
        private Name id;

        private @Attribute(name = "cn") String username;
        private @Attribute(name = "sn") String password;
        private transient String ids;

}