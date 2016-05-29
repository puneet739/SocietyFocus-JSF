package com.fairdeal.action.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "helpdeskaction")
@Scope(value = "session")
public class HelpdeskAction implements Serializable{

}
