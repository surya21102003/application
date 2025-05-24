package com.example.demo.service;

import com.example.demo.Request.CreateRestaurantRequest;
import com.example.demo.model.Address;
import com.example.demo.model.Restaurant;
import com.example.demo.model.RestaurantDto;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private AddressRepository addressRepository;
@Autowired
private UserRepository userrepo;

    @Autowired
    private RestaurantRepository restaurantrepository;

    @Override
    public Restaurant createrestaurant(CreateRestaurantRequest req, User user) {
        Address address=addressRepository.save(req.getAddress());
        Restaurant res=new Restaurant();
        res.setAddress(address);
        res.setContactinformation(req.getContactinformation());
        res.setCuisinetype(req.getCuisinetype());
        res.setDescription(req.getDescription());
        res.setImages(req.getImages());
        res.setName(req.getName());
        res.setOpeninghours(req.getOpeninghours());
        res.setRegistrationdate(LocalDateTime.now());
        res.setOwner(user);
        return restaurantrepository.save(res);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest upr) throws Exception {
      Restaurant res=findbyrestaurantId(restaurantId);
      if(res.getCuisinetype()!=null){
          res.setCuisinetype(upr.getCusionType());
      }
      if(res.getDescription()!=null){
          res.setDescription(upr.getDescription);
      }
      if(res.getName()!=null){
          res.setName(upr.getName());
      }
        return null;
    }

    @Override
    public void deleRestaurant(Long restaurantId) throws Exception {
Restaurant r=findbyrestaurantId(restaurantId);
restaurantrepository.delete(r);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantrepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantrepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant findbyrestaurantId(long id) throws Exception {
        Optional<Restaurant> opt=restaurantrepository.findById(id);
     if(opt.isEmpty()){
         throw new Exception("restaurant is not found  with it id");
     }
        return opt.get();
    }

    @Override
    public Restaurant getrestaurantByuserId(Long id) throws Exception {
        Restaurant r=restaurantrepository.findByOwnerId(id);
        if(r==null){
            throw new Exception("restaurant is not found  with it ownerid");
        }
        return r;
    }

    @Override
    public RestaurantDto addToFavourite(Long restaurantId, User user) throws Exception {
        Restaurant r=findbyrestaurantId(restaurantId);
        RestaurantDto rto=new RestaurantDto();
        rto.setDescription(r.getDescription());
        rto.setImages(r.getImages());
        rto.setTitle(r.getName());
        rto.setId(r.getId());
        if(user.getFavorites().contains(rto)){
            user.getFavorites().remove(rto);
        }
        else user.getFavorites().add(rto);
        userrepo.save(user);
        return rto;
    }

    @Override
    public Restaurant updaterestaurantStatus(Long id) throws Exception {
        Restaurant r=findbyrestaurantId(id);
        r.setOpen(!r.isOpen());
        return restaurantrepository.save(r);
    }
}
