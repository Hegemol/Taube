package org.hegemol.taube.client.common.model;

/**
 * Result.
 *
 * @author KevinClair
 **/
public class MessageResult {

    // code
    public static final String SUCCESS_STATUS = "SUCCESS";
    public static final String FAIL_STATUS = "FAIL";

    // result
    public static final MessageResult SUCCESS = new MessageResult(SUCCESS_STATUS);
    public static final MessageResult FAIL = new MessageResult(FAIL_STATUS);

    // status.
    private String status;

    public MessageResult(final String status) {
        this.status = status;
    }
}
