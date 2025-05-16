package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Plantype;
import com.demo.projectmanagementsystem.model.Subscription;
import com.demo.projectmanagementsystem.repo.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class Sunbscriptionimpl implements SubscriptionService{
    @Autowired
    private UserService userService;
    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private Plantype plantype;

    @Override
    public Subscription createSubscription(Myuser user) {
        Subscription subscription=new Subscription();
        subscription.setUser(user);
        subscription.setSubcriptionstartdate(LocalDate.now());
        subscription.setGetsubcriptionenddate(LocalDate.now().plusMonths(12));
        subscription.setIsvalid(true);
        subscription.setPlantype(plantype.FREE);
        return subscriptionRepo.save(subscription);
    }

    @Override
    public Subscription getuserssubscription(Long userid) throws Exception {
        Subscription subscription=subscriptionRepo.findByuserId(userid);
        if (isvalid(subscription)){
            subscription.setPlantype(Plantype.FREE);
            subscription.setGetsubcriptionenddate(LocalDate.now().plusMonths(12));
        subscription.setSubcriptionstartdate(LocalDate.now());
        }
        return subscriptionRepo.save(subscription);
    }

    @Override
    public Subscription upgradrsubscription(Long userid, Plantype plantype) {
        Subscription subscription=subscriptionRepo.findByuserId(userid);
        subscription.setPlantype(plantype);
        subscription.setSubcriptionstartdate(LocalDate.now());
        if (plantype.equals(plantype.ANNUALLY)){
            subscription.setGetsubcriptionenddate(LocalDate.now().plusMonths(12));
        }else {
            subscription.setGetsubcriptionenddate(LocalDate.now().plusMonths(1));
        }

        return subscriptionRepo.save(subscription);
    }

    @Override
    public boolean isvalid(Subscription subscription) {
        if (subscription.getPlantype().equals(plantype.FREE)){
            return true;
        }
        LocalDate enddate=subscription.getGetsubcriptionenddate();
        LocalDate curdate=LocalDate.now();

        return enddate.isAfter(curdate)||enddate.isEqual(curdate);
    }
}
