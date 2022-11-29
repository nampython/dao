package com.example.Excercise1.utils;

import java.io.Serializable;
import java.util.*;

public class ErrorCode implements Serializable {
    public final Map<Integer, List<String>> errorMsg = new LinkedHashMap<>();
    private boolean disableSubmit = false;
    private String command = null;

    public ErrorCode() {
    }

    /**
     * Use to add messages into map according to the code
     * @param code: the code to identify message
     * @param msg: msg to display on the client side
     */
    public void addErrorMsg(int code, String msg) {
        if (this.errorMsg.containsKey(code)) {
            List<String> values = this.errorMsg.get(code);
            values.add(msg);
            this.errorMsg.put(code, values);
        } else {
            List<String> values = new ArrayList<>();
            values.add(msg);
            this.errorMsg.put(code, values);
        }
    }

    /**
     * use to get the length of errors
     * @return num of errors
     */
    public int getNumErrors() {
        List<AbstractMap.SimpleEntry<Integer, String>> errorMsgList = this.getErrorMsgListFromMap();
        return errorMsgList.size();
    }

    /**
     * convert from map into list of error msg
     * @return List of error msg
     */
    public List<AbstractMap.SimpleEntry<Integer, String>> getErrorMsgListFromMap() {
        Set<Integer> key = this.errorMsg.keySet();
        Iterator<Integer> iterator = key.iterator();
        List<AbstractMap.SimpleEntry<Integer, String>> errorMsgList = new ArrayList<>();

        while (iterator.hasNext()) {
            Integer var1 = iterator.next();
            List<String> messages = this.errorMsg.get(var1);
            Iterator<String> iteratorMsg = messages.iterator();
            while (iteratorMsg.hasNext()) {
                String msg = iteratorMsg.next();
                errorMsgList.add(new AbstractMap.SimpleEntry<>(var1, msg));
            }
          }
        return errorMsgList;
    }
}
