package io.github.rexmolo.exception;

public final class ErrMsg {

    public static void notAllowNull(String prefix) {
        thr(prefix + " Not allowed to be null");
    }

    public static void custom(String msg) {
        thr(msg);
    }

    private static void thr(String msg) {
        throw new IllegalArgumentException(msg);
    }

}
