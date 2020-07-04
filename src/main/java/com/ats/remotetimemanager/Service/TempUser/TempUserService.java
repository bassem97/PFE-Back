package com.ats.remotetimemanager.Service.TempUser;

import com.ats.remotetimemanager.Model.TempUser;
import com.ats.remotetimemanager.Model.User;

import java.util.List;

public interface TempUserService {
    TempUser add(TempUser tempUser) ;
    void delete(long id);
    TempUser findById(long id);
    User acceptRequest(TempUser tempUser, String action) throws Exception;
    TempUser declineRequest(long id);


}
