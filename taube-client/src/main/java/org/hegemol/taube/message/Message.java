package org.hegemol.taube.message;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息实体
 *
 * @author clock
 **/
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 9092202597484915225L;

    private String msgId;
    private String topic;
    private byte[] body;
    private long timeStamp;

}