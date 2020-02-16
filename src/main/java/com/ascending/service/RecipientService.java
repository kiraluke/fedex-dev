package com.ascending.service;

import com.ascending.model.Recipient;
import com.ascending.repository.RecipientDao;
import com.ascending.repository.RecipientDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipientService {
    @Autowired
    private RecipientDao recipientDao;

    public Recipient save(Recipient recipient){
        return recipientDao.save(recipient);
    }
    public Recipient update(Recipient recipient){
        return recipientDao.update(recipient);
    }
    public boolean delete(Recipient recipient){
        return recipientDao.delete(recipient);
    }
    public List<Recipient> getRecipients(){
        return recipientDao.getRecipients();
    }
    public Recipient getRecipientByName(String recipientName){
        return recipientDao.getRecipientByName(recipientName);
    }
    public List<Recipient> getRecipientsAndPacks(String recipientName){
        return recipientDao.getRecipientsAndPacksBy(recipientName);
    }
}
