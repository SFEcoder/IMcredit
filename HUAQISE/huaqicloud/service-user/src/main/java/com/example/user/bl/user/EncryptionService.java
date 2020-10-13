package com.example.user.bl.user;

import com.example.user.po.User;
import com.example.user.vo.UserForm;

/*
*  加密文件
**/

public interface EncryptionService {
    public String encryptionOfData(String data) ;

    public String decryptionOfData(String data);

    public User encryptionOfUser(User user);

    public User decryptionOfUser(User user) ;

    public UserForm encryptionOfUserForm(UserForm userForm);

    public UserForm decryptionOfUserForm(UserForm userForm);
}
