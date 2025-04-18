package com.example.sampleapi.user.data

import com.example.sampleapi.user.data.model.UserData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
public class UserService {
    @Autowired
    private lateinit var userService:UserService

    fun getUser(name:String):List<UserData>{
        return userService.getUser(name)
    }
}