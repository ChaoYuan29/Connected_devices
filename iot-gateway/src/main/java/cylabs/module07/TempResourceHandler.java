package cylabs.module07;

import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class TempResourceHandler extends CoapResource{
	
	private static final Logger _Logger = 
			Logger.getLogger(TempResourceHandler.class.getName());

	public TempResourceHandler() {
		super("");
	}
	
	public TempResourceHandler(String name) {
		super(name);
	}
	
	public TempResourceHandler(String name, boolean visible) {
		super(name, visible);
	}
	
	@Override
	public void handleGET(CoapExchange exch) {
		exch.respond(ResponseCode.VALID, super.getName()+"response");
		_Logger.info("Get request：" + super.getName());
	}
	@Override
	public void handlePOST(CoapExchange exch) {
		exch.respond(ResponseCode.VALID, super.getName()+"response");
		_Logger.info("Post request：" + exch.getRequestText());
	}

	@Override
	public void handlePUT(CoapExchange exch) {
		exch.respond(ResponseCode.VALID, super.getName()+"response");
		_Logger.info("Put request：" + exch.getRequestText());
	}

	@Override
	public void handleDELETE(CoapExchange exch) {
		exch.respond(ResponseCode.VALID, super.getName()+"response");
		_Logger.info("Delete request：" + super.getName());
	}
}
