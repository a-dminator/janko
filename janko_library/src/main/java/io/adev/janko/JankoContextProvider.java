package io.adev.janko;

public interface JankoContextProvider<V> {
    JankoContext getJankoContext();
    V _();
}
