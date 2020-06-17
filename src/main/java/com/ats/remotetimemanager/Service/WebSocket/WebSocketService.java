package com.ats.remotetimemanager.Service.WebSocket;

import com.ats.remotetimemanager.Model.Greeting;
import com.ats.remotetimemanager.Model.WebSocketMessage;

public interface WebSocketService  {

     Greeting sendWebSocketMessage(WebSocketMessage message) throws Exception ;


    }
