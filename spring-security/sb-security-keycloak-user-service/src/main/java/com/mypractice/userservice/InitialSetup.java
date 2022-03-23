package com.mypractice.userservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.mypractice.userservice.data.UserEntity;
import com.mypractice.userservice.data.UsersRepository;

@Component
public class InitialSetup {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        UserEntity user = new UserEntity(
                1L,
                "nkhan",
                "Jalalluddin",
                "khan",
                "jalaluddin@gmail.com",
                bCryptPasswordEncoder.encode("jalaluddin"),
                "",
                false);

        usersRepository.save(user);
    }
}
