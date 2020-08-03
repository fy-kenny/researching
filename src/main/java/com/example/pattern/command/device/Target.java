package com.example.pattern.command.device;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class Target<T> {

    private T target;

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }
}
