package planning.ejbMessage;

import java.time.LocalDate;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.jboss.ejb3.annotation.DeliveryActive;

@MessageDriven (name = "EnvoiProduit",
activationConfig = {
		@ActivationConfigProperty( propertyName = "destinationType",
				propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty( propertyName = "destination",
		propertyValue = "jms/queue/TestDMQueue"),
		@ActivationConfigProperty( propertyName = "acknowledgeMode",
		propertyValue = "Auto-acknowledge") })
@DeliveryActive(true)
public class QueueListenerMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				System.out.println("Queue: " + LocalDate.now());
				TextMessage msg = (TextMessage) message;
				System.out.println("Le message est : " + msg.getText());
			}
			else if (message instanceof ObjectMessage) {
				System.out.println("Queue: " + LocalDate.now());
				ObjectMessage msg = (ObjectMessage) message;
			}
			else {
				System.out.println("Le message n'est pas valide");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
