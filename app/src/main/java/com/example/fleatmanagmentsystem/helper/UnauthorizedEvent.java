package com.example.fleatmanagmentsystem.helper;

import okhttp3.ResponseBody;

public class UnauthorizedEvent {

    public static UnauthorizedEvent instance(ResponseBody error) {
        return new UnauthorizedEvent();
    }

    private UnauthorizedEvent() {
    }
}
