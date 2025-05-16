package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Plantype;
import com.demo.projectmanagementsystem.model.Subscription;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
Subscription createSubscription(Myuser user);
Subscription getuserssubscription(Long userid)throws Exception;
Subscription upgradrsubscription(Long userid, Plantype plantype);
boolean isvalid(Subscription subscription);
}
