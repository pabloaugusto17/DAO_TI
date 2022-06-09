package com.example.api_1.ViewInitializer;

import org.springframework.stereotype.Component;

@Component
public interface ControlledScreen {

    public void setScreenParent(ScreenController screenPage);

}
