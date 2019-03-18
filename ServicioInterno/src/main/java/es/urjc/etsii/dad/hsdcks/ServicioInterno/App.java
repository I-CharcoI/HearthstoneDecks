package es.urjc.etsii.dad.hsdcks.ServicioInterno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class App 
{
    public static void main( String[] args )
    {
       

		System.out.println("preparados");
		
		int puertoServidor = 5555;
		
		
		String email;
		
		
		while(true) {
			
			System.out.println("Esperando una conexion en el puerto: " + puertoServidor);
			
			
			try {
			
			ServerSocket serverSocket = new ServerSocket(puertoServidor);	
			Socket fromClientSocket = serverSocket.accept();	
			
			PrintWriter pw = new PrintWriter(fromClientSocket.getOutputStream(), true);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
			
			
			email = br.readLine();
			System.out.println("El email recibido es: " + email);
			
			
			String destinatario = email; 
		    String asunto = "¡¡NOVEDADES!!";
		    String cuerpo = "HAY NOVEDADES EN LA PAGINA. ¡¡¡VEN A VERNOS!!!";

		    enviarConGMail(destinatario, asunto, cuerpo);
			
		    pw.println(email);
			
		    
			pw.close();
			br.close();
			fromClientSocket.close();
			serverSocket.close();
			
			} catch (IOException e) {
				System.out.println("conexion fail");
			}
			
		}
	}
	
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com.
	    String remitente = "deckshearthstone0";  //Para la dirección deckshearthstone0@gmail.com
	    				  //deckshearthstone0@gmail.com
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "Hsd1234567");    //la contraseña 
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
	    props.setProperty("mail.smtp.ssl.trust", "*");

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "Hsd1234567");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   
	    }
	}
	
	
}
