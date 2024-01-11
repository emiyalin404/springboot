package net.javaguides.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
public class Message implements Serializable {
    private  static final long serialVersionUID = 1L;

    private String msgType;

    private String msgTitle;

    private String msg;

    private boolean hasError = false;

    private String msgData;


}
