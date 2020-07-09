package com.ats.remotetimemanager.Service.TempUser;

import com.ats.remotetimemanager.Model.TempUser;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.AddressRepository;
import com.ats.remotetimemanager.Repository.TempUserRepository;
import com.ats.remotetimemanager.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tempUserService")
public class TempUserServiceImpl implements TempUserService {

    @Autowired
    TempUserRepository tempUserRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserService userService;


    @Override
    public TempUser add(TempUser tempUser){
        return tempUserRepository.save(tempUser);
    }

    @Override
    public void delete(long id) {
         tempUserRepository.deleteById(id);
    }

    @Override
    public TempUser findById(long id) {
        return tempUserRepository.findByUserId(id);
    }

    @Override
    public User acceptRequest(TempUser tempUser, String action) throws Exception {
        User user = new User(tempUser.getName(),tempUser.getFirstName(),tempUser.getGender(),tempUser.getBirthDate(),
                    tempUser.getPhone(),tempUser.getEmail(),tempUser.getCin(),
                    null,tempUser.getPost(),tempUser.getDepartment(),tempUser.getImage());
            user.setAddresses(tempUser.getAddresses());
            user.getAddresses().forEach(address -> {
                addressRepository.delete(address);
                address.setTempUser(null);
                address.setAddressId(0);
            });
            user.getRoles().clear();
            user.setUserId(0);
            delete(tempUser.getUserId());
        if(action.equals("add")){
            return userService.add(user);
        }else if(action.equals("update")){
            return userService.update(user,tempUser.getUserId());
        }return null;
    }

    @Override
    public TempUser declineRequest(long id) {
        TempUser tmp = tempUserRepository.findByUserId(id);
         tempUserRepository.deleteById(id);
         return tmp;
    }
}
