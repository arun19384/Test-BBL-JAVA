package com.example.testBBL.service;

import com.example.testBBL.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDataService {

    private final Map<Long, UserModel> userMap = new HashMap<>();
    private long id = 1;

    public UserDataService() {
        userMap.put(id, new UserModel(id++, "Arun Sutamchai", "Summer", "Arun.sutamchai@BBL.com", "08x-xxx-xxxx", "www.BBL.com"));
        userMap.put(id, new UserModel(id++, "Aran SuNat", "Sammuer", "Sammuer.sutamchai@BBL.com", "09x-xxx-xxxx", "www.BBL.com"));
    }

    public List<UserModel> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public UserModel getUserById(Long id) {
        return userMap.get(id);
    }

    public UserModel createUser(UserModel user) {
        user.setId(id++);
        userMap.put(user.getId(), user);
        return user;
    }

    public UserModel updateUser(Long id, UserModel updatedUserDetails) {
        if (userMap.containsKey(id)) {
            updatedUserDetails.setId(id);
            userMap.put(id, updatedUserDetails);
            return updatedUserDetails;
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        return userMap.remove(id) != null;
    }
}
