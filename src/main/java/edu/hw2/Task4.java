package edu.hw2;

public class Task4 {
    private Task4() {}

    static  CallingInfo callingInfo() {
        String methodName = new Throwable().getStackTrace()[1].getMethodName();
        String className = new Throwable().getStackTrace()[0].getClassName();
        return new CallingInfo(className, methodName);
    }

    public record CallingInfo(String className, String methodName) {}
}
