package com.androidpprog2.chatdemo.model.chat;

import androidx.annotation.Keep;

import com.google.firebase.database.Exclude;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.util.Date;


/**
 * Use of @Keep so that internally the name of the variables is not modified when reading from Firebase.
 */
@Keep
public class Message implements IMessage {


    public User user;

    public String text;
    public String id;
    public Date timestamp;


    /**
     * Use @Exclude to exclude getters from the database.
     */
    @Override
    @Exclude
    public String getId() {
        return id;
    }

    @Override
    @Exclude
    public String getText() {
        return text;
    }

    @Override
    @Exclude
    public IUser getUser() {
        return user;
    }

    @Override
    @Exclude
    public Date getCreatedAt() {
        return timestamp;
    }

    /**
     * Overwrite toString method to quickly test information.
     */
    @Override
    @Exclude
    public String toString() {
        return "Message{" +
                "user=" + user +
                ", text='" + text + '\'' +
                ", id='" + id + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
