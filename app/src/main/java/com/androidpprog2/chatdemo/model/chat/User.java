package com.androidpprog2.chatdemo.model.chat;

import androidx.annotation.Keep;

import com.google.firebase.database.Exclude;
import com.stfalcon.chatkit.commons.models.IUser;

/**
 * Use of @Keep so that internally the name of the variables is not modified when reading from Firebase.
 */
@Keep
public class User implements IUser {

    public String name;
    public String surname;
    public String alias;
    public String avatar;
    public String timezone;
    public Integer senderId;


    /**
     * Use @Exclude to exclude getters from the database.
     */
    @Override
    @Exclude
    public String getId() {
        return null;
    }

    @Override
    @Exclude
    public String getName() {
        return name + " " + surname;
    }

    @Override
    @Exclude
    public String getAvatar() {
        return avatar;
    }

    /**
     * Overwrite toString method to quickly test information.
     */
    @Override
    @Exclude
    public String toString() {
        return "ChatUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", alias='" + alias + '\'' +
                ", avatar='" + avatar + '\'' +
                ", timezone='" + timezone + '\'' +
                ", senderId=" + senderId +
                '}';
    }
}
