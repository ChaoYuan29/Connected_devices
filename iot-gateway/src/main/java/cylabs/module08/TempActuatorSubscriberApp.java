package cylabs.module08;

import java.util.logging.Logger;

public class TempActuatorSubscriberApp {
	
	// static
    private static final Logger _Logger =
       Logger.getLogger(TempActuatorSubscriberApp.class.getName());
    private static TempActuatorSubscriberApp _App;
    /**
     * @param args
     */
    public static void main(String[] args)
    {
       _App = new TempActuatorSubscriberApp();
       try {
              _App.start();
       } catch (Exception e) {
              e.printStackTrace();
       } 
    }
    // params
    private MqttClientConnector _mqttClient;
    // constructors
    /**
     * Default.
     */

    public TempActuatorSubscriberApp()
	{
	super(); 
	}
// public methods
/**
* Connect to the MQTT client, then:
* 1) If this is the subscribe app, subscribe to the given topic
* 2) If this is the publish app, publish a test message to the given topic
*/
    public void start()
	{
	_mqttClient = new MqttClientConnector("things.ubidots.com","A1E-cohoPVgrJYePKdP7FkjNMRWKSzQ4xC",null,"/Users/andyyuan/Desktop/ubidots.pem");
	_mqttClient.connect();
	String topicName = "/v1.6/devices/homeiotgateway/tempactuator";
 // only for subscribing...
	_mqttClient.subscribeToTopic(topicName,2); // you must implement this method yourself
//	_mqttClient.subscribeToAll(); // this is implemented for you
// // only for publishing...
//	String payload = "This is a test...";
// // only for publishing...
//	_mqttClient.publishMessage(topicName, 0, payload.getBytes());
//	_mqttClient.disconnect();
	}

}
