package com.example.researching.pattern.command.device;

import com.example.researching.pattern.command.Switcher;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class Room {

    private Map<String, Switcher> swithMap = Maps.newHashMap();

    public Room() {
        this.swithMap.put("common", new LightRemoteControl());
        this.swithMap.put("red", new RedLight());
        this.swithMap.put("AC", new AirConditioner1());
    }

    public Switcher getLightByLightkey(String lightKey) {
        return this.swithMap.get(lightKey);
    }
}
