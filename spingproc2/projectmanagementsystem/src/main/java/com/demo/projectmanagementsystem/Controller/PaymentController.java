package com.demo.projectmanagementsystem.Controller;

import com.demo.projectmanagementsystem.Paymentlinkreponse;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Plantype;
import com.demo.projectmanagementsystem.service.UserService;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import lombok.Value;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
   // @Value("${razorpay.api.keyId}")
    private String keyId;
   //@Value("${razorpay.api.keySecret}")
    private String keySecret;

    @Autowired
    private UserService userService;

    @PostMapping("/{plantype}")
    public ResponseEntity<Paymentlinkreponse> createpaymentlink(
            @PathVariable Plantype plantype,
            @RequestParam("Authorization")String jwt
    ) throws Exception {
        Myuser user = userService.finduserprofilebyjwt(jwt);
        int amount = 799 * 100;
        if (plantype.equals(Plantype.ANNUALLY)) {
            amount = amount * 12;
            amount = (int) (amount * 0.7);

        }

            RazorpayClient razorpay = new RazorpayClient(keyId, keySecret);
            JSONObject paymentlink = new JSONObject();
            paymentlink.put("amount", amount);
            paymentlink.put("currency", "INR");

            JSONObject customer = new JSONObject();
            customer.put("name", user.getUsername());
            customer.put("email", user.getEmail());
            paymentlink.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("email", true);
            notify.put("notify", notify);

            paymentlink.put("callback_url", "http://localhost:5173/upgrade_plan/success?planType" + plantype);

            PaymentLink payment = razorpay.paymentLink.create(paymentlink);
            String paymentid = payment.get("id");
            String paymenturl = payment.get("short_url");
            Paymentlinkreponse res = new Paymentlinkreponse();
            res.setPayment_link_url(paymenturl);
            res.setPayment_link_id(paymentid);
            return new ResponseEntity<>(res, HttpStatus.CREATED);







    }

}
