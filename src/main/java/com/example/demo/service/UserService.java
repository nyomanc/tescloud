package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;



@Service
public class UserService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserRepo userRepo;

    public BaseResp addUser(User user) {
        BaseResp response = new BaseResp();

        try {
            userRepo.save(user);

            response.setErrorCode("00");
            response.setErrorMessage("Success");
            response.setDefaultTimestamp();
        } catch (Exception e) {
            response.setErrorCode("100");
            response.setErrorMessage(e.getMessage());
            response.setDefaultTimestamp();
        }

        return response;
    }
    public PutUserResp editUser(PutUserReq putUserReq, String nip) {
        PutUserResp response = new PutUserResp();

        try {
            PutUserOutputSchema outputSchema = new PutUserOutputSchema();

            User user = userRepo.findById(nip).get();
            user.setNama(putUserReq.getNama());
            user.setEmail(putUserReq.getEmail());
            user.setPassword(putUserReq.getPassword());

            userRepo.save(user);

            outputSchema.setNip(user.getNip());
            outputSchema.setNama(user.getNama());
            outputSchema.setEmail(user.getEmail());

            response.setOutputSchema(outputSchema);
            response.setErrorCode("00");
            response.setErrorMessage("Success");
            response.setDefaultTimestamp();
        } catch (Exception e) {
            response.setErrorCode("100");
            response.setErrorMessage(e.getMessage());
            response.setDefaultTimestamp();
        }
        return response;
    }
    public void deleteByNip(String nip) {
        PutUserResp response = new PutUserResp();
        User user = userRepo.findById(nip).get();
        if(user!=null)
        userRepo.deleteById(nip);
        else
        {
            response.setErrorCode("100");
            response.setErrorMessage("gak ketemu");
            response.setDefaultTimestamp();
        }
    }

    public GetUserResp getUserByNip (String nip){

        GetUserResp resp = new GetUserResp ();
        try {

            nip = nip.toUpperCase();
            String query="select NIP, NAMA, EMAIL, PASSWORD from TBL_USER where NIP =?";
            System.out.println(nip);
            System.out.println(query);
            Query myQuery = entityManager.createNativeQuery(query, User.class);
            myQuery.setParameter(1, nip);
            List<User> userResult = myQuery.getResultList();

            GetUserOutputSchema outputSchema = new GetUserOutputSchema();
            User user = userResult.get(0);
            outputSchema.setNip(user.getNip());
            outputSchema.setNama(user.getNama());
            outputSchema.setEmail(user.getEmail());

            resp.setOutputSchema(outputSchema);
            resp.setDefaultTimestamp();
            resp.setErrorCode("00");
            resp.setErrorMessage("Success");
        }catch(Exception e){
            resp.setDefaultTimestamp();
            resp.setErrorCode("100");
            if(e.getMessage().equals("Index: 0, Size: 0"))
            resp.setErrorMessage("tidak ketemu");
        }
        return resp;
    }

}

