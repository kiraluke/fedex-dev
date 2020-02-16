package com.ascending.repository;

import com.ascending.model.Recipient;

import java.util.List;

public interface RecipientDao {
    List<Recipient> getRecipients();
    Recipient save(Recipient recipient);
    boolean delete(Recipient recipient);
    boolean deleteBy(String recipientName);
    Recipient update(Recipient recipient);
    List<Recipient> getRecipientsAndPacksBy(String recipientName);
    Recipient getRecipientByName(String recipientName);
}
