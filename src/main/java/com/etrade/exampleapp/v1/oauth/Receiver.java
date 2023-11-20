package com.auto-etrade.v1.oauth;

import com.auto-etrade.v1.exception.ApiException;
import com.auto-etrade.v1.oauth.model.Message;
import com.auto-etrade.v1.oauth.model.SecurityContext;
/*
 * Interface used for chaining the oauth related request objects.
 */
public interface Receiver {
	boolean handleMessage(Message message, SecurityContext context)throws ApiException;
	void handleNext(Receiver nextHandler)throws TokenException;
}
