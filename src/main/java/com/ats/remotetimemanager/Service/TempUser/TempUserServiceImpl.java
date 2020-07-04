package com.ats.remotetimemanager.Service.TempUser;

import com.ats.remotetimemanager.Model.TempUser;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.TempUserRepository;
import com.ats.remotetimemanager.Service.User.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tempUserService")
public class TempUserServiceImpl implements TempUserService {

    @Autowired
    TempUserRepository tempUserRepository;

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
    public TempUser findByUserCIN(String cin) {
        return tempUserRepository.findByCin(cin);
    }

    @Override
    public User acceptRequest(TempUser tempUser, String action) throws Exception {
        if(action.equals("add")){
            User user = new User(tempUser.getName(),tempUser.getFirstName(),tempUser.getGender(),tempUser.getBirthDate(),
                    tempUser.getPhone(),tempUser.getEmail(),tempUser.getCin(),
                    null,tempUser.getPost(),tempUser.getDepartment(),tempUser.getImage());
            tempUserRepository.deleteById(tempUser.getUserId());
            return userService.add(user);
        }else if(action.equals("update")){
            User user = new User(tempUser.getName(),tempUser.getFirstName(),tempUser.getGender(),tempUser.getBirthDate(),
                    tempUser.getPhone(),tempUser.getEmail(),tempUser.getCin(),
                    null,tempUser.getPost(),tempUser.getDepartment(),tempUser.getImage());
            tempUserRepository.deleteById(tempUser.getUserId());
            return userService.update(user,tempUser.getUserId());
        }return null;
    }

    @Override
    public User declineRequest(TempUser tempUser, String action) {
        return null;
    }
}
