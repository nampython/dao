package com.example.Excercise1.utils;

import java.io.Serializable;
import java.util.*;

public class ErrorCode implements Serializable {
    private static final long serialVersionUID = 1L;
    public final Map<Integer, List<String>> errorMsg = new LinkedHashMap();

    public int getNumErrors() {
        List<AbstractMap.SimpleEntry<Integer, String>> errorMsgList = this.getErrorMsgListFromMap();
        return errorMsgList.size();
    }

    private List<AbstractMap.SimpleEntry<Integer, String>> getErrorMsgListFromMap() {
        List<AbstractMap.SimpleEntry<Integer, String>> errorMsgList = new ArrayList();
        new ArrayList();
        Set<Integer> keys = this.errorMsg.keySet();
        Iterator var5 = keys.iterator();

        while(var5.hasNext()) {
            Integer key = (Integer)var5.next();
            List<String> messages = (List)this.errorMsg.get(key);
            Iterator var7 = messages.iterator();

            while(var7.hasNext()) {
                String msg = (String)var7.next();
                errorMsgList.add(new AbstractMap.SimpleEntry(key, msg));
            }
        }

        return errorMsgList;
    }

    public void addErrorMsg(int code, String msg) {
        if (this.errorMsg.containsKey(code)) {
            List<String> values = (List)this.errorMsg.get(code);
            values.add(msg);
            this.errorMsg.put(code, values);
        } else {
            List<String> values = new ArrayList();
            values.add(msg);
            this.errorMsg.put(code, values);
        }

    }
    public Enumeration<Integer> getErrorMsgCodeEnum() {
        Enumeration<Integer> en = Collections.enumeration(this.errorMsg.keySet());
        return en;
    }

    public Enumeration<String> getErrorMsgMultiple(int msgNum) {
        return Collections.enumeration((Collection)this.errorMsg.get(msgNum));
    }

    public List<String> getErrorMessageList() {
        List<String> errMsgList = new ArrayList();
        Enumeration<Integer> errorEnum = this.getErrorMsgCodeEnum();
        String msg = null;
        Enumeration<String> msgEnum = null;
//        int err = false;
        Integer errCd = null;

        while(errorEnum.hasMoreElements()) {
            errCd = (Integer)errorEnum.nextElement();
            int err = errCd;
            msgEnum = this.getErrorMsgMultiple(err);

            while(msgEnum.hasMoreElements()) {
                msg = (String)msgEnum.nextElement();
                errMsgList.add(err + " - " + msg);
            }
        }

        return errMsgList;
    }
}
