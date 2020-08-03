package com.example.researching.pattern.command.device;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class AirConditionerRemoteControl implements AirConditioner {

    private AirConditioner airConditioner;

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void on() {
        airConditioner.on();
    }

    @Override
    public void off() {
        airConditioner.off();
    }

    @Override
    public void up() {
        airConditioner.up();
    }

    @Override
    public void down() {
        airConditioner.down();
    }
}
