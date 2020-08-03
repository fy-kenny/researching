package com.example.researching.pattern.command.device;

import com.example.researching.pattern.command.*;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class Client {

    public static void main(String[] args) {

        Room room = new Room();

        RemoteController<RemoteControl> remoteController = new RemoteController<>();

//        Target<RemoteControl> target = new Target<>();
//
//        for (String lightKey : args) {
//            target.setTarget(room.getLightByLightkey(lightKey));
//
//            remoteController.setTarget(target);
//            remoteController.pressButton(new SwitchOnCommand());
//            remoteController.pressButton(new SwitchOffCommand());
//        }

//        target.setTarget(new CommonLight());

        remoteController.setTarget(new AirConditioner1());
        remoteController.press(new SwitchOnCommand());
        remoteController.press(new UpCommand());
        remoteController.press(new DownCommand());
        remoteController.press(new SwitchOffCommand());

//        LightRemoteControl lightRemoteControl = new LightRemoteControl();
//        lightRemoteControl.setLight(new RedLight());
//        target.setTarget(new CommonLight());
//
        remoteController.setTarget(new CommonLight());
        remoteController.press(new SwitchOnCommand());
        remoteController.press(new SwitchOffCommand());
//
//        target.setTarget(new AirConditioner2());
//
        remoteController.setTarget(new AirConditioner2());
        remoteController.press(new SwitchOnCommand());
        remoteController.press(new UpCommand());
        remoteController.press(new DownCommand());
        remoteController.press(new SwitchOffCommand());

        remoteController.setTarget(new RedLight());
        remoteController.press(new SwitchOnCommand());
        remoteController.press(new UpCommand());
        remoteController.press(new DownCommand());
        remoteController.press(new SwitchOffCommand());

        AirConditionerRemoteControl airConditionerRemoteControl = new AirConditionerRemoteControl();
        airConditionerRemoteControl.setAirConditioner(new AirConditioner2());
        remoteController.setTarget(airConditionerRemoteControl);
        remoteController.press(new SwitchOnCommand());
        remoteController.press(new UpCommand());
        remoteController.press(new DownCommand());
        remoteController.press(new SwitchOffCommand());

        LightRemoteControl lightRemoteControl = new LightRemoteControl();
        lightRemoteControl.setLight(new RedLight());
        remoteController.setTarget(lightRemoteControl);
        remoteController.press(new SwitchOnCommand());
        remoteController.press(new UpCommand());
        remoteController.press(new DownCommand());
        remoteController.press(new SwitchOffCommand());

    }
}
