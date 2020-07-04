package com.ats.remotetimemanager.Service.TempUser;

import com.ats.remotetimemanager.Model.TempUser;
import com.ats.remotetimemanager.Model.User;

import java.util.List;

public interface TempUserService {
    TempUser add(TempUser tempUser) ;
    void delete(long id);
    TempUser findByUserCIN(String cin);
    User acceptRequest(TempUser tempUser, String action) throws Exception;
    User declineRequest(TempUser tempUser, String action);

}
